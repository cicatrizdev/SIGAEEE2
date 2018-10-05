package dao;  // fazer o excluir, ler e lerTodos

import model.Equipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipeDAO {

    public static void inserir(Equipe equipe) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO equipe (nome) VALUE (?)";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, equipe.getNomeEquipe());


            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void alterar(Equipe equipe) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE equipe SET nome = ? WHERE id = ?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, equipe.getNomeEquipe());

            comando.execute();
            BD.fecharConexao(conexao, comando);
        }catch (SQLException e){
            throw e;
        }
    }

    public static Equipe lerEquipe(Integer idEquipe) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Equipe equipe = null;

        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM equipe WHERE id = ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, idEquipe);
            ResultSet rs = comando.executeQuery();
            rs.first();
            equipe = new Equipe(rs.getInt("esporte_id"),
                    rs.getString("esporte_nome"),
                    rs.getInt("id"),
                    rs.getString("nome")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return equipe;
    }

    public static List<Equipe> lerTodasEquipes() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Equipe> equipes = new ArrayList<Equipe>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM equipe";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()) {
                Equipe equipe = new Equipe(rs.getInt("esporte_id"),
                        rs.getString("esporte_nome"),
                        rs.getInt("id"),
                        rs.getString("nome")
                );
            }
        } catch (SQLException e) {

        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return equipes;
    }
}
