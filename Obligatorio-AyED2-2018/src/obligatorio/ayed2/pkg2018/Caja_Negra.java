package obligatorio.ayed2.pkg2018;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Caja_Negra {

    public static Hashtable<String, String> Lista_DE_PK = new Hashtable<String, String>();

    public Caja_Negra() {
        Lista_DE_PK.put("Comentario", "Comentario");
        Lista_DE_PK.put("Reserva", "Cliente");
        Lista_DE_PK.put("Restaurante", "Ciudad");
        Lista_DE_PK.put("Restaurante", "Nombre");
        Lista_DE_PK.put("Servicio", "Servicio");
        Lista_DE_PK.put("Cliente", "CI");
    }
    
    
    //<editor-fold defaultstate="collapsed" desc=" BUSCADORES  ">
    public static int binarySearch(ArrayList<Object> Lista, Object Dato_A_Buscar, int inicio, int ultimo) {

        if (Lista.isEmpty() || Lista == null || inicio >= ultimo) {
            return -2;
        }

        int mid = (inicio + ultimo) / 2;

        if (Iguales(Dato_A_Buscar, Lista.get(mid))) {
            return mid;
        }
        if (Lista.size()-1==mid) {
            return -1;
        }

        if (Comparador(Dato_A_Buscar, Lista.get(mid)) >= 0) {
            return binarySearch(Lista, Dato_A_Buscar, inicio, mid);
        }
        return binarySearch(Lista, Dato_A_Buscar, mid, ultimo);
    }

    public static int Ubicacion(List<Object> Lista, Object Dato_A_Buscar) {

        if (Lista.isEmpty()) {
            return -1;
        }

        int mid = (0 + Lista.size() + 1) / 2;

        int midI = mid;
        int midF = mid;

        int[] ListValue = ValorDeAmbosOBJ(Dato_A_Buscar, Lista.get(mid - 1));

        int DatoAOrdenar = ListValue[0];
        int DatoOrdenado = ListValue[1];

        if (Lista.size() == 1) {
            if (DatoAOrdenar < DatoOrdenado) {
                return 0;
            } else {
                return 1;
            }
        }
        if (DatoAOrdenar < DatoOrdenado) {
            while ((DatoAOrdenar < DatoOrdenado) || (midI == 0)) {
                midI = midI / 2;
                ListValue = ValorDeAmbosOBJ(Dato_A_Buscar, Lista.get(midI));
                DatoOrdenado = ListValue[1];
                if (midI == 0) {
                    break;
                }
            }

            while (DatoAOrdenar > DatoOrdenado) {
                midF--;
                ListValue = ValorDeAmbosOBJ(Dato_A_Buscar, Lista.get(midF));
                DatoOrdenado = ListValue[1];
                if (midF == 0) {
                    break;
                }
            }
            return (midI + (mid - midF));
        } else if (DatoAOrdenar > DatoOrdenado) {

            int aux = mid;

            while (DatoAOrdenar > DatoOrdenado) {
                midF = midF / 2;
                aux = +midF;
                ListValue = ValorDeAmbosOBJ(Dato_A_Buscar, Lista.get(aux));
                DatoOrdenado = ListValue[1];
                if (midF == 0) {
                    break;
                }
            }
            midI = Lista.size();
            while (DatoAOrdenar < DatoOrdenado) {
                midI--;
                ListValue = ValorDeAmbosOBJ(Dato_A_Buscar, Lista.get(midI));
                DatoOrdenado = ListValue[1];
                if (midI == 0) {
                    break;
                }
            }
            return (aux - (Lista.size() - midI));
        }

        return mid;
    }
    
    public static int Buscar_Por_Referecia_Ciudad(ArrayList<Object> Lista, Object Dato_A_Buscar, int inicio, int ultimo, String Ciudad) {

        if (Lista.isEmpty() || Lista == null || inicio >= ultimo) {
            return -2;
        }

        int mid = (inicio + ultimo) / 2;

        if (Iguales(Dato_A_Buscar, Lista.get(mid)) && getCiudad(Dato_A_Buscar, Ciudad)) {
            return mid;
        }
        if (Lista.size()-1==mid) {
            return -1;
        }

        if (Comparador(Dato_A_Buscar, Lista.get(mid)) >= 0) {
            return binarySearch(Lista, Dato_A_Buscar, inicio, mid);
        }
        return binarySearch(Lista, Dato_A_Buscar, mid, ultimo);
    }
    
    public static int Buscar_Por_Referecia_RestauranteyCiudad(ArrayList<Object> Lista, Object Dato_A_Buscar, int inicio, int ultimo, String Restaurante, String Ciudad) {

        if (Lista.isEmpty() || Lista == null || inicio >= ultimo) {
            return -2;
        }

        int mid = (inicio + ultimo) / 2;

        if (Iguales(Dato_A_Buscar, Lista.get(mid)) && getRestaurante(Dato_A_Buscar, Restaurante) && getCiudad(Dato_A_Buscar, Ciudad)) {
            return mid;
        }
        if (Lista.size()-1==mid) {
            return -1;
        }

        if (Comparador(Dato_A_Buscar, Lista.get(mid)) >= 0) {
            return Buscar_Por_Referecia_RestauranteyCiudad(Lista, Dato_A_Buscar, inicio, mid, Restaurante, Ciudad);
        }
        return Buscar_Por_Referecia_RestauranteyCiudad(Lista, Dato_A_Buscar, inicio, mid, Restaurante, Ciudad);
    }

//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" METODOS AUX ">

    private static boolean Iguales(Object ObjectA, Object ObjectB) {
        String StringObjA = ObjectA.getClass().getSimpleName();
        String StringObjB = ObjectB.getClass().getSimpleName();

        // Obtengo las PK de los Objetos
        String PKObjtA = Lista_DE_PK.get(StringObjA);
        String PKObjtB = Lista_DE_PK.get(StringObjB);

        // Obtengo Gets,sets y constructor
        Method[] MetodosObjA = ObjectA.getClass().getDeclaredMethods();
        Method[] MetodosObjB = ObjectB.getClass().getDeclaredMethods();

        // creo variable de valores
        Object Valor_OBJA = new Object();
        Object Valor_OBJB = new Object();

        // Busco los valores
        try {
            for (Method method : MetodosObjA) {
                if (method.getName().startsWith("get" + PKObjtA)) {
                    Valor_OBJA = method.invoke(ObjectA);
                    break;
                }
            }

            for (Method method : MetodosObjB) {
                if (method.getName().startsWith("get" + PKObjtB)) {
                    Valor_OBJB = method.invoke(ObjectB);
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR COMPARADOR :  " + e.toString());
        }
        if (Valor_OBJA.equals(Valor_OBJB)) {
            return true;
        }
        return false;
    }
    
    public static int Comparador(Object ObjectA, Object ObjectB) {

        // Nombre de las Clases de Los Objetos
        String StringObjA = ObjectA.getClass().getSimpleName();
        String StringObjB = ObjectB.getClass().getSimpleName();

        // Obtengo las PK de los Objetos
        String PKObjtA = Lista_DE_PK.get(StringObjA);
        String PKObjtB = Lista_DE_PK.get(StringObjB);

        // Obtengo Gets,sets y constructor
        Method[] MetodosObjA = ObjectA.getClass().getDeclaredMethods();
        Method[] MetodosObjB = ObjectB.getClass().getDeclaredMethods();

        // creo variable de valores
        Object Valor_OBJA = new Object();
        Object Valor_OBJB = new Object();

        // Busco los valores
        try {
            for (Method method : MetodosObjA) {
                if (method.getName().startsWith("get" + PKObjtA)) {
                    Valor_OBJA = method.invoke(ObjectA);
                    break;
                }
            }

            for (Method method : MetodosObjB) {
                if (method.getName().startsWith("get" + PKObjtB)) {
                    Valor_OBJB = method.invoke(ObjectB);
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR COMPARADOR :  " + e.toString());
        }

        int minLength = Math.min(Valor_OBJA.toString().length(), Valor_OBJB.toString().length());

        int ObjA = Pasar_Valor_A_INT(Valor_OBJA, minLength);
        int ObjB = Pasar_Valor_A_INT(Valor_OBJB, minLength);

        if (ObjA < ObjB) {
            return 1;
        }
        return -1;
    }

    public static int Pasar_Valor_A_INT(Object Valor, int Largo) {
        if (Valor.getClass().equals(String.class)) {
            return getValue(Valor.toString(), Largo);
        }
        if (Valor.getClass().equals(java.lang.Integer.class) || Valor.getClass().equals(int.class) || Valor.getClass().equals(java.lang.Double.class)) {
            String auxString = Valor.toString();
            int rtn = Integer.parseInt(auxString);
            return rtn;
        }
        return -1;
    }

    public static int getValue(String str, int length) {

        int result = 0;

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            result += Math.pow(10, i) * c;
        }

        return result;
    }

    public static int[] ValorDeAmbosOBJ(Object ObjectA, Object ObjectB) {

        // Nombre de las Clases de Los Objetos
        String StringObjA = ObjectA.getClass().getSimpleName();
        String StringObjB = ObjectB.getClass().getSimpleName();

        // Obtengo las PK de los Objetos
        String PKObjtA = Lista_DE_PK.get(StringObjA);
        String PKObjtB = Lista_DE_PK.get(StringObjB);

        // Obtengo Gets,sets y constructor
        Method[] MetodosObjA = ObjectA.getClass().getDeclaredMethods();
        Method[] MetodosObjB = ObjectB.getClass().getDeclaredMethods();

        // creo variable de valores
        Object Valor_OBJA = new Object();
        Object Valor_OBJB = new Object();

        // Busco los valores
        try {
            for (Method method : MetodosObjA) {
                if (method.getName().startsWith("get" + PKObjtA)) {
                    Valor_OBJA = method.invoke(ObjectA);
                    break;
                }
            }

            for (Method method : MetodosObjB) {
                if (method.getName().startsWith("get" + PKObjtB)) {
                    Valor_OBJB = method.invoke(ObjectB);
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR COMPARADOR :  " + e.toString());
        }

        int minLength = Math.min(Valor_OBJA.toString().length(), Valor_OBJB.toString().length());

        int ObjA = Pasar_Valor_A_INT(Valor_OBJA, minLength);
        int ObjB = Pasar_Valor_A_INT(Valor_OBJB, minLength);

        int[] rtn = new int[]{ObjA, ObjB};

        return rtn;
    }
    
    private static boolean getCiudad(Object ObjectA, String Ciudad) {
       
        // Obtengo Gets,sets y constructor
        Method[] MetodosObjA = ObjectA.getClass().getDeclaredMethods();
       
        // creo variable de valores
        Object Valor_OBJA = new Object();
      
        // Busco los valores
        try {
            for (Method method : MetodosObjA) {
                if (method.getName().startsWith("getCiudad" )) {
                    Valor_OBJA = method.invoke(ObjectA);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR COMPARADOR :  " + e.toString());
        }
        if (Valor_OBJA.equals(Ciudad)) {
            return true;
        }
        return false;
    }
    
    private static boolean getRestaurante(Object ObjectA, String Restaurante) {
        
       // Obtengo Gets,sets y constructor
        Method[] MetodosObjA = ObjectA.getClass().getDeclaredMethods();
       
        // creo variable de valores
        Object Valor_OBJA = new Object();
      
        // Busco los valores
        try {
            for (Method method : MetodosObjA) {
                if (method.getName().startsWith("getRestaurante" )) {
                    Valor_OBJA = method.invoke(ObjectA);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR COMPARADOR :  " + e.toString());
        }
        if (Valor_OBJA.equals(Restaurante)) {
            return true;
        }
        return false;
    }
    
//</editor-fold>    
    }
