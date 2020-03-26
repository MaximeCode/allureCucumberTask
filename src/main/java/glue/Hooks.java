package glue;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.Init;

public class Hooks {

    @After
    public void shutDown() {
        Init.shutDown();
    }
}
