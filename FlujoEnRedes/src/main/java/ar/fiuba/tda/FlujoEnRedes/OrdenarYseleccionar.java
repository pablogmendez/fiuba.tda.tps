package ar.fiuba.tda.EstadisticoDeOrdenK;

public final class OrdenarYseleccionar extends Algoritmos {

	private void quickSort(int lowerIndex, int higherIndex, int[] array) {
        
        int i = lowerIndex;
        int j = higherIndex;
        
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j, array);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            quickSort(lowerIndex, j, array);
        if (i < higherIndex)
            quickSort(i, higherIndex, array);
    }

	@Override
	public int calcularEstadistico(int[] array, int k) {
		quickSort(0, array.length - 1, array);
		return array[k];
	}
	
}
