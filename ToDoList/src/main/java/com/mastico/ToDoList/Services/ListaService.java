package com.mastico.ToDoList.Services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastico.ToDoList.Controllers.ListaController;
import com.mastico.ToDoList.Controllers.Mapper.DozerMapper;
import com.mastico.ToDoList.Controllers.Mapper.VO.ListaVO;
import com.mastico.ToDoList.Models.Lista;
import com.mastico.ToDoList.Repository.ListaRepository;

@Service
public class ListaService {
	
	@Autowired
	ListaRepository repository;
	
	public ListaVO create(ListaVO lista) throws Exception {
		var entity = DozerMapper.parseObject(lista, Lista.class);

		var savedEntity = repository.save(entity);
		var vo = DozerMapper.parseObject(savedEntity, ListaVO.class);
		
		vo.add(linkTo(methodOn(ListaController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	
	public ListaVO update(ListaVO lista) throws Exception  {
	    if (lista != null) {
	        var entity = repository.findById(lista.getKey()).orElse(null);

	        if(entity != null) {
	            entity.setNome(lista.getNome());
	            entity.setDescricao(lista.getDescricao());
	            entity.setPrioridade(lista.getPrioridade());
	            entity.setRealizado(lista.getRealizado());
	            
	            var updateEntity = repository.save(entity);
	            
	            var vo = DozerMapper.parseObject(updateEntity, ListaVO.class);
	            vo.add(linkTo(methodOn(ListaController.class).findById(vo.getKey())).withSelfRel());
	            return vo;
	        } else {
	            throw new RuntimeException("No records found for this ID!");
	        }
	    } else {
	        throw new RuntimeException("Invalid request body!");
	    }
	}

	
	public ListaVO findById(Long id) throws Exception {
		var entity = repository.findById(id).orElse(null);
		if(entity != null) {
			var vo = DozerMapper.parseObject(entity, ListaVO.class);
			vo.add((linkTo(methodOn(ListaController.class).findById(id)).withSelfRel()));
			return vo;
		}else {
            throw new RuntimeException("No records found for this ID!");
		}
	}
	
	public List<ListaVO> findAll(){
		var listas = DozerMapper.parseListObjects(repository.findAll(), ListaVO.class);
		
		listas
			.stream()
			.forEach(p -> {
				try {
					p.add(linkTo(methodOn(ListaController.class).findById(p.getKey())).withSelfRel());
				}catch(Exception e) {
					e.printStackTrace();
				}
			});
		return listas;
	}
	
	public ListaVO delete(Long id) {
		var entity = repository.findById(id).orElse(null);
		if(entity != null) {
			repository.delete(entity);
		}else {
            throw new RuntimeException("No records found for this ID!");
		}
		return null;
	}
}
