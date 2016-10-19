package graph;

public class Vertex {

	public  char label;
	public boolean wasVisited;
	
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

	
	

} // fim da classe
