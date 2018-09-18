package dao;

import model.Equipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EquipeDAO {

    public static void inserir(Equipe equipe) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO equipe (nome) VALUE (?)";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, equipe.getNome());


            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            throw e;
        }
    }
}

    public static void alterar(Equipe equipe) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE equipe SET nome = ? WHERE id = ?"
            comando = conexao.prepareStatement(sql);
            comando.setString(1, equipe.getNome());

            comando.execute();
            BD.fecharConexao(conexao, comando);
        }catch (SQLException e){
            throw e;
        }
    }
}
