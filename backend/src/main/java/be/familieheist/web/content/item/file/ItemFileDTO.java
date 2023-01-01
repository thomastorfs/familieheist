package be.familieheist.web.content.item.file;

import be.familieheist.web.content.item.ItemDataDTO;
import lombok.Builder;

@Builder
public record ItemFileDTO(
    String id,
    ItemFileType fileType,
    String fileName,
    String fileUri
) implements ItemDataDTO<ItemFileDTO> {
}
