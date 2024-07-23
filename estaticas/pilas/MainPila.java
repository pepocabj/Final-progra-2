package estaticas.pilas;

public class MainPila {

	public static void PasarPila(PilaTDA origen, PilaTDA destino) {
		while (!origen.PilaVacia()) {
			destino.Apilar(origen.Tope());
			origen.Desapilar();
		}
	}
	
	public static void main(String[] args) {
		PilaTDA origen = new PilaTF();
		PilaTDA destino = new PilaTF();
		origen.InicializarPila();
		origen.Apilar(1);
		origen.Apilar(2);
		origen.Apilar(3);
		destino.InicializarPila();
		PasarPila(origen, destino);
	}

}
