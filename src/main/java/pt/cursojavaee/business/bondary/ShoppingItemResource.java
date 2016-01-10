package pt.cursojavaee.business.bondary;

import pt.cursojavaee.business.entity.ShoppingListItem;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brunohorta on 10/01/16.
 */
@Path("shoppinglists")
public class ShoppingItemResource {

    @GET
    @Produces("application/json")
    public List<ShoppingListItem> getAll() {
        List<ShoppingListItem> shoppingListItems = new ArrayList<>();
        shoppingListItems.add(new ShoppingListItem("Cafe", 100));
        shoppingListItems.add(new ShoppingListItem("Pizza", 50));
        return shoppingListItems;
    }
}
