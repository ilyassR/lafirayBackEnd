package com.lafiray.springboot.repository;

import com.lafiray.springboot.enteties.SubCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface SubCategoryRepository extends CrudRepository<SubCategory, UUID> {
    List<SubCategory> findByCategoryName(String name);
    List<SubCategory> findByName(String name);
}
