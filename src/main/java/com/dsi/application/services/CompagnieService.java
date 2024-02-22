package com.dsi.application.services;

import java.io.IOException;
import java.util.List;

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
		String fileName= StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		
		try {
		comp.setLogo(file.getBytes());
		
	}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		comp.setNom(nom);
		comp.setSiege(siege);
		comp.setTel(tel);
		
		comprep.save(comp);
		
	}

	public List<Compagnie> getAllCompagnies(){
		return comprep.findAll();
	}
	
	
	public boolean deleteCompagnie(int id) {
		comprep.deleteById(id);
		return !comprep.existsById(id);
	}
	
}
