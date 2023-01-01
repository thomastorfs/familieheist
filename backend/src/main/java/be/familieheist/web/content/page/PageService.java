package be.familieheist.web.content.page;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PageService {
    private final PageRepository pageRepository;
    private final PagepartService pagepartService;

    public Mono<PageDTO> getPageById(String id) {
        return pageRepository
            .findById(id)
            .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "No Content Page found with ID `%s`".formatted(id))))
            .map(PageDBO::toDto)
            .flatMap(this::aggregatePageparts);
    }

    private Mono<PageDTO> aggregatePageparts(PageDTO pageDTO) {
        return pagepartService.getPageById(pageDTO.id())
            .map(pageparts -> pageDTO.toBuilder().pageparts(pageparts).build());
    }
}
