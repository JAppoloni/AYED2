/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.ayed2.pkg2018;

/**
 *
 * @author 
 */
public class Obligatorio_AyED2_2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Sistema s = new Sistema();
        Prueba p = new Prueba();
        
        //-----------------------PRUEBAS OK---------------------------//
        
            PruebaOK_1(s,p);
            PruebaOK_2(s,p);
            PruebaOK_3(s,p);
            PruebaOK_4(s,p);
            PruebaOK_5(s,p);
            PruebaOK_6(s,p);
          
        //-----------------------PRUEBAS ERROR------------------------//
        
            //PruebaERROR_1(s,p);
            
        p.imprimirResultadosPrueba();
    }
    
    //-------------PRUEBAS OK-----------------//
    public static void PruebaOK_1(Sistema s, Prueba p){
        s.crearSistemaReservas();
        System.out.println("Se crea el Sistema de Reservas vacio");
        tituloPrueba("PRUEBA 1: REGISTRAR RESTAURANTE");
        p.ver(s.registrarRestaurante("Colonia", "Urbano", 3, 20), Sistema.TipoRet.OK, "Se agrega el restaurante Urbano de Colonia");
        p.ver(s.registrarRestaurante("Colonia", "Four Season", 5, 300), Sistema.TipoRet.OK, "Se agrega el restaurante Four Season de Colonia");
        p.ver(s.registrarRestaurante("Colonia", "Centro", 2, 20), Sistema.TipoRet.OK, "Se agrega el restaurante Centro de Colonia");
        p.ver(s.registrarRestaurante("Colonia", "Urbano", 2, 20), Sistema.TipoRet.ERROR_3, " Se espera ERROR:Se agrega el restaurante Urbano de Colonia");
       s.listarRestaurantesRanking();
        finPrueba(" Fin PRUEBA 1");
    }
    
    public static void PruebaOK_2(Sistema s, Prueba p){
        s.crearSistemaReservas();
        System.out.println("Se crea el Sistema de Reservas vacio");
        tituloPrueba("PRUEBA 2: INGRESAR SERVICIO");
       
        Restaurante pRestaurante = new Restaurante("Colonia", "Urbano", 2, 20);
        
        p.ver(s.ingresarServicio("Colonia",pRestaurante, "Desayuno continental"), Sistema.TipoRet.OK, "Se agrega Desayuno continental a restaurante Urbano de Colonia");
        p.ver(s.ingresarServicio("Colonia", pRestaurante, "TV Cable"), Sistema.TipoRet.OK, "Se agrega TV Cable a restaurante Urbano de Colonia");
        p.ver(s.ingresarServicio("Colonia",pRestaurante, "Servicio a la mesa"), Sistema.TipoRet.OK, "Se agrega Servicio a la mesa a restaurante Urbano de Colonia");
        s.listarServicios("Colonia", "Urbano");
        finPrueba(" Fin PRUEBA 2");
    }
    
    public static void PruebaOK_3(Sistema s, Prueba p){
        s.crearSistemaReservas();
        System.out.println("Se crea el Sistema de Reservas vacio");
        tituloPrueba("PRUEBA 3: BORRAR SERVICIO");
       
         Restaurante pRestaurante = new Restaurante("Colonia", "Urbano", 2, 20);
        
        p.ver(s.ingresarServicio("Colonia", pRestaurante, "Desayuno continental"), Sistema.TipoRet.OK, "Se agrega Desayuno continental a restaurante Urbano de Colonia");
        p.ver(s.ingresarServicio("Colonia", pRestaurante, "TV Cable"), Sistema.TipoRet.OK, "Se agrega TV Cable a restaurante Urbano de Colonia");
        p.ver(s.ingresarServicio("Colonia", pRestaurante, "Servicio a la mesa"), Sistema.TipoRet.OK, "Se agrega Servicio a la mesa a restaurante Urbano de Colonia");
        s.listarServicios("Colonia", "Urbano");
        
        p.ver(s.borrarServicio("Colonia", pRestaurante, "Desayuno continental"), Sistema.TipoRet.OK, "Se borra Desayuno continental a restaurante Urbano de Colonia");
        s.listarServicios("Colonia", "Urbano");
        finPrueba(" Fin PRUEBA 3");
    }
    
    public static void PruebaOK_4(Sistema s, Prueba p){
        s.crearSistemaReservas();
        System.out.println("Se crea el Sistema de Reservas vacio");
        tituloPrueba("PRUEBA 4: INGRESAR COMENTARIO");
        p.ver(s.registrarRestaurante("Colonia", "Urbano", 3, 20), Sistema.TipoRet.OK, "Se agrega el restaurante Urbano de Colonia");
        
        p.ver(s.ingresarComentario("Colonia", "Urbano", "A gusto", 3), Sistema.TipoRet.OK, "Se ingresa comentario para restaurante Urbano de Colonia");
        p.ver(s.ingresarComentario("Colonia", "Urbano", "Mala Atención", 0), Sistema.TipoRet.OK, "Se ingresa comentario para restaurante Urbano de Colonia");
        p.ver(s.ingresarComentario("Colonia", "Urbano", "Lo que esperabamos", 4), Sistema.TipoRet.OK, "Se ingresa comentario para restaurante Urbano de Colonia");
        
        s.listarComentarios("Colonia", "Urbano");
        finPrueba(" Fin PRUEBA 4");
    }
    
    public static void PruebaOK_5(Sistema s, Prueba p){
        s.crearSistemaReservas();
        System.out.println("Se crea el Sistema de Reservas vacio");
        tituloPrueba("PRUEBA 5: REALIZAR RESERVA");
        p.ver(s.registrarRestaurante("Colonia", "Urbano", 3, 2), Sistema.TipoRet.OK, "Se agrega el restaurante Urbano de Colonia");
        
        p.ver(s.realizarReserva(34175426, "Colonia", "Urbano"), Sistema.TipoRet.OK, "Realiza una reserva para restaurante Urbano de Colonia, el cliente 34175426");
        p.ver(s.realizarReserva(24515694, "Colonia", "Urbano"), Sistema.TipoRet.OK, "Realiza una reserva para restaurante Urbano de Colonia, el cliente 24515694");
        p.ver(s.realizarReserva(43547816, "Colonia", "Urbano"), Sistema.TipoRet.OK, "Realiza una reserva para restaurante Urbano de Colonia, el cliente 43547816");
        p.ver(s.realizarReserva(54177810, "Colonia", "Urbano"), Sistema.TipoRet.OK, "Realiza una reserva para restaurante Urbano de Colonia, el cliente 54177810");
        
        s.listarEspera("Colonia", "Urbano");
        finPrueba(" Fin PRUEBA 5");
    }
    
    public static void PruebaOK_6(Sistema s, Prueba p){
        s.crearSistemaReservas();
        System.out.println("Se crea el Sistema de Reservas vacio");
        tituloPrueba("PRUEBA 6: CANCELAR RESERVA");
        p.ver(s.registrarRestaurante("Colonia", "Urbano", 3, 2), Sistema.TipoRet.OK, "Se agrega el restaurante Urbano de Colonia");
        
        p.ver(s.realizarReserva(34175426, "Colonia", "Urbano"), Sistema.TipoRet.OK, "Realiza una reserva para restaurante Urbano de Colonia, el cliente 34175426");
        p.ver(s.realizarReserva(24515694, "Colonia", "Urbano"), Sistema.TipoRet.OK, "Realiza una reserva para restaurante Urbano de Colonia, el cliente 24515694");
        p.ver(s.realizarReserva(43547816, "Colonia", "Urbano"), Sistema.TipoRet.OK, "Realiza una reserva para restaurante Urbano de Colonia, el cliente 43547816");
        p.ver(s.realizarReserva(54177810, "Colonia", "Urbano"), Sistema.TipoRet.OK, "Realiza una reserva para restaurante Urbano de Colonia, el cliente 54177810");
        s.listarEspera("Colonia", "Urbano");
        
        p.ver(s.cancelarReserva(54177810, "Colonia", "Urbano"), Sistema.TipoRet.OK, "Cancela una reserva para restaurante Urbano de Colonia, el cliente 54177810");
        s.listarEspera("Colonia", "Urbano");
        finPrueba(" Fin PRUEBA 6");
    }
    
    
    
    
    public static void tituloPrueba(String s){
        System.out.println("****************************************************************");
        System.out.println("  "+ s );
        System.out.println("*****************************************************************");
    }

    public static void finPrueba(String s){
        System.out.println("******************* " + s +" ***********************");
        System.out.println("****************************************************");
        System.out.println();
    }
}
