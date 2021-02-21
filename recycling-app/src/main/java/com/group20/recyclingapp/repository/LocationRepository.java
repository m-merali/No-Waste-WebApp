package com.group20.recyclingapp.repository;

import com.group20.recyclingapp.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository <Location, Long> {
}
