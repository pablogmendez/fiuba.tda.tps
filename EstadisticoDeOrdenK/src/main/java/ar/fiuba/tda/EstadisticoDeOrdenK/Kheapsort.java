package ar.fiuba.tda.EstadisticoDeOrdenK;

public class Kheapsort extends Algoritmos {

	@Override
	public int minimo(int[] array) {
		heapSort(array);
		return array[0];
	}

	@Override
	public int maximo(int[] array) {
		heapSort(array);
		return array[array.length - 1];
	}

	@Override
	public int mediana(int[] array) {
		heapSort(array);
		return array[array.length/2];
	}

    private void heapify(int[] arr, int i)
    {
        int lft = i * 2;
        int rgt = lft + 1;
        int grt = i;

        if (lft <= (arr.length - 1) && arr[lft] > arr[grt]) grt = lft;
        if (rgt <= (arr.length - 1) && arr[rgt] > arr[grt]) grt = rgt;
        if (grt != i) {
            swap(i, grt, arr);
            heapify(arr, grt);
        }
    }

    public void heapSort(int[] arr)
    {
        int total = arr.length - 1;

        for (int i = total / 2; i >= 0; i--)
            heapify(arr, i);

        for (int i = total; i > 0; i--) {
            swap(0, i, arr);
            total--;
            heapify(arr, 0);
        }
    }
	
}
