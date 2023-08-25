package Test;

public class Test {
	public static void main(String[] args) {
        System.out.print("Elemento da nascondere");
        System.out.print("\u001B[2K"); // Cancella la linea precedente
        System.out.print("\u001B[1A"); // Sposta il cursore su una riga sopra
        System.out.print("\u001B[2K"); // Cancella la linea corrente
        System.out.println("Elemento nascosto");
    }
}
