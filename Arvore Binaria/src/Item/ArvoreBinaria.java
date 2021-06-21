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
public class ArvoreBinaria {
    private static class No {
        Item reg;
        No esq, dir;
    }
    private No raiz;
    public int j, i;
    public ArvoreBinaria(){
        // inicializar nó raiz
        this.raiz = null;
    }
    private No insere(Item reg, No p){
        if(p == null){
            p = new No();   p.reg = reg;
            p.esq = null;   p.dir = null;
        }
        else if(reg.compara(p.reg) < 0){       // é menor, então vai pra esquerda
            p.esq = insere(reg, p.esq);
        }
        else if(reg.compara(p.reg) > 0){    // é maior, então vai pra direita
            p.dir = insere(reg, p.dir);
        }
        else            
            i++;
            //System.out.println("Erro: registro já existe!");
        return p;
    }
    
    private Item pesquisa(Item reg, No p){
        j++;
        if (p == null) return null;      // não há esse registro
        else if(reg.compara(p.reg) < 0) return pesquisa(reg, p.esq);  // achou na esquerda
        else if(reg.compara(p.reg) > 0) return pesquisa(reg, p.dir);    // achou na direita
        else return p.reg;    
    }
    
    public Item pesquisa(Item reg){
        return this.pesquisa(reg, this.raiz);
    }
    
    public void insere(Item reg){
        this.raiz = this.insere(reg, this.raiz);
    }  
}
