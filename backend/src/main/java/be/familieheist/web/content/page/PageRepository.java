package be.familieheist.web.content.page;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Mono;

public interface PageRepository extends ReactiveSortingRepository<PageDBO, String> {
    Mono<PageDBO> findById(String id);
    Mono<PageDBO> findByUri(String uri);
}
