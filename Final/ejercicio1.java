package Final;
import estaticas.diccionariosMultiples.*;
import estaticas.conjuntos.*;


public class ejercicio1 {

    public static DiccionarioMultipleTDA Verifico(DiccionarioMultipleTDA D1, DiccionarioMultipleTDA D2){
        ConjuntoTDA claves2 = D2.Claves();
        ConjuntoTDA claves1 = D1.Claves();
        DiccionarioMultipleTDA dicc = new DiccionarioMultipleA();
        dicc.InicializarDiccionario();
        while (!claves1.ConjuntoVacio()) {
            int clave1 = claves1.Elegir();
            if (claves2.Pertenece(clave1)) {
                ConjuntoTDA valores = D1.Recuperar(clave1);
                ConjuntoTDA valores2 = D2.Recuperar(clave1);
                while (!valores.ConjuntoVacio()) {
                    int valor = valores.Elegir();
                    dicc.Agregar(clave1, valor);
                    valores.Sacar(valor);
                }
                while (!valores2.ConjuntoVacio()) {
                    int valor2 = valores2.Elegir();
                    dicc.Agregar(clave1, valor2);
                    valores2.Sacar(valor2);
                }
            }
            claves1.Sacar(clave1);
        }
        return dicc;
    }


    public static void main(String[] args) {
        DiccionarioMultipleTDA D1 = new DiccionarioMultipleA();
        DiccionarioMultipleTDA D2 = new DiccionarioMultipleA();
        D1.InicializarDiccionario();
        D2.InicializarDiccionario();

        D1.Agregar(30, 10);
        D1.Agregar(15, 22);
        D1.Agregar(30, 17);
        D1.Agregar(50, 41);
        D1.Agregar(15, 98);

        D2.Agregar(50, 8);
        D2.Agregar(87, 26);
        D2.Agregar(15, 17);
        D2.Agregar(65, 15);

        DiccionarioMultipleTDA dic1 = Verifico(D1, D2);

        ConjuntoTDA clave = dic1.Claves();
        while (!clave.ConjuntoVacio()) {
            int clave1 = clave.Elegir();
            ConjuntoTDA valor = dic1.Recuperar(clave1);
            String txt = "";
            while (!valor.ConjuntoVacio()) {
                int num1 = valor.Elegir();
                txt += "; " + num1;
                valor.Sacar(num1);
            }
            System.out.println("Clave: " + clave1 + " Valor " + txt);
            clave.Sacar(clave1);
        }
    }
}
