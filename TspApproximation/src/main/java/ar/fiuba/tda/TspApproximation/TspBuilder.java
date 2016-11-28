package ar.fiuba.tda.TspApproximation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class TspBuilder {
	public static ProblemaViajante crearProblemaViajante(String tspFile)
			throws Exception {
		TspParser parser = new TspParser(tspFile);
		return new ProblemaViajante(parser.getGrafo(), 1, parser.getDistancias());
	}

	private static class TspParser {
		private int dimension;
		private int[][] distancias;
		private Grafo g;
		Boolean isFullMatrix;

		public TspParser(String filename) throws Exception {
			FileReader input = new FileReader(filename);
			BufferedReader bufRead = new BufferedReader(input);

			String myLine;
			while ((myLine = bufRead.readLine()) != null) {
				if (myLine.startsWith("DIMENSION")) {
					dimension =
							Integer.parseInt(myLine.replaceAll("[\\D]", ""));
					distancias = new int[dimension][dimension];
					g = new Grafo(dimension);
				}
				else if (myLine.startsWith("EDGE_WEIGHT_FORMAT")) {
					isFullMatrix = myLine.contains("FULL_MATRIX");
				}
				else if (myLine.startsWith("EDGE_WEIGHT_SECTION")) {
					int i = 0, j = 0;

					if (isFullMatrix) {
						while ((myLine = bufRead.readLine()) != null) {
							@SuppressWarnings("resource")
							Scanner in = new Scanner(myLine);
							while (in.hasNextInt()) {
								int costo = in.nextInt();
								distancias[i][j] = costo;
								if (j < i) {
									g.add_edge(i, j, costo);
								}
								if ((j = (j + 1) % dimension) == 0) {
									if (++i == dimension) {
										in.close();
										bufRead.close();
										return;
									}
								}
							}
						}
					}
					else {
						while ((myLine = bufRead.readLine()) != null) {
							@SuppressWarnings("resource")
							Scanner in = new Scanner(myLine);
							while (in.hasNextInt()) {
								int distancia = in.nextInt();
								distancias[i][j] = distancias[j][i] = distancia;
								if (j == i) {
									j = 0;
									if (++i == dimension) {
										in.close();
										bufRead.close();
										return;
									}
								}
								else {
									g.add_edge(i, j, distancia);
									++j;
								}
							}
						}
					}
				}
			}
			bufRead.close();
			throw new Exception("Mal parseo");
		}

		public Grafo getGrafo() {
			return g;
		}
		
		public int[][] getDistancias() {
		    return distancias;
		}
	}
}
