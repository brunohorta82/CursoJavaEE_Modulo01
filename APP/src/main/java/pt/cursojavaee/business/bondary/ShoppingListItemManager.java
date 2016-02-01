package pt.cursojavaee.business.bondary;

import pt.cursojavaee.business.entity.ShoppingListItem;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brunohorta on 01/02/16.
 */
@Stateful
public class ShoppingListItemManager {

    @PersistenceContext
    private EntityManager em;

    public ShoppingListItem save(ShoppingListItem shoppingListItem) {
        return em.merge(shoppingListItem);
    }


    public ShoppingListItem get(long id) {
        return em.find(ShoppingListItem.class, id);
    }

    public List<ShoppingListItem> getAll() {
        //TODO PROXIMA AULA
        return new ArrayList<>();
    }

    public void remove(long id) throws ShoppingItemNotFoundException {
        try {
            em.remove(em.getReference(ShoppingListItem.class, id));
        }catch (EntityNotFoundException x){
            throw new ShoppingItemNotFoundException();
        }
    }
}
