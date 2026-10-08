package api.tests;

import api.clients.UserApiClient;
import api.models.CreateUserRequest;

import api.base.ApiBaseTest;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class CreateUserTest extends ApiBaseTest  {

    @Test
    public void createUserTest() {

        CreateUserRequest request =
                new CreateUserRequest(
                        "Avinash",
                        "Automation Engineer"
                );

        UserApiClient userApiClient =
                new UserApiClient();

        Response response =
                userApiClient.createUser(
                        request
                );

        System.out.println(
                "Status Code: "
                        + response.getStatusCode()
        );

        System.out.println(
                response.getBody()
                        .asPrettyString()
        );

        Assert.assertEquals(
                response.getStatusCode(),
                201
        );

        String name =
                response
                    .jsonPath()
                    .getString("name");

        Assert.assertEquals(
                name,
                "Avinash"
        );
    }
}