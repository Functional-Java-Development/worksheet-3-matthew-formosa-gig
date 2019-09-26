import java.util.List;
import java.util.Optional;

class ShoppingCart {

    private final List<Item> items;
    private final String couponCode;

    ShoppingCart(final List<Item> items, final String couponCode) {
        this.items = items;
        this.couponCode = couponCode;
    }

    List<Item> getItems() {
        return items;
    }

    Optional<String> getCouponCode() {
        return Optional.ofNullable(couponCode);
    }
}
