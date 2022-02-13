package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.GUITestBase;

public class GuiHooks {

    private final String BASE_URL = "https://www.amazon.in/";

    @Before(value = "@GuiTest", order = 0)
    public void beforeScenario() {
        GUITestBase.setWebDriver("chrome", BASE_URL);
    }

    @After(value = "@GuiTest", order = 0)
    public void afterScenario() {
        GUITestBase.tearDown();
    }
}
