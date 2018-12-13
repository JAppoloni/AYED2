package obligatorio.ayed2.pkg2018;

import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Comparator;

public class SistemaDeReservas {

    private ArrayList<Comentario> Comentario;
    private ArrayList<Reserva> Reserva;
    private ArrayList<Restaurante> Restaurante;
    private ArrayList<Servicio> Servicio;

    private static SistemaDeReservas _instancia;

    public static Caja_Negra pCaja_Negra;

    public static SistemaDeReservas obtenerInstancia() {
        return (_instancia == null) ? _instancia = new SistemaDeReservas() : _instancia;
    }

    public SistemaDeReservas() {
        Comentario = new ArrayList<Comentario>();
        Reserva = new ArrayList<Reserva>();
        Restaurante = new ArrayList<Restaurante>();
        Servicio = new ArrayList< Servicio>();
    }

    // <editor-fold defaultstate="collapsed" desc=" Setters">   
    public void setComentario(ArrayList<Comentario> Comentario) {
        this.Comentario = Comentario;
    }

    public void setReserva(ArrayList<Reserva> Reserva) {
        this.Reserva = Reserva;
    }

    public void setRestaurante(ArrayList<Restaurante> Restaurante) {
        this.Restaurante = Restaurante;
    }

    public void setServicio(ArrayList<Servicio> Servicio) {
        this.Servicio = Servicio;
    }

    // </editor-fold>     
    // <editor-fold defaultstate="collapsed" desc=" Gets">   
    public ArrayList<Comentario> getComentario() {
        return Comentario;
    }

    public ArrayList<Reserva> getReserva() {
        return Reserva;
    }

    public ArrayList<Restaurante> getRestaurante() {
        return Restaurante;
    }

    public ArrayList<Servicio> getServicio() {
        return Servicio;
    }

// </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc=" Adds">   
    public void AddComentario(Comentario pComentario) {
        Comentario.add(pComentario);
       Collections.sort(Comentario, new Comparator<Comentario>() {
            @Override
            public int compare(final Comentario object1, final Comentario object2) {
                return object1.getComentario().compareTo(object2.getComentario());
            }
        });
    }

    public void AddReserva(Reserva pReserva) {
        Reserva.add(pReserva);
        Collections.sort(Reserva, new Comparator<Reserva>() {
            @Override
            public int compare(final Reserva object1, final Reserva object2) {
                return String.valueOf(object1.getCI()).compareTo(String.valueOf(object2.getCI()));
            }
        });

    }

    public void AddRestaurante(Restaurante pRestaurante) {

        Restaurante.add(pRestaurante);
        Collections.sort(Restaurante, new Comparator<Restaurante>() {
            @Override
            public int compare(final Restaurante object1, final Restaurante object2) {
                return object1.getNombre().compareTo(object2.getNombre());
            }
        });
    }

    public void AddServicio(Servicio pServicio) {
        Servicio.add(pServicio);
        Collections.sort(Servicio, new Comparator<Servicio>() {
            @Override
            public int compare(final Servicio object1, final Servicio object2) {
                return object1.getServicio().compareTo(object2.getServicio());
            }
        });
    }
// </editor-fold>  

    void EliminarSistema() {
        _instancia = null;
    }
}
