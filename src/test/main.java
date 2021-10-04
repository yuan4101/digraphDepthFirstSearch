package test;

import lib.In;
import lib.Bag;
import lib.Digraph;
import java.io.File;
import lib.DirectedDFS;
import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {

		// Crear la variable File a partir del archivo
		File file = new File("sGraph.txt");

		// Crear la variable de entrada In a partir de la variable File
		In in = new In(file);

		// Crear el grafo a partir de la variable In
		Digraph varGrafo = new Digraph(in);

		// Crear la pila de Integers de tipo Bag
		Bag<Integer> varList = new Bag<Integer>();
		
		// Buffer para almacenar la informacion a mostrar
		String varBuffer = "";

		// Menu
		int varOpcion = -1;
		
		do {
			try {

				varOpcion = Integer.parseInt(JOptionPane.showInputDialog(null,
						"1. Nodos alcanzables desde un solo nodo\n"
						+ "2. Nodos alcanzables desde una lista de nodos\n"
						+ "3. Salir", "Menu", JOptionPane.QUESTION_MESSAGE));

				switch (varOpcion) {

				case 1:
					// Los nodos alcanzables desde un solo nodo en el grafo
					int varValue = Integer.parseInt(JOptionPane.showInputDialog(null,
							"Ingrese el valor del nodo", "OPCION 1",
							JOptionPane.QUESTION_MESSAGE));
					
					DirectedDFS varDfsValue = new DirectedDFS(varGrafo, varValue);
					
					// Imprimir los nodos alcanzables value
					for (int v = 0; v < varGrafo.V(); v++) {
						if (varDfsValue.marked(v))
							varBuffer += v + " ";
					}
					JOptionPane.showMessageDialog(null,
							"Los nodos alcanzables desde el nodo " + varValue
							+ " son:\n" + varBuffer, "NODOS",
							JOptionPane.INFORMATION_MESSAGE);
					varBuffer = "";
					break;

				case 2:
					// Los nodos alcanzables desde varios nodos
					int varOpcion2 = -1;
					String varNodos = "";
					
					do {
						varOpcion2 = Integer.parseInt(JOptionPane.showInputDialog(null,
								"1. Agregar nodo a la lista\n"
								+ "2. Buscar\n"
								+ "3. Regresar al menu anterior\n"
								+ "4. Salir", "OPCION 2",
								JOptionPane.QUESTION_MESSAGE));
						
						switch (varOpcion2) {
						
						case 1:
							int varNodo = Integer.parseInt(JOptionPane.showInputDialog(null,
									"Ingrese el nodo a agregar", "LISTA DE NODOS",
									JOptionPane.QUESTION_MESSAGE));
							varList.add(varNodo);
							varNodos += varNodo + " ";
							JOptionPane.showMessageDialog(null,
									"Nodo " + varNodo + " agregado con exito!", "NODO",
									JOptionPane.INFORMATION_MESSAGE);
							break;
						
						case 2:
							DirectedDFS varDfsList = new DirectedDFS(varGrafo, varList);
							
							// Imprimir los nodos alcanzables list
							for (int v = 0; v < varGrafo.V(); v++) {
								if (varDfsList.marked(v))
									varBuffer += v + " ";
							}
							JOptionPane.showMessageDialog(null,
									"Los nodos alcanzables desde los nodos " + varNodos
									+ " son:\n" + varBuffer, "NODOS",
									JOptionPane.INFORMATION_MESSAGE);
							varBuffer = "";
							break;
							
						case 3:
							varList = new Bag<Integer>();
							varNodos = "";
							JOptionPane.showMessageDialog(null, "Regresando al menu anterior", "SALIDA", JOptionPane.INFORMATION_MESSAGE);
							break;
							
						case 4:
							varOpcion2 = 3;
							varOpcion = 3;
							break;
						default:
							JOptionPane.showMessageDialog(null, "Opcion Incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
							break;
						}
					} while (varOpcion2 != 3);
					
					break;
					
				case 3:
					JOptionPane.showMessageDialog(null, "Saliendo...", "SALIDA", JOptionPane.INFORMATION_MESSAGE);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opcion Incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
					break;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		} while (varOpcion != 3);
	}
}