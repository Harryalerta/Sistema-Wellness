package com.tc3wellness.Sistema.gateway;

import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

import com.github.javafaker.Faker;

import io.gatling.javaapi.core.CoreDsl;
import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.core.CoreDsl.global;
import static io.gatling.javaapi.core.CoreDsl.rampUsersPerSec;
import io.gatling.javaapi.core.OpenInjectionStep.RampRate.RampRateOpenInjectionStep;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpDsl;
import static io.gatling.javaapi.http.HttpDsl.http;
import io.gatling.javaapi.http.HttpProtocolBuilder;

public class CadastroProfissionalLoadTest extends Simulation {

        public CadastroProfissionalLoadTest() {

                setUp(buildPostScenario()
                                .injectOpen(injection())
                                .protocols(setupProtocol())).assertions(global().responseTime()
                                                .max()
                                                .lte(10000),
                                                global().successfulRequests()
                                                                .percent()
                                                                .gt(90d));
        }

        private static ScenarioBuilder buildPostScenario() {
                return CoreDsl.scenario("Load Cadastro Profissional Test")
                                .feed(feedData())
                                .exec(http("cadastrar-profissional").post("cadastro/profissional")
                                                .header("Content-Type", "application/json")
                                                .body(StringBody("{\r\n" + //
                                                                "  \"nome\": \"${nome}\",\r\n" + //
                                                                "  \"horarioAbertura\": \"01:00\",\r\n" + //
                                                                "  \"horarioFechamento\": \"03:00\",\r\n" + //
                                                                "  \"valor\": 500\r\n" + //
                                                                "}")));

        }

        private static Iterator<Map<String, Object>> feedData() {
                Faker faker = new Faker();
                Iterator<Map<String, Object>> iterator;
                iterator = Stream.generate(() -> {
                        Map<String, Object> stringObjectMap = new HashMap<>();
                        stringObjectMap.put("nome", faker.book()
                                        .title());
                        return stringObjectMap;
                }).iterator();

                return iterator;
        }

        private static HttpProtocolBuilder setupProtocol() {
                return HttpDsl.http.baseUrl("http://localhost:8080/")
                                .acceptHeader("application/json")
                                .maxConnectionsPerHost(10)
                                .userAgentHeader("Performance Test");
        }

        private RampRateOpenInjectionStep injection() {
                int totalUsers = 100;
                double userRampUpPerInterval = 10;
                double rampUpIntervalInSeconds = 5;

                int rampUptimeSeconds = 20;
                int duration = 40;
                return rampUsersPerSec(userRampUpPerInterval / (rampUpIntervalInSeconds)).to(totalUsers)
                                .during(Duration.ofSeconds(rampUptimeSeconds + duration));
        }
}
