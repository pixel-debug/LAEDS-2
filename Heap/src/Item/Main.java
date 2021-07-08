/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Random gerador = new Random();
       int tamVetor = 100000;
        
       int posicao = 0;
       Item vetorItens[] = new Item[tamVetor];
       for(int i = tamVetor; i > 0; i --){
           
           Item item = new Item(gerador.nextInt(tamVetor));
           vetorItens[posicao] = item;
           posicao++;
       }

       HeapSort hs = new HeapSort();
       
       hs.heapSort(vetorItens, tamVetor);
       
       int comparacoes = hs.comp;
       
       
       try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("resultados4.txt", true)));
                out.println("Arvore 1 aleatoria de " + tamVetor +". Comparações: " + (comparacoes - 1)
                        );
                out.close();
            }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

    }
    
}
