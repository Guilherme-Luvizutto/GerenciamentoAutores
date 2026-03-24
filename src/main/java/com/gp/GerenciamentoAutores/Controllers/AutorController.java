package com.gp.GerenciamentoAutores.Controllers;

import com.gp.GerenciamentoAutores.Models.AutorModel;
import com.gp.GerenciamentoAutores.Repositories.AutorRepository;
import com.gp.GerenciamentoAutores.Services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<AutorModel> salvarAutor(@RequestBody AutorModel autorModel) {
        AutorModel request =  autorService.salvarAutor(autorModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(autorModel.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<AutorModel>> findAll() {
        List<AutorModel> request = autorService.findAllAutores();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorModel> findById(@PathVariable Long id) {
        AutorModel request = autorService.findAutorById(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        autorService.deleteAutorById(id);
        return ResponseEntity.noContent().build();
    }
}
