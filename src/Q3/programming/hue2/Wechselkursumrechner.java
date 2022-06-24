package Q3.programming.hue2;

public class Wechselkursumrechner {

    // 100EuroCent = 119USDCent

    private final int exchangeRateEUCtoUSDC = 119;

    /** Function to convert EuroCent to USDCent
     *
     * @param euroCent [[int]] MUST BE >= 0
     * @return [[int]] converted USDCent
     */
    public int euroCentToUsdCent(int euroCent) {
        return (euroCent * exchangeRateEUCtoUSDC) / 100;
    }

    /** Function to convert USDCent to EuroCent
     *
     * @param usdCent [[int]] MUST BE >= 0
     * @return [[int]] converted EuroCent
     */
    public int usdCentToEuroCent(int usdCent) {
        return (100 * usdCent) / exchangeRateEUCtoUSDC;
    }

}
