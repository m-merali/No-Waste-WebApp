package com.group20.recyclingapp.model;

import javax.persistence.*;
import javax.persistence.EntityListeners;


@Entity
@Table(name = "Recyclable_items")
public class Items {
    @Id
    private Integer itemId;
    private String itemDescription;
    
    public Items(Integer itemId, String itemDescription){
        super();
        this.itemId = itemId;
        this.itemDescription = itemDescription;
    }
    public Integer getitemId() {
        return itemId;
        }
     
    public void setitemId(Integer itemId) {
        this.itemId = itemId;
        }
     
    public String getitemDescription() {
        return itemDescription;
        }
     
    public void setitemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
        }
   
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "ITEM_ID")
      //  private Long itemId;
        
    //@Column(name = "ITEM_DESCRIPTION")
       // private String itemDescription;
//
       // public Long getitemId() {
       //     return itemId;
       // }
    //
       // public void setitemId(Long itemId) {
       //     this.itemId = itemId;
       // }
    
       // public String getitemDescription() {
      //      return itemDescription;
       // }
    
       // public void setitemDescription(String itemDescription) {
      //      this.itemDescription = itemDescription;
       // }
}
