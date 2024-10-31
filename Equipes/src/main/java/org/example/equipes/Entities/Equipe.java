package org.example.equipes.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NumSerie",unique = true)
    private Long numSerie;

    @Column(name = "code")
    private String code;

    @Column(name = "libelle")
    private String libelle;
}
