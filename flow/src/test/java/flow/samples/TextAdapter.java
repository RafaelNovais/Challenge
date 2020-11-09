package flow.samples;

import cucumber.api.java.en.When;
import flow.*;

public class TextAdapter implements IAdapter<IAction> {
	@When("The message is converted by the Adapter")
  public IEvent adapt(IAction action) throws ActionException {
    String value = (String) action.execute();
    return new TextEvent(value);
  }
}
