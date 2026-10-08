package api.tests;

import api.config.ApiSpec;

import api.base.ApiBaseTest;

import api.clients.UserApiClient;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class GetUsersTest extends ApiBaseTest  {

    @Test(groups = {"api", "regression"})
    public void getUsersTest() {

        UserApiClient userApiClient =
                new UserApiClient();

       Response response =
        userApiClient.getUsers(2);

        System.out.println(
                "Status Code: "
                        + response.getStatusCode()
        );

        Assert.assertEquals(
                response.getStatusCode(),
                200
        );

        String firstUserEmail =
                response
                    .jsonPath()
                    .getString(
                        "data[0].email"
                    );

        System.out.println(
                "First User Email: "
                        + firstUserEmail
        );

        Assert.assertNotNull(
                firstUserEmail,
                "User email should not be null"
        );
    }
}