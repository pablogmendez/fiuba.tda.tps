package ar.fiuba.tda.EstadisticoDeOrdenK;

public class Kselecciones extends Algoritmos {

	@Override
	public int minimo(int[] array) {
		selectionSort(array);
		return array[0];
	}

	@Override
	public int maximo(int[] array) {
		selectionSort(array);
		return array[array.length - 1];
	}

	@Override
	public int mediana(int[] array) {
		selectionSort(array);
		return array[array.length/2];
	}

	private void selectionSort(int[] array) {
		for(int i = 0; i < array.length - 1; ++i) {
			int min = i;
			for(int j = i + 1; j < array.length; ++j) {
				if(array[j] < array[min]) {
					min = j;
				}
			}
			swap(i, min, array);
		}
	}
	
}
