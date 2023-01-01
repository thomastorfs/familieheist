package be.familieheist.web.content.item;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface ItemRepository extends ReactiveSortingRepository<ItemDBO, String> {
    Flux<ItemDBO> findByPagepartId(String pagepartId);
}
