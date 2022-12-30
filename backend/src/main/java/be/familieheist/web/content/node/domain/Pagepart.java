package be.familieheist.web.content.node.domain;

import java.util.ArrayList;
import java.util.List;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;

import be.familieheist.web.content.item.domain.Item;

//@Entity
//@Table(name = "content_pagepart")
public class Pagepart extends Node {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    //@ManyToMany
    //@JoinTable(name = "content_pagepart_item", joinColumns = //@JoinColumn(name = "pagepart_id"), inverseJoinColumns = //@JoinColumn(name = "item_id"))
    List<Item> items = new ArrayList<>();

}
