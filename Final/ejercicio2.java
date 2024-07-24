package Final;

import estaticas.colas.ColaPU;
import estaticas.colas.ColaTDA;
import estaticas.conjuntos.ConjuntoA;
import estaticas.conjuntos.ConjuntoTDA;

public class ejercicio2 {

    public static void repetidos(ColaTDA cola, ConjuntoTDA conj){
        ConjuntoTDA conj2 = new ConjuntoA();
        conj2.InicializarConjunto();
        while (!cola.ColaVacia()) {
            int res = cola.Primero();
            cola.Desacolar();
            if (!conj2.Pertenece(res)) {
                conj2.Agregar(res);
            }else{
                conj.Agregar(res);
            }
        }

    }
    public static void main(String[] args) {
        ColaTDA cola = new ColaPU();
        cola.InicializarCola();
        cola.Acolar(15);
        cola.Acolar(6);
        cola.Acolar(15);
        cola.Acolar(88);
        cola.Acolar(61);
        cola.Acolar(6);

        ConjuntoTDA conj = new ConjuntoA();
        conj.InicializarConjunto();

        repetidos(cola, conj);

        while (!conj.ConjuntoVacio()) {
            int num = conj.Elegir();
            System.out.println(num);
            conj.Sacar(num);
        }
    }
}
