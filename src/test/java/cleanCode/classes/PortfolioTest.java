package cleanCode.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortfolioTest {
    private FixedStockExchangeStub exchange;
    private Portfolio portfolio;

    @BeforeEach
    protected void setUp() {
        exchange = new FixedStockExchangeStub();
        exchange.fix("MSFT", 100);
        portfolio = new Portfolio(exchange);
    }

    @Test
    public void GivenFiveMSFTTotalShouldBe500() throws Exception {
       //portfolio.add(5, "MSFT");
        //Assert.assertEquals(500, portfolio.value());
    }

}