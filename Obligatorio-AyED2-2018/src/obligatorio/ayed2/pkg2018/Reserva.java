package obligatorio.ayed2.pkg2018;

public class Reserva {

    private Cliente cliente;
    private int IdReserva;
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

    public void setIdReserva(int IdReserva) {
        this.IdReserva = IdReserva;
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

    public int getIdReserva() {
        return IdReserva;
    }
    

// </editor-fold>  

    public Reserva(Cliente cliente, int IdReserva, String Ciudad, Restaurante Restaurante) {
        this.cliente = cliente;
        this.IdReserva = IdReserva;
        this.Ciudad = Ciudad;
        this.Restaurante = Restaurante;
    }

  
}
