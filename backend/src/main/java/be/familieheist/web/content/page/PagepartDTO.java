package be.familieheist.web.content.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
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
    Integer position
) implements Comparable<PagepartDTO> {
    @Override
    public int compareTo(PagepartDTO pagepartDTO) {
        return position.compareTo(pagepartDTO.position);
    }
}
