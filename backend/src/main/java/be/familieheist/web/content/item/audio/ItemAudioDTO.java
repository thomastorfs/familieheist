package be.familieheist.web.content.item.audio;

import be.familieheist.web.content.item.ItemDataDTO;
import lombok.Builder;

@Builder
public record ItemAudioDTO(
    String id,
    String audioUri
) implements ItemDataDTO<ItemAudioDTO> {
}
