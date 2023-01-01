package be.familieheist.web.content.page;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PagepartRepository extends ReactiveSortingRepository<PagepartDBO, String> {
    Flux<PagepartDBO> findByPageIdOrderByPosition(String pageId);
}
