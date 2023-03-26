package com.lafiray.springboot.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.lafiray.springboot.enteties.Category;
import com.lafiray.springboot.enteties.SubCategory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.validation.constraints.AssertFalse;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/*
Nowadays Unit Test is so important in Software Development, and Spring Framework also
provides @DataJpaTest annotation to make writing test for JPA Repository more simpler.
In this tutorial, we’re gonna look at how to apply @DataJpaTest in our Spring Boot Project
with TestEntityManager, then run with JUnit 5.
 */
@DataJpaTest
class SubCategoryRepositoryTest {

    @Autowired
    SubCategoryRepository subCategoryRepository;

    @Autowired
    CategoryRepository categoryRepository;

    SubCategory s1;
    SubCategory s2;
    @BeforeEach
    void setUp() {
        Category c = Category.builder()
                .id(UUID.randomUUID())
                .name("Classic")
                .build();
        s1 = SubCategory.builder()
                .id(UUID.randomUUID())
                .category(c)
                .name("Cabriolet")
                .build();
        s2 = SubCategory.builder()
                .id(UUID.randomUUID())
                .category(c)
                .name("Coupé")
                .build();
        categoryRepository.save(c);
    }

    @Test
    void findByName() {
        assertEquals(1, 1);
        List<SubCategory> s = subCategoryRepository.findByName("Cabriolet");
        assertFalse(s.isEmpty());
        assertEquals(1, s.size());
    }

    @Test
    void findByNameContaining() {
        assertEquals(1, 1);
        List<SubCategory> s = subCategoryRepository.findByNameContaining("Cabr");
        assertFalse(s.isEmpty());
        assertEquals(1, s.size());
    }

    @Test
    void findByNameContainingIgnoreCase() {
        assertEquals(1, 1);
        List<SubCategory> s = subCategoryRepository.findByNameContainingIgnoreCase("cABr");
        assertFalse(s.isEmpty());
        assertEquals(1, s.size());
    }

    @Test
    void findByCategoryName() {
        assertEquals(1, 1);
        List<SubCategory> s = subCategoryRepository.findByCategoryName("Classic");
        assertFalse(s.isEmpty());
        assertEquals(2, s.size());
        Assertions.assertThat(s)
                .hasSize(2)
                .extracting(SubCategory::getName)
                .containsExactlyInAnyOrder(
                        s1.getName(), s2.getName()
                );
        List<Category> categoryList = s.stream().map(SubCategory::getCategory).collect(Collectors.toList());
        Assertions.assertThat(categoryList)
                .extracting(Category::getName)
                .containsExactlyInAnyOrder(
                        s1.getCategory().getName(), s2.getCategory().getName()
                );
    }

    @Test
    void findByCategoryNameContainsIgnoreCaseOrderByNameAsc() {
        assertEquals(1, 1);
        List<SubCategory> s = subCategoryRepository.findByCategoryNameContainsIgnoreCaseOrderByNameAsc("Classic");
        assertFalse(s.isEmpty());
        assertEquals(2, s.size());
        assertEquals("Cabriolet", s.get(0).getName());
        assertEquals("Coupé", s.get(1).getName());
    }

    @Test
    void findByCategoryNameContainsIgnoreCaseOrderByNameDesc() {
        List<SubCategory> s = subCategoryRepository.findByCategoryNameContainsIgnoreCaseOrderByNameDesc("Classic");
        assertFalse(s.isEmpty());
        assertEquals(2, s.size());
        assertEquals("Coupé", s.get(0).getName());
        assertEquals("Cabriolet", s.get(1).getName());
    }


    void findByCategoryNameContainsIgnore() {
        assertEquals(1, 1);
        //Sort sort = new Sort(Sort.Direction.ASC, "name");
        //List<SubCategory> s = subCategoryRepository.findByCategoryNameContainsIgnore("Classic", sort);
        //assertFalse(s.isEmpty());
        //assertEquals(2, s.size());
        //assertEquals("Coupé", s.get(0).getName());
        //assertEquals("Cabriolet", s.get(1).getName());
    }

    @Test
    void findFirst1ByCategoryNameContainsIgnoreCase() {
        List<SubCategory> s = subCategoryRepository.findFirst1ByCategoryNameContainsIgnoreCaseOrderByNameDesc("Classic");
        assertFalse(s.isEmpty());
        assertEquals(1, s.size());
        assertEquals("Coupé", s.get(0).getName());
    }
}