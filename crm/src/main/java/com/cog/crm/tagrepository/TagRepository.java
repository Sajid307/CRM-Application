package com.cog.crm.tagrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cog.crm.entity.TagEntity;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Integer> {

}
