package be.familieheist.web.content.page;

import java.util.UUID;

public class PageDBOCreator {
    public static PageDBO createDBOFromCreateCommand(PageCreateCommandDTO commandDTO) {
        PageDBO pageDBO = new PageDBO();
        pageDBO.setNew(true);
        pageDBO.setId(UUID.randomUUID().toString());
        pageDBO.setTitle(commandDTO.title());
        commandDTO.description().ifPresent(pageDBO::setDescription);
        pageDBO.setUrl(commandDTO.url());
        return pageDBO;
    }

    public static PageDBO createDBOFromUpdateCommand(String id, PageUpdateCommandDTO commandDTO) {
        PageDBO pageDBO = new PageDBO();
        pageDBO.setId(id);
        pageDBO.setTitle(commandDTO.title());
        commandDTO.description().ifPresent(pageDBO::setDescription);
        pageDBO.setUrl(commandDTO.url());
        return pageDBO;
    }
}
