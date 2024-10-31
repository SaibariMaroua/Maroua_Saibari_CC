package org.example.joueurs.Web;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import org.example.joueurs.Entities.Joueur;
import org.example.joueurs.Service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/joueurs")
@OpenAPIDefinition(
        info = @Info(
                title = "Gestion des Joueurs",
                description = "offre les opération pour gérer les joueurs",
                version = "1.0.0"
        ),
        servers = @Server(
                url = "http://localhost:8082/"
        )
)
public class JoueurAPI {

    @Autowired
    private JoueurService joueurService;

    @Operation(
            summary = "Ajouter un nouveau Joueur",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Joueur.class)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Bien ajoutee", content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Joueur.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Mal ajoutee")
            }
    )
    @PostMapping
    public ResponseEntity<Joueur> createJoueur(@RequestBody Joueur joueur) {
        Joueur createdJoueur = joueurService.CreateJoueur(joueur);
        return ResponseEntity.ok(createdJoueur);
    }

    @GetMapping
    public ResponseEntity<List<Joueur>> getAllJoueurs() {
        List<Joueur> joueurs = joueurService.GetAllJoueurs();
        return ResponseEntity.ok(joueurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Joueur> getJoueurById(@PathVariable Long id) {
        Joueur joueur = joueurService.GetJoueurById(id);
        return joueur != null ? ResponseEntity.ok(joueur) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Joueur> updateJoueur(@RequestBody Joueur joueur, @PathVariable Long id) {
        try {
            Joueur updatedJoueur = joueurService.UpdateJoueur(joueur, id);
            return ResponseEntity.ok(updatedJoueur);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/nbButs")
    public ResponseEntity<Joueur> updateNbButs(@PathVariable Long id, @RequestParam Integer nbbuts) {
        Joueur joueur = joueurService.GetJoueurById(id);
        if (joueur != null) {
            joueur.setNbbuts(nbbuts);
            Joueur updatedJoueur = joueurService.UpdateJoueur(joueur, id);
            return ResponseEntity.ok(updatedJoueur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJoueur(@PathVariable Long id) {
        joueurService.DeleteJoueur(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nbButsDesc")
    public ResponseEntity<List<Joueur>> getAllJoueursDescByNbButs() {
        List<Joueur> joueurs = joueurService.GetALLDESC();
        return ResponseEntity.ok(joueurs);
    }
}
