package clases;

public class Cliente {
    
    public String nombre;
    public Object[] ingredientes_cigarro = new Object[3];
    Fosforo fosforo;
    Papel papel;
    Tabaco tabaco;

    public Cliente(String nombre){
        this.nombre = nombre;
    }

    public void armarCigarro(Cliente cliente){
        if(cliente.contarIngredientesCigarro() == 3){
            cliente.fumar();
        }
        else if (cliente.contarIngredientesCigarro() != 3){
            //Aqui se arma el cigarro, pero toy viendo como aplicar la logica xd
        }
    }
    
    public int contarIngredientesCigarro(){
        int ingredientesNoNull = 0;
        for (int i = 0; i<3; i++) {
            if (this.ingredientes_cigarro[i] != null)
                ingredientesNoNull = ingredientesNoNull + 1;
        }
        
        //System.out.println(ingredientesNoNull); 
        return ingredientesNoNull;
    }
    
    public void fumar(){
        for (int i = 0; i<3; i++) {
            this.ingredientes_cigarro[i] = null;
        }
        System.out.println("Cigarro fumado"); 
    }

}
