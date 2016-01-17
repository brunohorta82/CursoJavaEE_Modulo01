package pt.cursojavaee.business.bondary;

import pt.cursojavaee.business.entity.ShoppingListItem;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brunohorta on 10/01/16.
 */
@Path("shoppinglists")
public class ShoppingItemResource {

    @GET
    @Produces({"application/json", "application/xml"})
    public List<ShoppingListItem> getAll() {
        List<ShoppingListItem> shoppingListItems = new ArrayList<>();
        shoppingListItems.add(new ShoppingListItem("Cafe", 100));
        shoppingListItems.add(new ShoppingListItem("Pizza", 50));
        return shoppingListItems;

    }

    /**
     * FIND ID GET /id
     * SAVE  POST (objeto para guardar)
     * UPDATE PUT /id (objecto para alterar)
     * DELETE ID  DELETE /id
     */

    @GET
    @Path("{id}")
    public ShoppingListItem find(@PathParam("id") long id) {
        ShoppingListItem bolachas = new ShoppingListItem("BOLACHAS", 20);
        bolachas.setId(100);
        return bolachas;
    }

    @POST
    @Consumes("application/json")
    public Response save(ShoppingListItem shoppingListItem, @Context UriInfo uriInfo) {
        shoppingListItem.setId(1);
        System.out.println("SAVED " + shoppingListItem);
        URI uri = uriInfo.getAbsolutePathBuilder().path("/" + shoppingListItem.getId()).build();
        return Response.created(uri).entity(shoppingListItem).build();
    }

    @PUT
    @Path("{id}")
    public ShoppingListItem update(@PathParam("id") long id, ShoppingListItem shoppingListItem) {
        shoppingListItem.setId(id);
        System.out.println("UPDATED " + shoppingListItem);
        return shoppingListItem;
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") long id) {
        System.out.println("DELETED OBJECT WITH ID " + id);
        return Response.ok().build();
    }

}
