package com.group20.recyclingapp.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public class Recycablerepo {

    


@Query(value = "select * from recycling_items where"
                +"MATCH (recycling_items_id, material,impact, recycle)"
                +"AGAINST('?!')", nativeQuery = true) 
        public List<Items> search(String keyword);
    
}
