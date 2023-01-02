package be.familieheist.web.content.page;

import io.swagger.v3.oas.annotations.media.Schema;

public record PageCreateCommandDTO(
    @Schema(description = "The title of the Content Page", example = "The Family Tree")
    String title,
    @Schema(description = "The description of the Content Page", example = "This page shows a family tree")
    String description,
    @Schema(description = "The URL in order to access the Content Page in the Front-End", example = "familytree")
    String url
) {
}