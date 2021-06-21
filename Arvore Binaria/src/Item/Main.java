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
    public static void main(String[] args) {
       Random gerador = new Random();
       
        /* ARVORE 1 - ordenada de 1000 elementos*/
//       ArvoreBinaria arvore = new ArvoreBinaria();
//       
//       for(int i = 0; i < 9000; i ++){
//           Item item = new Item(i);
//           arvore.insere(item);
//       }
//       
//       Item iten1 = new Item(9001);
//       
//       long inicio = System.nanoTime();
//       Item retorno1 = arvore.pesquisa(iten1);
//       long fim = System.nanoTime();
//       int comparacoes = arvore.j;
//       System.out.println(comparacoes);
       
       
      
       /* ARVORE 1 - randomica de 1000 elementos*/
        ArvoreBinaria arvore = new ArvoreBinaria();

         for(int i = 0; i < 9000; i ++){
             Item item = new Item(gerador.nextInt(9000));
             arvore.insere(item);
         }
         int elementos = arvore.i;
         
         Item iten = new Item(9001);

         long inicio = System.nanoTime();
         arvore.pesquisa(iten);
         long fim = System.nanoTime();
         int comparacoes = arvore.j;
         System.out.println(comparacoes);
//      
         try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("resultados.txt", true)));
                out.println("Arvore 9 aleatoria de " + (9000 - elementos) +" elementos. Comparações: " 
                        + (comparacoes -1 ) + ". Tempo: "+ new Long(fim - inicio).toString());
                out.close();
            }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

      
      
      
       }
    
    
}