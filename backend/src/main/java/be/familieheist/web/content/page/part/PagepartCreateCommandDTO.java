package be.familieheist.web.content.page.part;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Optional;

public record PagepartCreateCommandDTO(
    @Schema(description = "Identifier of the Content Page which this Content Pagepart belongs to", example = "29d062ad-969d-43e3-93f0-3efb17bbbdb5")
    String pageId,
    @Schema(description = "The title of the Content Pagepart", example = "Introduction: Uncle Bob")
    String title,
    @Schema(description = "The description of the Content Pagepart", example = "This is how Uncle Bob's life started")
    Optional<String> description,
    @Schema(description = "The type of the Content Pagepart")
    PagepartType type,
    @Schema(description = "The position of the Content Pagepart within the Content Page")
    Integer position
) {
}
