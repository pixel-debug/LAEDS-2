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
/* ---------- Aqui vai funcionar a busca em profundidade ---------- */
/* essa classe também vai me dizer se é acíclico ou não 
     se a aresta de retorno for encontrada então esse grafo tem ciclo, se não retornar, é acíclico */
public class Busca {
    /* todo mundo começa com a cor branca
        quando é visitado pela primeira vez, o vértice fica na cor cinza
        fica preto quando sua lista de adjacencia foi completamente examinada
    */
    
    public static final byte branco = 0;
    public static byte cinza = 1;
    public static byte preto = 2;
    private int tempo_descoberta[ ] , tempo_final [ ] , antecessor [ ] ;
    private Grafo grafo;
    public int ciclo;
    
    public Busca (Grafo grafo ) {
        this.grafo = grafo; 
        int n = this.grafo.numVertices();
        tempo_descoberta = new int [n]; 
        tempo_final = new int [n];
        antecessor = new int [n];
        this.ciclo = 0;
    }
    
    private int buscas_profundas ( int u, int tempo, int cor [ ] ) {
        // vertice visitado pela primeira vez
        cor[u] = cinza; 
        // cata o tempo de descoberta
        this.tempo_descoberta[u] = ++tempo;
        if ( !this.grafo.listaAdjVazia(u)) {
            // coloca na lista de adjacencia
            Grafo.Aresta a = this.grafo.primeiroListaAdj(u);
            while (a != null ) {
                int v = a.getV2 ( ) ;
                if ( cor[v] == branco) {
                    // se o vertice adjacente é branco, coloco v como antecessor 
                    this.antecessor[v] = u;
                    // realizo a nova busca por ele
                    tempo = this.buscas_profundas (v, tempo, cor );
                }
                if(cor[v] == cinza) // caso o vertice já tenha sido visitado antes
                    ciclo++;        // tem ciclo
                a = this.grafo.proxAdj(u);
            }
        }
        // vertices total visitados
        cor[u] = preto; 
        this.tempo_final[u] = ++tempo;
        return tempo;
    }

    public void busca ( ) {
        int tempo = 0; 
        int cor [] = new int[this.grafo.numVertices( )];
        
        for ( int u = 0; u < grafo.numVertices ( ); u++) {
            cor[u] = branco; 
            this.antecessor[u] = -1;
        }
        for ( int u = 0; u < grafo.numVertices ( ); u++)
            if ( cor[u] == branco) 
                tempo = this.buscas_profundas(u, tempo, cor );
    }
    
    public int tempo_descoberta ( int v ) {
       return this.tempo_descoberta[v ]; 
    }
    
    public int tempo_final ( int v ) { 
        return this.tempo_final [v ];
    }
        
    public int antecessor ( int v ) { 
        return this.antecessor[v ];
    }
    
    public void imprimeCaminho ( int origem, int v) {
        if (origem == v) System.out. println (origem);
        else if (this .antecessor[v] == -1)
            System.out. println ( "Nao existe caminho de " + origem + " ate " + v);
        else {
            imprimeCaminho (origem, this .antecessor[v ] ) ;
            System.out. println (v);
        }
    }
    public int getCiclo() {
        this.busca();
        return this.ciclo/2;
    }
}
