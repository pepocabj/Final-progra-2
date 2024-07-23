package ejercicios;

public class Lista2Main {
    public static void main(String[] args) {
        Lista2EnlazadaTDA lst1 = new Lista2Enlazada();
        lst1.InicializarLst();

        lst1.Agregar(8);
        lst1.Agregar(52);
        lst1.Agregar(19);
        lst1.Agregar(44);
        lst1.Agregar(91);

        lst1.Eliminar(19);

        String aux = lst1.MostrarLista();
        System.out.println(aux);
    }
}
