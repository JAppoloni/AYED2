package obligatorio.ayed2.pkg2018;

public class Reserva {

    private int cliente;
    private String Ciudad;
    private Restaurante Restaurante;

    // <editor-fold defaultstate="collapsed" desc=" Setters">   
    public void setCliente(int cliente) {
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
    public int getCliente() {
        return cliente;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public Restaurante getRestaurante() {
        return Restaurante;
    }

// </editor-fold>  

    public Reserva(int cliente, String Ciudad, Restaurante Restaurante) {
        this.cliente = cliente;
        this.Ciudad = Ciudad;
        this.Restaurante = Restaurante;
    }


}
