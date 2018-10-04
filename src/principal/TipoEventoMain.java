package principal;

import dao.TipoEventoDAO;
import model.Atleta;
import dao.AtletaDAO;
import model.TipoEvento;

import java.sql.SQLException;

public class TipoEventoMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        TipoEvento tipoEvento = new TipoEvento(123, "Amistoso");

        TipoEventoDAO.inserir(tipoEvento);
    }
}
