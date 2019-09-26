import static java.lang.String.format;

public class Item {

    private final Type type;
    private final String name;
    private final float costPerUnit;
    private final float quantity;

    Item(final Type type, final String name, final float costPerUnit, final float quantity) {
        this.type = type;
        this.name = name;
        this.costPerUnit = costPerUnit;
        this.quantity = quantity;
    }

    Type getType() {
        return type;
    }

    float getCostPerUnit() {
        return costPerUnit;
    }

    float getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return format("%s item %s @%.2f per %.2f", type, name, costPerUnit, quantity);
    }

    enum Type {

        ART,
        CONFECTIONARY,
        REPAIRS,
        PHARMACEUTICAL,
        GOODS
    }
}
