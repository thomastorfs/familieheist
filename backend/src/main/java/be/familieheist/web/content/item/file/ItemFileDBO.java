package be.familieheist.web.content.item.file;

import be.familieheist.web.content.item.ItemDataDBO;
import be.familieheist.web.content.item.ItemDataDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("content_item_file")
public class ItemFileDBO implements ItemDataDBO, Persistable<String> {
    @Id
    @Column("id")
    private String id;

    @Column("content_item_id")
    private String itemId;

    @Column("file_type")
    private ItemFileType fileType;

    @Column("file_name")
    private String fileName;

    @Column("file_uri")
    private String fileUri;

    @Transient
    private boolean isNew = false;

    @Override
    public boolean isNew() {
        return isNew;
    }

    public ItemDataDTO toDto() {
        return ItemFileDTO.builder()
            .id(id)
            .fileType(fileType)
            .fileName(fileName)
            .fileUri(fileUri)
            .build();
    }
}
