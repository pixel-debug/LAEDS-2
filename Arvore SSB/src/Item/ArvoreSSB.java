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
public class ArvoreSSB {
    private static class No {
        Item reg;
        No esq, dir;
        byte incE, incD;
    }
    private static final byte Horizontal = 0;
    private static final byte Vertical = 1;
    private No raiz;
    private boolean propSBB;
    public int j, i;
    
    public ArvoreSSB(){
        this.raiz = null;
        this.propSBB = true;        
    }
    
    private No insere(Item reg, No pai, No filho, boolean filhoESQ){
        if(filho == null){
            filho = new No();             filho.reg = reg;
            filho.incE = Vertical;        filho.incD = Vertical;
            filho.dir = null;             filho.esq = null;
            
            if( pai != null) 
                if(filhoESQ) pai.incE = Horizontal;
                else         pai.incD = Horizontal;                   
           
            this.propSBB = false;
        }
        else if(reg.compara(filho.reg) < 0){
            filho.esq = insere(reg, filho, filho.esq, true);
            if(!this.propSBB)
                if(filho.incE == Horizontal){
                    if(filho.esq.incE == Horizontal){
                        filho = this.ee(filho);     // esquerda
                        if( pai != null)
                            if(filhoESQ)    pai.incE = Horizontal;
                            else            pai.incD = Horizontal;
                    }
                    else if(filho.esq.incD == Horizontal){
                        filho = this.ed(filho);         // esquerda direita
                        if( pai != null)
                            if(filhoESQ)        pai.incE = Horizontal;
                            else                pai.incD = Horizontal;

                    }
                }
            else  this.propSBB = true;
        }
        
        else if(reg.compara(filho.reg) > 0){
                filho.dir = insere(reg, filho, filho.dir, true);
                if(!this.propSBB)
                    if(filho.incD == Horizontal)
                        if(filho.dir.incD == Horizontal){
                            filho = this.dd(filho);     // direita
                            if( pai != null){
                                if(filhoESQ)
                                    pai.incE = Horizontal;
                                else
                                    pai.incD = Horizontal;
                            }
                        }
                
                    else if(filho.dir.incE == Horizontal){
                        filho = this.de(filho);         // direita esquerda
                        if( pai != null){
                                if(filhoESQ)
                                    pai.incE = Horizontal;
                                else
                                    pai.incD = Horizontal;
                        }
                    }
                else this.propSBB = true;
        }
        else{
            i++;
            
            this.propSBB = true;
            System.out.println("Erro: já existe esse registro!");
            }
        return filho;
    }
    
     private Item pesquisa(Item reg, No p){
        j++;
        if (p == null) return null;      // não há esse registro
        else if(reg.compara(p.reg) < 0) return pesquisa(reg, p.esq);  // achou na esquerda
        else if(reg.compara(p.reg) > 0) return pesquisa(reg, p.dir);    // achou na direita
        else return p.reg;    
    }
    
    private No ee(No ap) {
        No ap1 = ap.esq;
        ap.esq = ap1.dir;
        ap1.dir = ap;
        ap1.incE = Vertical;
        ap.incE = Vertical;
        ap = ap1;
      
        return ap;
    }
    private No ed(No ap) {
        No ap1 = ap.esq;
        No ap2 = ap1.dir;
        ap1.incD = Vertical;
        ap.incE = Vertical;
        ap1.dir = ap2.esq;
        ap2.esq = ap1;
        ap.esq = ap2.dir;
        ap2.dir = ap;
        ap = ap2;
        
        return ap;
    }
    private No dd(No ap) {
        No ap1 = ap.dir;
        ap.dir = ap1.esq;
        ap1.esq = ap;
        ap1.incD = Vertical;
        ap.incD = Vertical;
        ap = ap1;
        
        return ap;
    }
    private No de(No ap) {
        No ap1 = ap.dir;
        No ap2 = ap1.esq;
        ap1.incE = Vertical;
        ap.incD = Vertical;
        ap1.esq = ap2.dir;
        ap2.dir = ap1;
        ap.dir = ap2.esq;
        ap2.esq = ap;
        ap = ap2;
        
        return ap;
    }

    
    public Item pesquisa(Item reg){
        return this.pesquisa(reg, this.raiz);
    }
    
    public void insere( Item reg){
        this.raiz = insere(reg, null, this.raiz, true);
    }
    
   
}
