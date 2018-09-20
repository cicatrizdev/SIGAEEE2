package dao;

import model.Evento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventoDAO {

    public static void inserir(Evento evento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();

            String sql = "INSERT INTO evento (id_evento, nome, descricao, data, local) VALUES (?,?,?,?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, evento.getId_evento());
            comando.setString(2, evento.getNome());
            comando.setString(3, evento.getDescricao());
            comando.setDate(4, (Date) evento.getData());
            comando.setString(5, evento.getLogradouro());

            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e){
            throw e;
        }
    }

    public static void alterar(Evento evento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try{
            conexao = BD.getConexao();

            String sql = "UPDATE evento SET nome = ?, descricao = ?, data = ?, local = ? WHERE id_evento = ? ";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, evento.getNome());
            comando.setString(2, evento.getDescricao());
            comando.setDate(3, (Date) evento.getData());
            comando.setString(4, evento.getLogradouro());
            comando.setLong(5, evento.getId_evento());

            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e){
            throw e;
        }
    }
}
