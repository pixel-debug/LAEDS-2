/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xaedsmaps;

/**
 * Para resolver o problema da prática 7, buscar tanto o caminho mais curto
 * quanto o caminho mais longo, decidi usar o algoritmo de Dijkstra
 */
public class XAEDsMaps {
    private Grafo grafo;
    private int antecessor [ ] ;
    private double tempo[ ] ;
    private double distancia[ ] ;
    private int v1;         // vértice inicial
    private int v2;         // vértice final
    
    
    public XAEDsMaps (Grafo grafo ) { this .grafo = grafo ; }
    
    public void obterMenorCaminho ( int raiz ) throws Exception {
        int n = this.grafo.numVertices();
        this.distancia = new double[n] ; // peso dos vértices
        int vs[] = new int [n+1]; // vértices
        this.antecessor = new int [n] ;
        for ( int u = 0; u < n; u ++) {
            this.antecessor[u] = -1;
            distancia[u] = Double.MAX_VALUE ; // todos os outros vertices levam o valor ∞
            vs[u+1] = u; // Heap indireto a ser construído
        }
        distancia[ raiz ] = 0;      // vertice de origem leva o valor 0
   
        FpHeapMinIndireto heap = new FpHeapMinIndireto (distancia, vs);
        heap.constroi( );
        while ( !heap.vazio ( ) ) {    
            // a cada iteração, um vertice u é tirado do heap e mandado pra aux
            int u = heap. retiraMin ( ) ;   // tiro o menor deles
            if ( ! this .grafo. listaAdjVazia (u)) {
                Grafo.Aresta adj = grafo. primeiroListaAdj (u);
                while ( adj != null ) {
                    int v = adj .getV2 ( ) ;
                    if (this .distancia[v] > (this.distancia[u] + adj.pesoDistancia( ))) {
                        // este é o menor/maior caminho?
                        antecessor[v] = u;                              // atualizo o meu antecessor
                        heap.diminuiChave (v, this.distancia[u] + adj.pesoDistancia( )) ; 
                    }
                    adj = grafo.proxAdj(u);
                }
            }
        }
    }
    
    public void obterMenorTempo ( int raiz ) throws Exception {
        int n = this.grafo.numVertices();
        this.tempo = new double[n] ; // peso dos vértices
        int vs[] = new int [n+1]; // vértices
        this.antecessor = new int [n] ;
        for ( int u = 0; u < n; u ++) {
            this.antecessor[u] = -1;
            tempo[u] = Double.MAX_VALUE ; // todos os outros vertices levam o valor ∞
            vs[u+1] = u; // Heap indireto a ser construído
        }
        tempo[ raiz ] = 0;      // vertice de origem leva o valor 0
   
        FpHeapMinIndireto heap = new FpHeapMinIndireto (tempo, vs);
        heap.constroi( );
        while ( !heap.vazio ( ) ) {    
            // a cada iteração, um vertice u é tirado do heap e mandado pra aux
            int u = heap. retiraMin ( ) ;   // tiro o menor deles
            if ( ! this .grafo. listaAdjVazia (u)) {
                Grafo.Aresta adj = grafo. primeiroListaAdj (u);
                while ( adj != null ) {
                    int v = adj .getV2 ( ) ;
                    if (this .tempo[v] > (this.tempo[u] + adj.pesoTempo( ))) { 
                        // este é o menor/maior caminho?
                        antecessor[v] = u;                              // atualizo o meu antecessor
                        heap.diminuiChave (v, this.tempo[u] + adj.pesoTempo( )) ; 
                    }
                    adj = grafo.proxAdj(u);
                }
            }
        }
    }
    
    public int antecessor ( int u) { 
     //   System.out.println("antecessor: "+this.antecessor[u]);
        return this.antecessor[u] ; 
    }
    public double tempo ( int u) { return this .tempo[u] ; }
    
    public double distancia ( int u) { return this .distancia[u] ; }
    
    public void imprimeCaminho ( int origem, int v) {
   //     System.out.println("antecessor: "+this.antecessor[v]);
        if (origem == v) System.out.println (origem);
        else if (this.antecessor[v] == -1)
        System.out. println ( "Nao existe caminho de " +origem+ " ate " +v);
        else {
            imprimeCaminho (origem, this .antecessor[v ] ) ;
            System.out. println (v);
        }
    }
}