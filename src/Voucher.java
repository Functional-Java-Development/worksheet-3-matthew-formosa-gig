import java.util.function.Predicate;

import static java.lang.String.format;

public class Voucher {

    private final String description;
    private final String voucherCode;
    private final float discount;
    private final Predicate<Invoice> isApplicable;

    Voucher(final String description, final String voucherCode, final float discount, final Predicate<Invoice> isApplicable) {
        this.description = description;
        this.voucherCode = voucherCode;
        this.discount = discount;
        this.isApplicable = isApplicable;
    }

    String getDescription() {
        return description;
    }

    String getVoucherCode() {
        return voucherCode;
    }

    float getDiscount() {
        return discount;
    }

    Invoice apply(final Invoice invoice) {
        if (isApplicable.test(invoice)) {
            return new Invoice(invoice.getTotalCost() - (discount * invoice.getTotalCost()), invoice.getTotalTax() - (discount * invoice.getTotalTax()), invoice.getTotalItems());
        }
        return invoice;
    }

    @Override
    public String toString() {
        return format("Voucher Description: %s; Voucher Code: %s; Voucher Discount: %.2f", description, voucherCode, discount);
    }
}
