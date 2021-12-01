package Model;

public class Pedidos {
    private int id;
    private int id_clientes;
    private int id_produtos;
    private int quantidade;

    public Pedidos() {
    }

    public Pedidos(int id, int id_clientes, int id_produtos, int quantidade) {
        this.id = id;
        this.id_clientes = id_clientes;
        this.id_produtos = id_produtos;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_clientes() {
        return id_clientes;
    }

    public void setId_clientes(int id_clientes) {
        this.id_clientes = id_clientes;
    }

    public int getId_produtos() {
        return id_produtos;
    }

    public void setId_produtos(int id_produtos) {
        this.id_produtos = id_produtos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
