package be.familieheist.web.content.item.file;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Mono;

public interface ItemFileRepository extends ReactiveSortingRepository<ItemFileDBO, String> {
    Mono<ItemFileDBO> findByItemId(String itemId);
}
