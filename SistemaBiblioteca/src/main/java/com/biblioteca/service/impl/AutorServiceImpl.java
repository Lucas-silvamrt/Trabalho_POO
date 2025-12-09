package com.biblioteca.service.impl;

import biblioteca.Autor;
import com.biblioteca.repository.AutorRepository;
import com.biblioteca.service.AutorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl implements AutorService {

    private final AutorRepository repository;

    public AutorServiceImpl(AutorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Autor salvar(Autor autor) {
        return repository.save(autor);
    }

    @Override
    public Autor buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado com ID: " + id));
    }

    @Override
    public List<Autor> listar() {
        return repository.findAll();
    }

    @Override
    public Autor atualizar(Long id, Autor autorDetalhes) {
        Autor existente = buscarPorId(id);

        if (autorDetalhes.getNome() != null) {
            existente.setNome(autorDetalhes.getNome());
        }
        
        return repository.save(existente);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}