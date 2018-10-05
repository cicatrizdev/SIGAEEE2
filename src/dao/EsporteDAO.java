package dao;

import model.Esporte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EsporteDAO {

    public static void inserir(Esporte esporte) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();

            String sql = "INSERT INTO esporte (id, nome) VALUES (?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, esporte.getIdEsporte());
            comando.setString(2, esporte.getNomeEsporte());
            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e){
            throw e;
        }
    }

    public static void alterar(Esporte esporte) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try{
            conexao = BD.getConexao();
            String sql = "UPDATE evento SET nome = ? WHERE id = ? ";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, esporte.getNomeEsporte());
            comando.setInt(2, esporte.getIdEsporte());
            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e){
            throw e;
        }
    }

    public static void excluir(Esporte esporte) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            String sql = "DELETE FROM esporte where id = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, esporte.getIdEsporte());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static Esporte lerEsporte(Integer idEsporte) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Esporte esporte = null;

        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM esporte WHERE id = ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, idEsporte);
            ResultSet rs = comando.executeQuery();
            rs.first();
            esporte = new Esporte(rs.getInt("id"),  // ta certo isso aqui??
                    rs.getString("nome")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return esporte;
    }

    public static List<Esporte> lerTodosEsportes() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Esporte> esportes = new ArrayList<Esporte>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM esporte";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()) {
                Esporte esporte = new Esporte(rs.getInt(rs.getInt("id")),
                        rs.getString("nome")
                );
            }
        } catch (SQLException e) {

        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return esportes;
    }
}
