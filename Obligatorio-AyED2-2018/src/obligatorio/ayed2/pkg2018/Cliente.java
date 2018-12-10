package obligatorio.ayed2.pkg2018;

public class Cliente {

    private int CI;
    private String Nombre;

    public Cliente(int CI, String Nombre) {
        this.CI = CI;
        this.Nombre = Nombre;
    }

    public int getCI() {
        return CI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setCI(int CI) {
        this.CI = CI;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }



}
