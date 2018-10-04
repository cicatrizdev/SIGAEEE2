package principal;

import dao.EquipeDAO;
import dao.EventoDAO;
import model.Atleta;
import dao.AtletaDAO;
import model.Evento;

import java.sql.SQLException;

public class EventoMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Evento evento = new Evento(2, "Competição azarada", "Campo ruim", "22/09/1998", "R dos Bobos");

        EventoDAO.inserir(evento);
    }
}
