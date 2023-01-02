package be.familieheist.web.content.page;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record PageCreateCommandDTO(
    @Schema(description = "The title of the Content Page", example = "The Family Tree")
    String title,
    @Schema(description = "The description of the Content Page", example = "This page shows a family tree")
    String description,
    @Schema(description = "The URL in order to access the Content Page in the Front-End", example = "familytree")
    String url
) {
    public PageDBO toPageDbo() {
        PageDBO pageDBO = new PageDBO();
        pageDBO.setNew(true);
        pageDBO.setId(UUID.randomUUID().toString());
        pageDBO.setTitle(title);
        pageDBO.setDescription(description);
        pageDBO.setUrl(url);
        return pageDBO;
    }
}
