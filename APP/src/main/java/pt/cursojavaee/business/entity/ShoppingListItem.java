package pt.cursojavaee.business.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by brunohorta on 10/01/16.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoppingListItem {

    /**
     * ATRIBUTOS
     * CONSTRUTORES
     * ENCAPSULAMENTO (GETTERS AND SETTERS)
     */

    private String description;
    private  int quantity;

    protected ShoppingListItem() {
    }

    public ShoppingListItem(String description, int quantity) {
        this.description = description;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
