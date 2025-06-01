
# CRUD Genérico com JDBC

Este projeto é um esboço de um **CRUD genérico em Java 1.8**, usando `JDBC` para conexão com banco de dados. Ele foi estruturado para funcionar com múltiplas tabelas, usando um `GenericDAO` reutilizável e camadas de **Model**, **DAO**, **Service** e **Controller**.

---

## Estrutura de Diretórios 

```
src/
├── controller/
│   └── PessoaFisicaController.java
├── dao/
│   ├── GenericDAO.java
│   ├── PessoaFisicaDAO.java
│   ├── DesastreDAO.java
│   ├── EntidadeGovernamentalDAO.java
│   └── MensageriaDAO.java
├── db/
│   └── ConnectionFactory.java
├── model/
│   ├── PessoaFisica.java
│   ├── Desastre.java
│   ├── EntidadeGovernamental.java
│   └── Mensageria.java
├── service/
│   ├── PessoaFisicaService.java
│   ├── DesastreService.java
│   ├── EntidadeGovernamentalService.java
│   └── MensageriaService.java
```

---

## Camadas da Aplicação

- **Model:** Representa as entidades (tabelas).
- **DAO:** Responsável por executar comandos SQL.
- **Service:** Aplica regras de negócio (se necessário).
- **Controller:** Simula interface de execução (Adaptado para API REST).
- **ConnectionFactory:** Cria conexões com o banco de dados.

---

## Como Funciona

### `GenericDAO<T>`

Classe base com métodos genéricos como:
- `findAll()`
- `findById(Long id)`
- `insert(T entity)`
- `update(T entity)`
- `delete(Long id)`
- `mapResultSetToEntity(ResultSet rs)` *(implementado por cada DAO)*

### DAO específico (ex: `PessoaFisicaDAO`)
Estende `GenericDAO<PessoaFisica>` e implementa o mapeamento de dados para a entidade.

### Service
Recebe um DAO e expõe os métodos `criar`, `atualizar`, `listarAll`, `buscarId`, `deletar`.

### Controller
Simula uma execução da aplicação (pode ser substituído por REST futuramente).

---

## Exemplo de Uso

```java
PessoaFisica pf = new PessoaFisica();
pf.setNome("João da Silva");
pf.setCpf("12345678900");
service.criar(pf);

List<PessoaFisica> pessoas = service.listarTodos();
pessoas.forEach(p -> System.out.println(p.getNome()));
```

---

## Próximos Passos

- Adicionar validações no `Service`
- Criar testes unitários com JUnit
- Adaptar para API REST com Spring Boot
- Criar `FilterDAO` para buscas dinâmicas

---

## Conexão com o Banco

Precisa de uma `ConnectionFactory.java`:

```java
public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "usuario", "senha");
    }
}
```

---

## Observações

Este projeto é uma base modular. Ele pode ser facilmente expandido para suportar:
- Outras tabelas com mapeamento simples
- API REST com Spring Boot ou Jakarta EE
- Integração com frameworks como Hibernate ou JPA

---
