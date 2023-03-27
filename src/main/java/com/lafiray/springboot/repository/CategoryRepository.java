package com.lafiray.springboot.repository;

import com.lafiray.springboot.enteties.Category;
import com.lafiray.springboot.enteties.SubCategory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Query("FROM Category WHERE UPPER(name) LIKE CONCAT('%', UPPER(?1), '%')")
    List<Category> findNomCategoryOrderParameter(String name, Sort sort);

    @Query("FROM Category WHERE UPPER(name) LIKE CONCAT('%', UPPER(?1), '%')")
    List<Category> findBynomeCatContainingIgnoreCase(String name);

    // Paginating Query Results
    @Query("FROM Category WHERE UPPER(name) LIKE CONCAT('%', UPPER(?1),'%')")
    List<Category> findAllCategoryPaginated(String name, Pageable pageable);

    /**SpEL Expressions*/
    @Query("FROM #{#entityName} WHERE UPPER(name) LIKE %?#{[0].toUpperCase()}%")
    List<Category> findAllAcategorySpELExpressions(String name);
}
