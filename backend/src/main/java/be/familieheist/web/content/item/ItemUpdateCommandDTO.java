package be.familieheist.web.content.item;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Optional;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;

public record ItemUpdateCommandDTO(
    @Schema(description = "The title of the Content Item", example = "Photograph")
    String title,
    @Schema(description = "The description of the Content Item", example = "This is a picture of Uncle Bob at his wedding.", requiredMode = NOT_REQUIRED)
    Optional<String> description,
    @Schema(description = "The type of the Content Item", example = "IMAGE")
    ItemType type,
    @Schema(description = "The position of the Content Item within the Content Pagepart")
    Integer position
) {
}
