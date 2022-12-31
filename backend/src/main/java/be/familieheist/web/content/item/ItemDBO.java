package be.familieheist.web.content.item;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("content_item")
public class ItemDBO implements Persistable<String> {
    @Id
    @Column("id")
    String id;

    @Column("pagepart_id")
    String pagepartId;

    @Column("order")
    Integer order;

    @Column("title")
    String title;

    @Column("description")
    String description;

    @Column("type")
    ItemType type;

    @Transient
    private boolean isNew = false;

    @Override
    public boolean isNew() {
        return isNew;
    }
}
