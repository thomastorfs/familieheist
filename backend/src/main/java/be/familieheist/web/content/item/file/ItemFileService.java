package be.familieheist.web.content.item.file;

import be.familieheist.web.content.item.ItemDataDBO;
import be.familieheist.web.content.item.ItemDataDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ItemFileService {
    private final ItemFileRepository itemFileRepository;

    public Mono<ItemDataDTO> findByItemId(String itemId) {
        return itemFileRepository.findByItemId(itemId)
            .map(ItemDataDBO::toDto);
    }
}
