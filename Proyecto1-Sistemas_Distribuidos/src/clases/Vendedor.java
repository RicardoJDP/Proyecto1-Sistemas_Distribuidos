package clases;
import java.util.Random;

public class Vendedor {
    public String nombre;
    //BancoIngrediente bancoIngrediente;
    public BancoIngrediente[] bancosIngredientes = new BancoIngrediente[3];

    public Vendedor(String nombre){
        this.nombre = nombre;
    }

    public void surtirBancos(BancoIngrediente bancoFosforo, BancoIngrediente bancoPapel, BancoIngrediente bancoTabaco){

        int min = 1;
		int max = 2;
		Random random = new Random();

		int value = random.nextInt(max + min) + min;
		//System.out.println(value);

        if(value == 1){
            bancoFosforo.agregarIngrediente();
            bancoPapel.agregarIngrediente();
        } else if (value == 2){
            bancoPapel.agregarIngrediente();
            bancoTabaco.agregarIngrediente();
        } else if (value == 3){
            bancoFosforo.agregarIngrediente();
            bancoTabaco.agregarIngrediente();
        }

    }
}
