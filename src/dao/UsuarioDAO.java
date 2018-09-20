package dao;

import dao.BD;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UsuarioDAO {

    public static void inserir(Usuario usuario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO usuario (id , nome, email, senha, tipoUsario) VALUES (?,?,?,?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, usuario.getId());
            comando.setString(2, usuario.getNome());
            comando.setString(3, usuario.getEmail());
            comando.setString(4, usuario.getSenha());
            comando.setString(5, usuario.getTipoUsuario());

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
            conexao = BD.getConexao();
            String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ?, tipoUsuario = ? WHERE id = ?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getEmail());
            comando.setString(3, usuario.getSenha());
            comando.setString(4, usuario.getTipoUsuario());
            comando.setLong(5, usuario.getId());
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
            conexao = BD.getConexao();
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

    public static Usuario lerUsuario(long id) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Usuario usuario = null;
        try {
            conexao BD.getConexao();
            String sql = "SELECT * FROM usuario WHERE id = ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet rs = comando.executeQuery(sql);
            rs.first();
            usuario = new Usuario(rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("tipoUsario"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return usuario;
    }



}



