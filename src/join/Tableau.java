package join;

public class Tableau {

	public static char[] copierTableau(char[] original, int new_size) {
		
		char[] copie = new char[new_size];
		
		for (int i = 0; i < new_size; i++) {
			copie[i] = original[i];
		}

		return copie;
	}
}
