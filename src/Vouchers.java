import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toMap;

class Vouchers {

    private static final List<Voucher> VOUCHERS = List.of(new Voucher("10% off €50 or more", "10POFF50E", 0.1f, (invoice) -> invoice.getGrandTotal() >= 50f), new Voucher("5% off 10 items or more", "5POFF10I", 0.05f, (invoice) -> invoice.getTotalItems() >= 10));
    private static final Map<String, Voucher> VOUCHER_MAP = VOUCHERS.stream().collect(toMap(Voucher::getVoucherCode, voucher -> voucher));

    static Optional<Voucher> getVoucher(final String discountCode) {
        return Optional.ofNullable(VOUCHER_MAP.get(discountCode));
    }
}
