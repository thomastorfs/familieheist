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
    private String id;

    @Column("pagepart_id")
    private String pagepartId;

    @Column("order")
    private Integer order;

    @Column("title")
    private String title;

    @Column("description")
    private String description;

    @Column("type")
    private ItemType type;

    @Transient
    private boolean isNew = false;

    @Override
    public boolean isNew() {
        return isNew;
    }
}
