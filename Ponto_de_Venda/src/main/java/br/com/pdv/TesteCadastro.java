
package br.com.pdv;

import br.com.pdv.dao.ProdutoDAO;
import br.com.pdv.model.Produto;

import java.sql.SQLException;

public class TesteCadastro {

    public static void main(String[] args) {

        Produto produto = new Produto();

        produto.setNome("Camiseta Geek");
        produto.setCodigo("GEEK001");
        produto.setPreco(59.90);
        produto.setQuantidade(10);
        produto.setPrecoCusto(30.00);
        produto.setEstoqueMinimo(2);
        produto.setCategoria("Roupas");
        produto.setAtivo(true);

        // Medidas opcionais: não informadas
        produto.setLargura(null);
        produto.setAltura(null);
        produto.setComprimento(null);
        produto.setPeso(null);

        ProdutoDAO dao = new ProdutoDAO();

        try {
            dao.cadastrar(produto);

            System.out.println("Produto cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar produto:");
            e.printStackTrace();
        }
    }
}
