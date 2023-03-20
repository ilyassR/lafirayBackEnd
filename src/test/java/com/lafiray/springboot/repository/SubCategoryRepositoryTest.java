package com.lafiray.springboot.repository;
import static org.assertj.core.api.Assertions.*;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.validation.constraints.AssertFalse;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

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
}