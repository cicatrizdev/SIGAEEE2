package principal;

import model.Atleta;
import dao.AtletaDAO;

import java.sql.SQLException;

public class AtletaMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Atleta atleta = new Atleta("jorge", "jorge@jorge.com", "123", 200F, 1.8F, "10-10-2000");

        AtletaDAO.inserir(atleta);
    }
}
