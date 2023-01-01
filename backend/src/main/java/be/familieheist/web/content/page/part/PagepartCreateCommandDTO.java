package be.familieheist.web.content.page.part;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record PagepartCreateCommandDTO(
    @Schema(description = "Identifier for a Content Pagepart", example = "29d062ad-969d-43e3-93f0-3efb17bbbdb5")
    String pageId,
    @Schema(description = "The generic data for the Content Pagepart")
    PagepartDTO pagepart
) {
    public PagepartDBO toDbo() {
        PagepartDBO pagepartDBO = new PagepartDBO();
        pagepartDBO.setNew(true);
        pagepartDBO.setId(UUID.randomUUID().toString());
        pagepartDBO.setTitle(pagepart.title());
        pagepartDBO.setDescription(pagepart.description());
        pagepartDBO.setType(pagepart.type());
        pagepartDBO.setPosition(pagepart.position());
        return pagepartDBO;
    }
}
