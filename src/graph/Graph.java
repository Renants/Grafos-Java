package graph;

public class Graph {
	private final int MAX_VERTEX = 20; // numero de vertices máximos
	private Vertex vertexlist[];
	private int adjMat[][];
	private int nVerts; // numeros de vertices atuais
	
	//----------------------------------------------------------
	
	public Graph()
	{
		this.vertexlist = new Vertex[MAX_VERTEX];
		this.adjMat = new int[MAX_VERTEX][MAX_VERTEX];
		this.nVerts = 0;
		for(int i = 0; i < this.MAX_VERTEX; i++) // defino adjacencia
		{
			for (int j = 0; i < this.MAX_VERTEX; i++)
			{
				this.adjMat[i][j] = 0; 
			}
		}
		
	} // fim do construtor

	//----------------------------------------------------------

	public void addVertex( char lab) // argumento eh um idenficador
	{
		this.vertexlist[this.nVerts++] = new Vertex(lab);
	}
		
	//----------------------------------------------------------
	
	public void addEdge(int origin,int destine )
	{
		this.adjMat[origin][destine] = 1;
		this.adjMat[destine][origin] = 1;
	}
	
	//----------------------------------------------------------
	
	public void displayVertex(int u)
	{
		System.out.println(this.vertexlist[u]);
	}
	
	//----------------------------------------------------------
	
}// fim da classe Graph
