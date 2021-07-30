/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xgrafo;

/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         //---------------------GRAFO NUMERO 1 ------------------------------
        Grafo grafo1 = new Grafo(8);
        

        grafo1.insereAresta(0, 1, 1);
        grafo1.insereAresta(0, 4, 1);        
        grafo1.insereAresta(0, 3, 1);
        
        grafo1.insereAresta(1, 2, 1);
        grafo1.insereAresta(1, 0, 1);
        grafo1.insereAresta(1, 5, 1);
        
        grafo1.insereAresta(2, 3, 1);
        grafo1.insereAresta(2, 6, 1);
        grafo1.insereAresta(2, 1, 1);
        
        grafo1.insereAresta(3, 7, 1);
        grafo1.insereAresta(3, 2, 1);
        grafo1.insereAresta(3, 0, 1);
        
        grafo1.insereAresta(4, 7, 1);
        grafo1.insereAresta(4, 5, 1);
        grafo1.insereAresta(4, 0, 1);
        
        grafo1.insereAresta(5, 6, 1);
        grafo1.insereAresta(5, 1, 1);
        grafo1.insereAresta(5, 4, 1);
        
        grafo1.insereAresta(6, 7, 1);
        grafo1.insereAresta(6, 2, 1);
        grafo1.insereAresta(6, 5, 1);
        
        grafo1.insereAresta(7, 3, 1);
        grafo1.insereAresta(7, 4, 1);
        grafo1.insereAresta(7, 6, 1);
        
        System.out.println("Resultados grafo 1");
        grafo1.imprime();
        Busca busca1 = new Busca(grafo1);
        int ciclo1 = busca1.getCiclo();
        System.out.println("Há "+ ciclo1 +" ciclos");
       
        //---------------------GRAFO NUMERO 2 ------------------------------
        System.out.println("----------------------------");
        Grafo grafo2 = new Grafo(10);
        

        grafo2.insereAresta(0, 5, 1);
        grafo2.insereAresta(0, 2, 1);        
        grafo2.insereAresta(0, 3, 1);       
        grafo2.insereAresta(0, 1, 1);
        
        grafo2.insereAresta(5, 4, 1);
        grafo2.insereAresta(5, 6, 1);
        
        grafo2.insereAresta(1, 2, 1);
        
        grafo2.insereAresta(2, 3, 1);
        grafo2.insereAresta(2, 4, 1);
        
        grafo2.insereAresta(4, 6, 1);
        
        grafo2.insereAresta(6, 7, 1);
        grafo2.insereAresta(6, 8, 1);
        
        grafo2.insereAresta(7, 8, 1);
        
        grafo2.insereAresta(9, 6, 1);
        
        
        System.out.println("Resultados grafo 2");
        grafo2.imprime();
        Busca busca2 = new Busca(grafo2);
        int ciclo2 = busca2.getCiclo();
        System.out.println("Há "+ ciclo2 +" ciclos");
    }
    
}
