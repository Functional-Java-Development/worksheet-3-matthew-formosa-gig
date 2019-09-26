import static java.lang.String.format;

public class Invoice {

    private final float totalCost;
    private final float totalTax;
    private final float totalItems;

    Invoice() {
        this.totalCost = 0f;
        this.totalTax = 0f;
        this.totalItems = 0;
    }

    Invoice(final float totalCost, final float totalTax, final float totalItems) {
        this.totalCost = totalCost;
        this.totalTax = totalTax;
        this.totalItems = totalItems;
    }

    float getTotalCost() {
        return totalCost;
    }

    float getTotalTax() {
        return totalTax;
    }

    float getTotalItems() {
        return totalItems;
    }

    float getGrandTotal() {
        return totalCost + totalTax;
    }

    @Override
    public String toString() {
        return format("Total Items: %.2f; Total Cost: %.2f; Total Tax: %.2f; Grand Total: %.2f", totalItems, totalCost, totalTax, getGrandTotal());
    }
}
