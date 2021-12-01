package Model;

public class Servicos {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int id_funcionarios;

    public Servicos() {
    }

    public Servicos(int id, String nome, String descricao, double preco, int id_funcionarios) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.id_funcionarios = id_funcionarios;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId_funcionarios() {
        return id_funcionarios;
    }

    public void setId_funcionarios(int id_funcionarios) {
        this.id_funcionarios = id_funcionarios;
    }
    
    
}
