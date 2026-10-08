package api.base;

import org.testng.annotations.BeforeClass;

public class ApiBaseTest {

    @BeforeClass
    public void apiSetUp() {

        System.out.println(
                "Starting API test suite..."
        );
    }
}