package estaticas.colas;

public class MainCola {
	
	public static void PasarCola(ColaTDA Origen, ColaTDA Destino) {
		while (!Origen.ColaVacia()) {
			Destino.Acolar(Origen.Primero());
			Origen.Desacolar();
		}
	}
	
	public static void main(String[] args) {
		ColaTDA Origen = new ColaPI();
		ColaTDA Destino = new ColaPU();
		Origen.InicializarCola();
		Origen.Acolar(2);
		Origen.Acolar(4);
		Origen.Acolar(6);
		Destino.InicializarCola();
		PasarCola(Origen, Destino);
	}

}
