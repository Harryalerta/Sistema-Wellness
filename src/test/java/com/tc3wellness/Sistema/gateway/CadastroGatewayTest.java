package com.tc3wellness.Sistema.gateway;

import org.apache.http.HttpStatus;
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

@Sql("/setup.sql")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class CadastroGatewayTest {
        @LocalServerPort
        private int port;

        private final String uuidProfissional01 = "9a6b7c05-563d-40a4-baca-ee5217062b66";
        private final String uuidEspecialidade01 = "3fa85f64-5717-4562-b3fc-2c963f66afa6";
        private final String uuidEstabelecimento01 = "fd560d1d-b06a-4105-ac45-21a4338c0f5f";

        @BeforeAll
        @SuppressWarnings("unused")
        void setup() {
                RestAssured.port = port;
                RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        }

        @Test
        void testCadastrarEspecialidade() {
                String requestbody = """
                                {\r
                                  "nome": "string nome",\r
                                  "descricao": "string descricao"\r
                                }""";

                given().filter(new AllureRestAssured())
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .body(requestbody)
                                .when()
                                .post("/cadastro/especialidade")
                                .then()
                                .statusCode(HttpStatus.SC_OK)
                                .and()
                                .body("nome", equalTo("string nome"))
                                .body("descricao", equalTo("string descricao"));
        }

        @Test
        void testCadastrarProfissional() {
                String requestbody = """
                                {\r
                                  "nome": "nome string",\r
                                  "horarioAbertura": "01:00",\r
                                  "horarioFechamento": "02:00",\r
                                  "valor": 999\r
                                }""";

                given().filter(new AllureRestAssured())
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .body(requestbody)
                                .when()
                                .post("/cadastro/profissional")
                                .then()
                                .statusCode(HttpStatus.SC_OK)
                                .and()
                                .body("nome", equalTo("nome string"));
        }

        @Test
        void testaCadastroEstabelecimento() {
                String body = """
                                {\r
                                "nome": "TESTANDO INCLUSAO",\r
                                "endereco": "CASA DA MAE JOANA",\r
                                "horarioFechamento": "02:00",\r
                                "horarioAbertura": "AAAAAA"\r
                                }""";

                given().filter(new AllureRestAssured())
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .body(body)
                                .when()
                                .post("/cadastro/estabelecimento")
                                .then()
                                .statusCode(HttpStatus.SC_OK)
                                .and()
                                .body("nome", equalTo("TESTANDO INCLUSAO"))
                                .body("endereco", equalTo("CASA DA MAE JOANA"));
        }

        @Test
        void testVincularEspecialidade() {
                String requestbody = "{\r\n" + //
                                "  \"idProfissional\": \"" + this.uuidProfissional01 + "\",\r\n" + //
                                "  \"listaEspecialidades\": [\r\n" + //
                                "    \"" + this.uuidEspecialidade01 + "\"\r\n" + //
                                "  ]\r\n" + //
                                "}";

                given().filter(new AllureRestAssured())
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .body(requestbody)
                                .when()
                                .post("/cadastro/vincular_especialidade")
                                .then()
                                .statusCode(HttpStatus.SC_OK);
        }

        @Test
        void testVincularEstabelecimento() {
                String requestbody = "{\r\n" + //
                                "  \"idEstabelecimento\": \"" + this.uuidEstabelecimento01 + "\",\r\n" + //
                                "  \"listaProfissionais\": [\r\n" + //
                                "    \"" + this.uuidProfissional01 + "\"\r\n" + //
                                "  ]\r\n" + //
                                "}";

                given().filter(new AllureRestAssured())
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .body(requestbody)
                                .when()
                                .post("/cadastro/vincular_estabelecimento")
                                .then()
                                .statusCode(HttpStatus.SC_OK);
        }
}
