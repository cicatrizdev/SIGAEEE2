package dao;

import model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dao.BD.getConexao;


public class UsuarioDAO {

    public static void inserir(Usuario usuario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO usuario (id_usuario , nome, email, senha) VALUES (?,?,?,?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, usuario.getId());
            comando.setString(2, usuario.getNome());
            comando.setString(3, usuario.getEmail());
            comando.setString(4, usuario.getSenha());
            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void alterar(Usuario usuario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = getConexao();
            String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE id = ?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getEmail());
            comando.setString(3, usuario.getSenha());
            comando.setInt(4, usuario.getId());
            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            throw e;
        }
    }

    public void excluir(Usuario usuario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = getConexao();
            String sql = "DELETE FROM usuario WHERE id = ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, usuario.getId());
            comando.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static Usuario lerUsuario(Integer id) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Usuario usuario = null;
        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM usuario WHERE id = ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet rs = comando.executeQuery(sql);
            rs.first();
            usuario = new Usuario(rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
            );

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return usuario;
    }

    public static List<Usuario> lerTodosUsuarios() throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM usuario";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
            }

        } catch (SQLException e) {

        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return usuarios;
    }
}



