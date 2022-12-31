package be.familieheist.web.content.page;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PageService {
    private final PageRepository pageRepository;

    public Mono<PageDTO> getPageById(String id) {
        return pageRepository
            .findById(id)
            .map(PageDBO::toDto);
    }
}
