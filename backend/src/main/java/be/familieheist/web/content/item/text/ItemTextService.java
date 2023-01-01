package be.familieheist.web.content.item.text;

import be.familieheist.web.content.item.ItemDataDBO;
import be.familieheist.web.content.item.ItemDataDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ItemTextService {
    private final ItemTextRepository itemTextRepository;

    public Mono<ItemDataDTO> findByItemId(String itemId) {
        return itemTextRepository.findByItemId(itemId)
            .map(ItemDataDBO::toDto);
    }
}
