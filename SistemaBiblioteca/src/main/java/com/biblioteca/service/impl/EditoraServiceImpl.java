package com.biblioteca.service.impl;

import biblioteca.Editora;
import com.biblioteca.repository.EditoraRepository;
import com.biblioteca.service.EditoraService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoraServiceImpl implements EditoraService {

    private final EditoraRepository repository;

    public EditoraServiceImpl(EditoraRepository repository) {
        this.repository = repository;
    }

    @Override
    public Editora salvar(Editora editora) {
        return repository.save(editora);
    }

    @Override
    public Editora buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Editora não encontrada"));
    }

    @Override
    public List<Editora> listar() {
        return repository.findAll();
    }

    @Override
    public Editora atualizar(Long id, Editora editora) {
        Editora existente = buscarPorId(id);
        existente.setNome(editora.getNome());
        return repository.save(existente);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}