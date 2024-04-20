package com.mastico.ToDoList.Controllers.Mapper.VO;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;



public class ListaVO extends  RepresentationModel<ListaVO> implements Serializable{
	
		private static final long serialVersionUID = 1L;
	
		@JsonProperty("id")
	    @Mapping("id")
		private Long key;
		private String nome;
		private String descricao;
		private Boolean realizado;
		private Long prioridade;
		
		
		ListaVO(){}
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + Objects.hash(prioridade, realizado, descricao, key, nome);
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			ListaVO other = (ListaVO) obj;
			return Objects.equals(prioridade, other.prioridade) && Objects.equals(realizado, other.realizado)
					&& Objects.equals(descricao, other.descricao) && Objects.equals(key, other.key)
					&& Objects.equals(nome, other.nome);
		}
		
		
		public Long getKey() {
			return key;
		}
		public void setKey(Long key) {
			this.key = key;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public Boolean getRealizado() {
			return realizado;
		}
		public void setRealizado(Boolean realizado) {
			this.realizado = realizado;
		}
		public Long getPrioridade() {
			return prioridade;
		}
		public void setPrioridade(Long prioridade) {
		    this.prioridade = prioridade;
		}

}
