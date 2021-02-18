package com.group20.recyclingapp.repository;

import com.group20.recyclingapp.model.RecyclingCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclingCentreRepository extends JpaRepository <RecyclingCentre, Long>{

}
