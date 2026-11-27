package br.com.pdv;

import br.com.pdv.dao.ProdutoDAO;
import br.com.pdv.model.Produto;

import java.sql.SQLException;
import java.util.List;

public class TesteConsulta {

    public static void main(String[] args) {

        ProdutoDAO dao = new ProdutoDAO();

        try {

            System.out.println("=== TODOS OS PRODUTOS ===");

            List<Produto> produtos = dao.listarTodos();

            for (Produto produto : produtos) {

                System.out.println(
                        produto.getId() + " - "
                                + produto.getNome() + " - "
                                + produto.getCodigo()
                );
            }

            System.out.println("\n=== PESQUISA ===");

            List<Produto> encontrados =
                    dao.buscarPorNomeOuCodigo("GEEK001");

            for (Produto produto : encontrados) {

                System.out.println("Produto encontrado: "
                        + produto.getNome());

                System.out.println("Largura: "
                        + produto.getLargura());

                System.out.println("Altura: "
                        + produto.getAltura());

                System.out.println("Peso: "
                        + produto.getPeso());
            }

        } catch (SQLException e) {

            System.out.println("Erro ao consultar produtos:");
            e.printStackTrace();
        }
    }
}