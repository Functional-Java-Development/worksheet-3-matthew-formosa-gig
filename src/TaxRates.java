import java.util.Map;

class TaxRates {

    private final static Map<Item.Type, Float> TAX_RATES = Map.of(Item.Type.ART, 0.05f, Item.Type.CONFECTIONARY, 0.06f, Item.Type.REPAIRS, 0.075f, Item.Type.PHARMACEUTICAL, 0f, Item.Type.GOODS, 0.18f);

    static Float getTaxRate(final Item.Type itemType) {
        return TAX_RATES.getOrDefault(itemType, 0.18f);
    }
}
