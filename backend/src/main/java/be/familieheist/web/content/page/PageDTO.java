package be.familieheist.web.content.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public record PageDTO(
    @Schema(description = "Identifier for a Content Page", example = "10b054f1-a472-40c6-abed-895492271b96")
    String id,
    @Schema(description = "The title of the Content Page", example = "The Family Tree")
    String title,
    @Schema(description = "The description of the Content Page", example = "This page shows a family tree")
    String description,
    @Schema(description = "The URL in order to access the Content Page in the Front-End", example = "familytree")
    String url,
    @Schema(description = "The Content Page Parts that belong to this page")
    List<PagepartDTO> pageparts
) {
}
