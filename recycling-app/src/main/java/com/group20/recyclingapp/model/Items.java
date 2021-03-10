package com.group20.recyclingapp.model;

import javax.persistence.*;
import javax.persistence.EntityListeners;


@Entity
@Table(name = "Recyclable_items")
public class Items {
    
    @Id
    @Column(name = "ITEM_ID")
        private Long itemId;
        
    @Column(name = "ITEM_DESCRIPTION")
        private String itemDescription;
}
