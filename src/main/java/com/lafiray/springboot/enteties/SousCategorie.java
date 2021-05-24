package com.lafiray.springboot.enteties;

import javax.persistence.OneToMany;
import java.util.Collection;

public class SousCategorie {
    private String nom;

    @OneToMany
    private Collection<Piece> pieces;
}
