package Controller;

import Model.Cargos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CargosDAO {

    private final Connection con;
    private PreparedStatement cmd;

    public CargosDAO(Connection con) {
        this.con = Conexao.conectar();
    }

    public boolean inserir(Cargos cg) {
        try {
            String SQL = "insert into cargos"
                    + "(nome)"
                    + "values (?)";

            cmd = con.prepareCall(SQL);
            cmd.setString(1, cg.getNome());

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

    public List<Cargos> listar() {
        try {
            String SQL = "select * from cargos order by id";

            cmd = con.prepareCall(SQL);

            List<Cargos> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Cargos cg = new Cargos();
                cg.setId(rs.getInt("id"));
                cg.setNome(rs.getString("nome"));
                lista.add(cg);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO:" + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    public boolean atualizar(Cargos cg) {
        try {
            String SQL = "update cgcionarios set"
                    + "nome=? where id=?";

            cmd = con.prepareStatement(SQL);
            cmd.setString(1, cg.getNome());

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

    public List<Cargos> pesquisarNome(String nome) {
        try {

            String SQL = "select * from cargos where nome ilike ? ordery id";
            cmd = con.prepareCall(SQL);
            cmd.setString(1, "%" + nome + "%");

            List<Cargos> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Cargos cg = new Cargos();
                cg.setId(rs.getInt("id"));
                cg.setNome(rs.getString("nome"));
                lista.add(cg);
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
