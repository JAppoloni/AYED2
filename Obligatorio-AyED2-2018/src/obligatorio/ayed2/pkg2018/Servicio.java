package obligatorio.ayed2.pkg2018;

public class Servicio {

    private String Ciudad; 
    private Restaurante Restaurante; 
    private String Servicio;
    
    // <editor-fold defaultstate="collapsed" desc=" Setters">   
   public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public void setRestaurante(Restaurante Restaurante) {
        this.Restaurante = Restaurante;
    }

    public void setServicio(String Servicio) {
        this.Servicio = Servicio;
    }
    // </editor-fold>     
    
    // <editor-fold defaultstate="collapsed" desc=" Gets">   
     public String getCiudad() {
        return Ciudad;
    }

    public Restaurante getRestaurante() {
        return Restaurante;
    }

    public String getServicio() {
        return Servicio;
    }

   
// </editor-fold>  

    public Servicio(String Ciudad, Restaurante Restaurante, String Servicio) {
        this.Ciudad = Ciudad;
        this.Restaurante = Restaurante;
        this.Servicio = Servicio;
    }
   
}
