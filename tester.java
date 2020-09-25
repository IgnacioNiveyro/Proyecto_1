package tdp;


import java.util.ArrayList;
import java.util.List;

public class tester {
	public static void main(String[]args) {

		List<Integer> listaNodos=new ArrayList<Integer>();
		List<String> listaArcos=new ArrayList<String>();
		Graph g=new Graph(listaNodos, listaArcos);
		
		g.addNode(2);
		g.addNode(3);
		g.addNode(0);
		g.addNode(1);
		
		g.removeNode(0);
		g.removeNode(1);
		g.removeNode(0);
		
		g.addEdge(2, 3);
		g.addEdge(1, 3);
		
		g.removeEdge(2,3);
		g.removeEdge(1,3);
		
	}
}


