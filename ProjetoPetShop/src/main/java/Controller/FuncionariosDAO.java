package Controller;

import Model.Funcionarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionariosDAO {
    
    private final Connection con;
    private PreparedStatement cmd;
    
    public FuncionariosDAO() {
        this.con = Conexao.conectar();
    }
    
    public boolean inserir(Funcionarios fun) {
        try {
            String SQL = "insert into funcionarios"
                    + "(nome,salario, email, id_cargos)"
                    + "values (?,?,?,?)";
            
            cmd = con.prepareCall(SQL);
            cmd.setString(1, fun.getNome());
            cmd.setDouble(2, fun.getSalario());
            cmd.setString(3, fun.getEmail());
            cmd.setInt(4, fun.getId_cargo());
            
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
    
    public List<Funcionarios> listar() {
        try {
            String SQL = "select * from funcionarios order by id";
            
            cmd = con.prepareCall(SQL);
            
            List<Funcionarios> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Funcionarios fun = new Funcionarios();
                fun.setId(rs.getInt("id"));
                fun.setNome(rs.getString("nome"));
                fun.setSalario(rs.getDouble("salario"));
                fun.setEmail(rs.getString("email"));
                fun.setId_cargo(rs.getInt("id_cargos"));
                lista.add(fun);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO:" + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }
    
    public boolean atualizar(Funcionarios fun) {
        try {
            String SQL = "update funcionarios set"
                    + "nome=?, salario=?, email=?, id_cargos=? where id=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, fun.getNome());
            cmd.setDouble(2, fun.getSalario());
            cmd.setString(3, fun.getEmail());
            cmd.setInt(4, fun.getId_cargo());
            
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
    
    public List<Funcionarios> pesquisarCargos(String id) {
        try {
                    
            String SQL = "select * from funcionarios where id_cargo=?";
            cmd = con.prepareCall(SQL);
            cmd.setInt(1, Integer.parseInt(id));
            
            List<Funcionarios> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Funcionarios fun = new Funcionarios();
                fun.setId(rs.getInt("id"));
                fun.setNome(rs.getString("nome"));
                fun.setSalario(rs.getDouble("salario"));
                fun.setEmail(rs.getString("email"));
                fun.setId_cargo(rs.getInt("id_cargos"));
                lista.add(fun);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO:" + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }
    
    public List<Funcionarios> pesquisarNome(String nome) {
        try {
                    
            String SQL = "select * from funcionarios where nome ilike ? ordery id";
            cmd = con.prepareCall(SQL);
            cmd.setString(1, "%" + nome + "%");
            
            List<Funcionarios> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Funcionarios fun = new Funcionarios();
                fun.setId(rs.getInt("id"));
                fun.setId(rs.getInt("nome"));
                fun.setId(rs.getInt("salario"));
                fun.setId(rs.getInt("email"));
                fun.setId(rs.getInt("id_cargos"));
                lista.add(fun);
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
