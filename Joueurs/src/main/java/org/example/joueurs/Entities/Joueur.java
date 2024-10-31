package org.example.joueurs.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.joueurs.Module.Equipe;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "position")
    private String position;

    @Column(name = "salaire")
    private Float salaire;

    @Column(name = "nbbuts")
    private Integer nbbuts;

    @Column(name = "Id_Equipe")
    private Long idEquipe;

    @Transient
    Equipe equipe;


}
