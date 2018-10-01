package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BD {

    public static Connection getConexao()
        throws ClassNotFoundException, SQLException{
        Connection conexao = null;
      //  Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection
                ("jdbc:mysql://localhost/sigaeee", "root", "");
    }

    public static void fecharConexao(Connection conexao, Statement comando){
        try {
            if (comando != null){
                comando.close();
            }
            if (comando != null){
                conexao.close();
            }
        } catch (SQLException ignored){
        }
    }
}
