//Classe FuncionárioDAO para as função entre objeto Funcionário
//e tabela Funcionário criado no Postegree
package Controller;

import Model.Produtos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    //Estabelecer conexão entre o banco de dados
    private final Connection con;

    private PreparedStatement cmd;

    public ProdutosDAO() {
        this.con = Conexao.conectar();
    }

    //Função para inserir um novo obejto funcionário na tabela tb_funcionário
    public int inserir(Produtos obj) {
        try {
            String SQL = "insert into produtos "
                    + "(nome,descrição,preco,quantidade) values (?,?,?,?)";

            cmd = con.prepareStatement(SQL);
            cmd.setString(1, obj.getNome());
            cmd.setString(2, obj.getDescricao());
            cmd.setDouble(3, obj.getPreco());
            cmd.setInt(4, obj.getQuantidade());

            if (cmd.executeUpdate() > 0) {
                return 1;
            } else {
                return -1;
            }

        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    //Função para criar uma lista dos valores do tb_funcionário no banco de dados
    public List<Produtos> listar() {
        try {
            String SQL = "select * from produtos order by id";
            cmd = con.prepareStatement(SQL);

            List<Produtos> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Produtos funcio = new Produtos();
                funcio.setId(rs.getInt("id"));
                funcio.setNome(rs.getString("nome"));
                funcio.setDescricao(rs.getString("descrição"));
                funcio.setPreco(rs.getDouble("preco"));
                funcio.setQuantidade(rs.getInt("quantidade"));
                lista.add(funcio);
            }
            return lista;

        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    //Função para pesquisar a empresa a partir do id_empresa
    // da tb]-funcionario e adicionar numa lista
    public List<Produtos> PesquisarNome(String nome) {
        try {
            String SQL = "select * from produtos where nome ilike ?";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, "%"+nome+"%");

            List<Produtos> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Produtos funcio = new Produtos();
                funcio.setId(rs.getInt("id"));
                funcio.setNome(rs.getString("nome"));
                funcio.setDescricao(rs.getString("descrição"));
                funcio.setPreco(rs.getDouble("preco"));
                funcio.setQuantidade(rs.getInt("quantidade"));;
                lista.add(funcio);
            }
            return lista;
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    //Função para pesquisar pelo id do Funcionários existentes na produtos
    public Produtos pesquisarPorID(String id) {
        try {
            String SQL = "select * from produtos where id = ? order by id ";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, Integer.parseInt(id));

            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Produtos funcio = new Produtos();
                funcio.setId(rs.getInt("id"));
                funcio.setNome(rs.getString("nome"));
                funcio.setDescricao(rs.getString("descrição"));
                funcio.setPreco(rs.getDouble("preco"));
                funcio.setQuantidade(rs.getInt("quantidade"));

                return funcio;
            }
            return null;
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    //Função para atulizar vaores existentes na tb_funcionário
    public int atualizar(Produtos obj) {
        try {
            String SQL = "update produtos set nome=?, descrição=?, preco= ?, quantidade=? where id =?";

            cmd = con.prepareStatement(SQL);
            cmd.setString(1, obj.getNome());
            cmd.setString(2, obj.getDescricao());
            cmd.setDouble(3, obj.getPreco());
            cmd.setInt(4, obj.getQuantidade());
            cmd.setInt(5, obj.getId());

            if (cmd.executeUpdate() > 0) {
                return 1;
            } else {
                return -1;
            }

        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        } finally {
            Conexao.Desconectar(con);
        }
    }

}
