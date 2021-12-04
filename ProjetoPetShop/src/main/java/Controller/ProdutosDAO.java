package Controller;

import Model.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {
    
    private final Connection con;
    private PreparedStatement cmd;
    
    public ProdutosDAO(Connection con) {
        this.con = Conexao.conectar();
    }
    
    public boolean inserir(Produtos prod) {
        try {
            String SQL = "insert into produtos"
                    + "(nome, descrição, preco, quantidade)"
                    + "values (?,?,?,?)";
            
            cmd = con.prepareCall(SQL);
            cmd.setString(1, prod.getNome());
            cmd.setString(2, prod.getDescricao());
            cmd.setDouble(3, prod.getPreco());
            cmd.setInt(4, prod.getQuantidade());
            
            
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
    
    public List<Produtos> listar() {
        try {
            String SQL = "select * from produtos order by id";
            
            cmd = con.prepareCall(SQL);
            
            List<Produtos> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Produtos prod = new Produtos();
                prod.setId(rs.getInt("id"));
                prod.setNome(rs.getString("nome"));
                prod.setDescricao(rs.getString("descrição"));
                prod.setPreco(rs.getDouble("preco"));
                prod.setQuantidade(rs.getInt("quantidade"));

                lista.add(prod);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO:" + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }
    
    public boolean atualizar(Produtos prod) {
        try {
            String SQL = "update produtos set"
                    + "nome=?, descrição=?, preco=?, quantidade=? where id=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, prod.getNome());
            cmd.setString(2, prod.getDescricao());
            cmd.setDouble(3, prod.getPreco());
            cmd.setInt(4, prod.getQuantidade());
            
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
    
    /*public List<Produtos> pesquisarX(String id) {
        try {
                    
            String SQL = "select * from produtos where id_cargo=?";
            cmd = con.prepareCall(SQL);
            cmd.setInt(1, Integer.parseInt(id));
            
            List<Produtos> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Produtos prod = new Produtos();
                prod.setId(rs.getInt("id"));
                prod.setNome(rs.getString("nome"));
                prod.setDescricao(rs.getString("descrição"));
                prod.setPreco(rs.getDouble("preco"));
                prod.setQuantidade(rs.getInt("quantidade"));
                lista.add(prod);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO:" + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }*/
    
    public List<Produtos> pesquisarNome(String nome) {
        try {
                    
            String SQL = "select * from produtos where nome ilike ? ordery id";
            cmd = con.prepareCall(SQL);
            cmd.setString(1, "%" + nome + "%");
            
            List<Produtos> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Produtos prod = new Produtos();
                prod.setId(rs.getInt("id"));
                prod.setNome(rs.getString("nome"));
                prod.setDescricao(rs.getString("descrição"));
                prod.setPreco(rs.getDouble("preco"));
                prod.setQuantidade(rs.getInt("quantidade"));
                lista.add(prod);
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
