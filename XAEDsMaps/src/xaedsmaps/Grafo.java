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
public class Grafo {
    /* ---------- Definição das arestas ---------- */
    public static class Aresta{
        private int v1, v2, pesoDistancia, pesoTempo;;
        public Aresta (int v1, int v2, int pesoDistancia, int pesoTempo){
            this.v1 = v1;
            this.v2 = v2;
            this.pesoDistancia = pesoDistancia; 
            this.pesoTempo = pesoTempo;
        }

        public int getV1() {
            return v1;
        }

        public int getV2() {
            return v2;
        }

        public int pesoDistancia() { 
            return this.pesoDistancia; 
        }
        
        public int pesoTempo() { 
            return this.pesoTempo; 
        }
       
    }
    
    private int[][] matriz_adj ; // pesos das arestas
    private int numVertices;
    private int pos[ ]; // p/guardar a posição quando percorrer a lista de um vértice
    
    /* ---------- Declaração e inicialização dos grafos ---------- */
    public Grafo ( int numVertices) {
        this.matriz_adj = new int [numVertices][numVertices];
        this.pos = new int [numVertices ]; 
        this.numVertices = numVertices;
        
        for ( int i = 0; i < this .numVertices; i ++) {
            for ( int j = 0; j < this .numVertices; j ++){ 
                this.matriz_adj[i][j] = 0;
            }
            this.pos[i] = -1;
        }
    }
    /* ---------- Inserção de aresta cujos vértices são passados por parâmetro ---------- */
    public void insereAresta ( int v1, int v2, int pesoDistancia, int pesoTempo) {
        this.matriz_adj[v1][v2] = pesoDistancia; 
        this.matriz_adj[v1][v2] = pesoTempo; 
    }
   
    public boolean existeAresta ( int v1, int v2) {
        return (this.matriz_adj[v1][v2] > 0);
    }
   
    /* ---------- Declaração da primeira lista de adjacencia ---------- */
    /* Retorna a primeira aresta que o vértice v participa ou
         null se a lista de adjacência de v for vazia */
    public Aresta primeiroListaAdj ( int v) {
        this.pos[v] = -1; 
        return this.proxAdj(v);
    }
    
    /* ---------- Método que obtém a próxima aresta na lista de adjacência ---------- */
    public Aresta proxAdj ( int v) {
        /*coloca a posição na proxima aresta visitada */
        this.pos[v] ++;
        /*sai verificando se essa posição do vertice é uma adjacencia valida e se existe */
        while (( this.pos[v] < this.numVertices) && (this.matriz_adj[v][ this.pos[v]] == 0)){
            this.pos[v]++;  // se não existe vai para a proxima
        }
        if (this.pos[v] == this.numVertices) return null ;  // é invalida
        else return new Aresta (v, this.pos[v], this.matriz_adj[v][this.pos[v]], this.matriz_adj[v][this.pos[v]]); // é válida
    }
    
    /* ---------- Remoção de aresta cujos vértices são passados por parâmetro ---------- */
    public Aresta retiraAresta ( int v1, int v2) {
        if (this.matriz_adj[v1][v2] == 0) return null ; // Aresta não existe
        else {
            Aresta aresta = new Aresta (v1, v2, this.matriz_adj[v1][v2], this.matriz_adj[v1][this.pos[v2]]) ;
            this.matriz_adj[v1][v2] = 0; 
            return aresta;
        }
    }

    public void imprime ( ) {
        System.out. print ( "  " );
        for ( int i = 0; i < this.numVertices; i++){
            System.out.print ( i + " " );
        }
        System.out.println ( ) ;
        for ( int i = 0; i < this.numVertices; i ++) {
            System.out.print ( i + " " );
            for ( int j = 0; j < this.numVertices; j++){
                System.out.print (this.matriz_adj[ i ] [ j ] + " " );
            }
            System.out.println ( ) ;
        }
    }
    
    public int numVertices ( ) {
        return this.numVertices;
   
    }
    
    public boolean listaAdjVazia ( int v) {
        for ( int i =0; i < this .numVertices; i++)
            if (this.matriz_adj[v] [ i ] > 0) return false;
        return true;
    }
}
