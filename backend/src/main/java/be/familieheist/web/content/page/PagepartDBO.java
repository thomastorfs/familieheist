package be.familieheist.web.content.page;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("content_pagepart")
public class PagepartDBO implements Persistable<String> {
    @Id
    @Column("id")
    private String id;

    @Column("page_id")
    private String pageId;

    @Column("order")
    private Integer order;

    @Column("title")
    private String title;

    @Column("description")
    private String description;

    @Transient
    private boolean isNew = false;

    @Override
    public boolean isNew() {
        return isNew;
    }
}
