package obligatorio.ayed2.pkg2018;

public class Servicio {

    private String Ciudad; 
    private String Restaurante; 
    private String Servicio;
    
    // <editor-fold defaultstate="collapsed" desc=" Setters">   
   public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public void setRestaurante(String Restaurante) {
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

    public String getRestaurante() {
        return Restaurante;
    }

    public String getServicio() {
        return Servicio;
    }

   
// </editor-fold>  

    public Servicio(String Ciudad, String Restaurante, String Servicio) {
        this.Ciudad = Ciudad;
        this.Restaurante = Restaurante;
        this.Servicio = Servicio;
    }
   
}
