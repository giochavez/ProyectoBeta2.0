import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class radixSort{
    private radixSort(){
    }
    public static void menu(List<Integer> numeros){
          Scanner sc = new Scanner(System.in);
          int op;
          do{
              System.out.println("De que forma quieres ordenar el archivo?");
              System.out.println(" 1) Ascendente\n 2) Descendente\n 3) Salir");
              System.out.println("Opcion: ");
              op = sc.nextInt();
              switch(op){
                  case 1:
                      ascendente(numeros);
                      break;
                  case 2:
                      descendente(numeros);
                      break;
                  case 3:
                      System.out.println("Saliendo de radix...");
                      break;
                  default:
                      System.out.println("Opcion no es valida");
                      break;
              }
          }while(op != 3);
      }


      public static void ascendente(List<Integer> numeros){
        int u = 1, d = 10, c = 100;
        List<Integer> aux = new LinkedList();
        File rS = new File("radixSort");
        rS.mkdir();
        LinkedList<Integer> unidades[];
        LinkedList<Integer> decenas[];
        LinkedList<Integer> centenas[];
        unidades = utileriaRadix.crearListas();
        System.out.println("Archivo original: " + numeros);
        unidades = utileriaRadix.ordenar(numeros, unidades, u);
        utileriaRadix.EscrituraArchivos(unidades, "Unidades");
        System.out.println("\n\tUNIDADES:");
        utileriaRadix.imprimirArchivos("Unidades");
        utileriaRadix.EscrituraArchivosAux(unidades, "AuxiliarUnidades");
        aux = utileriaRadix.leerArchivos("Unidades");
        utileriaRadix.ImprimirArchivosAux("AuxiliarUnidades");
        decenas = utileriaRadix.crearListas();
        decenas = utileriaRadix.ordenar(aux, decenas, d);
        utileriaRadix.EscrituraArchivos(decenas, "Decenas");
        System.out.println("\n\tDECENAS:");
        utileriaRadix.imprimirArchivos("Decenas");
        aux.clear();
        aux = utileriaRadix.leerArchivos("Decenas");
        utileriaRadix.EscrituraArchivosAux(decenas, "AuxiliarDecenas");
        utileriaRadix.ImprimirArchivosAux("AuxiliarDecenas");
        centenas = utileriaRadix.crearListas();
        centenas = utileriaRadix.ordenar(aux, centenas, c);
        utileriaRadix.EscrituraArchivos(centenas, "Centenas");
        System.out.println("\n\tCENTENAS:");
        utileriaRadix.imprimirArchivos("Centenas");
        aux.clear();
        aux = utileriaRadix.leerArchivos("Centenas");
        utileriaRadix.EscrituraArchivosAux(centenas, "AuxiliarCentenas");
        utileriaRadix.ImprimirArchivosAux("AuxiliarCentenas");
        System.out.println("\nArreglo ordenado: " + aux);
        System.out.println("\nEscribiendo respuesta en un archivo...");
        utileriaRadix.EscrituraArchivosAux(centenas, "Respuesta");
        utileriaRadix.ImprimirArchivosAux("Respuesta");
        System.out.println("\n");
    }

    public static void descendente(List<Integer> numeros){
        int u = 1, d = 10, c = 100;
        List<Integer> aux = new LinkedList();
        File rS = new File("radixSort");
        rS.mkdir();
        LinkedList<Integer> unidades[];
        LinkedList<Integer> decenas[];
        LinkedList<Integer> centenas[];
        unidades = utileriaRadix.crearListas();
        System.out.println("Archivo original: " + numeros);
        unidades = utileriaRadix.ordenar(numeros, unidades, u);
        utileriaRadix.EscrituraArchivosDes(unidades, "Unidades");
        utileriaRadix.imprimirArchivosD("Unidades");
        utileriaRadix.EscrituraArchivosAuxDes(unidades, "AuxiliarUnidades");
        aux = utileriaRadix.leerArchivosDes("Unidades");
        utileriaRadix.ImprimirArchivosAux("AuxiliarUnidades");
        decenas = utileriaRadix.crearListas();
        decenas = utileriaRadix.ordenar(aux, decenas, d);
        utileriaRadix.EscrituraArchivosDes(decenas, "Decenas");
        utileriaRadix.imprimirArchivosD("Decenas");
        aux.clear();
        aux = utileriaRadix.leerArchivosDes("Decenas");
        utileriaRadix.EscrituraArchivosAuxDes(decenas, "AuxiliarDecenas");
        utileriaRadix.ImprimirArchivosAux("AuxiliarDecenas");
        centenas = utileriaRadix.crearListas();
        centenas = utileriaRadix.ordenar(aux, centenas, c);
        utileriaRadix.EscrituraArchivosDes(centenas, "Centenas");
        utileriaRadix.imprimirArchivosD("Centenas");
        aux.clear();
        aux = utileriaRadix.leerArchivosDes("Centenas");
        utileriaRadix.EscrituraArchivosAuxDes(centenas, "AuxiliarCentenas");
        utileriaRadix.ImprimirArchivosAux("AuxiliarCentenas");
        System.out.println("\nArreglo ordenado: " + aux);
        System.out.println("Escribiendo respuesta en un archivo...");
        utileriaRadix.EscrituraArchivosAuxDes(centenas, "Respuesta");
        utileriaRadix.ImprimirArchivosAux("Respuesta");
    }
}
