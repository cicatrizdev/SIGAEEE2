package dao;

import model.Atleta;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

            String sql2 = "INSERT INTO atleta (id_atleta, peso, altura, data_nascimento) values (?,?,?)";
            comando = conexao.prepareStatement(sql2);
            comando.setLong(1, atleta.getId_usuario());
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
            comando.setLong(4, atleta.getId_usuario());

            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e){
            throw e;
        }
    }
}
