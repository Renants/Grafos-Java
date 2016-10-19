package graph;

public class Vertex {

	private  char label;
	private boolean wasVisited;
	
	public Vertex(char lab) //construtor
	{
		this.label = lab;
		this.wasVisited = false;
	}
	
    @Override
    public String toString() {
        String ch = label == '\n' ? "\\n" : "" + label;

        return String.format("%s", ch);
    }

	public boolean getVisited()
	{
		return this.wasVisited;
	}
	
	public void setVisitado(boolean bool)
	{
		this.wasVisited = bool;
	}
	

} // fim da classe
