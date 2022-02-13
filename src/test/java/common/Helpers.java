package common;

import static java.lang.Thread.sleep;

public class Helpers {
    public static void implicitWait(String countStr, String unit) throws InterruptedException {
        int count = Integer.parseInt(countStr);
        switch (unit) {
            case "mins":
                sleep((long) count * 60 * 1000);
                break;
            case "secs":
                sleep(count * 1000L);
                break;
            default:
                sleep(count);
        }
    }

}
