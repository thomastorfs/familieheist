package be.familieheist.web.content.node.domain;

import java.util.ArrayList;
import java.util.List;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;

//@Entity
//@Table(name = "content_page")
public class Page extends Node {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    //@ManyToMany
    //@JoinTable(name = "content_page_pagepart", joinColumns = //@JoinColumn(name = "page_id"), inverseJoinColumns = //@JoinColumn(name = "pagepart_id"))
    //@Column(name = "pageparts")
    List<Pagepart> pageparts = new ArrayList<>();

    //@Column(name = "url")
    String url;

}
