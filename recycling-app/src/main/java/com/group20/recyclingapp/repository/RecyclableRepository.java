package com.group20.recyclingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.group20.recyclingapp.model.Items;

@Repository
public interface RecyclableRepository extends JpaRepository <Items, Integer> {

    @Query(value = "SELECT * FROM items WHERE MATCH(item_name, item_description AGAINST (?1)", nativeQuery = true) //query to search database for related items
        public List<Items> search(String keyword);
}
