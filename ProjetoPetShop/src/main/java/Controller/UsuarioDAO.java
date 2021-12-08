package Controller;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDAO {

    private final Connection con;
    private PreparedStatement cmd;

    public UsuarioDAO() {
        this.con = Conexao.conectar();
    }

    public boolean login(Usuario u) {
        try {

            String SQL = "select * from usuarios where usuario=? and senha=md5(?)";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, u.getUsuario());
            cmd.setString(2, u.getSenha());
            

            ResultSet rs = cmd.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }

            /*if (cmd.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }*/
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            return false;
        }finally{
            Conexao.Desconectar(con);
        }
    }
    
    public int Cadastrar(Usuario obj){
        try {
            String SQL = "insert into usuarios (usuario, senha) values (?,md5(?))";
            
            cmd =  con.prepareStatement(SQL);
            cmd.setString(1, obj.getUsuario());
            cmd.setString(2, obj.getSenha());
            
            if (cmd.executeUpdate()>0) {
                return 1;
            } else {
                return -1;
            }
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        }finally{
            Conexao.Desconectar(con);
        }
    }
    
}
