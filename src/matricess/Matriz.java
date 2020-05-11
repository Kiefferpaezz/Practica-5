/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices;

/**
 *
 * @author Kieffer
 */
public class Matriz {
    private int nFilas,nCol;
    private int[][] matriz;

    public Matriz(int[][] matriz,int nFilas, int nCol) {
        this.matriz = matriz;
        this.nCol=nCol;
        this.nFilas=nFilas;
    }

    public int getnFilas() {
        return nFilas;
    }

    public void setnFilas(int nFilas) {
        this.nFilas = nFilas;
    }

    public int getnCol() {
        return nCol;
    }

    public void setnCol(int nCol) {
        this.nCol = nCol;
    }
    

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    /**
     * Este metodo es el encargado de elevat nuestra matriz inicial al cubo.
     * 
     **/
    public int[][] elevarAlCubo(){
        int [][] cubo=new int[nFilas][nCol];
        for (int i = 0; i <nFilas; i++) {
            for (int j = 0; j <nCol; j++) {
                cubo[i][j]=(int) Math.pow(matriz[i][j],3);
               
            }
        }
        return cubo;
    }
    /**
     * Este metodo es el encargado de mostrar nuesta matriz.
     * @param resultado 
     **/
    public void mostrarMatriz(int[][] resultado){
        for (int i = 0; i <resultado.length; i++) {
            for (int j = 0; j <resultado[0].length; j++) {
                 System.out.print(resultado[i][j]+","); 
            }
            System.out.println(""); 
        }
    }
    /**
     * Metodo encargado de transponer nuestra matriz inicial.
     *  
     **/
    public int[][] transpuesta(){
        int [][] transpuesta=new int[nCol][nFilas];
        for (int i = 0; i <nFilas; i++) {
            for (int j = 0; j <nCol; j++) {
                transpuesta[j][i]=matriz[i][j];
               
            }
        }
        return transpuesta;
}
    /**
     * Metodo encargado de hacer producto punto con nuestra matriz inical.
     * 
     * 
     **/
    public int[][] productoPunto(int[][]x){
	System.out.println("Matriz con la cual se va a realizar el producto punto ");
        this.mostrarMatriz(x);
        int [][]producto=new int[nFilas][nCol];
        System.out.println("Resultado del producto punto");
	for(int i=0; i<nFilas; i++){
            for( int j=0; j<nCol; j++){
		producto[i][j]=(x[i][j]*matriz[i][j]);
            }
        }
     return producto;   
     }
    /**
     * Metodo encargado de sumar nuestra matriz inicial con la que ingresemos.    
     **/
    public int [][] sumaMatrices (int[][]x){
        System.out.println("Matriz con la cual se va a realizar la suma es ");
        this.mostrarMatriz(x);
        int [][]producto=new int[nFilas][nCol];
        System.out.println("Resultado de la suma es:");
        int [][] suma= new int[nFilas][nCol];
        for(int i=0; i<nFilas; i++){
            for( int j=0; j<nCol; j++){
		suma[i][j]=(x[i][j]+matriz[i][j]);
            }
        }
     return suma;   
     }
    /**
     * Metodo encargado de restar nuestra matriz inicial con la que ingresemos.    
     **/
    public int [][] restarMatrices (int[][]x){
        System.out.println("Matriz con la cual se va a realizar la resta ");
        this.mostrarMatriz(x);
        int [][]producto=new int[nFilas][nCol];
        System.out.println("Resultado de la resta");
        int [][] restar= new int[nFilas][nCol];
        for(int i=0; i<nFilas; i++){
            for( int j=0; j<nCol; j++){
		restar[i][j]=(x[i][j]-matriz[i][j]);
            }
        }
     return restar;          
    }
    /**
    * Metodo encargado de multiplicar nuestra matriz inicial con la que ingresemos.      
    **/
    public  int[][] multiplicacionMatrices ( int[][] b) {
        int[][] c = new int[matriz.length][b[0].length];
        System.out.println("Matriz con la cual se va a realizar la multiplicacion");
        this.mostrarMatriz(b);
        System.out.println("Resultado de la multiplicacion");
      for (int i= 0; i<c.length; i++)
          for (int j=0; j<c[0].length; j++)
              for (int k=0; k<b.length; k++)
                  c[i][j] = c[i][j] + matriz[i][k] * b[k][j];
      return c;
   }
    
}
