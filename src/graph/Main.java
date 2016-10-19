package graph;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph grafo = new Graph();
		grafo.addVertex('A');//0
		grafo.addVertex('B');//1
		grafo.addVertex('C');//2
		grafo.addVertex('D');//3
		grafo.addVertex('E');//4
		
		grafo.addEdge(0, 1);//AB
		grafo.addEdge(1, 2);//BC
		grafo.addEdge(0, 3);//AD
		grafo.addEdge(3, 4);//DE
		
		grafo.Depth_First_Search();
		System.out.println();
		
		grafo.clear();
		
		grafo.addEdge(0, 1);//AB
		grafo.addEdge(0, 2);//AC
		grafo.addEdge(0, 3);//AD
		grafo.addEdge(0, 4);//AE
		grafo.addEdge(0, 1);//BC
		grafo.addEdge(1, 2);//BD
		grafo.addEdge(1, 3);//BE
		grafo.addEdge(1, 4);//CD
		grafo.addEdge(2, 3);//CE
		grafo.addEdge(2, 4);//DE
	}

}
