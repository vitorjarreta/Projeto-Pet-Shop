package Controller;

import Model.Agendamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO {

    private final Connection con;
    private PreparedStatement cmd;

    public AgendamentoDAO() {
        this.con = Conexao.conectar();
    }

    public boolean inserir(Agendamento agenda) {
        try {
            String SQL = "insert into agendamentos"
                    + "(id_servicos, id_clientes, dat)"
                    + "values (?,?,?)";

            cmd = con.prepareCall(SQL);
            cmd.setInt(1, agenda.getId_servicos());
            cmd.setInt(2, agenda.getId_clientes());
            cmd.setString(3, agenda.getData());

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

    public List<Agendamento> listar() {
        try {
            String SQL = "select * from agendamentos order by id";

            cmd = con.prepareCall(SQL);

            List<Agendamento> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Agendamento agenda = new Agendamento();
                agenda.setId(rs.getInt("id"));
                agenda.setId_servicos(rs.getInt("id_servicos"));
                agenda.setId_clientes(rs.getInt("id_clientes"));
                agenda.setData(rs.getString("dat"));
                lista.add(agenda);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO:" + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    public boolean atualizar(Agendamento agenda) {
        try {
            String SQL = "update agendamentos set"
                    + "id_servicos=?, id_clientes=?, dat=? where id=?";

            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, agenda.getId_servicos());
            cmd.setInt(2, agenda.getId_clientes());
            cmd.setString(3, agenda.getData());

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

    public List<Agendamento> pesquisarServico(String id) {
        try {

            String SQL = "select * from agendamentos where id_cargo=?";
            cmd = con.prepareCall(SQL);
            cmd.setInt(1, Integer.parseInt(id));

            List<Agendamento> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Agendamento agenda = new Agendamento();
                agenda.setId(rs.getInt("id"));
                agenda.setId_servicos(rs.getInt("id_servicos"));
                agenda.setId_clientes(rs.getInt("id_clientes"));
                agenda.setData(rs.getString("dat"));
                lista.add(agenda);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO:" + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    public List<Agendamento> pesquisarCliente(String id) {
        try {

            String SQL = "select * from agendamentos where id_clientes=?";
            cmd = con.prepareCall(SQL);
            cmd.setInt(1, Integer.parseInt(id));

            List<Agendamento> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Agendamento agenda = new Agendamento();
                agenda.setId(rs.getInt("id"));
                agenda.setId_servicos(rs.getInt("id_servicos"));
                agenda.setId_clientes(rs.getInt("id_clientes"));
                agenda.setData(rs.getString("dat"));
                lista.add(agenda);
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
