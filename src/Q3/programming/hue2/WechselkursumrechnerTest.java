package Q3.programming.hue2;

import org.junit.jupiter.api.Test;

class WechselkursumrechnerTest {
    Wechselkursumrechner WKU = new Wechselkursumrechner();

    @Test
    void EUCtoUSDC() {
        assert(WKU.euroCentToUsdCent(100) == 119);
        assert(WKU.euroCentToUsdCent(50) == 59);
        assert(WKU.euroCentToUsdCent(200) == 238);
        assert(WKU.euroCentToUsdCent(0) == 0);
    }

    @Test
    void USDCtoEUC() {
        assert(WKU.usdCentToEuroCent(119) == 100);
        assert(WKU.usdCentToEuroCent(59) == 49);
        assert(WKU.usdCentToEuroCent(238) == 200);
        assert(WKU.usdCentToEuroCent(0) == 0);
    }

    // Yes, this doesn't account for negative numbers. Should be added.
}