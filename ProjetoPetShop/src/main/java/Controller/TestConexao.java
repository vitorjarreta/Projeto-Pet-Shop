package Controller;

import java.sql.Connection;

public class TestConexao {

    public static void main(String[] args) {
        Connection con = Conexao.conectar();
        if (con != null) {
            System.out.println("Conexão Realizada com Sucesso");
            Conexao.Desconectar(con);
        }
    }
}
