package obligatorio.ayed2.pkg2018;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Caja_Negra {

    public static Hashtable<String, String> Lista_DE_PK = new Hashtable<String, String>();

    public Caja_Negra() {
        Lista_DE_PK.put("Comentario", "Comentario");
        Lista_DE_PK.put("Reserva", "CI");
        Lista_DE_PK.put("Restaurante", "Nombre");
        Lista_DE_PK.put("Servicio", "Servicio");
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
        if (Lista.size() - 1 == mid) {
            return -1;
        }

        if (Comparador(Dato_A_Buscar, Lista.get(mid)) >= 0) {
            if (mid==1 && ultimo==2){
                return binarySearch(Lista, Dato_A_Buscar, 2, 2);
            }
            return binarySearch(Lista, Dato_A_Buscar, mid, ultimo);
        }
        return binarySearch(Lista, Dato_A_Buscar, inicio, mid);
    }

    public static int Ubicacion(List<Object> Lista, Object Dato_A_Buscar) {

        if (Lista.isEmpty()) {
            return -1;
        }
        int mid, midI, midF;

        mid = (Lista.size()) / 2;

        if (Lista.size() == 1) {
            if (Comparador(Dato_A_Buscar, Lista.get(mid)) > 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (Comparador(Dato_A_Buscar, Lista.get(mid)) < 0) {
            midI = mid;
            while (Comparador(Dato_A_Buscar, Lista.get(midI)) < 0 || (midI == 0)) {
                midI = midI / 2;
                if (midI == 0) {
                    break;
                }
            }
            while (Comparador(Dato_A_Buscar, Lista.get(midI)) > 0) {
                midI++;
            }
            return midI;
        } else if (Comparador(Dato_A_Buscar, Lista.get(mid)) > 0) {

            midI = mid;
            while (Comparador(Dato_A_Buscar, Lista.get(midI)) > 0) {
                midI++;
                if (Lista.size() <= midI) {
                    midI = Lista.size()-1;
                    break;
                }
            }
            return (midI);
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
        if (Lista.size() - 1 == mid) {
            return -1;
        }

        if (Comparador(Dato_A_Buscar, Lista.get(mid)) >= 0) {
            return binarySearch(Lista, Dato_A_Buscar, mid, ultimo);
        }
        return binarySearch(Lista, Dato_A_Buscar, inicio, mid);
    }

    public static int Buscar_Por_Referecia_RestauranteyCiudad(ArrayList<Object> Lista, Object Dato_A_Buscar, int inicio, int ultimo, String Restaurante, String Ciudad) {

        if (Lista.isEmpty() || Lista == null || inicio >= ultimo) {
            return -2;
        }

        int mid = (inicio + ultimo) / 2;

        if (Iguales(Dato_A_Buscar, Lista.get(mid)) && getRestaurante(Lista.get(mid), Restaurante) && getCiudad(Lista.get(mid), Ciudad)) {
            return mid;
        }
        if (Lista.size() - 1 == mid) {
            return -1;
        }

        if (Comparador(Dato_A_Buscar, Lista.get(mid)) >= 0) {
            return Buscar_Por_Referecia_RestauranteyCiudad(Lista, Dato_A_Buscar, mid, ultimo, Restaurante, Ciudad);
        }
        return Buscar_Por_Referecia_RestauranteyCiudad(Lista, Dato_A_Buscar, inicio, mid, Restaurante, Ciudad);
    }

    // Dato_A_BUSCAR = string RESTAURANTE
    public static int Buscar_Por_Referecia_RestauranteyCiudad(ArrayList<Object> Lista, String Dato_A_Buscar, int inicio, int ultimo, String Ciudad) {

        if (Lista.isEmpty() || Lista == null || inicio >= ultimo) {
            return -2;
        }

        int mid = (inicio + ultimo) / 2;

        if (getRestaurante(Lista.get(mid), Dato_A_Buscar) && getCiudad(Lista.get(mid), Ciudad)) {
            return mid;
        }
        if (Lista.size() - 1 == mid) {
            return -1;
        }

        if (ComparadorObj_String(Lista.get(mid), Dato_A_Buscar) <= 0) {
            return Buscar_Por_Referecia_RestauranteyCiudad(Lista, Dato_A_Buscar, mid, ultimo, Ciudad);
        }
        return Buscar_Por_Referecia_RestauranteyCiudad(Lista, Dato_A_Buscar, inicio, mid, Ciudad);
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

            if (ObjectA.getClass().equals(int.class) || ObjectA.getClass().equals(java.lang.Integer.class)) {
                Valor_OBJA = ObjectA;
            } else {
                for (Method method : MetodosObjA) {
                    if (method.getName().startsWith("get" + PKObjtA)) {
                        Valor_OBJA = method.invoke(ObjectA);
                        break;
                    }
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
            if (ObjectA.getClass().equals(int.class) || ObjectA.getClass().equals(java.lang.Integer.class)) {
                Valor_OBJA = ObjectA;
            } else {
                for (Method method : MetodosObjA) {
                    if (method.getName().startsWith("get" + PKObjtA)) {
                        Valor_OBJA = method.invoke(ObjectA);
                        break;
                    }
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

        return Comparador(Valor_OBJA.toString(), Valor_OBJB.toString());
    }

    public static int Comparador(String A, String B) {
        int length = A.length() > B.length() ? B.length() : A.length();
        
        for (int a=0; a<length;a++)
        {
            String a1 =""+ A.charAt(a);
            String b= ""+B.charAt(a);
            
            int comp = a1.compareTo(b);
            if (comp>0) // es menor
            {
                return 1;
            }
            if (comp<0) // es mayor
            {
                return -1;
            }
            
        }
        return 0;
    }

    private static boolean getCiudad(Object ObjectA, String Ciudad) {

        // Obtengo Gets,sets y constructor
        Method[] MetodosObjA = ObjectA.getClass().getDeclaredMethods();

        // creo variable de valores
        Object Valor_OBJA = new Object();

        // Busco los valores
        try {
            for (Method method : MetodosObjA) {
                if (method.getName().startsWith("getCiudad")) {
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
                if (method.getName().startsWith("getRestaurante") || method.getName().startsWith("getNombre")) {
                    Valor_OBJA = method.invoke(ObjectA);
                    if (Valor_OBJA.getClass().getSimpleName().equals("Restaurante")) {

                        Method[] MetodosValor_OBJA = Valor_OBJA.getClass().getDeclaredMethods();
                        for (Method method2 : MetodosValor_OBJA) {
                            if (method2.getName().startsWith("getNombre")) {
                                Valor_OBJA = method2.invoke(Valor_OBJA);
                                break;
                            }
                        }
                    }
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

    public static int ComparadorObj_String(Object ObjectA, String ObjectB) {

        // Nombre de las Clases de Los Objetos
        String StringObjA = ObjectA.getClass().getSimpleName();

        // Obtengo las PK de los Objetos
        String PKObjtA = Lista_DE_PK.get(StringObjA);

        // Obtengo Gets,sets y constructor
        Method[] MetodosObjA = ObjectA.getClass().getDeclaredMethods();

        // creo variable de valores
        Object Valor_OBJA = new Object();

        // Busco los valores
        try {
            for (Method method : MetodosObjA) {
                if (method.getName().startsWith("get" + PKObjtA)) {
                    Valor_OBJA = method.invoke(ObjectA);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR COMPARADOR :  " + e.toString());
        }
        return Comparador(Valor_OBJA.toString(), ObjectB);
    }

//</editor-fold>    
}
