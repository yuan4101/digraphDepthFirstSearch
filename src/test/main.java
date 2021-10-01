package test;
import lib.In;
import lib.Bag;
import lib.StdOut;
import lib.Digraph;
import java.io.File;
import lib.DirectedDFS;

public class main {

	public static void main(String[] args) {
		// Crear el grafo a partir del archivo
		File file = new File("tinyEWD.txt");
		In in = new In(file);
		Digraph varGrafo = new Digraph(in);

		// Los nodos alcanzables desde un solo nodo en el grafo
		DirectedDFS varDfsValue = new DirectedDFS(varGrafo, 6);

		// Los nodos alcanzables desde varios nodos
		Bag<Integer> varList = new Bag<Integer>();
		varList.add(0);
		varList.add(1);
		DirectedDFS varDfsList = new DirectedDFS(varGrafo, varList);

		// Imprimir los nodos alcanzables value
		for (int v = 0; v < varGrafo.V(); v++) {
			if (varDfsValue.marked(v))
				StdOut.print(v + " ");
		}
		StdOut.println();

		// Imprimir los nodos alcanzables list
		for (int v = 0; v < varGrafo.V(); v++) {
			if (varDfsList.marked(v))
				StdOut.print(v + " ");
		}
		StdOut.println();
	}
}