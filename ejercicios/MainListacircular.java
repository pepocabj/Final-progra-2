package ejercicios;

public class MainListacircular {
    public static void main(String[] args) {
        ListaCircularTDA lst = new ListaCircular();
        lst.InicializarLista();
        lst.Agregar(90);
        lst.Agregar(15);
        lst.Agregar(43);
        lst.Agregar(70);
        lst.Agregar(17);
        
        lst.Eliminar(43);
        
        System.out.println(lst.Existe(55));
        String aux = lst.MostrarLista();
        System.out.println(aux);
    }
}
