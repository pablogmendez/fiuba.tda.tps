import java.io.BufferedReader;
import java.io.IOException;


public class parser{

	public int numberItem;
	public int[] weights;
	public int[] values;
	public int[] chosen;
	public int totalWeight;
	public int resultValue;

	private BufferedReader bufRead;
	
	public parser(BufferedReader bufRead){
		this.bufRead = bufRead;
	}

	public void parseAProblem(){
		try{

			String currentLine = bufRead.readLine();

			int k = 0;
			if (currentLine.charAt(0) == 'k'){
				currentLine = this.bufRead.readLine();
				this.numberItem = Integer.parseInt(currentLine.split(" ")[1]);
				currentLine = this.bufRead.readLine();
				this.totalWeight = Integer.parseInt(currentLine.split(" ")[1]);
				currentLine = this.bufRead.readLine();
				this.resultValue = Integer.parseInt(currentLine.split(" ")[1]);
			}
			currentLine = this.bufRead.readLine();

			this.values = new int[this.numberItem];
			this.weights = new int[this.numberItem];
			this.chosen = new int[this.numberItem];

			for (int i = 0; i < this.numberItem; i++){
				currentLine = this.bufRead.readLine();
				String[] datas = currentLine.split(",");
				this.values[i] = Integer.parseInt(datas[1]);
				this.weights[i] = Integer.parseInt(datas[2]);
				this.chosen[i] = Integer.parseInt(datas[3]);
			}
			for (k = 0; k < 2; k++)
				currentLine = this.bufRead.readLine();
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
}