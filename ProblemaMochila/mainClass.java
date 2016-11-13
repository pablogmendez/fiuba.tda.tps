import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class mainClass{

	private static double executeTime;
	private static double totalTime;

	public static void main(String[] args){

		try{
			FileReader input = new FileReader(args[0]);
			BufferedReader bufRead = new BufferedReader(input);
			parser p = new parser(bufRead);


			for (int i = 0; i < 100; i++){
				
				p.parseAProblem();

				double time = System.nanoTime();
				knapsackAlgorithm running = new knapsackAlgorithm(p.numberItem, p.totalWeight, p.values, p.weights);
				executeTime = (System.nanoTime() - time) * Math.pow(10, -9);
				totalTime += executeTime;

				if (running.resultValue != p.resultValue){
					System.out.println("Problem number: " + i + 1);
					System.out.println("Expected result: value = " + p.resultValue + ", weight = " + p.totalWeight);
					System.out.println("Actual result: value = " + running.resultValue + ", weight = " + running.resultWeight);	
				} else {
					int j = i + 1;
					System.out.println("Problem number " + j + " sucessfully solved in " + executeTime + " s");
				}
			}
			bufRead.close();
			System.out.println("Total execution time : " + totalTime);
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
}