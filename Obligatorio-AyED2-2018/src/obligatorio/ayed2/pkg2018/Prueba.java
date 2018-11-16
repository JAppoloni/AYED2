/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.ayed2.pkg2018;

import obligatorio.ayed2.pkg2018.Sistema.TipoRet;

/**
 *
 * @author 
 */
public class Prueba {
    static int cantCorrectas, cantIncorrectas, cantNoImplementadas;

    void inicializarResultadosPrueba() {
        cantCorrectas = cantIncorrectas = cantNoImplementadas = 0;
    }

    public void ver(TipoRet retorno, TipoRet retornoEsperado, String comentario) {
        System.out.println();

        System.out.println("----------------------------- Testeo --------------------------------");

        imprimirComentario(comentario);

        imprimirRetorno(retorno, retornoEsperado);

        System.out.println("---------------------------------------------------------------------");
        System.out.println();

        if (retorno.equals(retornoEsperado)) {
            cantCorrectas++;
        } else {
            if (retorno.equals(TipoRet.NO_IMPLEMENTADA)) {
                cantNoImplementadas++;
            } else {
                cantIncorrectas++;
            }

        }
    }

    void imprimirComentario(String comentario) {
        if (comentario != null || !comentario.isEmpty()) {
            System.out.println("\n  Comentario: " + comentario);
            System.out.println();
        }
    }

    public void imprimirRetorno(TipoRet retorno, TipoRet retornoEsperado) {
        System.out.println("  Retorno de la app.: " + retorno + "\t");

        if (retorno == retornoEsperado) {
            System.out.println("\t\t.........OK.........");
        } else {
            System.out.println("  Se esperaba.......: " + retornoEsperado + "\t");
        }
    }

    public String getStringRetorno(TipoRet retorno) {
        switch (retorno) {
            case OK:
                return "OK";
            case ERROR_1:
                return "ERROR_1";
            case ERROR_2:
                return "ERROR_2";
            case ERROR_3:
                return "ERROR_3";
            case NO_IMPLEMENTADA:
                return "NO_IMPLEMENTADA";
            default:
                return "NO_IMPLEMENTADA";
        }
    }

    void imprimirResultadosPrueba() {
        System.out.println();
        System.out.println("  +------------------------------+");
        System.out.println("    RESULTADOS DE LA PRUEBA    ");
        System.out.println("    Pruebas Correctas: " + cantCorrectas);
        System.out.println("    Pruebas Incorrectas: " + cantIncorrectas);
        System.out.println("    Pruebas NI: " + cantNoImplementadas);
        System.out.println("  +------------------------------+");
        System.out.println();
    }
}
