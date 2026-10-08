package api.config;

import framework.utils.ConfigReader;

import static io.restassured.filter.log.LogDetail.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

import io.restassured.http.ContentType;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

@SuppressWarnings("unused")
public class ApiSpec {

    public static RequestSpecification requestSpec() {

    return new RequestSpecBuilder()

            .setBaseUri(
                    ConfigReader.getProperty(
                            "apiBaseUrl"
                    )
            )

            .setContentType(
                    ContentType.JSON
            )

            .setAccept(
                    ContentType.JSON
            )

            .build();
}
    public static ResponseSpecification responseSpec() {

        return new ResponseSpecBuilder()

                .expectContentType(
                        ContentType.JSON
                )

                .build();
    }
}