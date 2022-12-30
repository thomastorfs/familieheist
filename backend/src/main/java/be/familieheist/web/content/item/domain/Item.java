package be.familieheist.web.content.item.domain;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;

import be.familieheist.web.content.file.domain.File;

//@Entity
//@Table(name = "content_item")
public class Item {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    //@Column(name = "title")
    String title;

    //@Column(name = "description")
    String description;

    //@Column(name = "text")
    String text;

    //@OneToOne
    //@JoinColumn(name = "content_file_id", referencedColumnName = "id")
    File file;

}
