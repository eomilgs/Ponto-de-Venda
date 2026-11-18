package br.com.pdv.model;

public class Produto {

    private int id;
    private String nome;
    private String codigo;
    private double preco;
    private int quantidade;
    private double precoCusto;
    private int estoqueMinimo;
    private String categoria;
    private boolean ativo;

    public Produto() {
    }

    public Produto(int id, String nome, String codigo, double preco,
                   int quantidade, double precoCusto, int estoqueMinimo,
                   String categoria, boolean ativo) {

        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
        // isso é pra calcular o gasto no produto e avenda dele para saber o lucro
        this.precoCusto = precoCusto;
        this.estoqueMinimo = estoqueMinimo;
        this.categoria = categoria;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}