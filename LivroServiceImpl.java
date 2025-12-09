package com.biblioteca.service.impl;

import biblioteca.Livro;
import com.biblioteca.repository.LivroRepository;
import com.biblioteca.service.LivroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroServiceImpl implements LivroService {

    private final LivroRepository repository;

    public LivroServiceImpl(LivroRepository repository) {
        this.repository = repository;
    }

    @Override
    public Livro salvar(Livro livro) {
        // Validações adicionais podem ser feitas aqui (ex: verificar se Autor e Editora existem)
        return repository.save(livro);
    }

    @Override
    public Livro buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    @Override
    public List<Livro> listar() {
        return repository.findAll();
    }

    @Override
    public Livro atualizar(Long id, Livro livro) {
        Livro existente = buscarPorId(id);
        existente.setTitulo(livro.getTitulo());
        existente.setAnoPublicacao(livro.getAnoPublicacao());
        existente.setAutor(livro.getAutor());
        existente.setEditora(livro.getEditora());
        return repository.save(existente);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}