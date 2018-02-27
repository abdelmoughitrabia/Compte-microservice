package com.abrab.comptemicroservice.repository;

import com.abrab.comptemicroservice.domain.Compte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompteRepository extends JpaRepository<Compte, Long> {

    public Page<Compte> findByRibContains(String mc, Pageable pageable);

    public Compte findByRibLike(String rib);

}
