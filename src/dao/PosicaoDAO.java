package dao;

import model.Posicao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PosicaoDAO {

    public static void inserir(Posicao posicao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();

            String sql = "INSERT INTO posicao (id, nome) VALUES (?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, posicao.getId());
            comando.setString(2, posicao.getNome());

            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e){
            throw e;
        }
    }

    public static void alterar(Posicao posicao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();

            String sql = "UPDATE posicao SET nome = ? WHERE id = ?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, posicao.getNome());
            comando.setInt(2, posicao.getId());

            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Posicao posicao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();

            String sql = "DELETE * FROM posicao WHERE id = ? ";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, posicao.getId());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static Posicao lerPosicao(Integer id) throws  ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Posicao posicao = null;

        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM posicao WHERE id= ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet rs = comando.executeQuery();
            rs.first();
            posicao = new Posicao(rs.getInt("id"),
                    rs.getString("nome")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return posicao;
    }

    public static List<Posicao> lerTodasPosicoes() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Posicao> posicoes = new ArrayList<Posicao>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM posicao";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()) {
                Posicao posicao = new Posicao(rs.getInt("id"),
                        rs.getString("nome")
                );
            }
        } catch (SQLException e) {

        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return posicoes;
    }
}
