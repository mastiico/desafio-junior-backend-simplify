package com.mastico.ToDoList.Models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Boolean realizado;
    private Long prioridade;

    public Lista() {}

    public Lista(Long key, String nome, String descricao, Boolean realizado, Long prioridade) {
        
        this.id = key;
        this.nome = nome;
        this.descricao = descricao;
        this.realizado = realizado;
        this.prioridade = prioridade;
    }

    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
    public int hashCode() {
        return Objects.hash(prioridade, realizado, descricao, id, nome);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Lista other = (Lista) obj;
        return Objects.equals(prioridade, other.prioridade) && Objects.equals(realizado, other.realizado)
                && Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
                && Objects.equals(nome, other.nome);
    }
}
