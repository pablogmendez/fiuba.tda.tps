public class knapsackAlgorithm{

	private int maxWeight;
	private int numberOfItem;
	private int[] values;
	private int[] weights;
	private int[][] chosen;

	public int resultValue;
	public int resultWeight;
	public int[] chosenItems;

	public knapsackAlgorithm(int NumberOfItem, int MaxWeight, int[] Values, int[] Weights){
		this.numberOfItem = NumberOfItem;
		this.maxWeight = MaxWeight;
		this.values = Values;
		this.weights = Weights;
		this.chosen = new int[numberOfItem][maxWeight + 1];
		this.chosenItems = new int[numberOfItem];
		this.resultValue = runAlgorithm();
	}

	private int runAlgorithm(){
		int[][] M = new int[this.numberOfItem][this.maxWeight + 1];
		for (int w = 0; w < this.maxWeight + 1; w++){
			M[0][w] = 0;
		}

		for (int i = 0; i < this.numberOfItem; i++){
			for (int w = 0; w < this.maxWeight + 1; w++){
				if (i == 0){
					if (w >= this.weights[i]){
						M[i][w] = this.values[i];
						this.chosen[i][w] = 1;
					}
				} else {
					if (w < this.weights[i]){
						M[i][w] = M[i - 1][w];
						this.chosen[i][w] = 0;
					} else if (M[i - 1][w] >= this.values[i] + M[i - 1][w - this.weights[i]]){
						M[i][w] = M[i - 1][w];
						this.chosen[i][w] = 0;
					} else {
						M[i][w] = this.values[i] + M[i - 1][w - this.weights[i]];
						this.chosen[i][w] = 1;
					}
				}
			}

			this.resultWeight = 0;
			int w = this.maxWeight;
			for (int j = this.numberOfItem - 1; j >= 0; j--){
				if (chosen[j][w] == 1){
					this.chosenItems[j] = 1;
					w -= this.weights[j];
					this.resultWeight += this.weights[j];
				}
				else
					this.chosenItems[j] = 0;
			}
		}
		return M[this.numberOfItem - 1][this.maxWeight];
	}
}