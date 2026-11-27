
package br.com.pdv.dao;

import br.com.pdv.database.ConexaoSQLite;
import br.com.pdv.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    public List<Produto> listarTodos() throws SQLException {

        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT * FROM Produto";

        try (Connection conexao = ConexaoSQLite.conectar();
             PreparedStatement statement = conexao.prepareStatement(sql);
             ResultSet resultado = statement.executeQuery()) {

            while (resultado.next()) {

                Produto produto = mapearProduto(resultado);

                produtos.add(produto);
            }
        }

        return produtos;
    }
    public List<Produto> buscarPorNomeOuCodigo(String pesquisa)
            throws SQLException {

        List<Produto> produtos = new ArrayList<>();

        String sql = """
            SELECT * FROM Produto
            WHERE nome LIKE ?
               OR codigo LIKE ?
            """;

        try (Connection conexao = ConexaoSQLite.conectar();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            String termo = "%" + pesquisa + "%";

            statement.setString(1, termo);
            statement.setString(2, termo);

            try (ResultSet resultado = statement.executeQuery()) {

                while (resultado.next()) {

                    Produto produto = mapearProduto(resultado);

                    produtos.add(produto);
                }
            }
        }

        return produtos;
    }
    private Produto mapearProduto(ResultSet resultado)
            throws SQLException {

        Produto produto = new Produto();

        produto.setId(resultado.getInt("id"));
        produto.setNome(resultado.getString("nome"));
        produto.setCodigo(resultado.getString("codigo"));
        produto.setPreco(resultado.getDouble("preco"));
        produto.setQuantidade(resultado.getInt("quantidade"));
        produto.setPrecoCusto(resultado.getDouble("preco_custo"));
        produto.setEstoqueMinimo(resultado.getInt("estoque_minimo"));
        produto.setCategoria(resultado.getString("categoria"));

        produto.setLargura(getDoubleNullable(resultado, "largura"));
        produto.setAltura(getDoubleNullable(resultado, "altura"));
        produto.setComprimento(getDoubleNullable(resultado, "comprimento"));
        produto.setPeso(getDoubleNullable(resultado, "peso"));

        produto.setAtivo(resultado.getInt("ativo") == 1);

        return produto;
    }
    private Double getDoubleNullable(ResultSet resultado, String coluna)
            throws SQLException {

        double valor = resultado.getDouble(coluna);

        if (resultado.wasNull()) {
            return null;
        }

        return valor;
}
}

