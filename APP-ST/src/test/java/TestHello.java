import com.airhacks.rulz.jaxrsclient.JAXRSClientProvider;
import org.junit.Rule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by brunohorta on 10/01/16.
 */
public class TestHello {

    @Rule
    public JAXRSClientProvider provider = JAXRSClientProvider.buildWithURI("http://localhost:8080/cursojavaee-1.0/api");


    @Test
    public void testData(){
        Client client = provider.client();
        assertNotNull(client);
        WebTarget target = provider.target().path("hello/");
        assertNotNull(target);
        Response response = target.request(MediaType.TEXT_PLAIN).get();
        assertThat(response.getStatus(), is(200));
        String payload = response.readEntity(String.class);
        assertNotNull(payload);
        assertTrue(payload.contains("Data atual"));

    }




}
