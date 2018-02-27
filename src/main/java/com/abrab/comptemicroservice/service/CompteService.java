package com.abrab.comptemicroservice.service;

import com.abrab.comptemicroservice.domain.Compte;
import com.abrab.comptemicroservice.repository.CompteRepository;
import com.abrab.comptemicroservice.serviceProxy.OperatrionServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private OperatrionServiceProxy operatrionServiceProxy;

    public Compte save(Compte compte) {
        return compteRepository.save(compte);
    }

    public Compte edit(Compte compte) {
        return compteRepository.save(compte);
    }

    public List<Compte> findAll() {
        return compteRepository.findAll();
    }

    public Compte findOne(Long id) {
        return compteRepository.findOne(id);
    }

    public Compte findByRib(String rib) {
        return compteRepository.findByRibLike(rib);
    }

    public Page<Compte> pageOfComptes(String mc, PageRequest pageRequest) {
        return compteRepository.findByRibContains(mc, pageRequest);
    }

    public String delete(Long id) {
        Compte compte = compteRepository.findOne(id);
        if (compte != null) {
            long size = operatrionServiceProxy.totalOperations(compte.getRib());//^^^^
            if (size == 0) {
                compteRepository.delete(id);
                return "deleted";
            }
            return "not deleted (there are some ops !!)";
        }
        return "not deleted (there is no such an account !!)";
    }
}
