package be.familieheist.web.content.item.audio;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Mono;

public interface ItemAudioRepository extends ReactiveSortingRepository<ItemAudioDBO, String> {
    Mono<ItemAudioDBO> findByItemId(String itemId);
}
