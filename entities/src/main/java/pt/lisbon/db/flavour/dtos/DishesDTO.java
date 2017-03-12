package pt.lisbon.db.flavour.dtos;

import pt.lisbon.db.flavour.enums.DishesType;

/**
 * Created by José Carlos Campos Sousa on 10/03/2017.
 */
public class DishesDTO {

    private String name;
    private String description;
    private DishesType type;
    private float price;

    public DishesDTO(String name, String description, DishesType type, float price) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "DishesDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", price=" + price +
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

    public DishesType getType() {
        return type;
    }

    public void setType(DishesType type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
