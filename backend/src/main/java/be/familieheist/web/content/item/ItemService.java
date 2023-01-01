package be.familieheist.web.content.item;

import be.familieheist.web.content.item.audio.ItemAudioService;
import be.familieheist.web.content.item.file.ItemFileService;
import be.familieheist.web.content.item.image.ItemImageService;
import be.familieheist.web.content.item.text.ItemTextService;
import be.familieheist.web.content.item.video.ItemVideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemAudioService itemAudioService;
    private final ItemFileService itemFileService;
    private final ItemImageService itemImageService;
    private final ItemTextService itemTextService;
    private final ItemVideoService itemVideoService;

    public Mono<List<ItemDTO>> getByPagepartId(String pagepartId) {
        return itemRepository
            .findByPagepartId(pagepartId)
            .map(ItemDBO::toDto)
            .flatMap(this::aggregateItemData)
            .collectSortedList(Comparator.comparing(ItemDTO::position));
    }

    private Mono<ItemDTO> aggregateItemData(ItemDTO itemDTO) {
        return switch (itemDTO.type()) {
            case AUDIO -> aggregateItemAudio(itemDTO);
            case FILE -> aggregateItemFile(itemDTO);
            case IMAGE -> aggregateItemImage(itemDTO);
            case TEXT -> aggregateItemText(itemDTO);
            case VIDEO -> aggregateItemVideo(itemDTO);
        };
    }

    private Mono<ItemDTO> aggregateItemAudio(ItemDTO itemDTO) {
        return itemAudioService.findByItemId(itemDTO.id())
            .map(itemAudioDTO -> itemDTO.toBuilder().data(itemAudioDTO).build());
    }

    private Mono<ItemDTO> aggregateItemFile(ItemDTO itemDTO) {
        return itemFileService.findByItemId(itemDTO.id())
            .map(itemFileDTO -> itemDTO.toBuilder().data(itemFileDTO).build());
    }

    private Mono<ItemDTO> aggregateItemImage(ItemDTO itemDTO) {
        return itemImageService.findByItemId(itemDTO.id())
            .map(itemImageDTO -> itemDTO.toBuilder().data(itemImageDTO).build());
    }

    private Mono<ItemDTO> aggregateItemText(ItemDTO itemDTO) {
        return itemTextService.findByItemId(itemDTO.id())
            .map(itemTextDTO -> itemDTO.toBuilder().data(itemTextDTO).build());
    }

    private Mono<ItemDTO> aggregateItemVideo(ItemDTO itemDTO) {
        return itemVideoService.findByItemId(itemDTO.id())
            .map(itemVideoDTO -> itemDTO.toBuilder().data(itemVideoDTO).build());
    }
}
