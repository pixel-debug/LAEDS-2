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
public class Heap {
       
        private Item v [] ;
        private int n;
        private int comparacoes;
        
        public Heap (Item v []) {
            this.v = v; 
            this.n = this.v.length - 1;
            this.comparacoes = 0;
        }

        
        public Item max() {
            return this.v[1];
        }
        
        public void refaz(int esq, int dir) {
            int j = esq * 2; 
            Item x = this.v[esq];
            
            while (j <= dir) {
                if((j < dir) && (this.v[j].compara(this.v[j+1]) < 0)){
                    j++;
                }
                this.comparacoes++; 
                if(x.compara(this.v[j]) >= 0) {
                    break;
                }
                this.v[esq] = this.v[j] ;
                esq = j ; 
                j = esq * 2;
            }
            this.v[esq] = x;
        }
        
        public void constroi() {
            int esq = n/2 + 1;
            while (esq > 1) {
                esq--;
                this.refaz(esq, this.n);
            }
        }
        
      
        public int getComparacoes() {
            return comparacoes;
        }

        public void setComparacoes(int comparacoes) {
            this.comparacoes = comparacoes;
        }
    
}
