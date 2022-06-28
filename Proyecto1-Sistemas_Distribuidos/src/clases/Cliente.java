package clases;

import java.io.*;

import java.net.*;

public class Cliente {
    
    public String nombre;
    //lista de objetos que contiene los ingredientes por fumador
    public Object[] ingredientes_cigarro = new Object[3];
    Fosforo fosforo;
    Papel papel;
    Tabaco tabaco;
    Log myLog;

    public Cliente(String nombre) throws IOException{
        this.nombre = nombre;
        myLog = new Log("./log.txt");
    }

    //utilizacion del comando synchronized para la exclusion mutua, al ejecutarse este metodo no se puede ejecutar otro
     
    public synchronized void armarCigarro(Cliente cliente, Vendedor vendedor, Fosforo fosforo, Papel papel, Tabaco tabaco) throws IOException{
        //System.out.println("si entra");
        boolean interrumpir_ciclo = false;
        int contador = 0;
        myLog.addLine("EL CLIENTE: " + this.nombre + " QUIERE ARMAR UN CIGARRO");

        //ciclo para que se ejecuten los 3 clientes iniciados en el main (App.java) y no termina hasta ejecutar los 3
        while(interrumpir_ciclo == false){
            contador++;
            if(cliente.contarIngredientesCigarro() == 3){
            //si el cliente tiene los 3 ingredientes entonces fuma
                //System.out.println("if0");
                cliente.fumar();
            }else if (cliente.ingredientes_cigarro[0] instanceof Fosforo){
                //fumador que posee fosforo infinito
                System.out.println("\n");
                System.out.println("Buscando ingredientes del cliente "+ cliente.nombre + " " +contador);
                myLog.addLine("EL CLIENTE: " + this.nombre + " ESTA BUSCANDO INGREDIENTES Y ESTA ES LA BUSQUEDA NUMERO: " + contador);
                if(cliente.ingredientes_cigarro[1] == null)
                //el fumador no tiene papel, lo busca
                    if (vendedor.bancosIngredientes[1].sustraerIngrediente(vendedor.bancosIngredientes[1]))
                        cliente.ingredientes_cigarro[1] = papel;
                if(cliente.ingredientes_cigarro[2] == null)
                //el fumador no tiene tabaco, lo busca
                    if (vendedor.bancosIngredientes[2].sustraerIngrediente(vendedor.bancosIngredientes[2]))
                        cliente.ingredientes_cigarro[2] = tabaco;
                //System.out.println("\n");
            }else if(cliente.ingredientes_cigarro[0] instanceof Papel){
                //fumador con papel infinito
                System.out.println("Buscando ingredientes del cliente "+ cliente.nombre + " " +contador);
                myLog.addLine("EL CLIENTE: " + this.nombre + " ESTA BUSCANDO INGREDIENTES Y ESTA ES LA BUSQUEDA NUMERO: " + contador);
                if(cliente.ingredientes_cigarro[1] == null)
                //no tiene fosforo, lo busca
                    if (vendedor.bancosIngredientes[0].sustraerIngrediente(vendedor.bancosIngredientes[0]))
                        cliente.ingredientes_cigarro[1] = fosforo;
                if(cliente.ingredientes_cigarro[2] == null)
                //no tiene tabaco, lo busca
                    if (vendedor.bancosIngredientes[2].sustraerIngrediente(vendedor.bancosIngredientes[2]))
                        cliente.ingredientes_cigarro[2] = tabaco;
                //System.out.println("\n");
            }else if(cliente.ingredientes_cigarro[0] instanceof Tabaco){
                //fumador con tabaco infinito
                System.out.println("Buscando ingredientes del cliente "+ cliente.nombre + " " +contador);
                myLog.addLine("EL CLIENTE: " + this.nombre + " ESTA BUSCANDO INGREDIENTES Y ESTA ES LA BUSQUEDA NUMERO: " + contador);
                if(cliente.ingredientes_cigarro[1] == null)
                //no tiene fosforo, lo busca
                    if (vendedor.bancosIngredientes[0].sustraerIngrediente(vendedor.bancosIngredientes[0]))
                        cliente.ingredientes_cigarro[1] = fosforo;
                if(cliente.ingredientes_cigarro[2] == null)
                //no tiene papel, lo busca
                    if (vendedor.bancosIngredientes[1].sustraerIngrediente(vendedor.bancosIngredientes[1]))
                        cliente.ingredientes_cigarro[2] = papel;
                //System.out.println("\n");
            }
                System.out.println("\n");
                //System.out.println(cliente.contarIngredientesCigarro());
            
            if(cliente.contarIngredientesCigarro() == 3){

            // el cliente tiene los tres ingredientes y fuma
                cliente.fumar();
                interrumpir_ciclo = true;
            }
            else{
                System.out.println("Se surtio en el banquito");
                
                //el banco esta vacio y se va a llenar
                System.out.println("\n");

               
                try{
                    //se crea el socket cliente para que haga la peticion al vendedor (servidor) para que llene los bancos
                    Socket skCliente = new Socket("localhost",5000);
              
                    InputStream aux = skCliente.getInputStream();
              
                    DataInputStream flujo = new DataInputStream( aux );
              
                    System.out.println( flujo.readUTF() );

                    //se llama al metodo para surtir los bancos
                    vendedor.surtirBancos(vendedor.bancosIngredientes[0], vendedor.bancosIngredientes[1], vendedor.bancosIngredientes[2]);
                    System.out.println("\n");
                    
                    interrumpir_ciclo = false;
                    
              
                    skCliente.close();

              
                  } catch( Exception e ) {
              
                    System.out.println( e.getMessage() );
              
                  }

                
            }
            
            
        }
    }
    
    //se cuentan los ingredientes para saber si estan los 3 
    public int contarIngredientesCigarro(){
        int ingredientesNoNull = 0;
        for (int i = 0; i<3; i++) {
            if (this.ingredientes_cigarro[i] != null)
                ingredientesNoNull = ingredientesNoNull + 1;
        }
        
        //System.out.println(ingredientesNoNull); 
        return ingredientesNoNull;
    }
    
    //el fumador fuma y se eliminan los ingredientes fumados
    public void fumar() throws IOException{
        
        for (int i = 1; i<3; i++) {
            this.ingredientes_cigarro[i] = null;
        }

        myLog.addLine("EL CLIENTE: " + this.nombre + " CONSIGUIO TODOS LOS INGREDIENTES Y ACABA DE FUMAR UN CIGARRO");
        System.out.println("\n");
        System.out.println("Cigarro fumado"); 
    }



}
