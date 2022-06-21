package clases;

public class BancoIngrediente {
    public int contador_ingrediente;

    public BancoIngrediente(){
    }

    public void agregarIngrediente(){
        contador_ingrediente =  contador_ingrediente +1;
    }
    
    public void sustraerIngrediente(){
        if(contador_ingrediente > 0)
            contador_ingrediente = contador_ingrediente -1;
        else{
            System.out.println("El banco esta fuera de stock");
        }
    }
}
