
package br.com.pdv.dao;

import br.com.pdv.database.ConexaoSQLite;
import br.com.pdv.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {

    public void cadastrar(Produto produto) throws SQLException {

        String sql = """
                INSERT INTO Produto
                (nome, codigo, preco, quantidade, preco_custo,
                 estoque_minimo, categoria, ativo)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection conexao = ConexaoSQLite.conectar();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getCodigo());
            statement.setDouble(3, produto.getPreco());
            statement.setInt(4, produto.getQuantidade());
            statement.setDouble(5, produto.getPrecoCusto());
            statement.setInt(6, produto.getEstoqueMinimo());
            statement.setString(7, produto.getCategoria());
            statement.setInt(8, produto.isAtivo() ? 1 : 0);

            statement.executeUpdate();
        }
    }
}
