package grafos;

import estaticas.conjuntos.*;

public class ejerciGrafos {

    public static ConjuntoTDA Adyacentes(GrafoTDA grafo, int v1){
        ConjuntoTDA conj1 = new ConjuntoA();
        conj1.InicializarConjunto();
        ConjuntoTDA vertices = grafo.Vertices();
        ConjuntoTDA adyacentes = new ConjuntoA();
        adyacentes.InicializarConjunto();

        while (!vertices.ConjuntoVacio()) {
            int vert = vertices.Elegir();
            vertices.Sacar(vert);
            if (grafo.ExisteArista(v1, vert)) {
                adyacentes.Agregar(vert);
            }
        }

        while (!adyacentes.ConjuntoVacio()) {
            int vert2 = adyacentes.Elegir();
            adyacentes.Sacar(vert2);
            vertices = grafo.Vertices();
            while (!vertices.ConjuntoVacio()) {
                int vert3 = vertices.Elegir();
                vertices.Sacar(vert3);
                if (grafo.ExisteArista(vert2, vert3)) {
                    conj1.Agregar(vert3);
                }
            }
        }
        return conj1;


    }

    public static int mayorC(GrafoTDA grafo, int v1){
        ConjuntoTDA conj1 = grafo.Vertices();
        int mayor = 0;
        while (!conj1.ConjuntoVacio()) {
            int num = conj1.Elegir();
            conj1.Sacar(num);
            if (grafo.ExisteArista(v1, num)) {
                if (grafo.PesoArista(v1, num) > mayor) {
                    mayor = grafo.PesoArista(v1, num);
                }
            }
        }
        return mayor;
    }

    public static ConjuntoTDA aislados(GrafoTDA grafo){
        ConjuntoTDA conj1 = grafo.Vertices();
        
        ConjuntoTDA aisl = new ConjuntoA();
        aisl.InicializarConjunto();

        ConjuntoTDA aisl2 = new ConjuntoA();
        aisl2.InicializarConjunto();

        while (!conj1.ConjuntoVacio()) {
            int res = conj1.Elegir();
            conj1.Sacar(res);
            ConjuntoTDA conj2 = grafo.Vertices();
            while (!conj2.ConjuntoVacio()) {
                int res2 = conj2.Elegir();
                conj2.Sacar(res2);
                if (grafo.ExisteArista(res, res2)) {
                    aisl.Agregar(res2);
                    aisl.Agregar(res);
                }
            }
        }
        ConjuntoTDA conj40 = grafo.Vertices();
        while (!conj40.ConjuntoVacio()) {
            int res = conj40.Elegir();
            conj40.Sacar(res);
            if (!aisl.Pertenece(res)) {
                aisl2.Agregar(res);
            }
        }
        return aisl2;
    }

    public static ConjuntoTDA Puente(GrafoTDA grafo,int v1, int v2){
        ConjuntoTDA vertices = grafo.Vertices();
        ConjuntoTDA conj = new ConjuntoA();
        conj.InicializarConjunto();

        while (!vertices.ConjuntoVacio()) {
            int num = vertices.Elegir();
            vertices.Sacar(num);
            if (grafo.ExisteArista(v1, num) && grafo.ExisteArista(num, v2)) {
                conj.Agregar(num);
            }else if (grafo.ExisteArista(num, v1) && grafo.ExisteArista(v2, num)) {
                conj.Agregar(num);
            }
        }
        return conj;
    }

    public static int grado(GrafoTDA grafo, int v1){
        ConjuntoTDA vertices = grafo.Vertices();
        int suma = 0;

        while (!vertices.ConjuntoVacio()) {
            int num = vertices.Elegir();
            vertices.Sacar(num);
            if (grafo.ExisteArista(v1, num)) {
                suma+=1;
            }else if (grafo.ExisteArista(num, v1)) {
                suma-=1;
            }
        }
        return suma;


    }

    public static void main(String[] args) {
        GrafoTDA grafo1 = new GrafoLA();
        grafo1.InicializarGrafo();

        GrafoTDA grafo2 = new GrafoMA();
        grafo2.InicializarGrafo();

        grafo1.AgregarVertice(15);
        grafo1.AgregarVertice(7);
        grafo1.AgregarVertice(17);
        grafo1.AgregarVertice(1);
        grafo1.AgregarVertice(11);
        grafo1.AgregarVertice(77);

        grafo1.AgregarArista(1, 7, 10);
        grafo1.AgregarArista(7, 11, 67);
        grafo1.AgregarArista(11,1, 4);
        grafo1.AgregarArista(15, 15, 4);
        grafo1.AgregarArista(7, 15, 10);

        int res = grado(grafo1, 1);
        System.out.println(res);

    }
}
