package be.familieheist.web.content.item;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("content_item_image")
public class ItemImageDBO implements Persistable<String> {
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
}
