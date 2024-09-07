//Atividade 5
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
    	Scanner ler = new Scanner(System.in);
    	
    	String invertida = "";
    	
    	System.out.print("Insira sua frase para inverter: ");
    	String palvavra = ler.nextLine();
    	
    	// Percorre a string de trás para frente e monta a string invertida
        for (int i = palvavra.length() - 1; i >= 0; i--) {
    	invertida += palvavra.charAt(i);
        }
    	
    	System.out.println("String original: " + palvavra);
        System.out.println("String invertida: " + invertida);
    	ler.close();
	}
}
