/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xaedsmaps;

/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Grafo grafo1 = new Grafo(6); // Primeiro grafo
       
        // inserindo elementos grafo1:
        
        grafo1.insereAresta(0, 1, 8, 3);
        grafo1.insereAresta(0, 3, 5, 2);
        grafo1.insereAresta(0, 2, 4, 10);
                
        grafo1.insereAresta(1, 4, 9, 5);

        grafo1.insereAresta(2, 5, 1, 4);
        grafo1.insereAresta(2, 4, 5, 2);
        
        grafo1.insereAresta(3, 1, 3, 8);
        grafo1.insereAresta(3, 2, 5, 7);
        grafo1.insereAresta(3, 4, 2, 7);
        
        
        System.out.println("------Resultados grafo 1-------");
        XAEDsMaps g1 = new XAEDsMaps(grafo1);
        System.out.println("Menor distancia");
        g1.obterMenorCaminho(0);
        g1.imprimeCaminho(0, 4);
        System.out.println(" ");
        System.out.println("Menor tempo");
        g1.obterMenorTempo(0);
        g1.imprimeCaminho(0, 4);
        
        System.out.println(" ");
        
        // inserindo elementos grafo2:        
        Grafo grafo2 = new Grafo(5); // Segundo grafo
        
        grafo2.insereAresta(0, 1, 3, 3);        // a -> b
        grafo2.insereAresta(0, 3, 5, 5);        // a -> d
        
        grafo2.insereAresta(1, 2, 2, 6);        // b -> c
        grafo2.insereAresta(1, 3, 2, 2);        // b -> d
        
        grafo2.insereAresta(2, 4, 2, 2);        // c -> e
        
        grafo2.insereAresta(3, 1, 3, 1);        // d -> b
        grafo2.insereAresta(3, 2, 5, 4);        // d -> c
        grafo2.insereAresta(3, 4, 9, 6);        // d -> e
        
        grafo2.insereAresta(4, 0, 6, 3);        // e -> c
        grafo2.insereAresta(4, 2, 4, 7);        // e -> a
        
        System.out.println("------Resultados grafo 2-------");
        XAEDsMaps g2 = new XAEDsMaps(grafo2);
        System.out.println("Menor distancia");
        g2.obterMenorCaminho(0);
        g2.imprimeCaminho(3, 0);
        
        System.out.println(" ");
        System.out.println("Menor tempo");
        g2.obterMenorTempo(0);
        g2.imprimeCaminho(3, 0);
    }
    
}
