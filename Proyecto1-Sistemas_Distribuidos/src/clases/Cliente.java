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

    public void armarCigarro(Cliente cliente, Vendedor vendedor, Fosforo fosforo, Papel papel, Tabaco tabaco){
        //System.out.println("si entra");
        boolean interrumpir_ciclo = false;
        int contador = 0;

        while(interrumpir_ciclo == false){
            contador++;
            if(cliente.contarIngredientesCigarro() == 3){
                //System.out.println("if0");
                cliente.fumar();
            }else if (cliente.ingredientes_cigarro[0] instanceof Fosforo){
                System.out.println("Buscando ingredientes del cliente "+ cliente.nombre + " " +contador);
                if(cliente.ingredientes_cigarro[1] == null)
                    if (vendedor.bancosIngredientes[1].sustraerIngrediente(vendedor.bancosIngredientes[1]))
                        cliente.ingredientes_cigarro[1] = papel;
                if(cliente.ingredientes_cigarro[2] == null)
                    if (vendedor.bancosIngredientes[2].sustraerIngrediente(vendedor.bancosIngredientes[2]))
                        cliente.ingredientes_cigarro[2] = tabaco;
                //System.out.println("\n");
            }else if(cliente.ingredientes_cigarro[0] instanceof Papel){
                System.out.println("Buscando ingredientes del cliente "+ cliente.nombre + " " +contador);
                if(cliente.ingredientes_cigarro[1] == null)
                    if (vendedor.bancosIngredientes[0].sustraerIngrediente(vendedor.bancosIngredientes[0]))
                        cliente.ingredientes_cigarro[1] = fosforo;
                if(cliente.ingredientes_cigarro[2] == null)
                    if (vendedor.bancosIngredientes[2].sustraerIngrediente(vendedor.bancosIngredientes[2]))
                        cliente.ingredientes_cigarro[2] = tabaco;
                //System.out.println("\n");
            }else if(cliente.ingredientes_cigarro[0] instanceof Tabaco){
                System.out.println("Buscando ingredientes del cliente "+ cliente.nombre + " " +contador);
                if(cliente.ingredientes_cigarro[1] == null)
                    if (vendedor.bancosIngredientes[0].sustraerIngrediente(vendedor.bancosIngredientes[0]))
                        cliente.ingredientes_cigarro[1] = fosforo;
                if(cliente.ingredientes_cigarro[2] == null)
                    if (vendedor.bancosIngredientes[1].sustraerIngrediente(vendedor.bancosIngredientes[1]))
                        cliente.ingredientes_cigarro[2] = papel;
                //System.out.println("\n");
            }
                System.out.println("\n");
                //System.out.println(cliente.contarIngredientesCigarro());
            
            if(cliente.contarIngredientesCigarro() == 3){
                cliente.fumar();
                interrumpir_ciclo = true;
            }
            else{
                System.out.println("Se surtio en el banquito");
                vendedor.surtirBancos(vendedor.bancosIngredientes[0], vendedor.bancosIngredientes[1], vendedor.bancosIngredientes[2]);
                System.out.println("\n");
                interrumpir_ciclo = false;
            }
            System.out.println("\n");
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
        for (int i = 1; i<3; i++) {
            this.ingredientes_cigarro[i] = null;
        }
        System.out.println("Cigarro fumado"); 
    }

}
