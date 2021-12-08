//Classe FuncionárioDAO para as função entre objeto Funcionário
//e tabela Funcionário criado no Postegree
package Controller;

import Model.Agendamento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO {

    //Estabelecer conexão entre o banco de dados
    private final Connection con;

    private PreparedStatement cmd;

    public AgendamentoDAO() {
        this.con = Conexao.conectar();
    }

    //Função para inserir um novo obejto funcionário na tabela tb_funcionário
    public int inserir(Agendamento obj) {
        try {
            String SQL = "insert into agendamentos "
                    + "(id_servicos,id_clientes,dat, id_pets) values (?,?,?,?)";

            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, obj.getId_servicos());
            cmd.setInt(2, obj.getId_clientes());
            cmd.setString(3, obj.getData());
            
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
    public List<Agendamento> listar() {
        try {
            String SQL = "select * from agendamentos order by id";
            cmd = con.prepareStatement(SQL);

            List<Agendamento> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Agendamento funcio = new Agendamento();
                funcio.setId(rs.getInt("id"));
                funcio.setId_clientes(rs.getInt("id_clientes"));
                funcio.setId_servicos(rs.getInt("id_servicos"));
                funcio.setId_pets(rs.getInt("id_pets"));
                funcio.setData(rs.getString("data"));
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
    public List<Agendamento> PesquisarNome(String nome) {
        try {
            String SQL = "select * from agendamentos where nome ilike ?";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, "%"+nome+"%");

            List<Agendamento> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Agendamento funcio = new Agendamento();
                funcio.setId(rs.getInt("id"));
                funcio.setId_clientes(rs.getInt("id_clientes"));
                funcio.setId_servicos(rs.getInt("id_servicos"));
                funcio.setId_pets(rs.getInt("id_pets"));
                funcio.setData(rs.getString("data"));
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

    //Função para pesquisar pelo id do Funcionários existentes na agendamentos
    public Agendamento pesquisarPorID(String id) {
        try {
            String SQL = "select * from agendamentos where id = ? order by id ";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, Integer.parseInt(id));

            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Agendamento funcio = new Agendamento();
                funcio.setId(rs.getInt("id"));
                funcio.setId_clientes(rs.getInt("id_clientes"));
                funcio.setId_servicos(rs.getInt("id_servicos"));
                funcio.setId_pets(rs.getInt("id_pets"));
                funcio.setData(rs.getString("data"));

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
    public int atualizar(Agendamento obj) {
        try {
            String SQL = "update agendamentos set id_servicos=?, id_clientes=?, dat= ? where id =?";

            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, obj.getId_servicos());
            cmd.setInt(2, obj.getId_clientes());
            cmd.setString(3, obj.getData());
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
