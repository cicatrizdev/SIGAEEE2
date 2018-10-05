package dao;

import model.Atleta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AtletaDAO {

    public static void inserir(Atleta atleta) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        String sql;

        try {
            sql = "INSERT INTO usuario (nome, email, senha) values (?,?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, atleta.getNomeUsuario());
            comando.setString(2, atleta.getEmail());
            comando.setString(3, atleta.getSenha());


            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            throw e;
        }

        try {
            conexao = BD.getConexao();

            sql = "INSERT INTO atleta (peso, altura, data_nascimento) values (?,?,?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setFloat(1, atleta.getPeso());
            comando.setFloat(2, atleta.getAltura());
            comando.setString(3, atleta.getDataNascimento());
            sql = "SELECT id FROM atleta WHERE nome = ?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, atleta.getNomeUsuario());
            ResultSet rs = comando.executeQuery(sql);
            rs.first();
            atleta.setIdAtleta(rs.getInt("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void alterar (Atleta atleta) throws  SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;

        try{
            conexao = BD.getConexao();

            String sql = "UPDATE atleta SET peso = ?, altura = ?, data_nascimento = ? WHERE id = ?";
            comando = conexao.prepareStatement(sql);
            comando.setFloat(1, atleta.getPeso());
            comando.setFloat(2, atleta.getAltura());
            comando.setString(3, atleta.getDataNascimento());
            comando.setInt(4, atleta.getIdAtleta());

            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e){
            throw e;
        }
    }

    public static void excluir (Atleta atleta) throws SQLException,ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "DELETE FROM atleta WHERE id_at = ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, atleta.getIdAtleta());
            comando.execute();
        }
        catch (SQLException e){
            throw e;
        }
        finally {
            BD.fecharConexao(conexao,comando);
        }
    }

    public static Atleta lerAtleta(Integer id) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Atleta atleta = null;
        try{
            conexao = BD.getConexao();
            String sql = "SELECT * FROM atleta RIGHT JOIN usuario ON usuario.atleta_id = atleta.id WHERE id = ? ";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet rs = comando.executeQuery(sql);
            rs.first();
            atleta = new Atleta(rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getFloat("peso"),
                    rs.getFloat("altura"),
                    rs.getString("dataNascimento")
            );
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            BD.fecharConexao(conexao,comando);
        }
        return atleta;
    }

    public static List<Atleta> lerTodosAtletas() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Atleta> atletas = new ArrayList<Atleta>();
        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM atleta RIGHT JOIN usuario ON usuario.atleta_id = atleta.id";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()) {
                Atleta atleta = new Atleta(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getFloat("peso"),
                        rs.getFloat("altura"),
                        rs.getString("dataNascimento")
                );
            }
        } catch (SQLException e) {

        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return atletas;
    }
}
