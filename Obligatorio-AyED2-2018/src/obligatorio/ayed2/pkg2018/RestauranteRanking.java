/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.ayed2.pkg2018;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class RestauranteRanking implements Comparable<RestauranteRanking>{

    private String Ciudad;
    private String Nombre;
    private int Ranking;

    public RestauranteRanking() {
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getRanking() {
        return Ranking;
    }

    public void setRanking(int Ranking) {
        this.Ranking = Ranking;
    }

    public RestauranteRanking(String Ciudad, String Nombre, int Ranking) {
        this.Ciudad = Ciudad;
        this.Nombre = Nombre;
        this.Ranking = Ranking;
    }

    @Override
    public int compareTo(RestauranteRanking o) {
        String a=String.valueOf(Ranking);
        String b=String.valueOf(o.getRanking());
        return a.compareTo(b);
    }
}
