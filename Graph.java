package tdp;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Graph {
	private List<Integer> listaNodos;
	private List<String> listaArcos;
	private static Logger logger;
	public Graph(List<Integer> lN, List<String> lA) {
		listaNodos=lN;
		listaArcos=lA;
		if(logger==null) {
			logger= Logger.getLogger(Graph.class.getName());
			
			Handler hnd=new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.WARNING);
			
			Logger rootLogger=logger.getParent();
			for(Handler h : rootLogger.getHandlers())
				h.setLevel(Level.OFF);
		}
	}
	public void addNode(int node) {
		logger.info("Se desea ingresar el nodo "+node+" al grafo");
		if(!listaNodos.contains(node)) {
			logger.fine("El nodo "+node+" fue ingresado con exito en el grafo");
			listaNodos.add(node);
		}else {
			logger.warning("El nodo "+node+" ya fue ingresado en el grafo");
		}
		
	}
	public void addEdge(int node1, int node2) {
		logger.info("Se desea ingresar un arco para los nodos "+node1+","+node2+" al grafo");
		if(listaNodos.contains(node1) && listaNodos.contains(node2)) {
			logger.fine("El arco "+node1+","+node2+" fue ingresado con exito en el grafo");
			listaArcos.add(node1+","+node2);
		}else
			if(!listaNodos.contains(node1) && !listaNodos.contains(node2))
				logger.warning("El nodo "+node1+" y "+node2+" no fueron encontrados en el grafo");
			else
				if(!listaNodos.contains(node1))
					logger.warning("El nodo "+node1+" no fue encontrado en el grafo, por lo tanto arco no agregado");
				else
					logger.warning("El nodo "+node2+" no fue encontrado en el grafo, por lo tanto arco no agregado");
		
	}
	
	public void removeNode(int node) {
		logger.info("Se desea remover el nodo "+node+" del grafo");
		if(listaNodos.contains(node)) {
			logger.fine("El nodo "+node+" fue removido con exito del grafo");
			int indice=listaNodos.indexOf(node);
			listaNodos.remove(indice);
		}else
			logger.warning("El nodo "+node+" a remover no fue encontrado en el grafo");
	}
	
	public void removeEdge(int node1, int node2) {
		logger.info("Se desea remover el arco de los nodos "+node1+","+node2+" del grafo");
		if(listaArcos.contains(node1+","+node2)) {
			logger.fine("el arco del "+node1+" al "+node2+" fue removido con exito");
			listaArcos.remove(node1+","+node2);
		}else
			logger.warning("el arco no pertenecia al grafo");
			
	}
}
