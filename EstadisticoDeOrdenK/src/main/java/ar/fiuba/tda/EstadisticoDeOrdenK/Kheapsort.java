package ar.fiuba.tda.EstadisticoDeOrdenK;

public class Kheapsort extends Algoritmos {

	@Override
	public int calcularEstadistico(int[] array, int k) {
		int j = k;
		int i = array.length - 1;
		buildheap(array);
		while( i >= 1 && j >= 0 ) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			heapify(array, i, 0);
			i--;
			j--;
		}
		return array[array.length - 1 - k];
	}    
    
    
	void heapify(int a[], int n, int i) {
		int max, child;
		child = 2 * i + 1;
		max = i;
		if (child < n)
			if (a[child] < a[max])
				max = child;
		if (child + 1 < n)
			if (a[child + 1] < a[max])
				max = child + 1;
		if (max != i) {
			int temp = a[i];
			a[i] = a[max];
			a[max] = temp;
			heapify(a, n, max);
		}
	}

	void buildheap(int a[]) {
		for (int i = a.length / 2 - 1; i >= 0; i--) {
			heapify(a, a.length, i);
		}
	}

}
