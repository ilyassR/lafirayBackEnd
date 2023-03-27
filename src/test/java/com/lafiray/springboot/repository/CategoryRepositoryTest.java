package com.lafiray.springboot.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.assertj.core.api.Assertions;

import com.lafiray.springboot.enteties.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import utilities.JsonUtils;

import java.util.List;
import java.util.UUID;

@DataJpaTest
@Slf4j
public class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;

    UUID id = UUID.randomUUID();

    @BeforeEach
    void setup() {
        Category c1 = Category.builder()
                .id(UUID.randomUUID())
                .name("c1")
                .build();
        Category c2 = Category.builder()
                .id(UUID.randomUUID())
                .name("c2")
                .build();

        Category c3 = Category.builder()
                .id(id)
                .name("c3")
                .build();
        Category d1 = Category.builder()
                .id(UUID.randomUUID())
                .name("d1")
                .build();
        categoryRepository.saveAll(List.of(c1, c2, c3, d1));
    }

    @Test
    @Transactional
    void testFindAll() {
        log.info("...testFindAll...");
        List<Category> categoryList = categoryRepository.findAll();
        assertFalse(categoryList.isEmpty());
    }

    @Test
    @Transactional
    void testfindByName() {
        log.info("...testFindAll...");
        List<Category> categoryList = categoryRepository.findByName("c1");
        assertFalse(categoryList.isEmpty());
        assertEquals(1, categoryList.size());
        Assertions.assertThat(categoryList)
                .extracting(Category::getName)
                .containsExactlyInAnyOrder(
                        "c1"
                );
    }

    @Test
    @Transactional
    void testfindByNameAndId() {
        log.info("...testFindAll...");
        List<Category> categoryList = categoryRepository.findByIdAndName(id,"c3");
        assertFalse(categoryList.isEmpty());
        assertEquals(1, categoryList.size());
        Assertions.assertThat(categoryList)
                .extracting(Category::getName)
                .containsExactlyInAnyOrder(
                        "c3"
                );
    }

    @Test
    @Transactional
    void testFindAllCatgorySortByNameASC() throws JsonProcessingException {
        log.info("...testFindAllCatgorySortByName...");
        List<Category> categoryList = categoryRepository.findAllCatgorySortByNameASC();
        assertEquals(1,1);
        Assertions.assertThat(categoryList)
                .extracting(Category::getName)
                .containsExactly("Classic", "c1", "c2", "c3", "moderne");

        //log.info("results : " + JsonUtils.toJson(categoryList));
    }

    @Test
    @Transactional
    void testFindAllCatgorySortByNameDESC() throws JsonProcessingException {
        log.info("...testFindAllCatgorySortByName...");
        List<Category> categoryList = categoryRepository.findAllCatgorySortByNameDESC();
        Assertions.assertThat(categoryList)
                .extracting(Category::getName)
                .containsExactly("moderne", "c3", "c2", "c1", "Classic");
        //log.info("results : " + JsonUtils.toJson(categoryList));
    }

    @Test
    @Transactional
    void testFindNomCategoryTriee() throws JsonProcessingException {
        log.info("...testFindNomCategoryTriee...");
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        List<Category> categoryList = categoryRepository.findNomCategoryOrderParameter("c", sort);
        Assertions.assertThat(categoryList)
                .extracting(Category::getName)
                .containsExactly("Classic", "c1", "c2", "c3");
    }

    @Test
    @Transactional
    void testFindBynomeCatContainingIgnoreCase() throws JsonProcessingException {
        log.info("...findBynomeCatContainingIgnoreCaseSort...");
        List<Category> categoryList = categoryRepository.findBynomeCatContainingIgnoreCase("d");
        Assertions.assertThat(categoryList)
                .extracting(Category::getName)
                .containsExactlyInAnyOrder("d1", "moderne");
    }

    @Test
    @Transactional
    void testFindAllCategoryPaginated() throws JsonProcessingException {
        log.info("...findAllCategoryPaginated...");
        Pageable pageable = PageRequest.of(0, 3);
        List<Category> categoryList = categoryRepository.findAllCategoryPaginated("c", pageable);
        Assertions.assertThat(categoryList)
                .extracting(Category::getName)
                .containsExactlyInAnyOrder("Classic", "c1", "c2");
    }

    @Test
    @Transactional
    void testFindAllAcategorySpELExpressions() throws JsonProcessingException {
        log.info("...findAllAcategorySpELExpressions...");
        List<Category> categoryList = categoryRepository.findAllAcategorySpELExpressions("c");
        Assertions.assertThat(categoryList)
                .extracting(Category::getName)
                .containsExactlyInAnyOrder("Classic", "c1", "c2", "c3");
    }
}
