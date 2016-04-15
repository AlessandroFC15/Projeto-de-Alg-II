import java.util.Random;

public class Greedy {
	
	static Random rand = new Random();
	
	public static void main(String[] args) {
		Greedy a = new Greedy();
		 
		int[] w = {1, 3, 7, 15, 31, 63, 127, 255};
		
		int s = getSumList(w);
		
		int q = getQ(s);
		
		int r = getR(q);
		
		int[] chavePublica = getChavePublica(w, 557, 323);
	
		printArray(chavePublica);
	}
	
	private static int[] getChavePublica(int[] w, int q, int r)
	{
		int[] chavePublica = new int[w.length];
		
		// int r_mod_q = r % q;
		
		System.out.println();
		
		for (int i = 0; i < chavePublica.length; i++)
		{
			chavePublica[i] = (w[i] * r) % q;
		}
		
		return chavePublica;
		
	}
	
	private static int getR(int q)
	{
		while (true)
		{
			int r = rand.nextInt(q) + 1;
			if (areCoPrimes(r, q))
			{
				return r;
			}
		}
	}
	
	private static boolean areCoPrimes(int r, int q)
	{
		// Para descobrir se dois números são coprimos, calcularemos o maior divisor comum e verificaremos
		// se é igual a 1.
		return gcd(r, q) == 1;
	}
	
	private static int gcd(int a, int b)
	{
		if (b == 0) 
		{
			return a;
		}
		
		return gcd(b, a % b);
	}
	
	private static int getQ(int sumList)
	{
		return rand.nextInt(500) + sumList + 1;
	}
	
	private static int getSumList(int[] lista)
	{
		int sum = 0;
		
		for (int number: lista)
		{
			sum += number;
		}
		
		return sum;
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
			System.out.println(array[i]);
		}
	}
	
	private static void printArray(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
	}

	static double[] used = new double[10]; // Limite em cada caixa
	int binLoc; // Indice que identifica cada caixa
	
	public void firstFit(double[] size, int[] bin)
	{
		int n = size.length;
		
		for (int i = 0; i < n; i++)
		{
			used[i] = 0;
		}
		
		for (int item = 0; item < n; item += 1)
		{
			binLoc = 0;
			
			while (used[binLoc] + size[item] > 1)
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
			if (vetor[i] <= pivo)
				i++;
			else if (pivo < vetor[f])
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
