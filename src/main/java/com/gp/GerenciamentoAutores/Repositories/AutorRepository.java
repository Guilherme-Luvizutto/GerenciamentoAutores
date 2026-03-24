package com.gp.GerenciamentoAutores.Repositories;

import com.gp.GerenciamentoAutores.Models.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<AutorModel, Long> {
}
