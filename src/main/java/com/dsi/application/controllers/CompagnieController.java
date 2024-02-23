package com.dsi.application.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dsi.application.entities.Compagnie;
import com.dsi.application.services.CompagnieService;

@RestController
public class CompagnieController {
@Autowired
CompagnieService compserv;

@GetMapping("/compagnies")
public List<Compagnie> getAll(){
	return compserv.getAllCompagnies();
}	


@PostMapping(value = "/compagnies" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public void addCompagnie(@RequestParam("file") MultipartFile file,
		@RequestParam("compnom")  String nom,  
		@RequestParam("compsiege") String siege,  
		@RequestParam("comptel") String tel ) 
		 {
	 compserv.saveCompagnie(file, nom, siege,tel);
}

@GetMapping("/compagnies/{id}")
public Compagnie getOne(@PathVariable("id") int id) {
	return compserv.findCompagnie(id);
}


@PutMapping(value = "/compagnies/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public void updateCompagnie(
        @PathVariable("id") int id,
        @RequestParam(value = "file", required = false) MultipartFile file,
        @RequestParam(value = "compnom", required = false) String nom,
        @RequestParam(value = "compsiege", required = false) String siege,
        @RequestParam(value = "comptel", required = false) String tel) {
    compserv.updateCompagnie(id, file, nom, siege, tel);
}

@DeleteMapping("/compagnies/{id}")
public boolean deleteCompagnie(@PathVariable("id") int id) {
	return compserv.deleteCompagnie(id);
}

}
