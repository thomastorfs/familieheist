package be.familieheist.web.content.item.text;

import be.familieheist.web.content.item.ItemDataDTO;
import lombok.Builder;

@Builder
public record ItemTextDTO(
    String id,
    String text
) implements ItemDataDTO<ItemTextDTO> {
}
