package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String HOST = "localhost:5432";
    private static final String USUARIO = "postgree";
    private static final String SENHA = "123456";
    private static final String DATABASE = "PetShop";

    private static final String URL
            = "jdbc:postgresql://" + HOST + "/" + DATABASE;

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(
                    URL, USUARIO, DATABASE
            );
        } catch (Exception e) {
            System.out.println("ERRO:" + e.getMessage());
            return null;
        }
    }

    public static void Desconectar(Connection con){
        try {
            if(con!= null){
                con.close();
            }
        } catch (Exception e) {
            System.out.println("ERRO:" + e.getMessage());
        }
    }
}
