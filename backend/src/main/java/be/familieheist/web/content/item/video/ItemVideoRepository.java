package be.familieheist.web.content.item.video;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Mono;

public interface ItemVideoRepository extends ReactiveSortingRepository<ItemVideoDBO, String> {
    Mono<ItemVideoDBO> findByItemId(String itemId);
}
