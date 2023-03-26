package com.lafiray.springboot.repository;

import com.lafiray.springboot.enteties.Piece;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PieceReporistory extends CrudRepository<Piece, UUID> {
    Page<Piece> findAll(Pageable pageable);
}
