package com.lafiray.springboot.repository;

import com.lafiray.springboot.enteties.Category;
import com.lafiray.springboot.enteties.SubCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends CrudRepository<Category, UUID> {
    List<Category> findAll();

    @Query("FROM Category WHERE name = ?1")
    List<Category> findByName(String name);

    @Query("SELECT c FROM Category c WHERE c.id = ?1 AND c.name = ?2")
    List<Category> findByIdAndName(UUID id, String name);

    @Query("FROM Category ORDER BY name ASC")
    List<Category> findAllCatgorySortByNameASC();

    @Query("FROM Category ORDER BY name DESC")
    List<Category> findAllCatgorySortByNameDESC();
}
