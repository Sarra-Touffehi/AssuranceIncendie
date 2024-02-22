package com.dsi.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.application.entities.Offre;
import com.dsi.application.repositories.OffreRep;

@Service
public class OffreService {
@Autowired
OffreRep offrerep;

public boolean saveOffre (Offre offre) {
if(offrerep.save(offre)!=null)
return true;
else
return false;
}

public List<Offre> getAllOffres(){
return offrerep.findAll();
}

    public boolean updateOffre(int id, Offre updatedOffre) {
        Offre existingOffre = offrerep.findById(id).orElse(null);
        if (existingOffre != null) {
            existingOffre.setNom(updatedOffre.getNom());
            existingOffre.setConditions(updatedOffre.getConditions());
            existingOffre.setCouverture(updatedOffre.getCouverture());
            existingOffre.setFrais(updatedOffre.getFrais());
            existingOffre.setTaux_risque(updatedOffre.getTaux_risque());
            offrerep.save(existingOffre);
            return true;
        } else {
            return false;
        }
    }
}