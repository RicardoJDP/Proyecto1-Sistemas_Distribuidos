package clases;

public class BancoIngrediente {
    public int contador_ingrediente = 0;

    public BancoIngrediente(){
    }

    //se agrega una unidad al contador de los ingredientes cuando se surte el banco
    public void agregarIngrediente(){
        contador_ingrediente =  contador_ingrediente +1;
        System.out.println("Se agrego un ingrediente");
    }
    
    /*public Boolean verificarStockBanco(BancoIngrediente bancoIngrediente){
        if(bancoIngrediente.contador_ingrediente > 0)
            return true;
        else
            return false;
    }*/

    //se elimina una unidad al contador de los ingredientes cuando se sustrae un ingrediente del banco (si hay stock)
    public Boolean sustraerIngrediente(BancoIngrediente bancoIngrediente){
        if(contador_ingrediente > 0){    
            contador_ingrediente = contador_ingrediente -1;
            System.out.println("Se sustrajo un ingrediente");
            return true;
        }
        else{
            System.out.println("El banco esta fuera de stock");
            return false;
        }
    }
}
