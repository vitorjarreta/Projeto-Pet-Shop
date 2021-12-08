//Classe FuncionárioDAO para as função entre objeto Funcionário
//e tabela Funcionário criado no Postegree
package Controller;

import Model.Pets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetsDAO {

    //Estabelecer conexão entre o banco de dados
    private final Connection con;

    private PreparedStatement cmd;

    public PetsDAO() {
        this.con = Conexao.conectar();
    }

    //Função para inserir um novo obejto funcionário na tabela tb_funcionário
    public int inserir(Pets obj) {
        try {
            String SQL = "insert into pets "
                    + "(nome,raca,id_clientes) values (?,?,?)";

            cmd = con.prepareStatement(SQL);
            cmd.setString(1, obj.getNome());
            cmd.setString(2, obj.getRaca());
            cmd.setInt(3, obj.getId_clientes());

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
    public List<Pets> listar() {
        try {
            String SQL = "select * from pets order by id";
            cmd = con.prepareStatement(SQL);

            List<Pets> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Pets funcio = new Pets();
                funcio.setId(rs.getInt("id"));
                funcio.setNome(rs.getString("nome"));
                funcio.setRaca(rs.getString("raca"));
                funcio.setId_clientes(rs.getInt("id_clientes"));
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
    public List<Pets> PesquisarNome(String nome) {
        try {
            String SQL = "select * from pets where nome ilike ?";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, "%"+nome+"%");;

            List<Pets> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Pets funcio = new Pets();
                funcio.setId(rs.getInt("id"));
                funcio.setNome(rs.getString("nome"));
                funcio.setRaca(rs.getString("raca"));
                funcio.setId_clientes(rs.getInt("id_clientes"));
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

    //Função para pesquisar pelo id do Funcionários existentes na pets
    public Pets pesquisarPorID(String id) {
        try {
            String SQL = "select * from pets where id = ? order by id ";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, Integer.parseInt(id));

            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Pets funcio = new Pets();
                funcio.setId(rs.getInt("id"));
                funcio.setNome(rs.getString("nome"));
                funcio.setRaca(rs.getString("raca"));
                funcio.setId_clientes(rs.getInt("id_clientes"));

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
    public int atualizar(Pets obj) {
        try {
            String SQL = "update pets set nome=?, raca=?, id_clientes= ? where id =?";

            cmd = con.prepareStatement(SQL);
            cmd.setString(1, obj.getNome());
            cmd.setString(2, obj.getRaca());
            cmd.setInt(3, obj.getId_clientes());
            cmd.setInt(4, obj.getId());

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
