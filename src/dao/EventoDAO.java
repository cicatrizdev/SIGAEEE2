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

            String sql = "INSERT INTO evento (id, nome, descricao, data, local) VALUES (?,?,?,?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, evento.getIdEvento());
            comando.setString(2, evento.getNomeEvento());
            comando.setString(3, evento.getDescricaoEvento());
            comando.setString(4, evento.getDataEvento());
            comando.setString(5, evento.getLogradouroEvento());

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

            String sql = "UPDATE evento SET nome = ?, descricao = ?, data = ?, local = ? WHERE id = ? ";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, evento.getNomeEvento());
            comando.setString(2, evento.getDescricaoEvento());
            comando.setString(3,  evento.getDataEvento());
            comando.setString(4, evento.getLogradouroEvento());
            comando.setInt(5, evento.getIdEvento());

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
            String sql = "DELETE FROM evento where id = ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, evento.getIdEvento());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static Evento lerEvento(Integer idEvento) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Evento evento = null;

        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM evento WHERE id = ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, idEvento);
            ResultSet rs = comando.executeQuery();
            rs.first();
            evento = new Evento(rs.getInt("tipo_evento_id"),  // ta certo isso aqui??
                    rs.getString(rs.getString("tipo_evento_nome")),
                    rs.getInt(rs.getInt("id")),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getString("data"),
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
                Evento evento = new Evento(rs.getInt("tipo_evento_id"), // ta certo isso aqui??
                        rs.getString(rs.getString("tipo_evento_nome")),
                        rs.getInt(rs.getInt("id")),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getString("data"),
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


//ESSE METODOS LER ESTAO CERTOS?? DAFUQ