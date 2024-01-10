package cleanCode.classes;

public class Portfolio {
    private final StockExchange stockExchange;

    public Portfolio(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
    }

    public StockExchange getStockExchange() {
        return stockExchange;
    }
}
