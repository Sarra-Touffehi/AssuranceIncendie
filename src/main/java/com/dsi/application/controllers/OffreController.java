package com.dsi.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dsi.application.entities.Offre;
import com.dsi.application.services.OffreService;

@RestController
public class OffreController {
@Autowired
OffreService offreserv;
@GetMapping("/offres")
public List<Offre> getAll(){
return offreserv.getAllOffres();
}

/*@PostMapping("/offres")
public boolean addOffre(@RequestBody Offre offre) {
return offreserv.saveOffre(offre);
} */
@PostMapping("/offres")
public ResponseEntity<String> addOffre(@RequestBody Offre offre) {
    boolean saved = offreserv.saveOffre(offre);
    if (saved) {
        return ResponseEntity.ok().body("Offre ajoutée avec succès.");
    } else {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout de l'offre.");
    }
}

    @PutMapping("/offres/{id}")
    public ResponseEntity<String> updateOffre(@PathVariable("id") int
id, @RequestBody Offre updatedOffre) {
        boolean updated = offreserv.updateOffre(id, updatedOffre);
        if (updated) {
            return ResponseEntity.ok().body("Offre mise a jour.");
        } else {
            return
ResponseEntity.status(HttpStatus.NOT_FOUND).body("Impossible de mettre à jour l'offre");
        }
    }
    
    
    @PostMapping("/compagnies/{idcomp}/offres")
    public ResponseEntity<String>
ajouterOffrePourCompagnie(@PathVariable("idcomp") int
idcomp,@RequestBody Offre offre) {
        boolean ajoutReussi =
        		offreserv.ajouterOffrePourCompagnie(idcomp, offre);
        if (ajoutReussi) {
            return ResponseEntity.ok().body("Offre ajoutée avec succès pour la compagnie avec l'ID : " + idcomp);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de l'ajout de l'offre pour la compagnie avec l'ID : " + idcomp);
        }
    }

}
