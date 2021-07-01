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
public class ArvoreB {
    private static class Pagina{
        int num;                                // num de elementos na pag
        Item r[];                               // vetor de registros de tamanho 2m == mm
        Pagina p[];                             // vetor de objetos de nivel baixo 2m + 1
        
        public Pagina (int mm){
            this.num = 0; this.r = new Item[mm];
            this.p = new Pagina[mm + 1];
        }
    }
    private Pagina raiz;
    public int min, max;                       // quantiadde min e max de elementos na pagina
    public int j, i;
    
    public ArvoreB(int m){
        this.raiz = null;
        this.min = m;
        this.max = 2*min;
    }
    
    private Item pesquisa(Item reg, Pagina ap){
        j++;
        if(ap == null) return null;     // não achou
        else{
            int i = 0;
            while((i < ap.num - 1) && (reg.compara(ap.r[i]) > 0)) i++;     // vê se é válida e se é o elemento procuradp é maior que o atual
            if(reg.compara(ap.r[i]) == 0)   return ap.r[i];                 // foi igual
            else if (reg.compara(ap.r[i]) < 0)  return pesquisa(reg, ap.p[i]);      // ele é menor, entao chama a esquerda
            else    return pesquisa(reg, ap.p[i + 1]);                              // ele é maior, entao chama a direita
        }
    }
    
    private void inserePagina(Pagina ap, Item reg, Pagina apDir){
        int posValida = ap.num - 1;             // posicao válida a direita
        while((posValida >= 0) && (reg.compara(ap.r[posValida]) < 0)){          // desloca todo mundo para a direita ate encontrar a posicao certa
            ap.r[posValida+1] = ap.r[posValida];                                // 
            ap.p[posValida+2] = ap.p[posValida+1];
            posValida--;
        }
        ap.r[posValida+1] = reg;
        ap.p[posValida+2] = apDir;
        ap.num++;
    }
    
    private Pagina insere(Item reg, Pagina ap, Item[] regReturn, boolean[] grow){
        Pagina apReturn = null;
        if(ap == null){                 // pagina encontrada
            grow[0] = true;
            regReturn[0] = reg;
        }else{
            int i = 0;
            while((i < ap.num - 1) && (reg.compara(ap.r[i]) > 0)) i++;      // verifica onde colocar o novo element e se ele existe
            if(reg.compara(ap.r[i]) == 0){
                i++;
                System.out.println("Erro, registro já existe!");
                grow[0] = false;
            }else{
                if(reg.compara(ap.r[i]) > 0)i++;                            // devo ir para a esquerda ou para a direita?
                apReturn = insere(reg, ap.p[i], regReturn, grow);
                if(grow[0])
                    if(ap.num < this.max){                                  // temos espaço para mais um
                        this.inserePagina(ap, regReturn[0], apReturn);
                        grow[0] = false; apReturn = ap;
                    }
                    else{                                                   // temos não
                        Pagina apTemp = new Pagina(this.max);               // cria pagina
                        apTemp.p[0] = null;
                        if ( i <= this.min){                                // esse elemento deve ir 
                            this.inserePagina(apTemp, regReturn[0], apReturn);
                            ap.num--;
                            this.inserePagina(ap, regReturn[0], apReturn);    // para a pag atual?
                        }
                        else this.inserePagina(apTemp, regReturn[0], apReturn);    // para essa nova pag ?
                        for(int j = this.min + 1; j < this.max; j++){        // metade da galera da direita vai pra nova
                            this.inserePagina(apTemp, ap.r[j], ap.p[j +1]);
                            ap.p[j+1] = null;   // transfere memória
                        }
                        ap.num = this.min;
                        apTemp.p[0] = ap.p[this.min+1];
                        regReturn[0] = ap.r[this.min];          // ele vai subir
                        apReturn = apTemp;                      
                    }
                }
            }
        return(grow[0] ? apReturn : ap);
    }
    
    public void insere(Item reg){
        Item regReturn[] = new Item[1];
        boolean grow[] = new boolean[1];
        Pagina apReturn = this.insere(reg, this.raiz, regReturn, grow);
        if (grow[0]){           // a raiz cresceu?
            Pagina apTemp = new Pagina(this.max);       // sim, entao precisa de mais pagina
            apTemp.r[0] = regReturn[0];
            apTemp.p[0] = this.raiz;
            apTemp.p[1] = apReturn;
            this.raiz = apTemp; this.raiz.num++;
        }
        else
            this.raiz = apReturn;
    }
    public Item pesquisa(Item reg){
        return this.pesquisa(reg, this.raiz);
    }
}
