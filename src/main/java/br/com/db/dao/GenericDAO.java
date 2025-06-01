package br.com.db.dao;

import br.com.db.model.PessoaFisica;

import java.sql.*;
import java.util.*;

public abstract class GenericDAO<T> {

    protected Connection connection;

    public GenericDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract String getTableName();

    public abstract T mapResultSetToEntity(ResultSet rs) throws SQLException;

    public List<T> pesquisarAll() throws SQLException {
        List<T> list = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(mapResultSetToEntity(rs));
            }
        }
        return list;
    }

    public T pesquisarId(Long id) throws SQLException {
        String sql = "SELECT * FROM " + getTableName() + " WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEntity(rs);
                }
            }
        }
        return null;
    }

    public abstract void inserir(T entity) throws SQLException;

    public abstract void atualizar(T entity) throws SQLException;

    public void deletar(Long id) throws SQLException {
        String sql = "DELETE FROM " + getTableName() + " WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    public abstract void insert(PessoaFisica pf) throws SQLException;

    public abstract void update(PessoaFisica pf) throws SQLException;
}
