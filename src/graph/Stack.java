package graph;

public class Stack {
	private final int size = 20;
	private int[] array;
	private int top;
	
	public Stack()
	{
		this.array = new int[this.size];
		this.top = -1;
	}
	
	//----------------------------------------------------------
	
	public void push(int u)
	{
		this.array[++this.top]= u;
	}

	//----------------------------------------------------------
	
	public int pop()
	{
		return this.array[this.top--];
	}
	
	//----------------------------------------------------------

	public int top()
	{
		return this.array[this.top];
	}

	//----------------------------------------------------------

	public boolean isEmpty()
	{
		return (this.top == -1);
	}
	
	//----------------------------------------------------------

} // fim da classe Pilha
