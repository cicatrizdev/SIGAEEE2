package dao;

import model.Atleta;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AtletaDAO {

    public static void inserir(Atleta atleta) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;

        try{
            conexao = BD.getConexao();

            String sql = "INSERT INTO usuario (id_usuario, nome, email, senha, tipoUsuario) values(?,?,?,?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, atleta.getId());
            comando.setString(2, atleta.getNome());
            comando.setString(3, atleta.getEmail());
            comando.setString(4, atleta.getSenha());
            comando.setString(5, atleta.getTipoUsuario());

            String sql2 = "INSERT INTO atleta (id_atleta, peso, altura, data_nascimento) values (?,?,?,?)";
            comando = conexao.prepareStatement(sql2);
            comando.setLong(1, atleta.getId_atleta());
            comando.setFloat(2, atleta.getPeso());
            comando.setFloat(3, atleta.getAltura());
            comando.setDate(4, (Date) atleta.getDataNascimento());

            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e){
            throw e;
        }
    }

    public static void alterar (Atleta atleta) throws  SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;

        try{
            conexao = BD.getConexao();

            String sql = "UPDATE usuario SET nome = ?,email = ?,senha = ?, tipoUsuario = ? WHERE id_usuario = ?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, atleta.getNome());
            comando.setString(2, atleta.getEmail());
            comando.setString(3, atleta.getSenha());
            comando.setString(4, atleta.getTipoUsuario());
            comando.setLong(5, atleta.getId());

            String sql2 = "UPDATE atleta SET peso = ?, altura = ?, data_nascimento = ? WHERE id_atleta = ?";
            comando = conexao.prepareStatement(sql2);
            comando.setFloat(1, atleta.getPeso());
            comando.setFloat(2, atleta.getAltura());
            comando.setDate(3, (Date) atleta.getDataNascimento());
            comando.setLong(4, atleta.getId_atleta());

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
            String sql1 = "DELETE FROM usuario WHERE nome = ?,email = ?,senha = ?, tipoUsuario = ? id_usuario = ?";
            comando = conexao.prepareStatement(sql1);
            comando.setString(1, atleta.getNome());
            comando.setString(2, atleta.getEmail());
            comando.setString(3, atleta.getSenha());
            comando.setString(4, atleta.getTipoUsuario());
            comando.setLong(5, atleta.getId());
            comando.execute();

            String sql2 = "DELETE FROM atleta WHERE peso = ?, altura = ?, data_nascimento = ? id_atleta = ?";
            comando = conexao.prepareStatement(sql2);
            comando.setFloat(1, atleta.getPeso());
            comando.setFloat(2, atleta.getAltura());
            comando.setDate(3, (Date) atleta.getDataNascimento());
            comando.setLong(4, atleta.getId_atleta());
            comando.execute();
        }
        catch (SQLException e){
            throw e;
        }
        finally {
            BD.fecharConexao(conexao,comando);
        }
    }
    public static Atleta lerAtleta(Long id_atleta) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        Atleta atleta = null;
        try{
            conexao = BD.getConexao();
            String sql = "SELECT * FROM atleta WHERE id_atleta = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1,id_atleta);
            ResultSet rs = comando.executeQuery(sql);
            rs.first();
            atleta = new Atleta(rs.getLong("id_atleta"),
                    rs.getFloat("peso"),
                    rs.getFloat("altura"),
                    rs.getDate("dataNascimento")
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
            String sql = "SELECT * FROM atleta";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()) {
                Atleta atleta = new Atleta(rs.getLong("id_atleta"),
                        rs.getFloat("peso"),
                        rs.getFloat("altura"),
                        rs.getDate("dataNascimento")
                );
            }
        } catch (SQLException e) {

        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return atletas;
    }


}
