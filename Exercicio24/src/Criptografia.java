import java.util.ArrayList;
import java.util.Random;

public class Criptografia {
	
	static Random rand = new Random();
	static int[] w = {1, 3, 7, 15, 31, 63, 127, 255};
	static int[] sortedW = {1, 3, 7, 15, 31, 63, 127, 255};
	static int[] caixa = new int[w.length];
	static int limite;
	
	public static void main(String[] args) {
		int s = getSumList(w);
		
		// int q = getQ(s);
		int q = 557;
		
		// int r = getR(q);
		int r = 323;
		
		int[] chavePublica = getChavePublica(w, q, r);
	
		printArray(chavePublica);
		
		// Vamos supor que eu queira enviar a mensagem binária ASCII “a” que, em
		// binário, é igual a 01100101.

		int [] mensagemBinaria = {0, 1, 1, 0, 0, 1, 0, 1};
		
		int mensagemCriptografada = getMensagemCriptografada(mensagemBinaria, chavePublica);
	
		System.out.println("\nMensagem Criptografada: " + mensagemCriptografada);
		
		// Eu então envio o valor 1228 para um destinatário, o qual vai desencriptar a
		// minha mensagem.
		int [] mensagemRevelada = getMensagemRevelada(mensagemCriptografada, q, r);
		
		System.out.println("\n.: Mensagem Decriptada :.\n");
		
		printArray(mensagemRevelada);
	}
	
	private static int[] getMensagemRevelada(int mensagem, int q, int r)
	{
		int x = getX(q, r);
		
		int valor = mensagem * x % q;
		
		ArrayList<Integer> combinacao = getCombinacaoDeValores(valor);
		
		return decryptedMessage(combinacao);
		
	}
	
	private static int[] decryptedMessage(ArrayList<Integer> combinacao)
	{
		
		
		int[] mensagemDecriptografada = new int[w.length];
		
		for (int i = 0; i < w.length; i++)
		{
			mensagemDecriptografada[i] = 0;
		}
		
		for (int i = 0; i < w.length; i++)
		{
			if (combinacao.contains(w[i]))
			{
				mensagemDecriptografada[i] = 1;
			}
		}
		
		return mensagemDecriptografada;
	
	}
	
	private static ArrayList<Integer> getCombinacaoDeValores(int valor)
	{
		limite = valor;
		
		quicksort(sortedW);
		
		return firstFit(sortedW);
	}
	
	private static int getX(int q, int r)
	{
		int _1_mod_q = 1 % q;
		
		int x = 1;
		
		while (true)
		{
			if (r * x % q == _1_mod_q)
			{
				return x;
			}
			
			x++;
		}
	}
	
	private static int getMensagemCriptografada(int[] mensagem, int[] chavePublica)
	{
		// Multiplico cada bit que representa “a” pelo respectivo elemento da chave
		// pública b
		
		int sum = 0;
		
		for (int i = 0; i < mensagem.length; i++)
		{
			sum += mensagem[i] * chavePublica[i];
		}
		
		return sum;
	
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
	static int binLoc; // Indice que identifica cada caixa
	
	public static ArrayList<Integer> firstFit(int[] lista)
	{
		int volumeCaixa = 0;
		
		ArrayList<Integer> valores = new ArrayList<>();
		
		int n = lista.length;
		
		for (int item = 0; item < n; item += 1)
		{
			if (volumeCaixa + lista[item] <= limite)
			{
				volumeCaixa += lista[item];
				valores.add(lista[item]);
			} 
		}
		
		return valores;
		
	}
	
	// Quick Sort
	
	public static void quicksort(int[] vetor)
    {
		ordenar(vetor, 0, vetor.length - 1);
    }

	private static void ordenar(int[] vetor, int inicio, int fim)
    {
		if (inicio < fim)
		{
			int posicaoPivo = separar(vetor, inicio, fim);
			ordenar(vetor, inicio, posicaoPivo - 1);
			ordenar(vetor, posicaoPivo + 1, fim);
		}
    }

	private static int separar(int[] vetor, int inicio, int fim)
	{
		int pivo = vetor[inicio];
		int i = inicio + 1, f = fim;
		while (i <= f)
		{
			if (vetor[i] >= pivo)
				i++;
			else if (pivo > vetor[f])
				f--;
			else
			{
				int troca = vetor[i];
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
