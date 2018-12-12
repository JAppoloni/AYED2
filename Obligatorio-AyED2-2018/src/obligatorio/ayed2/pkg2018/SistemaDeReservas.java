package obligatorio.ayed2.pkg2018;

import java.util.ArrayList;

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
    }

    public void AddReserva(Reserva pReserva) {
        pCaja_Negra = new Caja_Negra();
        ArrayList<Object> objectList = new ArrayList<Object>(Reserva);
        int a = pCaja_Negra.Ubicacion(objectList, pReserva);
        a = (a <=  -1) ? 0 : a;
        Reserva.add(a, pReserva);
    }

    public void AddRestaurante(Restaurante pRestaurante) {
        pCaja_Negra = new Caja_Negra();
        ArrayList<Object> objectList = new ArrayList<Object>(Restaurante);
        int a = pCaja_Negra.Ubicacion(objectList, pRestaurante);
        a = (a <= -1) ? 0 : a;
        Restaurante.add(a, pRestaurante);
    }

    public void AddServicio(Servicio pServicio) {
        pCaja_Negra = new Caja_Negra();
        ArrayList<Object> objectList = new ArrayList<Object>(Servicio);
        int a = pCaja_Negra.Ubicacion(objectList, pServicio);
        a = (a <=  -1) ? 0 : a;
        Servicio.add(a, pServicio);
    }

// </editor-fold>  

    void EliminarSistema() {
        _instancia=null;
    }
}
