package org.example.joueurs.Client;

import org.example.joueurs.Module.Equipe;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="EQUIPES")
public interface EquipeRestFeign {
    @GetMapping("/v1/equipes/{id}")
    Equipe getEquipe(@PathVariable Long id);
}

