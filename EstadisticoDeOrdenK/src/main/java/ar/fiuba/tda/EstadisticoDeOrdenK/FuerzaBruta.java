package ar.fiuba.tda.EstadisticoDeOrdenK;

public final class FuerzaBruta extends Algoritmos {

	@Override
	public int calcularEstadistico(int[] array, int k) {
		int i;
		int j = 1;
		int max;
		
		// Saco el minimo
		int min = array[0];
		for(i = 1; i < array.length; ++i) {
			if(min > array[i]) {
				min = array[i];
			}
		}
		
		// Busco en el array el primero que encuentro que sea mayor al minimo y 
		// se lo asigno al maximo
		while(min != k && j < array.length) {
			i = 0;
			while(array[i] <= min) {
				++i;
			}
			max = array[i];		
			
			for(i = 0; i < array.length ; ++i) {
				if(min < array[i] && array[i] < max) {
					max = array[i];
				}
			}	
			++j;
			min = max;
		}
		
		// Si encontre el k retorno el orden estadistico; sino, retorno -1
		if(min == k) {
			return j - 1;
		}
		else {
			return -1;
		}
	}
}
