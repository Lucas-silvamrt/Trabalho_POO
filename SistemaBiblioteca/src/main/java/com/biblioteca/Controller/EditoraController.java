package com.biblioteca.Controller;

import biblioteca.Editora;
import com.biblioteca.service.EditoraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    private final EditoraService service;

    public EditoraController(EditoraService service) {
        this.service = service;
    }

    @PostMapping
    public Editora criar(@RequestBody Editora editora) {
        return service.salvar(editora);
    }

    @GetMapping
    public List<Editora> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Editora buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Editora atualizar(@PathVariable Long id, @RequestBody Editora editora) {
        return service.atualizar(id, editora);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}