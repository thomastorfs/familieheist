package be.familieheist.web.content.page;

import be.familieheist.web.content.page.part.PagepartDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.List;

@Builder(toBuilder = true)
public record PageDTO(
    @Schema(description = "Identifier for a Content Page", example = "10b054f1-a472-40c6-abed-895492271b96")
    String id,
    @Schema(description = "The title of the Content Page", example = "The Family Tree")
    String title,
    @Schema(description = "The description of the Content Page", example = "This page shows a family tree")
    String description,
    @Schema(description = "The URI in order to access the Content Page in the Front-End", example = "familytree")
    String uri,
    @Schema(description = "The date when the Content Page was created", example = "2023-01-01T00:00:00.000000000+01:00")
    ZonedDateTime datedCreated,
    @Schema(description = "The date when the Content Page was updated", example = "2023-01-04T17:32:32.112269654+01:00")
    ZonedDateTime datedUpdated,
    @Schema(description = "The username from the person who created this Content Page", example = "uncle_bob")
    String createdBy,
    @Schema(description = "The username from the person who updated this Content Page", example = "aunt_mary")
    String updatedBy,
    @Schema(description = "The Content Page Parts that belong to this page")
    List<PagepartDTO> pageparts
) {
}
