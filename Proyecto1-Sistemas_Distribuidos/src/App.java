import java.lang.reflect.Array;

import clases.*;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        BancoIngrediente bancoFosforo = new BancoIngrediente();
        BancoIngrediente bancoPapel = new BancoIngrediente();
        BancoIngrediente bancoTabaco = new BancoIngrediente();

        bancoFosforo.contador_ingrediente = 0;
        bancoPapel.contador_ingrediente = 0;
        bancoTabaco.contador_ingrediente = 0;

        Cliente cliente1 = new Cliente("Ricardo");
        
        Papel papel = new Papel();
        Fosforo fosforo = new Fosforo();
        Tabaco tabaco = new Tabaco();
        
        cliente1.ingredientes_cigarro[0] = papel;
        cliente1.ingredientes_cigarro[1] = fosforo;
        cliente1.ingredientes_cigarro[2] = tabaco;

        for (int i = 0; i<3; i++) {
            System.out.println(cliente1.ingredientes_cigarro[i]);
            System.out.println("\n");
          }

          //cliente1.contarIngredientesCigarro();

          Vendedor vend = new Vendedor("Javier");
          Vendedor.surtirBancos(bancoFosforo,bancoPapel,bancoTabaco);
          
          System.out.println(bancoFosforo.contador_ingrediente);
          System.out.println(bancoPapel.contador_ingrediente);
          System.out.println(bancoTabaco.contador_ingrediente);
    } 
}
