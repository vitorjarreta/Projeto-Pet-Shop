package Controller;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    private final Connection con;
    private PreparedStatement cmd;

    public UsuarioDAO(Connection con) {
        this.con = Conexao.conectar();
    }

    public boolean Logar(Usuario u) {
        try {
            String SQL = "select * from usuarios where"
                    + "usuario=? and senha=md5(?)";

            cmd = con.prepareStatement(SQL);
            cmd.setString(1, u.getUsuario());
            cmd.setString(2, u.getSenha());

            ResultSet rs = cmd.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("ERRO:" + e.getMessage());
            return false;
        } finally {
            Conexao.Desconectar(con);

        }
    }

    public boolean Cadastrar(Usuario u) {
        try {
            String SQL = "Insert into usuario (usuario, senha)"
                    + "values (?, md5(?))";

            cmd = con.prepareStatement(SQL);
            cmd.setString(1, u.getUsuario());
            cmd.setString(2, u.getSenha());

            ResultSet rs = cmd.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("ERRO:" + e.getMessage());
            return false;
        } finally {
            Conexao.Desconectar(con);
        }
    }

}
