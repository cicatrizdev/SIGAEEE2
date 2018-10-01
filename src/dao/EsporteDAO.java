package dao; // fazer o ler e lerTodos

import model.Esporte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EsporteDAO {

    public static void inserir(Esporte esporte) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();

            String sql = "INSERT INTO esporte (id_esporte, nome) VALUES (?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, esporte.getId_esporte());
            comando.setString(2, esporte.getNome());
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
            String sql = "UPDATE evento SET nome = ? WHERE id_evento = ? ";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, esporte.getNome());
            comando.setLong(2, esporte.getId_esporte());
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
            String sql = "DELETE FROM esporte where id_esporte = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, esporte.getId_esporte());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        }
    }
}
