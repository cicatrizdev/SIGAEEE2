package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException

public abstract class BD {

    public static Connection getConexao()
        throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection
                ("jdbc:mysql://localhost/sca", "root", "");
    }
}
