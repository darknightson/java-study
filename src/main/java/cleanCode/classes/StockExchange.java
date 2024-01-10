package cleanCode.classes;

import cleanCode.function.Money;

public interface StockExchange {
    Money currentPrice(String symbol);
}
