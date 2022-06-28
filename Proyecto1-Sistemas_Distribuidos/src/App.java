//import java.lang.reflect.Array;
import clases.*;

public class App {
    public static void main(String[] args) throws Exception {

        //creacion de los bancos de cada ingrediente
        BancoIngrediente bancoFosforo = new BancoIngrediente();
        BancoIngrediente bancoPapel = new BancoIngrediente();
        BancoIngrediente bancoTabaco = new BancoIngrediente();


         //creacion de los 3 fumadores
        Cliente cliente1 = new Cliente("Ricardo");
        Cliente cliente2 = new Cliente("Ana");
        Cliente cliente3 = new Cliente("Jeiber");
        
        //creacion de los ingredietes
        Papel papel = new Papel();
        Fosforo fosforo = new Fosforo();
        Tabaco tabaco = new Tabaco();

        //asignacion del ingrediente inicial a cada cliente
        cliente1.ingredientes_cigarro[0] = papel;
        cliente2.ingredientes_cigarro[0] = fosforo;
        cliente3.ingredientes_cigarro[0] = tabaco;
        
        //creacion del vendedor
        Vendedor vend = new Vendedor("Javier");  
        //asignacion de los bancos de ingredientes al vendedor      
        vend.bancosIngredientes[0] = bancoFosforo;
        vend.bancosIngredientes[1] = bancoPapel;
        vend.bancosIngredientes[2] = bancoTabaco;

        //se colocan 2 ingredientes por banco
        bancoFosforo.contador_ingrediente = 1;
        bancoPapel.contador_ingrediente = 1;
        bancoTabaco.contador_ingrediente = 1;
    
        System.out.println("\n");
        System.out.println("Cantidad de ingredientes en el Banco Fosforo:"  + vend.bancosIngredientes[0].contador_ingrediente);
        System.out.println("Cantidad de ingredientes en el Banco Papel:" + vend.bancosIngredientes[1].contador_ingrediente);
        System.out.println("Cantidad de ingredientes en el Banco Tabaco:" + vend.bancosIngredientes[2].contador_ingrediente);
        System.out.println("\n");
       

        /*System.out.println("\n");
        for (int i = 0; i<3; i++) {
            System.out.println(cliente3.ingredientes_cigarro[i]);
          }*/

          //llamada al metodo donde los fumadores intentan armar su cigarro
        cliente3.armarCigarro(cliente3, vend, fosforo, papel, tabaco);
        cliente2.armarCigarro(cliente2, vend, fosforo, papel, tabaco);
        cliente1.armarCigarro(cliente1, vend, fosforo, papel, tabaco);
    

        System.out.println("\n");
      
    } 
}
