import java.io.*;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;

public class mezclaED{
  static void sort(List<Integer> l0){
    List<Integer> lista0 = new LinkedList<>();
    lista0.addAll(l0);
    int tam = lista0.size(),n=1;
    List<ArrayList<Integer>> l1 = new ArrayList<>();
    List<ArrayList<Integer>> l2 = new ArrayList<>();
    List<ArrayList<Integer>> lf = new ArrayList<>();
    StringBuilder str = new StringBuilder();
    StringBuilder str2 = new StringBuilder();
    StringBuilder str0 = new StringBuilder();

    File me = new File("Mezcla equilibradaDes");
    me.mkdir();
    Archivos.crear("Mezcla equilibradaDes\\F1.txt");
    Archivos.crear("Mezcla equilibradaDes\\F2.txt");
    Archivos.crear("Mezcla equilibradaDes\\F0.txt");
    str0.append("Archivo original:\n");
    for(int i =0;i<tam;i++){
      if(i!=0){
        str0.append(",");
      }
      str0.append(lista0.get(i));
    }

    System.out.println("Iteracion "+n+":");
    generarClaves(lista0,l1,l2,str,str2);

    int b = MezclarClaves(l1,l2,lf,str0,n);
    n++;
    System.out.println();
    while(b != tam){
      System.out.println("Iteracion "+n+":");
      repartirClaves("Mezcla equilibradaDes\\F0.txt",lf,l1,l2,str,str2,n);
      b = MezclarClaves(l1,l2,lf,str0,n);
      System.out.println();
      n++;
    }
    str.insert(0,"Iteracion 1:\n");
    str2.insert(0,"Iteracion 1:\n");
    Archivos.escribir("Mezcla equilibradaDes\\F1.txt", str);
    Archivos.escribir("Mezcla equilibradaDes\\F2.txt", str2);
    Archivos.escribir("Mezcla equilibradaDes\\F0.txt", str0);
    System.out.print("El archivo ordenado es: ");
    for(int i = 0 ; i<tam; i++){
      if(i!=0){
        System.out.print(",");
      }
      System.out.print(lf.get(0).get(i));
    }
    System.out.println("\n");
    System.out.println("El resultado fue guardado en F0.txt dentro de la carpeta Mezcla equilibradaDes\n");
  }

  public static void generarClaves(List<Integer> l0,List<ArrayList<Integer>> l1,List<ArrayList<Integer>> l2,StringBuilder str,StringBuilder str2){
    int n=0;

    while(!l0.isEmpty()){
      ArrayList<Integer> datos1 = new ArrayList<>();
      ArrayList<Integer> datos2 = new ArrayList<>();
      if(n%2 == 0){
        if(n != 0)
          str.append(",");
        while(l0.size() != 1 && l0.get(0) >= l0.get(1)){
          str.append(Integer.toString(l0.get(0)));
          datos1.add(l0.get(0));
          l0.remove(0);
          str.append(",");
        }
        if(!l0.isEmpty()){
          str.append(Integer.toString(l0.get(0)));
          datos1.add(l0.get(0));
          l0.remove(0);
            n++;
        }
        l1.add(datos1);
      }else if(n%2 == 1){
        if(n != 1)
          str2.append(",");
        while(l0.size() != 1 && l0.get(0) >= l0.get(1)){
          str2.append(Integer.toString(l0.get(0)));
          datos2.add(l0.get(0));
          l0.remove(0);
          str2.append(",");
        }
        if(!l0.isEmpty()){
          str2.append(Integer.toString(l0.get(0)));
          datos2.add(l0.get(0));
          l0.remove(0);
          n++;
        }
        l2.add(datos2);
      }
    }
    System.out.println("F1:{"+str+"}");
    System.out.println("F2:{"+str2+"}");
  }

