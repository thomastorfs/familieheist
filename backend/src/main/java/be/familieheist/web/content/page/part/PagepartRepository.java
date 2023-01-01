package be.familieheist.web.content.page.part;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface PagepartRepository extends ReactiveSortingRepository<PagepartDBO, String> {
    Flux<PagepartDBO> findByPageId(String pageId);
}
