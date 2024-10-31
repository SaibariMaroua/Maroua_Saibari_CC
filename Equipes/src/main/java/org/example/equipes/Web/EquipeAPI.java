package org.example.equipes.Web;

import org.example.equipes.Entities.Equipe;
import org.example.equipes.Service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/equipes")
public class EquipeAPI {
    @Autowired
    private EquipeService equipeService;

    @PostMapping
    public ResponseEntity<Equipe> addEquipe(@RequestBody Equipe equipe) {
        Equipe equipe1 = equipeService.createEquipe(equipe);
        return ResponseEntity.ok(equipe1);
    }

    @GetMapping
    public ResponseEntity<List<Equipe>> getAllEquipes() {
        List<Equipe> equipes = equipeService.getAllEquipes();
        return ResponseEntity.ok(equipes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipe> getEquipe(@PathVariable Long id) {
        Equipe equipe = equipeService.getEquipeById(id);
        return ResponseEntity.ok(equipe);
    }

    @PutMapping("{id}")
    public ResponseEntity<Equipe> updateEquipe(@RequestBody Equipe equipe, @PathVariable Long id) {
        Equipe equipe1 = equipeService.updateEquipe(equipe, id);
        return ResponseEntity.ok(equipe1);
    }

    @DeleteMapping("{id}")
    public void deleteEquipe(@PathVariable Long id) {
        equipeService.deleteEquipe(id);
    }

}
