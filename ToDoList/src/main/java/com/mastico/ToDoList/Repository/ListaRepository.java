package com.mastico.ToDoList.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mastico.ToDoList.Models.Lista;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Long> {}
