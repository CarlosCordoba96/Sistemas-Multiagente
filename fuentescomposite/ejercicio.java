package composite;
import jade.core.Agent;
import jade.core.behaviours.*;

public class ejercicio extends Agent{
	private Micomportamiento c1;
	private Micomportamiento c2;
	protected void setup(){
		c1= new Micomportamiento(c2,"c1");
		c2= new Micomportamiento(c1,"c2");
		addBehaviour(c1);
		addBehaviour(c2);
	}
	protected void takeDown(){
        System.out.println("Liberando REcursos");
    }
	private class Micomportamiento extends Behaviour{
		private int NumeroEjecuciones;
		private Micomportamiento out_comportamiento;
		private int ejecuciones;
		private String nombre;
		private Micomportamiento(Micomportamiento c,String n){
			super();
			out_comportamiento=c;
			nombre=n;
		}
		public void onStart(){
			NumeroEjecuciones=(int) (Math.random() * 100);
			ejecuciones=0;
			System.out.println("NumeroEjecuciones de "+nombre+" es: "+NumeroEjecuciones);

		}
		public void action(){
			ejecuciones++;
			System.out.println("Executing ejecucion "+ejecuciones+ " de Behaviour "+ nombre);
			if(ejecuciones==NumeroEjecuciones/2){
				out_comportamiento.block();
				System.out.println("El comportamiento "+nombre+" ha bloqueado al otro");
			}
			
		}
		public final boolean done(){
			return ejecuciones==NumeroEjecuciones;
		}
		public int onEnd(){
           System.out.println("Terminado");
           doDelete();
            return 0;
        }

	}





}