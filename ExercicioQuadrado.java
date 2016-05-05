import java.util.Random;

public class ExercicioQuadrado {
	static double circleCenterX = 0.5;
	static double circleCenterY = 0.5;
	static int ladoQuadrado = 1;
	static double raio = ladoQuadrado / 2.0;
	static int acertos = 0;
	static int max_pontos = 100000000;
	
	public static void main(String[] args) {
		for (int i = 0; i < max_pontos; i++)
		{
			float x = rand.nextFloat();
			float y = rand.nextFloat();
			
			if (isPointInCircleArea(x, y))
			{
				acertos += 1;
			}
		}
		
		float result = (float) (4*((float) acertos / max_pontos));
		
		System.out.println(result);
	}
	
	private static boolean isPointInCircleArea(float x, float y)
	{
		return ((x - circleCenterX)*(x - circleCenterX))
				+ ((y - circleCenterY) * (y - circleCenterY)) < (raio * raio);
	}
	
	static Random rand = new Random();
}
