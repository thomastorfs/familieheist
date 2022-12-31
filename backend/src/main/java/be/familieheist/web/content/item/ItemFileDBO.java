package be.familieheist.web.content.item;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("content_item_file")
public class ItemFileDBO implements Persistable<String> {
    @Id
    @Column("id")
    String id;

    @Column("content_item_id")
    String itemId;

    @Column("file_type")
    ItemFileType fileType;

    @Column("file_name")
    String fileName;

    @Column("file_uri")
    String fileUri;

    @Transient
    private boolean isNew = false;

    @Override
    public boolean isNew() {
        return isNew;
    }
}
