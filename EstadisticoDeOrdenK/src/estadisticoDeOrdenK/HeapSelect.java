package estadisticoDeOrdenK;

public class HeapSelect extends Algoritmos {

	@Override
	public int minimo(int[] array) {
		return heapselect(array, 0);
	}

	@Override
	public int maximo(int[] array) {
		return heapselect(array, array.length - 1);
	}

	@Override
	public int mediana(int[] array) {
		return heapselect(array, array.length/2);
	}

	 public int heapselect(int A[], int k) {
		  int last = A.length - 1;
		  //convert array to heap in O(n)
		  int youngestParent = last / 2;//l = 2*p+1: p=(l-1)/2
		  for (int i = youngestParent; i >= 0; i--) {
		    moveDown(A, i, last);
		  }
		  //sort up to k (i.e. find the kth)
		  int limit = last - k + 1;
		  for (int i = last; i > limit; i--) {
		    if (A[0] > A[i]) {
		      swap(0, i, A);
		      moveDown(A, 0, i - 1);
		    }
		  }
		  return A[0];
		}//findKthLargest(int[], int)
		 
		private void moveDown(int[] A, int first, int last) {
		  int largest = 2 * first + 1;
		  while (largest <= last) {
		    if (largest < last && A[largest] < A[largest + 1]) {
		      largest++;
		    }
		    if (A[first] < A[largest]) {
		      swap(first, largest, A);
		      first = largest;
		      largest = 2 * first + 1;
		    } else {
		      return;
		    }
		  }
		}
}
