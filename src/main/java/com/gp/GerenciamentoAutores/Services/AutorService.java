package com.gp.GerenciamentoAutores.Services;

import com.gp.GerenciamentoAutores.Models.AutorModel;
import com.gp.GerenciamentoAutores.Repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public AutorModel salvarAutor(AutorModel autorModel) {
        return autorRepository.save(autorModel);
    }

    public AutorModel findAutorById(Long id) {
        return autorRepository.findById(id).get();
    }

    public List<AutorModel> findAllAutores() {
        return autorRepository.findAll();
    }

    public void  deleteAutorById(Long id) {
        autorRepository.deleteById(id);
    }
}
