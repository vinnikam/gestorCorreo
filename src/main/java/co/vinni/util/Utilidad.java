package co.vinni.util;

import java.util.Scanner;

public class Utilidad
{
    public static String leerCadena(String mensaje){
        return (String) leerDato(mensaje, false);
    }
    public static Integer leerNumero(String mensaje){
        return (Integer) leerDato(mensaje, true);
    }
    private static Object leerDato(String mensaje, boolean esNumero ){
        System.out.print(mensaje+" : ");
        Scanner sc = new Scanner(System.in);
        if (esNumero){
            return sc.nextInt();
        }else {
            return sc.nextLine();
        }

    }
}
