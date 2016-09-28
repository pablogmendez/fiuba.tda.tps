package ar.fiuba.tda.EstadisticoDeOrdenK;

public class QuickSelect extends Algoritmos {

	@Override
	public int calcularEstadistico(int[] array, int k) {
		return quickSelect(array, 0, array.length - 1, k);
	}
	
  	private static int quickSelect(int[] array, int left, int right, int n) {
  		if(left == right) {
  			return array[left];
  		}
  		
  		for(;;) {
  			int pivotIndex = randomPivot(left, right);
  			pivotIndex = partition(array, left, right, pivotIndex);
  			
  			if(n == pivotIndex) {
  				return array[n];
  			} else if(n < pivotIndex) {
  				right = pivotIndex - 1;
  			} else {
  				left = pivotIndex + 1;
  			}
  		}
	}

	private static int partition(int[] array, int left, int right, int pivotIndex) {
		int pivotValue = array[pivotIndex];
		swap(pivotIndex, right, array); // move pivot to end
		int storeIndex = left;
		for(int i = left; i < right; i++) {
			if(array[i] < pivotValue) {
				swap(storeIndex, i, array);
				storeIndex++;
			}
		}
		swap(right, storeIndex, array); // Move pivot to its final place
		return storeIndex;
	}
  	
	private static int randomPivot(int left, int right) {
		return left + (int) Math.floor(Math.random() * (right - left + 1));
	}

	
}
