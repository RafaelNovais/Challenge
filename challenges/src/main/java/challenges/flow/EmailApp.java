package challenges.flow;

import java.util.LinkedList;
import java.util.Queue;

import cucumber.api.java.en.Then;

import flow.ActionException;
import flow.EventException;
import flow.IApp;
import flow.IEvent;
import flow.ProtocolException;

public class EmailApp implements IApp<String> {
  private Queue<String> messages;

  public EmailApp() {
    this.messages = new LinkedList<String>();
  }

@Then("The Message server should contain the \"hello\" message in the queue")
  public String in(IEvent event) throws EventException, ProtocolException, ActionException {
    String message = (String) event.trigger();
    if(!message.startsWith("MSG:")) {
      throw new ProtocolException();
    }

    messages.add(message.replace("MSG:", ""));
    return message;
  }

  public String popMessage() {
    String message = messages.remove();
    return message;
  }
}
