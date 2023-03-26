package com.lafiray.springboot.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lafiray.springboot.enteties.Category;
import com.lafiray.springboot.enteties.Piece;
import com.lafiray.springboot.enteties.SubCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import utilities.JsonUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Slf4j
class PieceReporistoryTest {

    @Autowired
    PieceReporistory pieceReporistory;

    @Autowired
    SubCategoryRepository subCategoryRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Mock
    SubCategoryRepository subCategoryRepositoryMock;

    @BeforeEach
    void setUp() throws JsonProcessingException {
        // Category Data
        Category c = Category.builder()
                .id(UUID.randomUUID())
                .name("Classic")
                .build();
        categoryRepository.save(c);

        // Subcategory Data
        UUID id1 = UUID.randomUUID();
        SubCategory pharesRetroviseur = SubCategory.builder()
                .id(id1)
                .category(c)
                .name("Phare/Retroviseur")
                .build();

        UUID id2 = UUID.randomUUID();
        SubCategory moteursComposants = SubCategory.builder()
                .id(id2)
                .category(c)
                .name("Moteur/Composants")
                .build();
        subCategoryRepository.saveAll(List.of(pharesRetroviseur, moteursComposants));

        // Piece Data
        Piece p1 = Piece.builder()
                .id(UUID.randomUUID())
                .subCategory(pharesRetroviseur)
                .nom("Anti Brouillard")
                .prix(250)
                .build();
        Piece p2 = Piece.builder()
                .id(UUID.randomUUID())
                .subCategory(pharesRetroviseur)
                .nom("Feu de brouillard arrière")
                .prix(400)
                .build();
        Piece p3 = Piece.builder()
                .id(UUID.randomUUID())
                .subCategory(moteursComposants)
                .nom("Boitier commande de boîte à vitesse")
                .prix(250)
                .build();
        Piece p4 = Piece.builder()
                .id(UUID.randomUUID())
                .subCategory(moteursComposants)
                .nom("Accumulateur de pression")
                .prix(400)
                .build();
        Piece p5 = Piece.builder()
                .id(UUID.randomUUID())
                .subCategory(moteursComposants)
                .nom("Boitier de thermostat")
                .prix(200)
                .build();
        Piece p6 = Piece.builder()
                .id(UUID.randomUUID())
                .subCategory(moteursComposants)
                .nom("Bougie de pré chauffage")
                .prix(150)
                .build();
        pieceReporistory.saveAll(List.of(p1, p2, p3, p4, p5, p6));

        /*    Mockito.when(subCategoryRepositoryMock.findById(id1)).thenReturn(pharesRetroviseurOptional);
        Mockito.when(subCategoryRepositoryMock.findById(id2)).thenReturn(moteursComposantsOptional);
        List<Piece> piecesPharesRetroviseur = List.of(p1, p2);
        List<Piece> piecesMoteursComposants = List.of(p3, p4, p5, p6);
        pieceReporistory.saveAll(List.of(p1, p2, p3, p4, p5, p6));*/
        //subCategoryRepository.saveAll(List.of(pharesRetroviseur, moteursComposants));
        log.info("List : " + JsonUtils.toJson(List.of(p1, p2, p3, p4)));
        log.info("fin");
    }

    @Test
    @Transactional
    void testFindAllPaginated() {
        log.info("...testFindAllPaginated...");

        // Which page number you want to retrieve : 0
        // How many records should be on the page : 3
        Pageable pegeable = PageRequest.of(0, 3);
        Page<Piece> b = pieceReporistory.findAll(pegeable);

        assertNotNull(b);
        assertFalse(b.isEmpty());
        log.info("testFindAllpaginated result elements : " + b.getNumber());
    }
}