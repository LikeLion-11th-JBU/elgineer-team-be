package com.elgineer.hackertonelgineer.repository;

import com.elgineer.hackertonelgineer.dto.LifeCategoryDto;
import com.elgineer.hackertonelgineer.entity.LifeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LifeCategoryRepository extends JpaRepository<LifeCategory, Long> {

}
