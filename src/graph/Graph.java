package graph;

public class Graph {
	private final int MAX_VERTEX = 20; // numero de vertices máximos
	private Vertex vertexlist[];
	private boolean directed = false;
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
		if (this.directed == true)
		{
			this.adjMat[origin][destine] = 1;
		}
		else
		{
			this.adjMat[origin][destine] = 1;
			this.adjMat[destine][origin] = 1;
		}
		
	}
	
	//----------------------------------------------------------
	
	public void displayVertex(int u)
	{
		System.out.println(this.vertexlist[u]);
	}
	
	//----------------------------------------------------------
	
	public int getAdjUnvitedVertex( int u )// retorna o primeiro sucessor de qualquer vertice
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
	
	//----------------------------------------------------------
	
	public void Minimum_Spaning_Tree() // não leva em consideração o peso *(ver imagem)
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
		
	} // fim da arvore geradora mínima
	
	//----------------------------------------------------------
	
	//Passo 1 encontre um vertice sem sucessor
	//Passo 2 retire esse vertice do grafo e ponha em uma lista
	//passo 3 repita o passo 1
	public void Topological_Sorting_Algorithm()
	{
		char []sortedArray = new char[this.nVerts];
		int orig_Verts = this.nVerts; // numero de vertices no inicio
		while( orig_Verts > 0)
		{
			int u = this.noSucessor();
			if (u == -1) // deve ser um ciclo!
			{
				System.out.println("Erro, Grafo tem um ciclo!");
				return;
			}
			
			sortedArray[this.nVerts-1] = this.vertexlist[u].getLabel();
			deleteVertex(u);
				
		}
		
		System.out.println("Topological Sorted Order: ");
		for ( int i = 0; i< orig_Verts; i++)
		{
			System.out.println(sortedArray[i]);
			System.out.println(" ");
			
		}
		
	}
	
	public void deleteVertex(int u)
	{
		if ( u != this.nVerts -1) // se não for o ultimo vertice
		{
			for ( int i = u; i < this.nVerts -1; i++ )
				this.vertexlist[i] = this.vertexlist[i+1];//deleta elemento da lista de vertices
			
			for ( int row = u; row < this.nVerts -1; row++ ) // deleta a linha
				moveRowup(row,this.nVerts);
			
			for ( int col = u; col < this.nVerts -1; col++ ) // deleta a coluna
				moveColleft(col,this.nVerts);
						
				
			}
		this.nVerts--;// um vertice a menos
		
	}
	
	public void moveRowup(int row,int n)
	{
		for ( int col = 0; col < n; col++)
		{
			this.adjMat[row][col] = this.adjMat[row+1][col];
		}
	}
	
	public void moveColleft(int col, int n)
	{
		for ( int row = 0; row < n; row++)
		{
			this.adjMat[row][col] = this.adjMat[row][col+1];
		}
	
	}
	public int noSucessor() // retorna o primeiro vertice sem qualquer sucessor
	{
		boolean isEdge;
		for(int row = 0; row < this.nVerts; row ++)// para todo vertice
		{
			isEdge = false;
			for (int col = 0; col < this.nVerts; col ++)//verifica arestas
			{
				if ( this.adjMat[row][col]> 0 ) // existe aresta?
				{
					isEdge = true; // este vertice (row) tem sucessor
					break;
				}
				
			}
			if ( !isEdge)
			{
				return row; // se sem aresta, sem sucessor
			}
		}
		return -1; // não exite tal vertice
	}// fim de sem sucessor
	
	//----------------------------------------------------------
	
	
}// fim da classe Graph
	