package Model;

public class Funcionarios {
    private int id;
    private String nome;
    private double salario;
    private String email;
    private int id_cargo;

    public Funcionarios() {
    }

    public Funcionarios(int id, String nome, double salario, String email, int id_cargo) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.email = email;
        this.id_cargo = id_cargo;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }
    
    
}
