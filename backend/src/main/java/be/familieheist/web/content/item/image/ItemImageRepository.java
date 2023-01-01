package be.familieheist.web.content.item.image;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Mono;

public interface ItemImageRepository extends ReactiveSortingRepository<ItemImageDBO, String> {
    Mono<ItemImageDBO> findByItemId(String itemId);
}
