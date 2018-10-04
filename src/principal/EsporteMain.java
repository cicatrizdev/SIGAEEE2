package principal;

import dao.EsporteDAO;
import model.Atleta;
import dao.AtletaDAO;
import model.Esporte;

import java.sql.SQLException;

public class EsporteMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Esporte esporte = new Esporte();

        EsporteDAO.inserir(esporte);
    }
}
