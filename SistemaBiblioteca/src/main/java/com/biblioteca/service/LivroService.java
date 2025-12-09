package com.biblioteca.service;

import biblioteca.Livro;
import java.util.List;

public interface LivroService {
	Livro salvar(Livro Livro);
	Livro buscarPorId(Long id);
    List<Livro> listar();
    Livro atualizar(Long id, Livro Livro);
    void deletar(Long id);
}