package ar.fiuba.tda.RecorridoEnGrafos;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BusqConHeuristica extends Camino {

	private double dist[]; // Inicializar a +∞.
	private Arista edge[];
	private boolean marked[];

	private Heuristica h;

	public BusqConHeuristica(Digrafo g, int origen, int destino, Heuristica h) {
		super(g, origen, destino);
		this.h = h;
		
		// Creo la cola con prioridad
		Queue<VerticeConPrioridad> q = new PriorityQueue<VerticeConPrioridad>();
		
		// Inicializo las distancias a infinito
		dist = new double[g.V()];
		marked = new boolean[g.V()];
		for(int i = 0; i < dist.length; ++i)
			dist[i] = Double.POSITIVE_INFINITY;
		
		// Inicializo el vector de aristas
		edge = new Arista[g.V()];
		
		dist[origen] = 0;
		marked[origen] = true;
		q.add(new VerticeConPrioridad(origen, this.h.calcular(origen, destino)));
		
		while(!q.isEmpty()) {
			int v = q.remove().getVertice();
			int i = -1;
			int w = 0;
			int adj[] = g.adj(v);
			do {
				++i;
				w = adj[i];
				edge[w] = new Arista(v, w, 1);
				dist[w] = distancia(v) + this.h.calcular(w, destino);
				marked[w] = true;
				q.add(new VerticeConPrioridad(w, this.h.calcular(w, destino)));
			} while(i < adj.length && w != destino);
		}
	}

	@Override
	public double distancia(int v) {
		return dist[v];
	}

	@Override
	protected Arista edge_to(int v) {
		return edge[v];
	}
}

class VerticeConPrioridad implements Comparable<VerticeConPrioridad> {
	private int vertice;
	private int distancia;
	
	public int compareTo(VerticeConPrioridad o) {
		if(this.distancia < o.distancia)
			return -1;
		else if (this.distancia > o.distancia)
			return 1;
		else return 0;
	}
	
	public VerticeConPrioridad(int vertice, int distancia) {
		this.vertice = vertice;
		this.distancia = distancia;
	}
	
	public int getVertice() {
		return vertice;
	}

	public int getDistancia() {
		return distancia;
	}
	
}
