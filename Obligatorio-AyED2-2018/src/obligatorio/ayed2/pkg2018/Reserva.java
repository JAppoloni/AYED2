package obligatorio.ayed2.pkg2018;

public class Reserva {

    private Cliente cliente;
    private String Ciudad;
    private Restaurante Restaurante;

    // <editor-fold defaultstate="collapsed" desc=" Setters">   
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public void setRestaurante(Restaurante Restaurante) {
        this.Restaurante = Restaurante;
    }
    
    // </editor-fold>     

    // <editor-fold defaultstate="collapsed" desc=" Gets">   
    public Cliente getCliente() {
        return cliente;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public Restaurante getRestaurante() {
        return Restaurante;
    }

// </editor-fold>  

    public Reserva(Cliente cliente, int IdReserva, String Ciudad, Restaurante Restaurante) {
        this.cliente = cliente;
        this.Ciudad = Ciudad;
        this.Restaurante = Restaurante;
    }

  
}
