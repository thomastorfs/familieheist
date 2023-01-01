package be.familieheist.web.content.item.audio;

import be.familieheist.web.content.item.ItemDataDBO;
import be.familieheist.web.content.item.ItemDataDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ItemAudioService {
    private final ItemAudioRepository itemAudioRepository;

    public Mono<ItemDataDTO> findByItemId(String itemId) {
        return itemAudioRepository.findByItemId(itemId)
            .map(ItemDataDBO::toDto);
    }
}
