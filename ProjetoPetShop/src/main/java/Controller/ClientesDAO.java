//Classe FuncionárioDAO para as função entre objeto Funcionário
//e tabela Funcionário criado no Postegree
package Controller;

import Model.Clientes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {

    //Estabelecer conexão entre o banco de dados
    private final Connection con;

    private PreparedStatement cmd;

    public ClientesDAO() {
        this.con = Conexao.conectar();
    }

    //Função para inserir um novo obejto funcionário na tabela tb_funcionário
    public int inserir(Clientes obj) {
        try {
            String SQL = "insert into clientes "
                    + "(nome,cpf,email,telefone) values (?,?,?,?)";

            cmd = con.prepareStatement(SQL);
            cmd.setString(1, obj.getNome());
            cmd.setString(2, obj.getCpf());
            cmd.setString(3, obj.getEmail());
            cmd.setString(4, obj.getTelefone());

            if (cmd.executeUpdate() > 0) {
                return 1;
            } else {
                return -1;
            }

        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    //Função para criar uma lista dos valores do tb_funcionário no banco de dados
    public List<Clientes> listar() {
        try {
            String SQL = "select * from clientes order by id";
            cmd = con.prepareStatement(SQL);

            List<Clientes> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Clientes funcio = new Clientes();
                funcio.setId(rs.getInt("id"));
                funcio.setNome(rs.getString("nome"));
                funcio.setEmail(rs.getString("email"));
                funcio.setCpf(rs.getString("cpf"));
                funcio.setTelefone(rs.getString("telefone"));
                lista.add(funcio);
            }
            return lista;

        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    //Função para pesquisar a empresa a partir do id_empresa
    // da tb]-funcionario e adicionar numa lista
    public List<Clientes> PesquisarNome(String nome) {
        try {
            String SQL = "select * from clientes where nome ilike ?";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, "%"+nome+"%");

            List<Clientes> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Clientes funcio = new Clientes();
                funcio.setId(rs.getInt("id"));
                funcio.setNome(rs.getString("nome"));
                funcio.setEmail(rs.getString("email"));
                funcio.setCpf(rs.getString("cpf"));
                funcio.setTelefone(rs.getString("telefone"));
                lista.add(funcio);
            }
            return lista;
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    //Função para pesquisar pelo id do Funcionários existentes na clientes
    public Clientes pesquisarPorID(String id) {
        try {
            String SQL = "select * from clientes where id = ? order by id ";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, Integer.parseInt(id));

            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Clientes funcio = new Clientes();
                funcio.setId(rs.getInt("id"));
                funcio.setNome(rs.getString("nome"));
                funcio.setEmail(rs.getString("email"));
                funcio.setCpf(rs.getString("cpf"));
                funcio.setTelefone(rs.getString("telefone"));

                return funcio;
            }
            return null;
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    //Função para atulizar vaores existentes na tb_funcionário
    public int atualizar(Clientes obj) {
        try {
            String SQL = "update clientes set nome=?, cpf=?, email =?, telefone= ? where id =?";

            cmd = con.prepareStatement(SQL);
            cmd.setString(1, obj.getNome());
            cmd.setString(2, obj.getCpf());
            cmd.setString(3, obj.getEmail());
            cmd.setString(4, obj.getTelefone());
            cmd.setInt(5, obj.getId());

            if (cmd.executeUpdate() > 0) {
                return 1;
            } else {
                return -1;
            }

        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        } finally {
            Conexao.Desconectar(con);
        }
    }

}
