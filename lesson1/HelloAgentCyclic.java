package ejemplo2;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class HelloAgentCyclic extends Agent{
	public void setup(){
		System.out.println("Hello. My name is "+getLocalName());
		  addBehaviour(new CyclicBehaviour() {
	    public void action(){
		ACLMessage msgRx=receive();
		while(true){
			
		}
		
		if(msgRx!=null){
		     System.out.println(msgRx);
		     ACLMessage msgTx=msgRx.createReply();
		     msgTx.setContent("Hello!");
		     send(msgTx);
		     
		}//if
		else{
		block();
		}
	      }
	    });
		
		
	
	    }//setup
	}//Agent
