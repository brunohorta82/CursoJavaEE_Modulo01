import com.airhacks.rulz.jaxrsclient.JAXRSClientProvider;
import org.junit.Rule;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
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
        assertThat(item.getString("description"), is("Cafe"));
        assertTrue(item.getString("description").equals("Cafe"));

    }

    @Test
    public void testCRUD() {

        //CREATE

        WebTarget target = provider.target().path("shoppinglists");
        assertNotNull(target);

        JsonObject sList = Json.createObjectBuilder()
                .add("description", "chocolate")
                .add("quantity", 10).build();

        Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.json(sList));

        assertThat(response.getStatus(), is(201));

        JsonObject payload = response.readEntity(JsonObject.class);

        assertNotNull(payload);

        assertThat(payload.getJsonNumber("id").longValue(), is(1L));

        //UPDATE

        target = provider.target().path("shoppinglists/1");
        assertNotNull(target);

        sList = Json.createObjectBuilder()
                .add("description", "chocolate branco")
                .add("quantity", 11).build();

        response = target.request(MediaType.APPLICATION_JSON).put(Entity.json(sList));

        assertThat(response.getStatus(), is(200));

        payload = response.readEntity(JsonObject.class);

        assertNotNull(payload);

        assertThat(payload.getJsonNumber("id").longValue(), is(1L));
        assertThat(payload.getInt("quantity"), is(11));
        assertThat(payload.getString("description"), is("chocolate branco"));
        //FIND BY ID
        target = provider.target().path("shoppinglists/1");
        assertNotNull(target);

        response = target.request(MediaType.APPLICATION_JSON).get();

        assertThat(response.getStatus(), is(200));

        payload = response.readEntity(JsonObject.class);

        assertNotNull(payload);

        assertThat(payload.getJsonNumber("id").longValue(), is(1L));
        assertThat(payload.getString("description"), is("chocolate branco"));
        assertThat(payload.getInt("quantity"), is(11));


        //REMOVE
        target = provider.target().path("shoppinglists/1");
        assertNotNull(target);

        response = target.request(MediaType.APPLICATION_JSON).delete();

        assertThat(response.getStatus(), is(200));

        //REMOVE INVALID ITEM
        target = provider.target().path("shoppinglists/1");
        assertNotNull(target);

        response = target.request(MediaType.APPLICATION_JSON).delete();

        assertThat(response.getStatus(), is(204));

    }

    @Test
    public void testWithInvalidDescription() {
        WebTarget target = provider.target().path("shoppinglists");
        assertNotNull(target);

        JsonObject sList = Json.createObjectBuilder()
                .addNull("description")
                .add("quantity", 10).build();

        Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.json(sList));

        assertThat(response.getStatus(), is(400));
        JsonObject payload = response.readEntity(JsonObject.class);
        System.out.println(payload);
    }

    @Test
    public void testWithInvalidQuantity() {
        WebTarget target = provider.target().path("shoppinglists");
        assertNotNull(target);

        JsonObject sList = Json.createObjectBuilder()
                .add("description","Bolachas")
                .add("quantity", -1).build();

        Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.json(sList));

        assertThat(response.getStatus(), is(400));
        JsonObject payload = response.readEntity(JsonObject.class);
        System.out.println(payload);
    }


}
