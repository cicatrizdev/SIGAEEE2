package dao;

import model.Evento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void alterar(Evento evento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
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
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Evento evento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            String sql = "DELETE FROM evento where id_evento = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, evento.getId_evento());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static Evento lerEvento(Long id_evento) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Evento evento = null;

        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM evento WHERE id_evento = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, id_evento);
            ResultSet rs = comando.executeQuery();
            rs.first();
            evento = new Evento(rs.getLong("id_evento"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getDate("data"),
                    rs.getString("logradouro")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return evento;
    }

    public static List<Evento> lerTodosEventos() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Evento> eventos = new ArrayList<Evento>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM evento";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()) {
                Evento evento = new Evento(rs.getLong("id_evento"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getDate("data"),
                        rs.getString("logradouro")
                );
            }
        } catch (SQLException e) {

        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return eventos;
    }
}
