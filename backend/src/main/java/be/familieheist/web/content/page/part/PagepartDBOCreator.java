package be.familieheist.web.content.page.part;

import java.util.UUID;

public class PagepartDBOCreator {
    public static PagepartDBO createPagepartDBOFromCreateCommand(PagepartCreateCommandDTO commandDTO) {
        PagepartDBO pagepartDBO = new PagepartDBO();
        pagepartDBO.setNew(true);
        pagepartDBO.setId(UUID.randomUUID().toString());
        pagepartDBO.setPageId(commandDTO.pageId());
        pagepartDBO.setTitle(commandDTO.title());
        commandDTO.description().ifPresent(pagepartDBO::setDescription);
        pagepartDBO.setType(commandDTO.type());
        pagepartDBO.setPosition(commandDTO.position());
        return pagepartDBO;
    }

    public static PagepartDBO createPagepartDBOFromUpdateCommand(String id, PagepartUpdateCommandDTO commandDTO) {
        PagepartDBO pagepartDBO = new PagepartDBO();
        pagepartDBO.setId(id);
        pagepartDBO.setTitle(commandDTO.title());
        commandDTO.description().ifPresent(pagepartDBO::setDescription);
        pagepartDBO.setPosition(commandDTO.position());
        return pagepartDBO;
    }
}
