package be.familieheist.web.content.page;

import java.time.ZonedDateTime;
import java.util.UUID;

public class PageDBOCreator {
    public static PageDBO createDBOFromCreateCommand(PageCreateCommandDTO commandDTO) {
        PageDBO pageDBO = new PageDBO();
        pageDBO.setNew(true);
        pageDBO.setId(UUID.randomUUID().toString());
        pageDBO.setTitle(commandDTO.title());
        commandDTO.description().ifPresent(pageDBO::setDescription);
        pageDBO.setUri(commandDTO.uri());
        pageDBO.setDateCreated(ZonedDateTime.now());
        pageDBO.setCreatedBy("TODO get from authenticated user");
        return pageDBO;
    }

    public static PageDBO createDBOFromUpdateCommand(String id, PageUpdateCommandDTO commandDTO) {
        PageDBO pageDBO = new PageDBO();
        pageDBO.setId(id);
        pageDBO.setTitle(commandDTO.title());
        commandDTO.description().ifPresent(pageDBO::setDescription);
        commandDTO.uri().ifPresent(pageDBO::setUri);
        pageDBO.setDateUpdated(ZonedDateTime.now());
        pageDBO.setUpdatedBy("TODO get from authenticated user");
        return pageDBO;
    }
}
