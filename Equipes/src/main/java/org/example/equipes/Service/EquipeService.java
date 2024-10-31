package org.example.equipes.Service;

import org.example.equipes.Entities.Equipe;
import org.example.equipes.Repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    public Equipe createEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    public Equipe getEquipeById(Long id) {
        return equipeRepository.findById(id).orElse(null);
    }

    public Equipe updateEquipe(Equipe equipe, Long id) {
        return equipeRepository.findById(id).map(e->{
            e.setNumSerie(equipe.getNumSerie());
            e.setCode(equipe.getCode());
            e.setLibelle(equipe.getLibelle());
            return equipeRepository.save(e);
        }).orElseThrow(()->new RuntimeException("Equipe not found"));
    }

    public void deleteEquipe(Long id) {
        equipeRepository.deleteById(id);
    }
}
