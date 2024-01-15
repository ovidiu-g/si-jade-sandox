package main;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class TestAgent extends Agent {

	@Override
	protected void setup() {
		registration();
	}

	@Override
	protected void takeDown() {
		deregistration();
	}

	private void registration() {
		ServiceDescription sd = new ServiceDescription();
		sd.setType("chat-agent");
		sd.setName("chat");

		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(this.getAID());
		dfd.addServices(sd);
		try {
			DFService.register(this, dfd);
		} catch (FIPAException e) {
			System.out.println("Tragedy strikes: There is no DF service! The sky is falling, cats and dogs... Bye!");
			doDelete();
		}
	}

	private void deregistration() {
		try {
			DFService.deregister(this);
		} catch (FIPAException e) {
			// e.printStackTrace();
		}
	}

}
