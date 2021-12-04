package Controller;

import Model.Pedidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PedidosDAO {

    private final Connection con;
    private PreparedStatement cmd;

    public PedidosDAO() {
        this.con = Conexao.conectar();
    }

    public boolean inserir(Pedidos ped) {
        try {
            String SQL = "insert into pedidos"
                    + "(id_clientes, id_produtos, quantidade)"
                    + "values (?,?,?)";

            cmd = con.prepareCall(SQL);
            cmd.setInt(1, ped.getId_clientes());
            cmd.setInt(2, ped.getId_produtos());
            cmd.setInt(3, ped.getQuantidade());

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

    public List<Pedidos> listar() {
        try {
            String SQL = "select * from pedidos order by id";

            cmd = con.prepareCall(SQL);

            List<Pedidos> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Pedidos ped = new Pedidos();
                ped.setId(rs.getInt("id"));
                ped.setId_clientes(rs.getInt("id_clientes"));
                ped.setId_produtos(rs.getInt("id_produtos"));
                ped.setQuantidade(rs.getInt("quantidade"));

                lista.add(ped);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO:" + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    public boolean atualizar(Pedidos ped) {
        try {
            String SQL = "update pedidos set"
                    + "id_clientes=?, id_pedidos=?, quantidade=? where id=?";

            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, ped.getId_clientes());
            cmd.setInt(2, ped.getId_produtos());
            cmd.setInt(3, ped.getQuantidade());

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

    public List<Pedidos> pesquisarCliente(String id) {
        try {

            String SQL = "select * from pedidos where id_clientes=?";
            cmd = con.prepareCall(SQL);
            cmd.setInt(1, Integer.parseInt(id));

            List<Pedidos> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Pedidos ped = new Pedidos();
                ped.setId(rs.getInt("id"));
                ped.setId_clientes(rs.getInt("id_clientes"));
                ped.setId_produtos(rs.getInt("id_produtos"));
                ped.setQuantidade(rs.getInt("quantidade"));
                lista.add(ped);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO:" + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    /*public List<Pedidos> pesquisarNome(String nome) {
        try {

            String SQL = "select * from pedidos where nome ilike ? ordery id";
            cmd = con.prepareCall(SQL);
            cmd.setString(1, "%" + nome + "%");

            List<Pedidos> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Pedidos ped = new Pedidos();
                ped.setId(rs.getInt("id"));
                ped.setId(rs.getInt("nome"));
                ped.setId(rs.getInt("salario"));
                ped.setId(rs.getInt("email"));
                ped.setId(rs.getInt("id_cargos"));
                lista.add(ped);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO:" + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }*/

}
