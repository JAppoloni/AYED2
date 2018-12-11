package obligatorio.ayed2.pkg2018;

public class Comentario {

    private String Ciudad;
    private Restaurante Restaurante;
    private String Comentario;
    private int Ranking;

    // <editor-fold defaultstate="collapsed" desc=" Setters">   
    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public void setRestaurante(Restaurante Restaurante) {
        this.Restaurante = Restaurante;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }

    public void setRanking(int Ranking) {
        this.Ranking = Ranking;
    }

    // </editor-fold>     
    // <editor-fold defaultstate="collapsed" desc=" Gets">   
    public String getCiudad() {
        return Ciudad;
    }

    public Restaurante getRestaurante() {
        return Restaurante;
    }

    public String getComentario() {
        return Comentario;
    }

    public int getRanking() {
        return Ranking;
    }
    
// </editor-fold>  

    public Comentario(String Ciudad, Restaurante Restaurante, String Comentario, int Ranking) {
            this.Ciudad = Ciudad;
        this.Restaurante = Restaurante;
        this.Comentario = Comentario;
        this.Ranking = Ranking;
    }

   
}
