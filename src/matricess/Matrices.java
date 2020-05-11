/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices;

import java.awt.HeadlessException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Kieffer
 */
public class Matrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        Scanner sc= new Scanner(System.in);
        Scanner entrada =new Scanner(System.in);
        int matriz[][], nFilas=0,nCol=0;
        boolean bandera=true;
        while(bandera){
                try{
                    nFilas = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de filas:"));
                    nCol = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de columnas:"));
                    if( nFilas>0 && nCol>0){
                     
                     bandera=false;
                    }else{
                        JOptionPane.showMessageDialog(null, "Ingrese un dato positivo");
                    }                   
                }catch(HeadlessException | NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ingrese un dato numerico");
                    bandera=true;
                   
                }
        }
        
        matriz = new int [nFilas][nCol];
        llenarMatriz(matriz,nFilas,nCol);       
        Matriz m=new Matriz(matriz,nFilas,nCol);
        System.out.println("Su matriz A es:");
        m.mostrarMatriz(m.getMatriz());
        bandera=true;
       int opcion=0;
       boolean bandera1=true,bandera2=true;
       String entrada1=null;
       while(bandera){
           JOptionPane.showMessageDialog(null, "1. Matriz al cubo\n"
                   + "2. Transpuesta de la Matriz\n"
                   + "3. Producto Punto\n"
                   + "4. Sumar matrices\n"
                   + "5. Restar matrices\n"
                   + "6. Multiplicar matrices\n");
                   
            while(bandera1){
                try{
                    opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion del 1 al 6"));
                    if(opcion>6||opcion<0){
                        JOptionPane.showMessageDialog(null, "Ingrese un dato valido");
                    }else{
                        bandera1=false;
                    }
                }catch(HeadlessException | NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ingrese un dato numerico");
                    bandera1=true;
                }
            }
            bandera1=true;
           switch(opcion){
               case 1:
                   System.out.println("Esta es su matriz A^3");
                   m.mostrarMatriz(m.elevarAlCubo());
                   break;
               case 2:
                   System.out.println("Transpuesta");
                   m.mostrarMatriz(m.transpuesta());
                   break;
               case 3:
                   System.out.println("Producto Punto");
                   int [][] matriz1=llenarMatriz1(m);
                   m.mostrarMatriz(m.productoPunto(matriz1));
                   break;
                case 4:
                   System.out.println("Suma de Matrices"); 
                   int [][] matriz2=llenarMatriz1(m);                
                   m.mostrarMatriz(m.sumaMatrices(matriz2));
                   break;
                case 5:
                   System.out.println("Resta de Matrices"); 
                   int [][] matriz3=llenarMatriz1(m);                
                   m.mostrarMatriz(m.restarMatrices(matriz3));
                   break;
                case 6:
                   System.out.println("Multiplicacion de Matrices"); 
                   int [][] matriz4=llenarMatriz2(m);                
                   m.mostrarMatriz(m.multiplicacionMatrices(matriz4));
                   break;
                
                   
            }
           while(bandera2){
            entrada1=JOptionPane.showInputDialog("¿Desea seguir  modificando la matriz?(si/no)");
            if(entrada1.equals("no")||entrada1.equals("NO")){
                bandera=false;
                bandera2=false;
            }else if(entrada1.equals("si")||entrada1.equals("SI")){
                bandera2=false;
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese si o no");
            }   
           }
           bandera2=true;
       }
        
        
      
        
        System.out.println("");
    }
    public static  void llenarMatriz(int[][]matriz,int nFilas,int nCol){
        String entrada=null;        
        boolean bandera=true, bandera2=true;
        while(bandera){
            entrada=JOptionPane.showInputDialog("¿Desea llenar la matriz manualmente? (si/no)");
            if(entrada.equals("no")||entrada.equals("NO")){
                bandera=false;
            }else if(entrada.equals("si")||entrada.equals("SI")){
                bandera=false;
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese si o no");
            }
        }
        if(entrada.equals("si")||entrada.equals("SI")){
            bandera=true;
            bandera2=true;
            int i=0,dato=0,j=0;
            while(bandera && i<nFilas){
                while(bandera && j<nCol){
                try{
                    dato= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer dato de la fila  "+(i+1)));
                        matriz[i][j]=dato;
                        dato=0;
                        j++;
                }catch(HeadlessException | NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ingrese un dato numerico");
                    bandera=true;
                    j--;
                }
                }
                j=0;
                i++;
                while(bandera2){
                    entrada=JOptionPane.showInputDialog("¿Desea seguir  llenando la matriz manualmente?(si/no)");
                    if(entrada.equals("no")||entrada.equals("NO")){
                        bandera=false;
                        bandera2=false;
                    }else if(entrada.equals("si")||entrada.equals("SI")){
                        bandera2=false;
                    }else{
                        JOptionPane.showMessageDialog(null, "Ingrese si o no");
                    }
                }
                bandera2=true;
            }
            for(int k=i;k<nFilas;k++){
                for(int l=0;l<nCol;l++){
                    matriz[k][l]=0;
                }
            }
        }else{
            Random rn =new Random();
            int dato=0,dato1=0;
            bandera=true;
            while(bandera){
                try{
                    dato= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el rango mayor del numero aleatorio "));
                    dato1= Integer.parseInt(JOptionPane.showInputDialog("Ingrese rango menor del numero aleatorio"));
                    bandera=false;
                }catch(HeadlessException | NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ingrese un dato numerico");
                    bandera=true;
                }
            }
            for(int i=0;i<nFilas;i++){
               for(int j=0;j<nCol;j++){
                  matriz[i][j]=(int)Math.floor(Math.random()*(dato-dato1+1)+dato1);   
                                     
                   
               }
            }
    }
  }
    public static  int[][] llenarMatriz1(Matriz m){
        int nFilas=0;int nCol=0;
        boolean bandera=true;
        int[][]matriz=null;
        while(bandera){
                try{
                    nFilas = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de filas:"));
                    nCol = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de columnas:"));
                    if(m.getnFilas()==nFilas && m.getnCol()==nCol){
                     matriz = new int [nFilas][nCol];
                     bandera=false;
                    }else{
                        JOptionPane.showMessageDialog(null, "Ingrese una matriz m=n");
                    }                   
                }catch(HeadlessException | NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ingrese un dato numerico");
                    bandera=true;
                   
                }
            }
        String entrada=null;        
        bandera=true;
        boolean bandera2=true;
        while(bandera){
            entrada=JOptionPane.showInputDialog("¿Desea llenar la matriz manualmente? (si/no)");
            if(entrada.equals("no")||entrada.equals("NO")){
                bandera=false;
            }else if(entrada.equals("si")||entrada.equals("SI")){
                bandera=false;
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese si o no");
            }
        }
        if(entrada.equals("si")||entrada.equals("SI")){
            bandera=true;
            bandera2=true;
            int i=0,dato=0,j=0;
            while(bandera && i<nFilas){
                while(bandera && j<nCol){
                try{
                    dato= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer dato de la fila  "+(i+1)));
                        matriz[i][j]=dato;
                        dato=0;
                        j++;
                }catch(HeadlessException | NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ingrese un dato numerico");
                    bandera=true;
                    j--;
                }
            }
            j=0;
            i++;
            while(bandera2){
                    entrada=JOptionPane.showInputDialog("¿Desea seguir  llenando la matriz manualmente?(si/no)");
                    if(entrada.equals("no")||entrada.equals("NO")){
                        bandera=false;
                        bandera2=false;
                    }else if(entrada.equals("si")||entrada.equals("SI")){
                        bandera2=false;
                    }else{
                        JOptionPane.showMessageDialog(null, "Ingrese si o no");
                    }
                }
                bandera2=true;
            }
            for(int k=i;k<nFilas;k++){
                for(int l=0;l<nCol;l++){
                    matriz[k][l]=0;
                }
            }
        }else{
            Random rn =new Random();
            int dato=0,dato1=0;
            bandera=true;
            while(bandera){
                try{
                    dato= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el rango mayor del numero aleatorio "));
                    dato1= Integer.parseInt(JOptionPane.showInputDialog("Ingrese rango menor del numero aleatorio"));
                    bandera=false;
                }catch(HeadlessException | NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ingrese un dato numerico");
                    bandera=true;
                }
            }
            for(int i=0;i<nFilas;i++){
               for(int j=0;j<nCol;j++){
                  matriz[i][j]=(int)Math.floor(Math.random()*(dato-dato1+1)+dato1);   
                                     
                   
               }
            }
    }
           return matriz;
    } 
    public static  int[][] llenarMatriz2(Matriz m){
        int nFilas=0;int nCol=0;
        boolean bandera=true;
        int[][]matriz=null;
        while(bandera){
                try{
                    nFilas = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de filas:"));
                    nCol = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de columnas:"));
                    if( m.getnCol()==nFilas){
                     matriz = new int [m.getnFilas()][nCol];
                     bandera=false;
                    }else{
                        JOptionPane.showMessageDialog(null, "Ingrese una matriz m=n");
                    }                   
                }catch(HeadlessException | NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ingrese un dato numerico");
                    bandera=true;
                   
                }
            }
        String entrada=null;        
        bandera=true;
        boolean bandera2=true;
        while(bandera){
            entrada=JOptionPane.showInputDialog("¿Desea llenar la matriz manualmente? (si/no)");
            if(entrada.equals("no")||entrada.equals("NO")){
                bandera=false;
            }else if(entrada.equals("si")||entrada.equals("SI")){
                bandera=false;
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese si o no");
            }
        }
        if(entrada.equals("si")||entrada.equals("SI")){
            bandera=true;
            bandera2=true;
            int i=0,dato=0,j=0;
            while(bandera && i<nFilas){
                while(bandera && j<nCol){
                try{
                    dato= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer dato de la fila  "+(i+1)));
                        matriz[i][j]=dato;
                        dato=0;
                        j++;
                }catch(HeadlessException | NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ingrese un dato numerico");
                    bandera=true;
                    j--;
                }
            }
            j=0;
            i++;
            while(bandera2){
                    entrada=JOptionPane.showInputDialog("¿Desea seguir  llenando la matriz manualmente?(si/no)");
                    if(entrada.equals("no")||entrada.equals("NO")){
                        bandera=false;
                        bandera2=false;
                    }else if(entrada.equals("si")||entrada.equals("SI")){
                        bandera2=false;
                    }else{
                        JOptionPane.showMessageDialog(null, "Ingrese si o no");
                    }
                }
                bandera2=true;
            }
            for(int k=i;k<nFilas;k++){
                for(int l=0;l<nCol;l++){
                    matriz[k][l]=0;
                }
            }
        }else{
            Random rn =new Random();
            int dato=0,dato1=0;
            bandera=true;
            while(bandera){
                try{
                    dato= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el rango mayor del numero aleatorio "));
                    dato1= Integer.parseInt(JOptionPane.showInputDialog("Ingrese rango menor del numero aleatorio"));
                    bandera=false;
                }catch(HeadlessException | NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ingrese un dato numerico");
                    bandera=true;
                }
            }
            for(int i=0;i<nFilas;i++){
               for(int j=0;j<nCol;j++){
                  matriz[i][j]=(int)Math.floor(Math.random()*(dato-dato1+1)+dato1);   
                                     
                   
               }
            }
    }
           return matriz;
    }
}
    

