
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Grafo {
	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		
		grafo.addDefaultVertices(7);
		
		grafo.printVertices();
		
		grafo.generateRandomConnections(5);
		
		if (grafo.hasVerticesSameColorConnected())
		{
			System.out.println("Invalid solution");
		} else
		{
			System.out.println("Valid solution");
		}
	}
	
	public void generateRandomConnections(int numberOfConnections)
	{
		for (int i = 1; i <= numberOfConnections; i++)
		{
			int randIndex1, randIndex2;
			
			while (true)
			{
				randIndex1 = rand.nextInt(vertices.size()) + 1;
				randIndex2 = rand.nextInt(vertices.size()) + 1;
				
				if (! connectionExists(randIndex1, randIndex2))
				{
					break;
				}
			}
			
			addConnection(randIndex1, randIndex2);
		}
	}
	
	public boolean connectionExists(int index1, int index2)
	{
		Vertice vertice1 = vertices.get(index1);
		
		return vertice1.hasConnection(index2);
	}
	
	public boolean hasVerticesSameColorConnected()
	{
		for (int indexVertice : vertices.keySet())
		{
			// For each vertix, get the its color and compare against the 
			// other vertix that he is connected to.
			Vertice vertice = vertices.get(indexVertice);
			int verticeColor = vertice.getColor();
			
			ArrayList<Integer> connections = new ArrayList<>(vertice.getConnections());
			
			for (int connectedVertice : connections)
			{
				int color = vertices.get(connectedVertice).getColor();
				
				if (verticeColor == color)
				{
					System.out.println("Vertice " + indexVertice + " and " + connectedVertice + 
							" have the same color!");
					return true;
				}
				
			}
		}
		
		return false;
	}
	
	public void addDefaultVertices(int numberOfVertices)
	{
		addVertice(1, new Vertice(getRandomColor()));
		addVertice(2, new Vertice(getRandomColor()));
		addVertice(3, new Vertice(getRandomColor()));
		addVertice(4, new Vertice(getRandomColor()));
		addVertice(5, new Vertice(getRandomColor()));
		addVertice(6, new Vertice(getRandomColor()));
		addVertice(7, new Vertice(getRandomColor()));
		addVertice(8, new Vertice(getRandomColor()));
		
		/*
		for (int i = 1; i <= numberOfVertices; i++)
		{
			addVertice(i, new Vertice(Vertice.ColorBLUE));
		}*/
	}
	
	public int getRandomColor()
	{
		return rand.nextInt(4);
	}
	
	
	public void addVertice(int number, Vertice vertice)
	{
		vertices.put(number, vertice);
	}
	
	public void printVertices()
	{
		for (int number : vertices.keySet())
		{
			System.out.println("VERTICE " + number);
			System.out.println(vertices.get(number).toString());
		}
	}
	
	public void addConnection(int indexVertice1, int indexVertice2)
	{
		if (indexVertice1 != indexVertice2)
		{
			Vertice vertice1 = vertices.get(indexVertice1);
			Vertice vertice2 = vertices.get(indexVertice2);
			
			vertice1.addConnection(indexVertice2);
			vertice2.addConnection(indexVertice1);
			
			System.out.println("Added aresta between " + indexVertice1 + " and " + indexVertice2);
		} else 
		{
			System.out.println("Wont add self loop");
		}
	}
	
	HashMap<Integer, Vertice> vertices = new HashMap<>();
	Random rand = new Random();
	// ArrayList<Vertice> vertices = new ArrayList<>();
}
