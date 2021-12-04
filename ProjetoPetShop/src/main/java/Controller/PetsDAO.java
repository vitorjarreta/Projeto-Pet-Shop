package Controller;

import Model.Pets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PetsDAO {

    private final Connection con;
    private PreparedStatement cmd;

    public PetsDAO() {
        this.con = Conexao.conectar();
    }

    public boolean inserir(Pets pt) {
        try {
            String SQL = "insert into pets"
                    + "(nome, raca)"
                    + "values (?, ?)";

            cmd = con.prepareCall(SQL);
            cmd.setString(1, pt.getNome());
            cmd.setString(2, pt.getRaca());

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

    public List<Pets> listar() {
        try {
            String SQL = "select * from pets order by id";

            cmd = con.prepareCall(SQL);

            List<Pets> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Pets pt = new Pets();
                pt.setId(rs.getInt("id"));
                pt.setNome(rs.getString("nome"));
                pt.setRaca(rs.getString("raca"));
                lista.add(pt);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO:" + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    public boolean atualizar(Pets pt) {
        try {
            String SQL = "update ptcionarios set"
                    + "nome=? where id=?";

            cmd = con.prepareStatement(SQL);
            cmd.setString(1, pt.getNome());

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

    public List<Pets> pesquisarNome(String nome) {
        try {

            String SQL = "select * from pets where nome ilike ? ordery id";
            cmd = con.prepareCall(SQL);
            cmd.setString(1, "%" + nome + "%");

            List<Pets> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Pets pt = new Pets();
                pt.setId(rs.getInt("id"));
                pt.setNome(rs.getString("nome"));
                pt.setRaca(rs.getString("raca"));
                lista.add(pt);
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
