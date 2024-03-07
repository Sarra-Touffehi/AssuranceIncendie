package com.dsi.application.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dsi.application.entities.Compagnie;
import com.dsi.application.repositories.CompagnieRep;

@Service
public class CompagnieService {
	@Autowired
	CompagnieRep comprep;
	


	public void saveCompagnie (MultipartFile file, String nom, String siege, String tel) {
		
		Compagnie comp= new Compagnie();
		
		
		try {
			String fileName= StringUtils.cleanPath(file.getOriginalFilename());
			if(fileName.contains("..")) {
				System.out.println("not a valid file");
			}
		comp.setLogo(file.getBytes());
		comp.setNom(nom);
		comp.setSiege(siege);
		comp.setTel(tel);
		comprep.save(comp);
		
	}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

	public List<Compagnie> getAllCompagnies(){
		return comprep.findAll();
	}
	
	
	
	public Compagnie findCompagnie(int id) {
		Optional<Compagnie> comp=comprep.findById(id);
		if(comp.isPresent())
			return comp.get();
		else
		return null;
	}
	
	public void updateCompagnie(int id, MultipartFile file, String nom, String siege, String tel) {
        Optional<Compagnie> existingCompagnie = comprep.findById(id);
        
        if (existingCompagnie.isPresent()) {
            Compagnie updatedCompagnie = existingCompagnie.get();
            
            // Mettez à jour uniquement les champs non nuls
            if (file != null) {
                try {
                    updatedCompagnie.setLogo(file.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                    // Gérer l'exception en conséquence
                }
            }
            if (nom != null) {
                updatedCompagnie.setNom(nom);
            }
            if (siege != null) {
                updatedCompagnie.setSiege(siege);
            }
            if (tel != null) {
                updatedCompagnie.setTel(tel);
            }
            
            comprep.save(updatedCompagnie);
        }
        // Si l'ID n'existe pas, vous pouvez choisir de lever une exception ou gérer de manière appropriée.
    }
	
	
	
	
	public boolean deleteCompagnie(int id) {
		comprep.deleteById(id);
		return !comprep.existsById(id);
	}
	
}
