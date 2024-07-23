package estaticas.colasPrioridad;
import estaticas.colas.*;

public class MainColaPrioridad {

	public static void Pasaje(ColaPrioridadTDA origen, ColaTDA Valores, ColaTDA prioridades) {
		while (!origen.ColaVacia()) {
			Valores.Acolar(origen.Primero());
			prioridades.Acolar(origen.Prioridad());
			origen.Desacolar();
		}
	}
	
	public static void main(String[] args) {
		ColaPrioridadTDA origen = new ColaPrioridadDA();
		ColaTDA Valores = new ColaPU();
		ColaTDA prioridades = new ColaPU();
		origen.InicializarCola();
		origen.AcolarPrioridad(5, 2);
		origen.AcolarPrioridad(10, 7);
		origen.AcolarPrioridad(3, 4);
		Valores.InicializarCola();
		prioridades.InicializarCola();
		Pasaje(origen, Valores, prioridades);
	}

}
