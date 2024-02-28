package com.example.trash.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trash.entity.TrashEntity;

@Repository
public interface TrashRepository extends JpaRepository<TrashEntity, Long> {
	
	List<TrashEntity> findByTimestampBefore(LocalDateTime timestamp);
}
