package com.lafiray.springboot.repository;

import com.lafiray.springboot.enteties.SubCategory;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface SubCategoryRepository extends CrudRepository<SubCategory, UUID> {
    List<SubCategory> findByCategoryName(String name);
    List<SubCategory> findByName(String name);
    List<SubCategory> findByNameContaining(String name);
    List<SubCategory> findByNameContainingIgnoreCase(String name);
    List<SubCategory> findByCategoryNameContainsIgnoreCaseOrderByNameAsc(String name);
    List<SubCategory> findByCategoryNameContainsIgnoreCaseOrderByNameDesc(String name);
    // Dynamic sort example
    List<SubCategory> findByCategoryNameContainsIgnoreCase(String name, Sort sort);

    // Limiting the number of results
    List<SubCategory> findFirst1ByCategoryNameContainsIgnoreCaseOrderByNameDesc(String name);
}
