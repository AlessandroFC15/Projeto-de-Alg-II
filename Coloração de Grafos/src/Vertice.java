import java.util.ArrayList;

public class Vertice {
	int edgeCount;
	int color;
	ArrayList<Integer> connectedVertices = new ArrayList<>();
	
	Vertice(int color)
	{
		this.color = color;
	}
	
	public void addConnection(int number)
	{
		if (! connectedVertices.contains(number))
		{
			connectedVertices.add(number);
		} else
		{
			System.out.println("Already registered");
		}
	}
	
	public String toString()
	{
		String output;
		
		output = "- Color = " + getColorString();
				
		return output;
	}
	
	public ArrayList<Integer> getConnections()
	{
		return connectedVertices;
	}
	
	public int getColor()
	{
		return color;
	}
	
	public String getColorString()
	{
		switch (color)
		{
			case (ColorBLUE):
				return "Blue";
			case (ColorRED):
				return "Red";
			case (ColorGREEN):
				return "Green";
			case (ColorWHITE):
				return "White";
			default:
				return "Uncolored";
		}
	}
	
	public boolean hasConnection(int indexVertice)
	{
		return connectedVertices.contains(indexVertice);
	}

	public static final int ColorBLUE = 0;
	public static final int ColorRED = 1;
	public static final int ColorGREEN = 2;
	public static final int ColorWHITE = 3;
}
