package obligatorio.ayed2.pkg2018;

public class Reserva {

    private int CI;
    private String Ciudad;
    private Restaurante Restaurante;

    // <editor-fold defaultstate="collapsed" desc=" Setters">   
    public void setCI(int cliente) {
        this.CI = cliente;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public void setRestaurante(Restaurante Restaurante) {
        this.Restaurante = Restaurante;
    }
    
    // </editor-fold>     

    // <editor-fold defaultstate="collapsed" desc=" Gets">   
    public int getCI() {
        return CI;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public Restaurante getRestaurante() {
        return Restaurante;
    }

// </editor-fold>  

    public Reserva( int CI, String Ciudad, Restaurante Restaurante) {
        this.CI = CI;
        this.Ciudad = Ciudad;
        this.Restaurante = Restaurante;
    }

  
}
