package graph;

public class Graph {
	private final int MAX_VERTEX = 20; // numero de vertices máximos
	private Vertex vertexlist[];
	private int adjMat[][];
	private int nVerts; // numeros de vertices atuais
	private Stack stack;
	private Queue queue;
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
	
	public int getAdjUnvitedVertex( int u )
	{
		for (int j = 0; j < this.nVerts; j++)
		{
			if(this.adjMat[u][j] == 1 && this.vertexlist[j].getVisited())
			
				return j;
			
		}
		return -1;
	}
	
	//----------------------------------------------------------
	public void clear()
	{
		for(int i = 0; i < this.MAX_VERTEX; i++) 
		{	
			for (int j = 0; i < this.MAX_VERTEX; i++)
			{
				this.adjMat[i][j] = 0; 
			}
		}
	
	}
	
	//----------------------------------------------------------
	
	public void Depth_First_Search()
	{
		this.vertexlist[0].setVisitado(true);
		this.displayVertex(0);
		this.stack.push(0); //pilha recebe um vertice
		while(!stack.isEmpty())
		{
			int v = this.getAdjUnvitedVertex(stack.top());
			if (v == -1) //sem adjacentes!
			{
				stack.pop();
			}
			else // se existe adjacente
			{
				this.vertexlist[v].setVisitado(true);
				this.displayVertex(v);
				stack.push(v);
			}
		}// a pilha está vazia, então o algoritmo terminou!
		
		for (int i = 0; i < this.nVerts; i++) // reset flags
		{
			this.vertexlist[i].setVisitado(false);
		}
		
	} // fim da DFS
	
	//----------------------------------------------------------
	
	public void Breadth_Fist_Search()
	{
		this.vertexlist[0].setVisitado(true);
		this.displayVertex(0);
		queue.insert(0);
		int u,v;
		
		while(!queue.isEmpty())
		{
			u = queue.remove(0);
			// enquanto u não tiver adjacentes
			while( (v = this.getAdjUnvitedVertex(u)) != -1)
			{
				this.vertexlist[v].setVisitado(true);
				this.displayVertex(v);
				queue.insert(v);
				
			} // a fila está fazia,logo o algoritmo terminou!
			
		}
		
		for (int i = 0; i < this.nVerts; i++) // reset flags
		{
			this.vertexlist[i].setVisitado(false);
		}
		
		
	}// fim da BFS
	
	public void Minimum_Spaning_Tree()
	{
		this.vertexlist[0].setVisitado(true);
		stack.push(0);
		while(!stack.isEmpty())
		{
			int u = stack.top();
			int v = this.getAdjUnvitedVertex(u);
			if ( v == -1)
			{
				stack.pop();
			}
			
			else
			{
				this.vertexlist[v].setVisitado(true);
				stack.push(v);
				
				this.displayVertex(u);
				this.displayVertex(v);
				System.out.println(" ");
				
				
			}
		
		}// a pilha está vazia, então o algoritmo terminou!
		
		for (int i = 0; i < this.nVerts; i++) // reset flags
		{
			this.vertexlist[i].setVisitado(false);
		}
		
	}
	
}// fim da classe Graph
	