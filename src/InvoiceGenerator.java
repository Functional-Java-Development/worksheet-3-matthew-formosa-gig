class InvoiceGenerator {

    private static Invoice addItemToInvoice(final Invoice invoice, final Item item) {
        return new Invoice(invoice.getTotalCost() + (item.getCostPerUnit() * item.getQuantity()), invoice.getTotalTax() + (item.getCostPerUnit() * item.getQuantity() * TaxRates.getTaxRate(item.getType())), invoice.getTotalItems() + item.getQuantity());
    }

    private static Invoice accumulateInvoices(final Invoice firstInvoice, final Invoice secondInvoice) {
        return new Invoice(firstInvoice.getTotalCost() + secondInvoice.getTotalCost(), firstInvoice.getTotalTax() + secondInvoice.getTotalTax(), firstInvoice.getTotalItems() + secondInvoice.getTotalItems());
    }

    static Invoice generateInvoice(final ShoppingCart shoppingCart) {
        final var invoice = shoppingCart.getItems()
                .stream()
                .reduce(new Invoice(), InvoiceGenerator::addItemToInvoice, InvoiceGenerator::accumulateInvoices);
        return shoppingCart.getCouponCode()
                .flatMap(couponCode -> Vouchers.getVoucher(couponCode)
                        .map(voucher -> voucher.apply(invoice)))
                .orElse(invoice);
    }
}
