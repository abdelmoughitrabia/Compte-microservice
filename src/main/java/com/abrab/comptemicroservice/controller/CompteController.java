package com.abrab.comptemicroservice.controller;

import com.abrab.comptemicroservice.domain.Compte;
import com.abrab.comptemicroservice.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RefreshScope//enable update of ppties at runtime , need of actuator also , curl -d {} http://localhost:port/refresh
@RestController
public class CompteController {

    @Autowired
    private CompteService compteService;
    @Autowired
    private Environment environment;
    @Value("${global}")
    private String testConf;

    @GetMapping("/conf")
    public String testConf() {
        return testConf;
    }

    @GetMapping("/comptes")
    public List<Compte> getComptes() {
        return compteService.findAll();
    }

    @GetMapping("/comptes/{id}")
    public Compte getOneCompte(@PathVariable("id") Long id) {
        return compteService.findOne(id);
    }

    @GetMapping("/comptes/rib/{rib}")
    public Compte getOneCompteByRib(@PathVariable("rib") String rib) {
        Compte compte = compteService.findByRib(rib);
        compte.setPort(environment.getProperty("local.server.port"));
        return compteService.findByRib(rib);
    }

    @GetMapping("/pageComptes")
    public Page<Compte> getPageOfCompte(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "0") int size,
            @RequestParam(name = "mc", defaultValue = "") String mc
    ) {
        return compteService.pageOfComptes(mc, new PageRequest(page, size, Sort.Direction.DESC, "dateCreation"));
    }

    @PostMapping("/compte")
    public Compte save(@RequestBody Compte compte) {
        compte.setDateCreation(new Date());
        return compteService.save(compte);
    }

    @PutMapping("/compte/{id}")
    public Compte edit(@RequestBody Compte compte, @PathVariable("id") Long id) {
        compte.setId(id);
        return compteService.edit(compte);
    }

    @DeleteMapping("/compte/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        return compteService.delete(id);
    }

}
