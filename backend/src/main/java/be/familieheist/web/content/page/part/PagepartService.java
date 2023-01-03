package be.familieheist.web.content.page.part;

import be.familieheist.web.content.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PagepartService {
    private final PagepartRepository pagepartRepository;
    private final ItemService itemService;

    public Mono<PagepartDTO> createPagepart(PagepartCreateCommandDTO createCommandDTO) {
        PagepartDBO pagepartDBO = PagepartDBOCreator.createPagepartDBOFromCreateCommand(createCommandDTO);
        return pagepartRepository.save(pagepartDBO)
            .map(PagepartDBO::toDto);
    }

    public Mono<List<PagepartDTO>> getPagepartById(String pageId) {
        return pagepartRepository
            .findByPageId(pageId)
            .map(PagepartDBO::toDto)
            .flatMap(this::aggregateItems)
            .collectSortedList(Comparator.comparing(PagepartDTO::position));
    }

    public Mono<PagepartDTO> updatePagepartById(String id, PagepartUpdateCommandDTO updateCommandDTO) {
        PagepartDBO pagepartDBO = PagepartDBOCreator.createPagepartDBOFromUpdateCommand(id, updateCommandDTO);
        return pagepartRepository.save(pagepartDBO)
            .map(PagepartDBO::toDto);
    }

    public Mono<Void> deletePagepartById(String id) {
        return pagepartRepository
            .findById(id)
            .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to delete, no Content Pagepart found with ID `%s`".formatted(id))))
            .flatMap(existingPageDBO -> pagepartRepository.deleteById(id));
    }

    private Mono<PagepartDTO> aggregateItems(PagepartDTO pagepartDTO) {
        return itemService.getByPagepartId(pagepartDTO.id())
            .map(items -> pagepartDTO.toBuilder().items(items).build());
    }
}
