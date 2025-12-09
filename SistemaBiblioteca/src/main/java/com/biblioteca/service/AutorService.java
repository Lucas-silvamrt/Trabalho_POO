package com.biblioteca.service;

import biblioteca.Autor;
import java.util.List;

public interface AutorService {
    Autor salvar(Autor autor);
    Autor buscarPorId(Long id);
    List<Autor> listar();
    Autor atualizar(Long id, Autor autor);
    void deletar(Long id);
}