  public static int MezclarClaves(List<ArrayList<Integer>> l1,List<ArrayList<Integer>> l2,List<ArrayList<Integer>> lf,StringBuilder str0,int cont){
    ArrayList<Integer> datos = new ArrayList<>();
    StringBuilder mezcla = new StringBuilder();
    int b=0;

    while(!l1.isEmpty() && !l2.isEmpty()){
      if(!l2.get(0).isEmpty() && !l2.get(0).isEmpty()){
        if(l1.get(0).size()>0 && l1.get(0).get(0) >= l2.get(0).get(0)){
          mezcla.append(l1.get(0).get(0));
          datos.add(l1.get(0).get(0));
          if(l1.get(0).isEmpty() || !l2.get(0).isEmpty()){
                      mezcla.append(",");
          }
          l1.get(0).remove(0);
        }else{
          mezcla.append(l2.get(0).get(0));
          datos.add(l2.get(0).get(0));
          l2.get(0).remove(0);
          if(!l2.get(0).isEmpty() || !l1.get(0).isEmpty()){
            mezcla.append(",");
          }
        }
      }else if(!l1.get(0).isEmpty() && l2.get(0).isEmpty()){
        while(!l1.get(0).isEmpty()){
          mezcla.append(l1.get(0).get(0));
          datos.add(l1.get(0).get(0));
          l1.get(0).remove(0);
          if(!l1.get(0).isEmpty() || !l2.get(0).isEmpty()){
            mezcla.append(",");
          }
        }
      }else if(l1.get(0).isEmpty() && !l2.get(0).isEmpty()){
        while(!l2.get(0).isEmpty()){
          mezcla.append(l2.get(0).get(0));
          datos.add(l2.get(0).get(0));
          l2.get(0).remove(0);
          if(!l2.get(0).isEmpty() || !l1.get(0).isEmpty()){
            mezcla.append(",");
          }
        }
      }
      if(l1.get(0).isEmpty() && l2.get(0).isEmpty()){
        l1.remove(0);
        l2.remove(0);
        if(!l1.isEmpty() && !l2.isEmpty())
          mezcla.append(",");
        if(datos.size()>b){
          b=datos.size();
        }
        lf.add(datos);
        datos = new ArrayList<>();
      }
    }
    if(!l1.isEmpty()){
      mezcla.append(",");
      datos = new ArrayList<>();
      while(!l1.get(0).isEmpty()){
        mezcla.append(l1.get(0).get(0));
        datos.add(l1.get(0).get(0));
        l1.get(0).remove(0);
        if(!l1.get(0).isEmpty()){
          mezcla.append(",");
        }
      }
      l1.remove(0);
      lf.add(datos);
    }
    System.out.println("F0:{"+mezcla+"}");
    Archivos.escribir("Mezcla equilibradaDes\\F0.txt", mezcla);
    mezcla.insert(0,"\n\nIteracion "+cont+":\n");
    str0.append(mezcla.toString());
    l1.clear();
    l2.clear();
    return b;
  }

  static void repartirClaves(String s,List<ArrayList<Integer>> lf,List<ArrayList<Integer>> l1,List<ArrayList<Integer>> l2,StringBuilder str,StringBuilder str2,int cont){
    File file1 = new File(s);
    int n=0,c=0,c2=0,i;

    try {
      Scanner sc1 = new Scanner(file1);
      StringBuilder clave1=new StringBuilder();
      StringBuilder clave2=new StringBuilder();

      while(sc1.hasNextLine()){
        String linea=sc1.nextLine();
        String [] datos = linea.split(",");
        c2 += lf.get(0).size();
        ArrayList<Integer> datos1 = new ArrayList<>();
        ArrayList<Integer> datos2 = new ArrayList<>();
        while(!lf.isEmpty()){
          if(n%2==0 && n!=0)
            clave1.append(",");
          if(n%2==1 && n!=1) clave2.append(",");
          for(i = c ; i < c2;i++){
            if(n%2==0){
              if(i!=0 && i > c)
                clave1.append(",");
                clave1.append(datos[i]);
                datos1.add(Integer.parseInt(datos[i]));
                Archivos.escribir("Mezcla equilibradaDes\\F1.txt",clave1);
            }else{
              if(i!=0 && i > c)
                clave2.append(",");
              clave2.append(datos[i]);
              datos2.add(Integer.parseInt(datos[i]));
              Archivos.escribir("Mezcla equilibradaDes\\F2.txt",clave2);
            }
          }
          if(n%2==0){
            l1.add(datos1);
            datos1 = new ArrayList<>();
          }else{
            l2.add(datos2);
            datos2 = new ArrayList<>();
          }
          lf.remove(0);
          if(!lf.isEmpty()){
            c=i;
            c2+=lf.get(0).size();
          }
          n++;
        }
      }
      System.out.println("F1:{"+clave1+"}");
      System.out.println("F2:{"+clave2+"}");
      clave1.insert(0,"\n\nIteracion "+cont+":\n");
      clave2.insert(0,"\n\nIteracion "+cont+":\n");
      str.append(clave1.toString());
      str2.append(clave2.toString());
    }catch (FileNotFoundException e){
      System.out.println("Error: " + e.getMessage());
      System.out.println();
    }catch(Exception e){
      System.out.println("Error: "+e.getMessage());
    }
  }
}
