package be.familieheist.web.content.page.part;

import be.familieheist.web.content.item.ItemDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public record PagepartDTO(
    @Schema(description = "Identifier for a Content Pagepart", example = "95cea6d9-7698-4a15-8751-ed5512f69bca")
    String id,
    @Schema(description = "The title of the Content Pagepart", example = "Introduction: Uncle Bob")
    String title,
    @Schema(description = "The description of the Content Pagepart", example = "This is how Uncle Bob's life started")
    String description,
    @Schema(description = "The type of the Content Pagepart")
    PagepartType type,
    @Schema(description = "The position  of the Content Pagepart within the Content Page")
    Integer position,
    @Schema(description = "The Content Items belonging to this Content Pagepart")
    List<ItemDTO> items
) {
}
