package obligatorio.ayed2.pkg2018;

public class Restaurante {
    
    private String Ciudad;
    private String Nombre;
    private int Puntaje;
    private  int Capacidad;

    // <editor-fold defaultstate="collapsed" desc=" Setters">   
    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setPuntaje(int Puntaje) {
        this.Puntaje = Puntaje;
    }

    public void setCapacidad(int Capacidad) {
        this.Capacidad = Capacidad;
    }
    // </editor-fold>     
    
    // <editor-fold defaultstate="collapsed" desc=" Gets">   
    public String getCiudad() {
        return Ciudad;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getPuntaje() {
        return Puntaje;
    }

    public int getCapacidad() {
        return Capacidad;
    }
// </editor-fold>  

    public Restaurante(String Ciudad, String Nombre, int Puntaje, int Capacidad) {
        this.Ciudad = Ciudad;
        this.Nombre = Nombre;
        this.Puntaje = Puntaje;
        this.Capacidad = Capacidad;
    }

}
