package be.familieheist.web.content.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public Mono<List<ItemDTO>> getByPagepartId(String pagepartId) {
        return itemRepository
            .findByPagepartId(pagepartId)
            .map(ItemDBO::toDto)
            .collectSortedList(Comparator.comparing(ItemDTO::position));
    }
}
