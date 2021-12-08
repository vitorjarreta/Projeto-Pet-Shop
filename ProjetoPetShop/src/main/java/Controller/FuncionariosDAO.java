//Classe FuncionárioDAO para as função entre objeto Funcionário
//e tabela Funcionário criado no Postegree
package Controller;

import Model.Funcionarios;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionariosDAO {

    //Estabelecer conexão entre o banco de dados
    private final Connection con;

    private PreparedStatement cmd;

    public FuncionariosDAO() {
        this.con = Conexao.conectar();
    }

    //Função para inserir um novo obejto funcionário na tabela tb_funcionário
    public int inserir(Funcionarios obj) {
        try {
            String SQL = "insert into funcionarios "
                    + "(nome,email,salario,id_cargos) values (?,?,?,?)";

            cmd = con.prepareStatement(SQL);
            cmd.setString(1, obj.getNome());
            cmd.setString(2, obj.getEmail());
            cmd.setDouble(3, obj.getSalario());
            cmd.setInt(4, obj.getId_cargo());

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
    public List<Funcionarios> listar() {
        try {
            String SQL = "select * from funcionarios order by id";
            cmd = con.prepareStatement(SQL);

            List<Funcionarios> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Funcionarios funcio = new Funcionarios();
                funcio.setId(rs.getInt("id"));
                funcio.setId_cargo(rs.getInt("id_cargos"));
                funcio.setNome(rs.getString("nome"));
                funcio.setEmail(rs.getString("email"));
                funcio.setSalario(rs.getDouble("salario"));
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
    public List<Funcionarios> PesquisarNome(String nome) {
        try {
            String SQL = "select * from funcionarios where nome ilike ?";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, "%"+nome+"%");

            List<Funcionarios> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Funcionarios funcio = new Funcionarios();
                funcio.setId(rs.getInt("id"));
                funcio.setId_cargo(rs.getInt("id_cargos"));
                funcio.setNome(rs.getString("nome"));
                funcio.setEmail(rs.getString("email"));
                funcio.setSalario(rs.getDouble("salario"));
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

    //Função para pesquisar pelo id do Funcionários existentes na funcionarios
    public Funcionarios pesquisarPorID(String id) {
        try {
            String SQL = "select * from funcionarios where id = ? order by id ";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, Integer.parseInt(id));

            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Funcionarios funcio = new Funcionarios();
                funcio.setId(rs.getInt("id"));
                funcio.setId_cargo(rs.getInt("id_cargos"));
                funcio.setNome(rs.getString("nome"));
                funcio.setEmail(rs.getString("email"));
                funcio.setSalario(rs.getDouble("salario"));

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
    public int atualizar(Funcionarios obj) {
        try {
            String SQL = "update funcionarios set nome=?, email =?, salario= ?, id_cargos=? where id =?";

            cmd = con.prepareStatement(SQL);
            cmd.setString(1, obj.getNome());
            cmd.setString(2, obj.getEmail());
            cmd.setDouble(3, obj.getSalario());
            cmd.setInt(4, obj.getId_cargo());
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
