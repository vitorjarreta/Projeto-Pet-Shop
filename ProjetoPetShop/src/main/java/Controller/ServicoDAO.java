package Controller;

import Model.Servicos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {
    
    private final Connection con;
    private PreparedStatement cmd;
    
    public ServicoDAO() {
        this.con = Conexao.conectar();
    }
    
    public boolean inserir(Servicos srv) {
        try {
            String SQL = "insert into servicos"
                    + "(nome, descricao, preco, id_funcionarios)"
                    + "values (?,?,?,?)";
            
            cmd = con.prepareCall(SQL);
            cmd.setString(1, srv.getNome());
            cmd.setString(2, srv.getDescricao());
            cmd.setDouble(3, srv.getPreco());
            cmd.setInt(4, srv.getId_funcionarios());
            
            
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
    
    public List<Servicos> listar() {
        try {
            String SQL = "select * from servicos order by id";
            
            cmd = con.prepareCall(SQL);
            
            List<Servicos> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Servicos srv = new Servicos();
                srv.setId(rs.getInt("id"));
                srv.setNome(rs.getString("nome"));
                srv.setDescricao(rs.getString("descricao"));
                srv.setPreco(rs.getDouble("preco"));
                srv.setId_funcionarios(rs.getInt("id_funcionarios"));

                lista.add(srv);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO:" + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }
    
    public boolean atualizar(Servicos srv) {
        try {
            String SQL = "update servicos set"
                    + "nome=?, descricao=?, preco=?, id_funcioanrios=? where id=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, srv.getNome());
            cmd.setString(2, srv.getDescricao());
            cmd.setDouble(3, srv.getPreco());
            cmd.setInt(4, srv.getId_funcionarios());
            
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
    
    /*public List<Servicos> pesquisarX(String id) {
        try {
                    
            String SQL = "select * from servicos where id_cargo=?";
            cmd = con.prepareCall(SQL);
            cmd.setInt(1, Integer.parseInt(id));
            
            List<Servicos> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Servicos srv = new Servicos();
                srv.setId(rs.getInt("id"));
                srv.setNome(rs.getString("nome"));
                srv.setSalario(rs.getDouble("salario"));
                srv.setEmail(rs.getString("email"));
                srv.setId_cargo(rs.getInt("id_cargos"));
                lista.add(srv);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO:" + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }*/
    
    public List<Servicos> pesquisarNome(String nome) {
        try {
                    
            String SQL = "select * from servicos where nome ilike ? ordery id";
            cmd = con.prepareCall(SQL);
            cmd.setString(1, "%" + nome + "%");
            
            List<Servicos> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Servicos srv = new Servicos();
                srv.setId(rs.getInt("id"));
                srv.setNome(rs.getString("nome"));
                srv.setDescricao(rs.getString("descricao"));
                srv.setPreco(rs.getDouble("preco"));
                srv.setId_funcionarios(rs.getInt("id_funcionarios"));
                lista.add(srv);
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
