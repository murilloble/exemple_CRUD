package br.com.db.controller;

import br.com.db.factory.ConnectionFactory;
import br.com.db.model.PessoaFisica;
import br.com.db.service.PessoaFisicaService;

import java.sql.Connection;
import java.util.List;

public class PessoaFisicaController {

    public static void main(String[] args) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            PessoaFisicaService service = new PessoaFisicaService(conn);

            // Criar uma pessoa
            PessoaFisica nova = new PessoaFisica();
            nova.setNome("Maria das Graças");
            nova.setCpf("98765432100");
            service.criar(nova);

            // Listar todas
            List<PessoaFisica> lista = service.listarTodos();
            lista.forEach(pf -> System.out.println(pf.getNome() + " - " + pf.getCpf()));

            // Buscar por ID
            PessoaFisica encontrada = service.buscarPorId(1L);
            System.out.println("Encontrado: " + encontrada.getNome());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

