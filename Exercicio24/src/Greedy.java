
public class Greedy {
	
	static double[] lista = {1, 3, 7, 15, 31, 63, 127, 255};
	static int[] caixa = {0,0,0,0,0,0,0,0};
	static int limite = 328;
	
	public static void main(String[] args) {
		Greedy a = new Greedy();
		 
		/*double[] lista = {0.2, 0.6, 0.5, 0.2, 0.8, 0.3, 0.2};
		int[] caixa = {0,0,0,0,0,0,0};
		
		double[] lista = {0.5, 0.7, 0.3, 0.9, 0.6, 0.8, 0.1, 0.4, 0.2, 0.5};
		int[] caixa = {0,0,0,0,0,0,0,0,0,0};
		*/
		
		quicksort(lista);
	
		printArray(lista);
		
		firstFit(lista, caixa);
		
		System.out.println("\n\n");
		
		printArray(used);
		System.out.println("Boxes Used: " + getBoxesUsed(used));
	
	}
	
	private static int getBoxesUsed(double[] array)
	{
		int boxesUsed = 0;
		
		for (int i = 0; i < array.length; i++)
		{
			if (used[i] != 0)
			{
				boxesUsed += 1;
			}
		}
		
		return boxesUsed;
	}
	
	private static void printArray(double[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + "  ");
		}
	}

	static double[] used = new double[10]; // Limite em cada caixa
	static int binLoc; // Indice que identifica cada caixa
	
	public static void firstFit(double[] size, int[] bin)
	{
		int n = size.length;
		
		for (int i = 0; i < n; i++)
		{
			used[i] = 0;
		}
		
		for (int item = 0; item < n; item += 1)
		{
			binLoc = 0;
			
			while (used[binLoc] + size[item] > limite)
			{
				if (binLoc == n - 1)
				{
					break;
				}
				binLoc += 1;
			}
			
			bin[item] = binLoc;
			used[binLoc] += size[item];
		}
	}
	
	// Quick Sort
	
	public static void quicksort(double[] vetor)
    {
		ordenar(vetor, 0, vetor.length - 1);
    }

	private static void ordenar(double[] vetor, int inicio, int fim)
    {
		if (inicio < fim)
		{
			int posicaoPivo = separar(vetor, inicio, fim);
			ordenar(vetor, inicio, posicaoPivo - 1);
			ordenar(vetor, posicaoPivo + 1, fim);
		}
    }

	private static int separar(double[] vetor, int inicio, int fim)
	{
		double pivo = vetor[inicio];
		int i = inicio + 1, f = fim;
		while (i <= f)
		{
			if (vetor[i] >= pivo)
				i++;
			else if (pivo > vetor[f])
				f--;
			else
			{
				double troca = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = troca;
				i++;
				f--;
			}
		}
		vetor[inicio] = vetor[f];
		vetor[f] = pivo;
		return f;
   }
}
