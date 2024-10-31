package org.example.joueurs.Repository;

import jakarta.transaction.Transactional;
import org.example.joueurs.Entities.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {

    @Query("SELECT j FROM Joueur j ORDER BY j.nbbuts DESC")
    List<Joueur> findAllOrderByNbButsDesc();

    @Modifying
    @Transactional
    @Query("UPDATE Joueur j SET j.nbbuts = j.nbbuts + :nouveauNB WHERE j.id = :id")
    void incrementNbButs(@Param("id") Long id, @Param("nouveauNB") Integer nouveau);
}