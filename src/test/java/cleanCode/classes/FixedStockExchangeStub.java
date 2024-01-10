package cleanCode.classes;

import cleanCode.function.Money;

public class FixedStockExchangeStub implements StockExchange {
    public void fix(String msft, int i) {

    }

    @Override
    public Money currentPrice(String symbol) {
        return null;
    }
}
