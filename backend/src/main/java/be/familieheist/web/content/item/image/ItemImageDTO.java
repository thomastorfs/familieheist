package be.familieheist.web.content.item.image;

import be.familieheist.web.content.item.ItemDataDTO;
import lombok.Builder;

@Builder
public record ItemImageDTO(
    String id,
    String imageUri
) implements ItemDataDTO<ItemImageDTO> {
}
