/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.ayed2.pkg2018;

/**
 *
 * @author rodrigo
 */
public class Sistema {
    
    public enum TipoRet {
        OK, ERROR_1, ERROR_2, ERROR_3, NO_IMPLEMENTADA
    };
    
    public TipoRet crearSistemaReservas(){
      
        SistemaDeReservas sistemaDeReservas = new SistemaDeReservas();       
        return TipoRet.OK;
    }
    
    public TipoRet destruirSistemaReservas(){
        
        SistemaDeReservas sistemaDeReservas = new SistemaDeReservas();       
        sistemaDeReservas = null;
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet registrarRestaurante(String Ciudad, String Nombre, int Puntaje, int Capacidad){
        if (Puntaje >= 1 && Puntaje <= 5) 
            return TipoRet.ERROR_1 ;
        
        if (Capacidad > 0) 
            return TipoRet.ERROR_2 ;
        
        if ()
            return TipoRet.ERROR_3 ;
        
        Restaurante pRestaurante = new Restaurante(Ciudad, Nombre, Puntaje, Capacidad);
        SistemaDeReservas sistemaDeReservas = new SistemaDeReservas();
        sistemaDeReservas.AddRestaurante(pRestaurante);
        return TipoRet.OK;
    }
    
    public TipoRet ingresarServicio(String Ciudad, String Hotel, String Servicio){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet borrarServicio(String Ciudad, String Hotel, String Servicio){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet ingresarComentario(String Ciudad, String Hotel, String Comentario, int Ranking){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet realizarReserva(int cliente, String Ciudad, String Hotel){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet cancelarReserva(int cliente, String Ciudad, String Hotel){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet listarServicios(String Ciudad, String Hotel){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet listarRestauranteCiudad(String Ciudad){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet listarRestaurantesRanking(){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet listarComentarios(String Ciudad, String Restaurante){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet listarEspera(String Ciudad, String Restaurante){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
}
