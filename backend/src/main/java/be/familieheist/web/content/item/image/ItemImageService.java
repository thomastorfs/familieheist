package be.familieheist.web.content.item.image;

import be.familieheist.web.content.item.ItemDataDBO;
import be.familieheist.web.content.item.ItemDataDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ItemImageService {
    private final ItemImageRepository itemImageRepository;

    public Mono<ItemDataDTO> findByItemId(String itemId) {
        return itemImageRepository.findByItemId(itemId)
            .map(ItemDataDBO::toDto);
    }
}
