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
            comando.setLong(1, atleta.getId());
            comando.setString(2, atleta.getNome());
            comando.setString(3, atleta.getEmail());
            comando.setString(4, atleta.getSenha());
            comando.setString(5, atleta.getTipoUsuario());

            String sql = "INSERT INTO atleta (peso, altura, data_nascimento) values (?,?,?)";
            comando.setFloat(1, atleta.getPeso());
            comando.setFloat(2, atleta.getAltura());
            comando.setDate(3, (Date) atleta.getDataNascimento());

            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e){
            throw e;
        }
    }
}
