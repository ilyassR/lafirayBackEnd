package com.lafiray.springboot.repository;

import com.lafiray.springboot.enteties.Category;
import com.lafiray.springboot.enteties.SubCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends CrudRepository<Category, UUID> {

}
