
package br.com.pdv.dao;

import br.com.pdv.database.ConexaoSQLite;
import br.com.pdv.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class ProdutoDAO {

    public void cadastrar(Produto produto) throws SQLException {

        String sql = """
                INSERT INTO Produto
                (nome, codigo, preco, quantidade, preco_custo,
                 estoque_minimo, categoria, largura, altura,
                 comprimento, peso, ativo)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
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

            if (produto.getLargura() != null) {
                statement.setDouble(8, produto.getLargura());
            } else {
                statement.setNull(8, Types.REAL);
            }

            if (produto.getAltura() != null) {
                statement.setDouble(9, produto.getAltura());
            } else {
                statement.setNull(9, Types.REAL);
            }

            if (produto.getComprimento() != null) {
                statement.setDouble(10, produto.getComprimento());
            } else {
                statement.setNull(10, Types.REAL);
            }

            if (produto.getPeso() != null) {
                statement.setDouble(11, produto.getPeso());
            } else {
                statement.setNull(11, Types.REAL);
            }

            statement.setInt(12, produto.isAtivo() ? 1 : 0);

            statement.executeUpdate();
        }
    }
}
