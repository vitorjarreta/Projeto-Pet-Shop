package Controller;

import Model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {

    private final Connection con;
    private PreparedStatement cmd;

    public ClientesDAO(Connection con) {
        this.con = Conexao.conectar();
    }

    public boolean inserir(Clientes cli) {
        try {
            String SQL = "insert into clientes"
                    + "(nome,cpf, email, telefone, id_pets)"
                    + "values (?,?,?,?,?)";

            cmd = con.prepareCall(SQL);
            cmd.setString(1, cli.getNome());
            cmd.setString(2, cli.getCpf());
            cmd.setString(3, cli.getEmail());
            cmd.setString(4, cli.getTelefone());
            cmd.setInt(5, cli.getId_pets());

            ResultSet rs = cmd.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.err.println("ERRO:" + e.getMessage());
            return false;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    public List<Clientes> listar() {
        try {
            String SQL = "select * from clientes order by id";

            cmd = con.prepareCall(SQL);

            List<Clientes> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Clientes cli = new Clientes();
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setCpf(rs.getString("cpf"));
                cli.setEmail(rs.getString("email"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setId_pets(rs.getInt("id_pets"));
                lista.add(cli);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO:" + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    public boolean atualizar(Clientes cli) {
        try {
            String SQL = "update clientes set"
                    + "nome=?, cpf=?, email=?, telefone=?, id_pets=? where id=?";

            cmd = con.prepareStatement(SQL);
            cmd.setString(1, cli.getNome());
            cmd.setString(2, cli.getCpf());
            cmd.setString(3, cli.getEmail());
            cmd.setString(4, cli.getTelefone());
            cmd.setInt(5, cli.getId_pets());

            ResultSet rs = cmd.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println("ERRO:" + e.getMessage());
            return false;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    public List<Clientes> pesquisarPets(String id) {
        try {

            String SQL = "select * from clientes where id_pets=?";
            cmd = con.prepareCall(SQL);
            cmd.setInt(1, Integer.parseInt(id));

            List<Clientes> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Clientes cli = new Clientes();
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setCpf(rs.getString("cpf"));
                cli.setEmail(rs.getString("email"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setId_pets(rs.getInt("id_pets"));
                lista.add(cli);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO:" + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    public List<Clientes> pesquisarNome(String nome) {
        try {

            String SQL = "select * from clientes where nome ilike ? ordery id";
            cmd = con.prepareCall(SQL);
            cmd.setString(1, "%" + nome + "%");

            List<Clientes> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Clientes cli = new Clientes();
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setCpf(rs.getString("cpf"));
                cli.setEmail(rs.getString("email"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setId_pets(rs.getInt("id_pets"));
                lista.add(cli);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO:" + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }

}
