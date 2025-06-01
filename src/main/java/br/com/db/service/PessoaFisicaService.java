package br.com.db.service;

import br.com.db.dao.PessoaFisicaDAO;
import br.com.db.model.PessoaFisica;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PessoaFisicaService {

    private final PessoaFisicaDAO dao;

    public PessoaFisicaService(Connection connection) {
        this.dao = new PessoaFisicaDAO(connection);
    }

    public List<PessoaFisica> listarTodos() throws SQLException {
        return dao.pesquisarAll();
    }

    public PessoaFisica buscarPorId(Long id) throws SQLException {
        return dao.pesquisarId(id);
    }

    public void criar(PessoaFisica pf) throws SQLException {
        // Aqui você pode adicionar validações, ex: CPF não pode estar vazio
        dao.insert(pf);
    }

    public void atualizar(PessoaFisica pf) throws SQLException {
        dao.update(pf);
    }

    public void deletar(Long id) throws SQLException {
        dao.deletar(id);
    }
}

