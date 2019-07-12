import helpers.TestBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task_19 extends TestBase {

    @Test
    void task_19() {
        app.addProductsToBasket();
        app.removeProductsFromBasket();
    }
}
