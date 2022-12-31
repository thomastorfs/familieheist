package be.familieheist.web.content.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record PageDTO(
    @Schema(description = "TODO", example = "TODO")
    String id,
    @Schema(description = "TODO", example = "TODO")
    String title,
    @Schema(description = "TODO", example = "TODO")
    String description,
    @Schema(description = "TODO", example = "TODO")
    String url
) {
}
