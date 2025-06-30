package com.tc3wellness.Sistema.gateway;

import org.apache.http.HttpStatus;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

@Sql("classpath:setup.sql")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class ConsultaGatewayTest {
    @LocalServerPort
    private int port;

    private final String uuidProfissional01 = "9a6b7c05-563d-40a4-baca-ee5217062b66";
    private final String uuidProfissional02 = "38d6f891-cb51-402d-88d6-24c326ba2e52";
    private final String uuidEspecialidade01 = "3fa85f64-5717-4562-b3fc-2c963f66afa6";
    private final String uuidEstabelecimento01 = "fd560d1d-b06a-4105-ac45-21a4338c0f5f";

    @BeforeAll
    @SuppressWarnings("unused")
    void setup() {
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void testEstabelecimentoPorId() {

        given().filter(new AllureRestAssured())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .get("/consulta/estabelecimento/" + uuidEstabelecimento01)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("nome", equalTo("ESTABELECIMENTO TESTE 01"))
                .body("endereco", equalTo("ENDERECO DE TESTE 01"));
    }

    @Test
    void testProfissionalPorId() {

        given().filter(new AllureRestAssured())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .get("/consulta/profissional/" + uuidProfissional01)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("nome", equalTo("TESTE 01"));
    }

    @Test
    void testProfissionalComEspecialidadesPorId() {

        given().filter(new AllureRestAssured())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .get("/consulta/profissional/" + uuidProfissional02)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("nome", equalTo("TESTE 02"))
                .body( containsString("MANICORES"));
    }
}
