package obligatorio.ayed2.pkg2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ListIterator;

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
        caja_Negra = new Caja_Negra();
        Servicio pServicio = new Servicio(Ciudad, Restaurante, Servicio);
        ArrayList<Object> objectList = new ArrayList<Object>(sistemaDeReservas.getServicio());
        if (caja_Negra.Buscar_Por_Referecia_RestauranteyCiudad(objectList, pServicio, 0, sistemaDeReservas.getServicio().size(), Restaurante.getNombre(), Ciudad) >= 0) {
            return TipoRet.ERROR_3;
        }
        if (objectList.isEmpty() || caja_Negra.Buscar_Por_Referecia_RestauranteyCiudad(objectList, pServicio, 0, sistemaDeReservas.getServicio().size(), Restaurante.getNombre(), Ciudad) < 0) {
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
        System.out.println("Restaurantes en " + Ciudad + "\n");
        Collections.sort(restaurantes);
        for (Restaurante res : restaurantes) {
            System.out.println(res.getNombre() + " - " + res.getPuntaje() + " - " + calcularRanking(res.getNombre(), Ciudad));
            vacia = false;
        }
        if (!vacia) {
            return TipoRet.OK;
        } else {
            System.out.println("No se encontraron datos");
            return TipoRet.ERROR_1;
        }
    }

    public TipoRet listarRestaurantesRanking() {
        ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>(sistemaDeReservas.getRestaurante());
        for (Restaurante r : restaurantes) {

            RestauranteRanking rr = new RestauranteRanking();
            rr.setCiudad(r.getCiudad());
            rr.setNombre(r.getNombre());
            rr.setRanking(calcularRanking(r.getNombre(), r.getCiudad()));
            sistemaDeReservas.AddRestauranteRanking(rr);

        }
        ArrayList<RestauranteRanking> rrs = new ArrayList<RestauranteRanking>(sistemaDeReservas.getRestauranteRanking());
        Collections.sort(rrs);

        System.out.println("Ciudad - Restaurantes - Ranking \n");
        int i = 1;
        for (RestauranteRanking rr : rrs) {
            System.out.println(i++ + " - " + rr.getCiudad() + " - " + rr.getNombre() + " - " + rr.getRanking());
        }
        return TipoRet.OK;

    }

    public TipoRet listarComentarios(String Ciudad, String Restaurante) {
        ArrayList<Comentario> comentarios = new ArrayList<Comentario>(sistemaDeReservas.getComentario());
        boolean vacia = true;
        System.out.println("Comentarios de " + Restaurante + " en " + Ciudad + " : \n");
        for (int i = comentarios.size() - 1; i <= 0; i--) {

            if (comentarios.get(i).getCiudad().toUpperCase().equals(Ciudad.toUpperCase()) && comentarios.get(i).getRestaurante().getNombre().toUpperCase().equals(Restaurante.toUpperCase())) {
                System.out.println(" - " + comentarios.get(i).getRestaurante().getNombre() + " Puntaje: " + comentarios.get(i).getRestaurante().getPuntaje() + " Ranking: " + comentarios.get(i).getRanking());
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
        ArrayList<Reserva> reservas = new ArrayList<Reserva>(sistemaDeReservas.getReserva());
        ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>(sistemaDeReservas.getRestaurante());
        Restaurante unRestaurante = new Restaurante();
        unRestaurante = null;
        for (Restaurante res : restaurantes) {
            if (res.getNombre().toUpperCase().equals(Restaurante.toUpperCase()) && res.getCiudad().toUpperCase().equals(Ciudad.toUpperCase())) {
                unRestaurante = res;
                break;
            }
        }
        if (unRestaurante == null) {
            return TipoRet.ERROR_1;
        }
        int cantReservas = 0;
        int numEspera = 0;
        for (Reserva unaReserva : reservas) {
            if (unaReserva.getRestaurante().equals(unRestaurante)) {
                if (cantReservas <= unRestaurante.getCapacidad()) {
                    cantReservas++;
                } else {
                    numEspera++;
                    System.out.println(numEspera + " - " + unaReserva.getCI());
                }
            }
        }
        if (numEspera == 0) {
            System.out.println("No existen reservas pendientes para el restaurante " + unRestaurante.getNombre() + " " + unRestaurante.getCiudad());
        }
        return TipoRet.OK;
    }

    private int calcularRanking(String restaurante, String ciudad) {
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
            return suma / aux;
        } else {
            return 0;
        }
    }

}
