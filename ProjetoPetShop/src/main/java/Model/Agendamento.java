package Model;

public class Agendamento {

    private int id;
    private int id_servicos;
    private int id_clientes;
    private String data;
    private int id_pets;

    public Agendamento() {
    }

    public Agendamento(int id, int id_servicos, int id_clientes, String data, int id_pets) {
        this.id = id;
        this.id_servicos = id_servicos;
        this.id_clientes = id_clientes;
        this.data = data;
        this.id_pets = id_pets;
    }

    public int getId_pets() {
        return id_pets;
    }

    public void setId_pets(int id_pets) {
        this.id_pets = id_pets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_servicos() {
        return id_servicos;
    }

    public void setId_servicos(int id_servicos) {
        this.id_servicos = id_servicos;
    }

    public int getId_clientes() {
        return id_clientes;
    }

    public void setId_clientes(int id_clientes) {
        this.id_clientes = id_clientes;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
