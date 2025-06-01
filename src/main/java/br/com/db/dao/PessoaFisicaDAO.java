package br.com.db.dao;

import br.com.db.model.PessoaFisica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaFisicaDAO extends GenericDAO<PessoaFisica> {

    public PessoaFisicaDAO(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return "Tabela_de_dados_pessoas_fisicas";
    }

    @Override
    public void inserir(PessoaFisica entity) throws SQLException {

    }

    @Override
    public void atualizar(PessoaFisica entity) throws SQLException {

    }

    @Override
    public PessoaFisica mapResultSetToEntity(ResultSet rs) throws SQLException {
        PessoaFisica pf = new PessoaFisica();
        pf.setId(rs.getLong("id"));
        pf.setNome(rs.getString("nome"));
        pf.setCpf(rs.getString("cpf"));
        return pf;
    }

    @Override
    public void insert(PessoaFisica pf) throws SQLException {
        String sql = "INSERT INTO " + getTableName() + " (nome, cpf) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pf.getNome());
            stmt.setString(2, pf.getCpf());
            stmt.executeUpdate();
        }
    }

    @Override
    public void update(PessoaFisica pf) throws SQLException {
        String sql = "UPDATE " + getTableName() + " SET nome = ?, cpf = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pf.getNome());
            stmt.setString(2, pf.getCpf());
            stmt.setLong(3, pf.getId());
            stmt.executeUpdate();
        }
    }
}

