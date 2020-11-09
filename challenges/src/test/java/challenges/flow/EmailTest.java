package challenges.flow;

import static org.mockito.Mockito.mock;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import flow.Engine;
import flow.IAdapter;
import flow.IAgent;
import flow.samples.TextAdapter;

@RunWith(JUnit4.class)
public class EmailTest {

	  @Test
	  public void testRun_AdapterIsCompliantWithProtocol_AppHasHelloMessage() throws Exception {
	    IAgent user = mock(IAgent.class);
	    Map<String, IAdapter> adapters = new HashMap();
	    adapters.put("EMAIL", new TextAdapter());

	    EmailApp app = new EmailApp();
	    Engine engine = new Engine(user, adapters, app);
	    engine.run();
	    Assert.assertEquals("hello", app.popMessage());
	  }
	  
}