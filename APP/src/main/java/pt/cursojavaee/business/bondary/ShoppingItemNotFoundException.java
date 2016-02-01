package pt.cursojavaee.business.bondary;

import javax.ejb.ApplicationException;

/**
 * Created by brunohorta on 01/02/16.
 */
@ApplicationException(rollback = true)
public class ShoppingItemNotFoundException  extends Exception{

    public ShoppingItemNotFoundException() {
        super("Item not found in database");
    }
}
