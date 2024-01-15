package main.behaviours;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.tools.testagent.TestAgent;
import jade.util.leap.ArrayList;

public class Receptor extends CyclicBehaviour {

	TestAgent superAgent;

	public Receptor(TestAgent a) {
		super(a);
		superAgent = a;
	}

	@Override
	public void action() {
		ACLMessage mesg = myAgent.receive();
		
		if (mesg == null) {
			this.block();
		} else {
			if ((mesg.getPerformative() == ACLMessage.INFORM) && mesg.getContent()!= null && mesg in ArrayList of aids) {
				display
			}
		}

	}

}
