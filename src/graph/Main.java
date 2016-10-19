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
		
	}

}
