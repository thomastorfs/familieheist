package be.familieheist.web.content.page;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.ZonedDateTime;

@Data
@Table("content_page")
public class PageDBO implements Persistable<String> {
    @Id
    @Column("id")
    private String id;

    @Column("title")
    private String title;

    @Column("description")
    private String description;

    @Column("uri")
    private String uri;

    @Column("date_created")
    private ZonedDateTime dateCreated;

    @Column("date_updated")
    private ZonedDateTime dateUpdated;

    @Column("created_by")
    private String createdBy;

    @Column("updated_by")
    private String updatedBy;

    @Transient
    private boolean isNew = false;

    @Override
    public boolean isNew() {
        return isNew;
    }

    public PageDTO toDto() {
        return PageDTO.builder()
            .id(id)
            .title(title)
            .description(description)
            .uri(uri)
            .datedCreated(dateCreated)
            .datedUpdated(dateUpdated)
            .createdBy(createdBy)
            .updatedBy(updatedBy)
            .build();
    }
}
