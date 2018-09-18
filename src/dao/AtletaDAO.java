package dao;

import model.Atleta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtletaDAO {

    public static void gravar(Atleta atleta) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;

        try{
            conexao = BD.getConexao();
            String sql = "INSERT INTO atleta (peso, altura, data_nascimento) values (?,?,?)";
            comando.setFloat(1, atleta.getPeso());
            comando.setFloat(2, atleta.getAltura());
            comando.setDate(3, atleta.getDataNascimento());
        }
    }
}
