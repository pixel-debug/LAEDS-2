/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;

/**
 *
 * @author usuario
 */
public class HeapSort {
    public static int comp = 0;
    public static int heapSort ( Item v [ ] , int n) {
        
        Heap fpHeap = new Heap( v ) ;
        
        int dir = n;
        fpHeap.constroi ( ); // constroi o heap 
        
        while ( dir > 1 ) { // ordena o vetor
            Item x = v[1] ;
            v[1] = v[ dir - 1];
            v [ dir - 1 ] = x ;
            dir--;
            fpHeap.refaz( 1 , dir ) ;
            }
        
        comp = fpHeap.getComparacoes();
        return comp;
        }

    public static int getComp() {
        return comp;
    }
    
}
