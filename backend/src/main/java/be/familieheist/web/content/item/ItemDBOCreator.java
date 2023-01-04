package be.familieheist.web.content.item;

import java.util.UUID;

public class ItemDBOCreator {
    public static ItemDBO createDBOFromCreateCommand(ItemCreateCommandDTO commandDTO) {
        ItemDBO itemDBO = new ItemDBO();
        itemDBO.setNew(true);
        itemDBO.setId(UUID.randomUUID().toString());
        itemDBO.setPagepartId(commandDTO.pagepartId());
        itemDBO.setTitle(commandDTO.title());
        commandDTO.description().ifPresent(itemDBO::setDescription);
        itemDBO.setType(commandDTO.type());
        itemDBO.setPosition(commandDTO.position());
        return itemDBO;
    }

    public static ItemDBO createDBOFromUpdateCommand(String id, ItemUpdateCommandDTO commandDTO) {
        ItemDBO itemDBO = new ItemDBO();
        itemDBO.setId(id);
        itemDBO.setTitle(commandDTO.title());
        commandDTO.description().ifPresent(itemDBO::setDescription);
        itemDBO.setPosition(commandDTO.position());
        return itemDBO;
    }
}
