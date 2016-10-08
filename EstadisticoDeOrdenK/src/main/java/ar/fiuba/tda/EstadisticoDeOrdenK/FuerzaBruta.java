package ar.fiuba.tda.EstadisticoDeOrdenK;

public final class FuerzaBruta extends Algoritmos {

	@Override
	public int calcularEstadistico(int[] array, int k) {

		for(int i = 0; i < array.length; ++i) {
			int j = 0;
			for(int l = 0; l < array.length; ++l) {
				if(array[i] > array[l])
					++j;
			}
			if(j == k) return array[i];
		}
		return -1;
	}
}
