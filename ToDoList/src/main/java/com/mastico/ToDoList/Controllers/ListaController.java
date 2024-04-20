package com.mastico.ToDoList.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastico.ToDoList.Controllers.Mapper.VO.ListaVO;
import com.mastico.ToDoList.Controllers.util.MediaType;
import com.mastico.ToDoList.Services.ListaService;

@RestController
@RequestMapping("/lista")
public class ListaController {
	
	@Autowired
	private ListaService service;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
			 	 produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public ListaVO create(@RequestBody ListaVO lista) throws Exception {
		return service.create(lista);
	}
	
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public ListaVO findById(@PathVariable("id")long id)  throws Exception {
		return service.findById(id);
	}
	
	@PutMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public ListaVO update(@RequestBody ListaVO lista) throws Exception{
		return service.update(lista);
	}
	
    @GetMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public List<ListaVO>findAll() throws Exception{
    	return service.findAll();
	}

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<?> delete(@PathVariable(value= "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}


}
