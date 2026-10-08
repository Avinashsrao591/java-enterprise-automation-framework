package api.clients;

import api.config.ApiSpec;

import api.models.CreateUserRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

@SuppressWarnings("unused")
public class UserApiClient {


    public Response getUsers(int page) {

        return given()
                .spec(
                        ApiSpec.requestSpec()
                )
                .queryParam("page", page)

            .when()

                .get("/api/users");
    }

   public Response createUser(
        CreateUserRequest request) {

    return given()
            .spec(
                    ApiSpec.requestSpec()
            )
            .body(request)

        .when()

            .post("/api/users");
}
}