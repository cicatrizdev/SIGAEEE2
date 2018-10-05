package dao;

import model.TipoEvento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipoEventoDAO {

    public static void inserir(TipoEvento tipoEvento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();

            String sql = "INSERT INTO tipo_evento (id, nome) VALUES (?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, tipoEvento.getIdTipoEvento());
            comando.setString(2, tipoEvento.getNomeTipoEvento());

            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e){
            throw e;
        }
    }

    public static void alterar(TipoEvento tipoEvento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();

            String sql = "UPDATE tipo_evento SET nome = ? WHERE id = ?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, tipoEvento.getNomeTipoEvento());
            comando.setInt(2, tipoEvento.getIdTipoEvento());

            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(TipoEvento tipoEvento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            String sql = "DELETE * FROM tipo_evento WHERE id = ? ";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, tipoEvento.getIdTipoEvento());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static TipoEvento lerTipoEvento(Integer idTipoEvento) throws  ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        TipoEvento tipoEvento= null;

        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM tipo_evento WHERE id= ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, idTipoEvento);
            ResultSet rs = comando.executeQuery();
            rs.first();
            tipoEvento = new TipoEvento(rs.getInt("id"),
                    rs.getString("nome")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return tipoEvento;
    }

    public static List<TipoEvento> lerTodosTiposEventos() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<TipoEvento> tipoEventos = new ArrayList<TipoEvento>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM tipo_evento";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()) {
                TipoEvento tipoEvento = new TipoEvento(rs.getInt("id"),
                        rs.getString("nome")
                );
            }
        } catch (SQLException e) {

        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return tipoEventos;
    }
}
