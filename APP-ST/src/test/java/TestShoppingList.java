import com.airhacks.rulz.jaxrsclient.JAXRSClientProvider;
import org.junit.Rule;
import org.junit.Test;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by brunohorta on 10/01/16.
 */
public class TestShoppingList {


    @Rule
    public JAXRSClientProvider provider = JAXRSClientProvider.buildWithURI("http://localhost:8080/cursojavaee-1.0/api");


    @Test
    public void testGetAll() {

        WebTarget target = provider.target().path("shoppinglists/");
        assertNotNull(target);
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        assertThat(response.getStatus(), is(200));
        JsonArray payload = response.readEntity(JsonArray.class);
        assertNotNull(payload);
        assertFalse(payload.isEmpty());

        JsonObject item = payload.getValuesAs(JsonObject.class).get(0);
        assertThat(item.getString("description"),is("Cafe"));
        assertTrue(item.getString("description").equals("Cafe"));

    }
}
