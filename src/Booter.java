import java.util.List;

public class Booter {

    public static void main(final String[] args) {
        generateInvoices(List.of(
                new Item(Item.Type.CONFECTIONARY, "Cake", 3.5f, 1),
                new Item(Item.Type.CONFECTIONARY, "Flour", 0.8f, 2.5f),
                new Item(Item.Type.ART, "Painting", 100.0f, 2),
                new Item(Item.Type.GOODS, "TV", 350.0f, 1),
                new Item(Item.Type.PHARMACEUTICAL, "Paracetamol", 2.1f, 4),
                new Item(Item.Type.REPAIRS, "Computer Repair", 35.0f, 1)));

        generateInvoices(List.of(
                new Item(Item.Type.CONFECTIONARY, "Flour", 0.8f, 2.5f),
                new Item(Item.Type.PHARMACEUTICAL, "Paracetamol", 2.1f, 4),
                new Item(Item.Type.REPAIRS, "Computer Repair", 35.0f, 1)));
    }

    private static void generateInvoices(final List<Item> items) {
        System.out.println(InvoiceGenerator.generateInvoice(new ShoppingCart(items, null)));
        System.out.println(InvoiceGenerator.generateInvoice(new ShoppingCart(items, "10POFF50E")));
        System.out.println(InvoiceGenerator.generateInvoice(new ShoppingCart(items, "5POFF10I")));
        System.out.println(InvoiceGenerator.generateInvoice(new ShoppingCart(items, "12312412")));
    }
}
