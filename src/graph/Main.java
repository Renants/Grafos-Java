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
		//----------------------/ Ordenação topologica only
		grafo.addVertex('F');//5
		grafo.addVertex('G');//6
		grafo.addVertex('H');//7
		
		
		grafo.addEdge(0, 1);//AB
		grafo.addEdge(1, 2);//BC
		grafo.addEdge(0, 3);//AD
		grafo.addEdge(3, 4);//DE
		
		grafo.Depth_First_Search();
		System.out.println();
		grafo.clear();
		//----------------------------------------------------------
		
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
		grafo.Minimum_Spaning_Tree();
		grafo.clear();
		
		//----------------------------------------------------------
		
		grafo.setDirected(true);// grafo direcionado
		grafo.addEdge(0, 3);//AD
		grafo.addEdge(0, 4);//AE
		grafo.addEdge(1, 4);//BE
		grafo.addEdge(2, 5);//CF
		grafo.addEdge(3, 6);//DG
		grafo.addEdge(4, 6);//EG
		grafo.addEdge(5, 7);//FH
		grafo.addEdge(6, 7);//GH
		grafo.Topological_Sorting_Algorithm();
		
		//----------------------------------------------------------
		
		
		
	}

}
