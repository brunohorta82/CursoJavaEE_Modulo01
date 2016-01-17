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

    private long id;

    private String description;
    private  int quantity;

    protected ShoppingListItem() {
    }

    public ShoppingListItem(String description, int quantity) {
        this.description = description;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ShoppingListItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
