package estadisticoDeOrdenK;

public abstract class Algoritmos {

	public abstract int minimo(int[] array);
	
	public abstract int maximo(int[] array);
	
	public abstract int mediana(int[] array);
	
    protected static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
