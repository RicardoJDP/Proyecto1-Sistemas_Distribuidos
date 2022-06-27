//import java.lang.reflect.Array;
import clases.*;

public class App {
    public static void main(String[] args) throws Exception {

        BancoIngrediente bancoFosforo = new BancoIngrediente();
        BancoIngrediente bancoPapel = new BancoIngrediente();
        BancoIngrediente bancoTabaco = new BancoIngrediente();

        Cliente cliente1 = new Cliente("Ricardo");
        Cliente cliente2 = new Cliente("Ana");
        Cliente cliente3 = new Cliente("Jeiber");
        
        Papel papel = new Papel();
        Fosforo fosforo = new Fosforo();
        Tabaco tabaco = new Tabaco();

        //Esto es importante, siempre hay que inicializarlo asi (Puede variar el orden de los clientes, mas no la posicion del ingrediente)
        cliente1.ingredientes_cigarro[0] = papel;
        cliente2.ingredientes_cigarro[0] = fosforo;
        cliente3.ingredientes_cigarro[0] = tabaco;
        

        Vendedor vend = new Vendedor("Javier");  
        //Esto es importante, siempre hay que inicializarlo asi       
        vend.bancosIngredientes[0] = bancoFosforo;
        vend.bancosIngredientes[1] = bancoPapel;
        vend.bancosIngredientes[2] = bancoTabaco;

        //Colocando 2 ingredientes por banco
        bancoFosforo.contador_ingrediente = 1;
        bancoPapel.contador_ingrediente = 1;
        bancoTabaco.contador_ingrediente = 1;
    
        System.out.println("\n");
        System.out.println("Cantidad de ingredientes en el Banco Fosforo:"  + vend.bancosIngredientes[0].contador_ingrediente);
        System.out.println("Cantidad de ingredientes en el Banco Papel:" + vend.bancosIngredientes[1].contador_ingrediente);
        System.out.println("Cantidad de ingredientes en el Banco Tabaco:" + vend.bancosIngredientes[2].contador_ingrediente);
        System.out.println("\n");
        cliente3.armarCigarro(cliente3, vend, fosforo, papel, tabaco);

        /*System.out.println("\n");
        for (int i = 0; i<3; i++) {
            System.out.println(cliente3.ingredientes_cigarro[i]);
          }*/

        cliente3.armarCigarro(cliente3, vend, fosforo, papel, tabaco);
        cliente2.armarCigarro(cliente2, vend, fosforo, papel, tabaco);
        cliente1.armarCigarro(cliente1, vend, fosforo, papel, tabaco);
        // cliente1.armarCigarro(cliente1, vend, fosforo, papel, tabaco);
        //cliente3.armarCigarro(cliente3, vend, fosforo, papel, tabaco);
        //cliente3.armarCigarro(cliente3, vend, fosforo, papel, tabaco);
        //cliente3.armarCigarro(cliente3, vend, fosforo, papel, tabaco);

        System.out.println("\n");
      
    } 
}
