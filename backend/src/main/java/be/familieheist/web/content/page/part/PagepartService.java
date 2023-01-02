package be.familieheist.web.content.page.part;

import be.familieheist.web.content.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PagepartService {
    private final PagepartRepository pagepartRepository;
    private final ItemService itemService;

    public Mono<PagepartDTO> createPagepart(PagepartCreateCommandDTO createCommandDTO) {
        return pagepartRepository.save(createCommandDTO.toPagepartDBO())
            .map(PagepartDBO::toDto);
    }

    public Mono<List<PagepartDTO>> getPagepartById(String pageId) {
        return pagepartRepository
            .findByPageId(pageId)
            .map(PagepartDBO::toDto)
            .flatMap(this::aggregateItems)
            .collectSortedList(Comparator.comparing(PagepartDTO::position));
    }

    private Mono<PagepartDTO> aggregateItems(PagepartDTO pagepartDTO) {
        return itemService.getByPagepartId(pagepartDTO.id())
            .map(items -> pagepartDTO.toBuilder().items(items).build());
    }
}
