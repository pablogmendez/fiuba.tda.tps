package ar.fiuba.tda.RecorridoEnGrafos;

import java.util.ArrayList;
import java.util.List;

public abstract class Camino {
	private int src, dst;
	protected Arista edge[];
	protected Digrafo digraph;

	protected Camino(Digrafo g, int origen, int destino) {
		src = origen;
		dst = destino;
		digraph = g;
	}

	public abstract double distancia(int v);

	protected abstract Arista edge_to(int v);

	public boolean visitado(int v) {
		return distancia(v) < Double.POSITIVE_INFINITY;
	}

	public List<Arista> camino(int v) {
		List<Arista> l = new ArrayList<Arista>();
		if(v == src) { // Si el destino es igual que el origen retorno una lista vacia.
			return l;
		}
		else {
			boolean encontrado = false;
			int i = 0;
			while(!encontrado && i < edge.length) {
				for(Arista a: edge) {
					if(a != null) {
						if(a.getDestino() == v || a.getOrigen() == v) {
							encontrado = true;
							break;
						}
					}
					++i;
				}
				if(!encontrado)
					return null; // Si no encuentro el destino, retorno null
				else { // Si no, retorno la lista del origen al destino  
					boolean origenEncontrado=false;
					int nuevoDestino = v;
					while(!origenEncontrado) {
						for(Arista a: edge) {
							if(a != null) {
								if(a.getDestino() == nuevoDestino) {
									l.add(0, a);
									nuevoDestino = a.getOrigen();
									origenEncontrado = (nuevoDestino == src);
									break;
								}			
							}
						}
					}
				}			
			}
		return l;
		}
	}
}
