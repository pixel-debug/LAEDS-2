/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xagm;

/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        XGrafo grafo1 = new XGrafo(9); // Primeiro grafo
       
        // inserindo elementos grafo1:
        grafo1.insereAresta(0, 1, 15);       // F -> G
        grafo1.insereAresta(1, 2, 5);        // G -> C
        grafo1.insereAresta(1, 4, 10);       // G -> A
        
        grafo1.insereAresta(2, 3, 5);        // C -> D 
        grafo1.insereAresta(3, 1, 10);       // D -> G
        grafo1.insereAresta(3, 5, 5);        // D -> E
        
        grafo1.insereAresta(4, 3, 10);       // A -> D
        grafo1.insereAresta(4, 6, 5);        // A -> B
        grafo1.insereAresta(4, 7, 10);        // A -> H
        
        grafo1.insereAresta(5, 4, 5);       // E -> A
        grafo1.insereAresta(5, 2, 10);       // E -> C
        grafo1.insereAresta(5, 8, 10);       // E -> K
        
        grafo1.insereAresta(7, 8, 20);      // H -> K
        grafo1.insereAresta(7, 6, 5);       // H -> B
        
        grafo1.insereAresta(8, 6, 10);      // K -> B
        
        grafo1.insereAresta(6, 0, 5);       // B -> F
       
        
        System.out.println("Resultados grafo 1");
        AGMPrim g1 = new AGMPrim(grafo1);
        g1.obterAgm(8);
        g1.imprime();
        System.out.println("PESO : " + g1.Peso());
       
        //---------------------GRAFO NUMERO 2 ------------------------------
        System.out.println("----------------------------");
        
        
        XGrafo grafo2 = new XGrafo(10); 
        
       
        grafo2.insereAresta(2, 1, 8);
        grafo2.insereAresta(2, 3, 3);
        grafo2.insereAresta(2, 4, 2);
        grafo2.insereAresta(2, 5, 7);
        grafo2.insereAresta(2, 6, 5);
        grafo2.insereAresta(2, 8, 6);
        
        grafo2.insereAresta(1, 3, 2);
        grafo2.insereAresta(1, 2, 8);
        grafo2.insereAresta(1, 7, 9);

        grafo2.insereAresta(3, 2, 3);
        grafo2.insereAresta(3, 1, 2);
        grafo2.insereAresta(3, 4, 9);
        grafo2.insereAresta(3, 7, 6);
       
        grafo2.insereAresta(4, 5, 6);
        grafo2.insereAresta(4, 7, 2);
        grafo2.insereAresta(4, 3, 9);
        grafo2.insereAresta(4, 2, 2);
        
        grafo2.insereAresta(5, 6, 5);
        grafo2.insereAresta(5, 7, 4);
        grafo2.insereAresta(5, 2, 7);
        grafo2.insereAresta(5, 4, 6);
        
        grafo2.insereAresta(6, 8, 4);
        grafo2.insereAresta(6, 7, 6);
        grafo2.insereAresta(6, 2, 5);
        grafo2.insereAresta(6, 5, 5);
        
        grafo2.insereAresta(8, 7, 3);
        grafo2.insereAresta(8, 6, 4);
        grafo2.insereAresta(8, 2, 6);
        
        grafo2.insereAresta(7, 1, 9);
        grafo2.insereAresta(7, 3, 6);
        grafo2.insereAresta(7, 4, 3);
        grafo2.insereAresta(7, 5, 4);
        grafo2.insereAresta(7, 6, 6);
        grafo2.insereAresta(7, 8, 3);
                       
        System.out.println("Resultados grafo 2");
        AGMPrim g2 = new AGMPrim(grafo2);
        g2.obterAgm(2);
        g2.imprime();
        System.out.println("PESO : " +g2.Peso());
    }
    
    
}
