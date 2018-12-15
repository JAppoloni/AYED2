package obligatorio.ayed2.pkg2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Sistema {

    public enum TipoRet {
        OK, ERROR_1, ERROR_2, ERROR_3, NO_IMPLEMENTADA
    };

    public static SistemaDeReservas sistemaDeReservas;
    public static Caja_Negra caja_Negra;

    public TipoRet crearSistemaReservas() {

        sistemaDeReservas = SistemaDeReservas.obtenerInstancia();
        return TipoRet.OK;
    }

    public TipoRet destruirSistemaReservas() {
        sistemaDeReservas.EliminarSistema();
        return TipoRet.OK;
    }

    public TipoRet registrarRestaurante(String Ciudad, String Nombre, int Puntaje, int Capacidad) {
        if (!(Puntaje >= 1 && Puntaje <= 5)) {
            return TipoRet.ERROR_1;
        }

        if (Capacidad <= 0) {
            return TipoRet.ERROR_2;
        }

        ArrayList<Object> objectList = new ArrayList<Object>(sistemaDeReservas.getRestaurante());
        Restaurante pRestaurante = new Restaurante(Ciudad, Nombre, Puntaje, Capacidad);
        caja_Negra = new Caja_Negra();
        if (caja_Negra.Buscar_Por_Referecia_Ciudad(objectList, pRestaurante, 0, objectList.size(), Ciudad) > 0) {
            return TipoRet.ERROR_3;
        }

        sistemaDeReservas.AddRestaurante(pRestaurante);
        return TipoRet.OK;
    }

    public TipoRet ingresarServicio(String Ciudad, Restaurante Restaurante, String Servicio) {

        Servicio pServicio = new Servicio(Ciudad, Restaurante, Servicio);
        ArrayList<Object> objectList = new ArrayList<Object>(sistemaDeReservas.getServicio());
        if (caja_Negra.Buscar_Por_Referecia_RestauranteyCiudad(objectList, pServicio, 0, sistemaDeReservas.getServicio().size(), Restaurante.getNombre(), Ciudad) > 0) {
            caja_Negra = new Caja_Negra();
            if (caja_Negra.Buscar_Por_Referecia_RestauranteyCiudad(objectList, pServicio, 0, sistemaDeReservas.getServicio().size(), Restaurante.getNombre(), Ciudad) >= 0) {
                return TipoRet.ERROR_3;
            }
            sistemaDeReservas.AddServicio(pServicio);
            return TipoRet.OK;
        }
        return TipoRet.ERROR_1;
    }

    public TipoRet borrarServicio(String Ciudad, Restaurante Restaurante, String Servicio) {

        Servicio pServicio = new Servicio(Ciudad, Restaurante, Servicio);
        ArrayList<Object> objectList = new ArrayList<Object>(sistemaDeReservas.getServicio());
        caja_Negra = new Caja_Negra();
        int ID = caja_Negra.binarySearch(objectList, pServicio, 0, sistemaDeReservas.getServicio().size());
        if (ID < 0) {
            return TipoRet.ERROR_2;
        }
        Servicio AuxpServicio = sistemaDeReservas.getServicio().get(ID);

        if (!AuxpServicio.getRestaurante().getNombre().equals(Restaurante.getNombre())) {
            return TipoRet.ERROR_1;
        }

        ArrayList<Servicio> list = sistemaDeReservas.getServicio();
        list.remove(ID);
        sistemaDeReservas.setServicio(list);
        return TipoRet.OK;
    }

    public TipoRet ingresarComentario(String Ciudad, String Restaurante, String Comentario, int Ranking) {
        if (!(Ranking >= 1 && Ranking <= 5)) {
            return TipoRet.ERROR_1;
        }
        caja_Negra = new Caja_Negra();
        ArrayList<Object> objectList = new ArrayList<Object>(sistemaDeReservas.getRestaurante());
        int id = caja_Negra.Buscar_Por_Referecia_RestauranteyCiudad(objectList, Restaurante, 0, sistemaDeReservas.getRestaurante().size(), Ciudad);
        if (id < 0) {
            return TipoRet.ERROR_2;
        }
        Restaurante pRest = sistemaDeReservas.getRestaurante().get(id);
        Comentario pComentario = new Comentario(Ciudad, pRest, Comentario, Ranking);
        sistemaDeReservas.AddComentario(pComentario);
        return TipoRet.OK;
    }

    public TipoRet realizarReserva(int cliente, String Ciudad, String Restaurante) {
        caja_Negra = new Caja_Negra();
        ArrayList<Object> objectList = new ArrayList<Object>(sistemaDeReservas.getRestaurante());
        int id = caja_Negra.Buscar_Por_Referecia_RestauranteyCiudad(objectList, Restaurante, 0, sistemaDeReservas.getRestaurante().size(), Ciudad);
        if (id < 0) {
            return TipoRet.ERROR_2;
        }
        Restaurante pRest = sistemaDeReservas.getRestaurante().get(id);
        Reserva pReserva = new Reserva(cliente, Ciudad, pRest);
        sistemaDeReservas.AddReserva(pReserva);
        return TipoRet.OK;
    }

    public TipoRet cancelarReserva(int cliente, String Ciudad, String Restaurante) {
        ArrayList<Object> objectList = new ArrayList<Object>(sistemaDeReservas.getRestaurante());
        caja_Negra = new Caja_Negra();
        int id = caja_Negra.Buscar_Por_Referecia_RestauranteyCiudad(objectList, Restaurante, 0, sistemaDeReservas.getRestaurante().size(), Ciudad);
        if (id < 0) {
            return TipoRet.ERROR_1;
        }
        Restaurante pRest = sistemaDeReservas.getRestaurante().get(id);

        objectList = new ArrayList<Object>(sistemaDeReservas.getReserva());
        id = caja_Negra.Buscar_Por_Referecia_RestauranteyCiudad(objectList, cliente, 0, sistemaDeReservas.getReserva().size(), Restaurante, Ciudad);
        if (id < 0) {
            return TipoRet.ERROR_2;
        }
        sistemaDeReservas.getReserva().remove(id);

        return TipoRet.OK;
    }
////////////////////////////////////////

    public TipoRet listarServicios(String Ciudad, String Restaurante) {
        ArrayList<Servicio> servicios = new ArrayList<Servicio>(sistemaDeReservas.getServicio());
        boolean vacia = true;
        System.out.println("Rest: " + Restaurante + " - Ciudad: " + Ciudad);
        for (Servicio s : servicios) {
            if (s.getRestaurante().getNombre().toUpperCase().equals(Restaurante.toUpperCase()) && s.getCiudad().toUpperCase().equals(Ciudad.toUpperCase())) {
                System.out.println(" - " + s.getServicio());
                vacia = false;
            }
        }
        if (!vacia) {
            return TipoRet.OK;
        } else {
            System.out.println("No existen servicios registrados en el restaurante" + Restaurante + " " + Ciudad);
            return TipoRet.ERROR_1;
        }
    }

    public TipoRet listarRestauranteCiudad(String Ciudad) {
        ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>(sistemaDeReservas.getRestaurante());
        boolean vacia = true;
        System.out.println("Restaurantes en " + Ciudad);
        for (Restaurante r : restaurantes) {
            if (r.getCiudad().toUpperCase().equals(Ciudad.toUpperCase())) {
                System.out.println(" - " + r.getNombre() + " Puntaje: " + r.getPuntaje() + " Ranking: " + calcularRanking(r.getNombre(), r.getCiudad()));
                vacia = false;
            }
        }
        if (!vacia) {
            return TipoRet.OK;
        } else {
            System.out.println("No se encontraron datos");
            return TipoRet.ERROR_1;
        }
    }

    public TipoRet listarRestaurantesRanking() {
        ArrayList<Comentario> comentarios = new ArrayList<Comentario>(sistemaDeReservas.getComentario());
        Collections.sort(comentarios);
        if (comentarios.isEmpty()) {
            System.out.println("Ciudad - Restaurantes - Ranking \n");
            int i = 1;
            for (Comentario c : comentarios) {
                System.out.println(i++ + " - " + c.getCiudad() + " - " + c.getRestaurante().getNombre() + " - " + calcularRanking(c.getRestaurante().getNombre(), c.getRestaurante().getCiudad()));
            }
            return TipoRet.OK;
        } else {
            System.out.println("No se encontraron datos");
            return TipoRet.ERROR_1;
        }
    }

    public TipoRet listarComentarios(String Ciudad, String Restaurante) {
        ArrayList<Comentario> comentarios = new ArrayList<Comentario>(sistemaDeReservas.getComentario());
        boolean vacia = true;
        System.out.println("Comentarios de " + Restaurante + " en " + Ciudad + " : \n");
        for (Comentario c : comentarios) {
            if (c.getCiudad().toUpperCase().equals(Ciudad.toUpperCase()) && c.getRestaurante().getNombre().toUpperCase().equals(Restaurante.toUpperCase())) {
                System.out.println(" - " + c.getRestaurante().getNombre() + " Puntaje: " + c.getRestaurante().getPuntaje() + " Ranking: " + c.getRanking());
                vacia = false;
            }
        }
        if (!vacia) {
            return TipoRet.OK;
        } else {
            System.out.println("No se encontraron datos");
            return TipoRet.ERROR_1;
        }
    }

    public TipoRet listarEspera(String Ciudad, String Restaurante) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    private String calcularRanking(String restaurante, String ciudad) {
        ArrayList<Comentario> comentarios = new ArrayList<Comentario>(sistemaDeReservas.getComentario());
        int suma = 0;
        int aux = 0;
        for (Comentario c : comentarios) {
            if (c.getRestaurante().getNombre().toUpperCase().equals(restaurante.toUpperCase()) && c.getRestaurante().getCiudad().toUpperCase().equals(ciudad.toUpperCase())) {
                suma += c.getRanking();
                aux++;
            }
        }
        if (aux > 0) {
            return String.valueOf(suma / aux);
        } else {
            return "No tiene comentarios";
        }
    }

}
