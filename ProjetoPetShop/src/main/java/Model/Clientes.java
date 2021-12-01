package Model;

public class Clientes {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private int id_pets;

    public Clientes() {
    }

    public Clientes(int id, String nome, String cpf, String email, String telefone, int id_pets) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.id_pets = id_pets;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId_pets() {
        return id_pets;
    }

    public void setId_pets(int id_pets) {
        this.id_pets = id_pets;
    }
    
    
}
