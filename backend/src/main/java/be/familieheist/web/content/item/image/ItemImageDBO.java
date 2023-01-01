package be.familieheist.web.content.item.image;

import be.familieheist.web.content.item.ItemDataDBO;
import be.familieheist.web.content.item.ItemDataDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("content_item_image")
public class ItemImageDBO implements ItemDataDBO, Persistable<String> {
    @Id
    @Column("id")
    private String id;

    @Column("content_item_id")
    private String itemId;

    @Column("image_uri")
    private String imageUri;

    @Transient
    private boolean isNew = false;

    @Override
    public boolean isNew() {
        return isNew;
    }

    public ItemDataDTO toDto() {
        return ItemImageDTO.builder()
            .id(id)
            .imageUri(imageUri)
            .build();
    }
}
