package principal;

import dao.EquipeDAO;
import dao.EventoDAO;
import model.Atleta;
import dao.AtletaDAO;
import model.Evento;

import java.sql.SQLException;

public class EventoMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Evento evento = new Evento(45, "Role", 45, "beber no mechanics", "ficar muito bebado", "Amanha", "R Alto dos Passo");
        EventoDAO.inserir(evento);
    }
}
