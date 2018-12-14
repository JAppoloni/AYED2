package obligatorio.ayed2.pkg2018;

import java.util.ArrayList;

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
            return TipoRet.ERROR_3;
        }
        sistemaDeReservas.AddServicio(pServicio);

        return TipoRet.OK;
    }

    public TipoRet borrarServicio(String Ciudad, Restaurante Restaurante, String Servicio) {

        Servicio pServicio = new Servicio(Ciudad, Restaurante, Servicio);
        ArrayList<Object> objectList = new ArrayList<Object>(sistemaDeReservas.getServicio());

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
        return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet realizarReserva(int cliente, String Ciudad, String Hotel) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet cancelarReserva(int cliente, String Ciudad, String Hotel) {
        return TipoRet.NO_IMPLEMENTADA;
    }

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
            System.out.println("No se encontraron datos");
            return TipoRet.ERROR_1;
        }
    }

    public TipoRet listarRestauranteCiudad(String Ciudad) {
       ArrayList<Comentario> comentarios = new ArrayList<Comentario>(sistemaDeReservas.getComentario());
       boolean vacia = true;
       System.out.println("Restaurantes en "+Ciudad);
       for(Comentario c:comentarios){
           if(c.getCiudad().toUpperCase().equals(Ciudad.toUpperCase())){
               System.out.println(" - "+c.getRestaurante().getNombre()+" Puntaje: "+c.getRestaurante().getPuntaje()+" Ranking: "+ c.getRanking());
               vacia=false;
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
        return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet listarComentarios(String Ciudad, String Restaurante) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet listarEspera(String Ciudad, String Restaurante) {
        return TipoRet.NO_IMPLEMENTADA;
    }

}
