package com.biblioteca.service;

import biblioteca.Editora;
import java.util.List;

public interface EditoraService {
    Editora salvar(Editora Editora);
    Editora buscarPorId(Long id);
    List<Editora> listar();
    Editora atualizar(Long id, Editora Editora);
    void deletar(Long id);
}