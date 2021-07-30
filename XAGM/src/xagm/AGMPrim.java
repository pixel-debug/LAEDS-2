/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xagm;

/**
 *
 * @author usuario
 */
public class AGMPrim {
    private int antecessor [ ] ;
    private double p[ ] ;
    private XGrafo grafo;
    private int peso;
    
    public AGMPrim (XGrafo grafo ) { 
        this.grafo = grafo;
        this.peso = 0;
    }
    
    public void obterAgm ( int raiz ) throws Exception {
        int n = this .grafo.numVertices();
        this.p = new double[n]; // peso dos vértices
        int vs[] = new int [n+1]; // vértices
        boolean itensHeap[] = new boolean[n];
        this.antecessor = new int [n];
        for ( int u = 0; u < n; u ++) {
            this.antecessor[u] = -1;
            p[u] = Double.MAX_VALUE ; // ∞
            vs[u+1] = u; // Heap indireto a ser construído
            itensHeap[u] = true;
        }
        p[ raiz ] = 0;
        FpHeapMinIndireto heap = new FpHeapMinIndireto (p, vs);
        heap.constroi ( );
        while ( !heap.vazio ( ) ) {         // enquanto esse heap nao tiver vazio
            int u = heap.retiraMin ( );     // retiro o menor numero
            itensHeap[u] = false;
            if ( ! this .grafo. listaAdjVazia (u)) {
                XGrafo.Aresta adj = grafo. primeiroListaAdj (u);    
                while ( adj != null ) {
                    int v = adj.getV2 ( ) ;         // pego o vertice do lado
                    if (itensHeap[v] && (adj.getPeso () < this.peso (v) ) ) {       // comparo se é o peso é menor 
                        antecessor[v] = u;                              
                        heap.diminuiChave (v, adj.getPeso ( ) ) ;
                    }
                adj = grafo.proxAdj (u);
                }
            }
        }
    }
    public int antecessor ( int u) { return this .antecessor[u] ; }
    
    public double peso ( int u) { return this .p[u] ; }
    
    public void imprime ( ) {
        for ( int u = 0; u < this .p.length ; u++)
        if (this .antecessor[u] != -1)
        System.out. println ( " ( " +antecessor[u]+ " ," +u+ ") −− p: " +
        peso (u));
    }
    
     public double Peso() {
        for (int u = 0; u < this.p.length; u++)
            if(this.antecessor [u] != -1)
                    this.peso += peso(u);
        
        return this.peso;
    }

}
