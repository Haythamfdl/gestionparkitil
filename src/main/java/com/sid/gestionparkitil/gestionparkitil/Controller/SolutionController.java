package com.sid.gestionparkitil.gestionparkitil.Controller;

import com.sid.gestionparkitil.gestionparkitil.Dto.SolutionDto;
import com.sid.gestionparkitil.gestionparkitil.Model.Probleme;
import com.sid.gestionparkitil.gestionparkitil.Model.Solution;
import com.sid.gestionparkitil.gestionparkitil.Model.Utilisateur;
import com.sid.gestionparkitil.gestionparkitil.Repo.SolutionRepo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class SolutionController {
    private SolutionRepo solutionRepo;

    public SolutionController(SolutionRepo solutionRepo) {
        this.solutionRepo = solutionRepo;
    }

    @GetMapping("/solutions/problem/{id}")
    public List<Solution> getProblemeSolutions(@PathVariable(name = "id") Long idprobleme) {
        Probleme probleme = new Probleme();
        probleme.setIdprob(idprobleme);
        return solutionRepo.findAllByProblemeAndIsdeletedOrderByDatesoumissionDesc(probleme, false);
    }

    @GetMapping("/solutions/user/{id}")
    public List<Solution> getUserSolutions(@PathVariable(name = "id") Long iduser) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setIduser(iduser);
        return solutionRepo.findAllByUserAndIsdeletedOrderByDatesoumissionDesc(utilisateur, false);
    }

    @GetMapping("/solutions/{id}")
    public Optional<Solution> getSolution(@PathVariable(name = "id") Long id) {
        return solutionRepo.findById(id);
    }

    @PostMapping(value = "/solutions", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addSolution(@RequestBody SolutionDto solutiondto) {
        solutionRepo.save(attribut(solutiondto));
    }

    @PutMapping(value = "/solutions", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateSolution(@RequestBody SolutionDto solutiondto) {
        solutionRepo.save(attribut(solutiondto));
    }

    private Solution attribut(SolutionDto solutiondto){
        Solution solution = new Solution();
        solution.setIdsol(solutiondto.getIdsol());
        solution.setTitre(solutiondto.getTitre());
        solution.setSolution(solutiondto.getSolution());
        solution.setDatesoumission(solutiondto.getDatesoumission());
        solution.setProbleme(solutiondto.getProbleme());
        solution.setUser(solutiondto.getUser());
        solution.setIsdeleted(solutiondto.getIsdeleted());
        return solution;
    }
}
