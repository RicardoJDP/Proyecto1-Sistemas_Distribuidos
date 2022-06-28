package clases;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.net.*;

//Clase Vendedor. Se implementó al Vendedor como servidor
class VendedorImp 
{
    //Puerto donde escucha el socket
    static final int PUERTO=5000;
   
    public static void main(String[] args) throws IOException 
    {

     
       //Código para que el socket server escuche y reciba peticiones de los fumadores (Cliente)
       try {

      ServerSocket skServidor = new ServerSocket( PUERTO );

      System.out.println("Escucho el puerto " + PUERTO );

        Socket skCliente = skServidor.accept(); // Crea objeto

        OutputStream aux = skCliente.getOutputStream();

        DataOutputStream flujo= new DataOutputStream( aux );

        flujo.writeUTF( "Atendiendo al Fumador");

        skCliente.close();

        //skServidor.close();

    } catch( Exception e ) {

      System.out.println( e.getMessage() );

    }



  }
}
  
public class Vendedor 
{
    public String nombre;
    //declaracion de los bancos
    public BancoIngrediente[] bancosIngredientes = new BancoIngrediente[3];
   

    public Vendedor(String nombre){
        this.nombre = nombre;
    }

    public synchronized void surtirBancos(BancoIngrediente bancoFosforo, BancoIngrediente bancoPapel, BancoIngrediente bancoTabaco){
    //utilizacion del comando synchronized para la exclusion mutua, al ejecutarse este metodo no se puede ejecutar otro
           
        int min = 1;
		int max = 2;

        //Declaracion de random surtir los bancos de forma aleatoria
		Random random = new Random();

		int value = random.nextInt(max + min) + min;
		//System.out.println(value);

        //se surten fosforo y papel
        if(value == 1){
            bancoFosforo.agregarIngrediente();
            bancoPapel.agregarIngrediente();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
            //se surten papel y tabaco
        } else if (value == 2){
            bancoPapel.agregarIngrediente();
            bancoTabaco.agregarIngrediente();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
        } else if (value == 3){
            //se surten tabaco y fosforo
            bancoFosforo.agregarIngrediente();
            bancoTabaco.agregarIngrediente();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
        }

    

    }
}


