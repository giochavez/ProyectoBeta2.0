import java.util.Scanner;
import java.io.*;
import java.util.List;
import java.util.LinkedList;

public class menuPrincipal{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    List<Integer> numeros = new LinkedList<>();

    int op;
    numeros = Archivos.Leer();

    do{
      System.out.println("Elige una opcion:");
      System.out.println("1) Polifase. \n2) Mezcla equilibrada. \n3) RadixSort.\n4) Ingresar un nuevo archivo.\n5) Salir");
      System.out.print("Opcion: ");
      op = sc.nextInt();
      System.out.println();

      switch(op){
        case 1:
          //polifase.sort(numeros);
          //System.out.println();
          break;
        case 2:
          System.out.println("Mezcla equilibrada:\n  1) Ascendente. \n  2) Descendente.");
          System.out.print("Eleccion: ");
          int op2 = sc.nextInt();
          do{
            switch(op2){
              case 1:
                mezclaEA.sort(numeros);
                op=0;
                break;
              case 2:
                mezclaED.sort(numeros);
                op=0;
                break;
              default: System.out.println("Opcion invalida.\n");break;
            }
          }while(op2==0);
          break;
        case 3:
          radixSort.menu(numeros);
          System.out.println();
          break;
        case 4:
          numeros = Archivos.Leer();
          break;
        case 5:
          System.out.println("Gracias por usar el proyecto.\n Hasta Luego");
          break;
        default:
          System.out.println("Opcion invalida.\n");
          break;
      }
    }while(op!=5);
  }
}
