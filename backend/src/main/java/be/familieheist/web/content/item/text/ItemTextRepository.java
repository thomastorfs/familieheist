package be.familieheist.web.content.item.text;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Mono;

public interface ItemTextRepository extends ReactiveSortingRepository<ItemTextDBO, String> {
    Mono<ItemTextDBO> findByItemId(String itemId);
}
