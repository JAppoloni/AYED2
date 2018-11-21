package obligatorio.ayed2.pkg2018;

import java.util.ArrayList;

public class SistemaDeReservas {

    private ArrayList<Comentario> Comentario;
    private ArrayList<Reserva> Reserva;
    private ArrayList<Restaurante> Restaurante;
    private ArrayList<Servicio> Servicio;

    private static SistemaDeReservas _instancia;

     public static SistemaDeReservas obtenerInstancia() {
        return (_instancia == null) ? _instancia = new SistemaDeReservas() : _instancia;
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
    public ArrayList<Comentario> AddComentario(Comentario pComentario) {
        Comentario.add(pComentario);
        return Comentario;
    }

    public ArrayList<Reserva> AddReserva(Reserva pReserva) {
        Reserva.add(pReserva);
        return Reserva;
    }

    public ArrayList<Restaurante> AddRestaurante(Restaurante pRestaurante) {
        Restaurante.add(pRestaurante);
        return Restaurante;
    }

    public ArrayList<Servicio> AddServicio(Servicio pServicio) {
        Servicio.add(pServicio);
        return Servicio;
    }

// </editor-fold>  
}
