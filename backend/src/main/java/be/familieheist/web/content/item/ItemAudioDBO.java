package be.familieheist.web.content.item;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("content_item_audio")
public class ItemAudioDBO implements Persistable<String> {
    @Id
    @Column("id")
    String id;

    @Column("content_item_id")
    String itemId;

    @Column("audio_uri")
    String audioUri;

    @Transient
    private boolean isNew = false;

    @Override
    public boolean isNew() {
        return isNew;
    }
}
