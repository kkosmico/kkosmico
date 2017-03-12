package pt.lisbon.db.flavour.entities;

import pt.lisbon.db.flavour.enums.DishesType;

import javax.persistence.*;


/**
 * Created by José Carlos Campos Sousa on 10/03/2017.
 */
@Entity
@Table(name="dishes")
public class Dishes extends Base{

    private String name;
    private String description;
    private float price;
    @Enumerated(EnumType.STRING)
    @Column
    private DishesType type;
    private boolean deleted;

    @Override
    public String toString() {
        return "Dishes{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", deleted=" + deleted +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public DishesType getType() {
        return type;
    }

    public void setType(DishesType type) {
        this.type = type;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
