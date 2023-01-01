package be.familieheist.web.content.item;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder(toBuilder = true)
public record ItemDTO<T>(
    @Schema(description = "Identifier for a Content Item", example = "e338aa98-7c37-4aa6-85ff-1e4b469074de")
    String id,
    @Schema(description = "The title of the Content Item", example = "Photograph")
    String title,
    @Schema(description = "The description of the Content Item", example = "This is a picture of Uncle Bob at his wedding.")
    String description,
    @Schema(description = "The type of the Content Item", example = "IMAGE")
    ItemType type,
    @Schema(description = "The position  of the Content Item within the Content Pagepart")
    Integer position,
    @Schema(description = "The data belonging to this Content Item")
    ItemDataDTO<T> data
) {
}
