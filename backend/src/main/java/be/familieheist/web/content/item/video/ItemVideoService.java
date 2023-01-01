package be.familieheist.web.content.item.video;

import be.familieheist.web.content.item.ItemDataDBO;
import be.familieheist.web.content.item.ItemDataDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ItemVideoService {
    private final ItemVideoRepository itemVideoRepository;

    public Mono<ItemDataDTO> findByItemId(String itemId) {
        return itemVideoRepository.findByItemId(itemId)
            .map(ItemDataDBO::toDto);
    }
}
