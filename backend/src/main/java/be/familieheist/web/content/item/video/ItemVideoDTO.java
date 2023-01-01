package be.familieheist.web.content.item.video;

import be.familieheist.web.content.item.ItemDataDTO;
import lombok.Builder;

@Builder
public record ItemVideoDTO(
    String id,
    String videoUri
) implements ItemDataDTO<ItemVideoDTO> {
}
