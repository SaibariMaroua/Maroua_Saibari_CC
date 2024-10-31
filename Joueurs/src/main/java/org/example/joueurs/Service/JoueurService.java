package org.example.joueurs.Service;

import org.example.joueurs.Client.EquipeRestFeign;
import org.example.joueurs.Entities.Joueur;
import org.example.joueurs.Module.Equipe;
import org.example.joueurs.Repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoueurService {
    @Autowired
    private JoueurRepository joueurRepository;
    @Autowired
    private EquipeRestFeign equipeRestFeign;

    public Joueur CreateJoueur(Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    public List<Joueur> GetAllJoueurs() {
        List<Joueur> joueurs = joueurRepository.findAll();
        for (Joueur joueur : joueurs) {
            Equipe equipe = equipeRestFeign.getEquipe(joueur.getIdEquipe());
            joueur.setEquipe(equipe);
        }
        return joueurs;
    }

    public Joueur GetJoueurById(Long id) {
        Joueur joueur = joueurRepository.findById(id).orElse(null);
        if (joueur != null) {
            Equipe equipe = equipeRestFeign.getEquipe(joueur.getIdEquipe());
            joueur.setEquipe(equipe);
        }
        return joueur;
    }

    public Joueur UpdateJoueur(Joueur joueur, Long id) {
        return joueurRepository.findById(id).map(j->{
            j.setNom(joueur.getNom());
            j.setPosition(joueur.getPosition());
            j.setSalaire(joueur.getSalaire());
            j.setNbbuts(joueur.getNbbuts());
            j.setIdEquipe(joueur.getIdEquipe());
            return joueurRepository.save(j);
        }).orElseThrow(()-> new RuntimeException("Joueur not found"));
    }

    public List<Joueur> GetALLDESC(){
        return joueurRepository.findAllOrderByNbButsDesc();
    }

    public void ajouterBut(Long joueurId,Integer NBAjoute) {
        joueurRepository.incrementNbButs(joueurId,NBAjoute);
    }

    public void DeleteJoueur(Long id) {
        joueurRepository.deleteById(id);
    }
}
