
package br.com.pdv.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {

    public static void criarTabelas() {

        String sql = """
        CREATE TABLE IF NOT EXISTS Produto (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            nome TEXT NOT NULL,
            codigo TEXT NOT NULL UNIQUE,
            preco REAL NOT NULL,
            quantidade INTEGER NOT NULL DEFAULT 0,
            preco_custo REAL NOT NULL,
            estoque_minimo INTEGER NOT NULL DEFAULT 0,
            categoria TEXT,
            largura REAL,
            altura REAL,
            comprimento REAL,
            peso REAL,
            ativo INTEGER NOT NULL DEFAULT 1
        );
        """;

        try (Connection conexao = ConexaoSQLite.conectar();
             Statement statement = conexao.createStatement()) {

            statement.execute(sql);

            System.out.println("Tabela Produto criada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
}
