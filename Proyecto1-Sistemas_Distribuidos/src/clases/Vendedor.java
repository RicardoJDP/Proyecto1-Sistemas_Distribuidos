package clases;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.net.*;


class VendedorImp 
{
    static final int PUERTO=5000;
    public static void main(String[] args) throws IOException 
    {

        
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
    //BancoIngrediente bancoIngrediente;
    public BancoIngrediente[] bancosIngredientes = new BancoIngrediente[3];
   

    public Vendedor(String nombre){
        this.nombre = nombre;
    }

    public synchronized void surtirBancos(BancoIngrediente bancoFosforo, BancoIngrediente bancoPapel, BancoIngrediente bancoTabaco){

           
        int min = 1;
		int max = 2;
		Random random = new Random();

		int value = random.nextInt(max + min) + min;
		//System.out.println(value);

        
        if(value == 1){
            bancoFosforo.agregarIngrediente();
            bancoPapel.agregarIngrediente();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
        } else if (value == 2){
            bancoPapel.agregarIngrediente();
            bancoTabaco.agregarIngrediente();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
        } else if (value == 3){
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


