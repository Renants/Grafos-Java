package graph;

public class Queue {
	private final int size = 20;
	private int array[];
	private int fromt;
	private int back;
	
	//----------------------------------------------------------
	
	public Queue()
	{
		array = new int[this.size];
		this.fromt = 0;
		this.back = -1;
	}
	
	//----------------------------------------------------------
	
	public void insert ( int u) // pôe ítem na calda da fila
	{
		if (this.back == this.size -1) // verifica se ainda há espaço
		{
			this.back = -1; // volta para frente
			this.array[++this.back] = u; 
		}
	}
	
	//----------------------------------------------------------
	
	public int remove(int u )
	{
		int temp = this.array[this.fromt++];
		if (this.fromt == this.size)
		{
			this.fromt = 0;
		}
		return temp;
	}
	
	//----------------------------------------------------------
	
	public boolean isEmpty()
	{
		return ((this.back+1 == this.fromt) || (this.size-1 == this.back));
	}
}
