package be.familieheist.web.content.file.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import be.familieheist.web.content.item.domain.Item;

@Entity
@Table(name = "content_file")
public class File extends Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "filename")
    String fileName;

    @Column(name = "filepath")
    String filePath;

    @Column(name = "filetype")
    String fileType;

}
