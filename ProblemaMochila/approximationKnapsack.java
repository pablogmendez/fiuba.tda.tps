
public class approximationKnapsack{

	static private int MAX_VALUE = 100000; 

	private int maxWeight;
	private int numberOfItem;
	private int[] values;
	private int[] weights;

	public int resultValue;
	public int resultWeight;

	public approximationKnapsack(int NumberOfItem, int MaxWeight, int[] Values, int[] Weights){
		this.numberOfItem = NumberOfItem;
		this.maxWeight = MaxWeight;
		this.values = Values;
		this.weights = Weights;
		this.resultValue = runAlgorithm();
	}

	private int runAlgorithm(){
		int totalValueSum = 0;
		for (int i = 0; i < this.numberOfItem; i++)
			totalValueSum += this.values[i];
		int[][] M = new int[this.numberOfItem + 1][totalValueSum + 1];
		for (int i = 0; i <= this.numberOfItem; i++){
			M[i][0] = 0;
		}

		int partialValueSum = 0;
		for (int i = 1; i <= this.numberOfItem; i++){
			partialValueSum += this.values[i - 1];
			for (int v = 1; v <= totalValueSum; v++){
				if (v > partialValueSum - this.values[i - 1])
					M[i][v] = this.weights[i - 1] + M[i - 1][v];
				else
					M[i][v] = Math.min(M[i - 1][v], this.weights[i - 1] + M[i  - 1][Math.max(0, v - this.values[i - 1])]);
			}
		}
		int res = 0;
		int v = 1;
		while (v <= totalValueSum && M[this.numberOfItem][v] <= this.maxWeight){
			this.resultWeight = M[this.numberOfItem][v];
			res = v;
			v++;
		}
		return res;
	}
}