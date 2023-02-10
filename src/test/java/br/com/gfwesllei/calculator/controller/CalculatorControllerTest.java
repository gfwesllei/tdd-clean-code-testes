package br.com.gfwesllei.calculator.controller;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CalculatorControllerTest {

  @Autowired
  private WebTestClient webTestClient;

  @ParameterizedTest
  @MethodSource("generateNumbersToSum")
  void shouldSumValues(double numberOne, double numberTwo, double expectedResult) {

    webTestClient.get().uri("/api/calculator/sum/{numberOne}/{number2}", numberOne, numberTwo)
        .exchange()
        .expectStatus()
        .is2xxSuccessful()
        .expectBody()
        .jsonPath("$.result").isEqualTo(expectedResult);

  }

  private static Stream<Arguments> generateNumbersToSum() {
    return Stream.of(Arguments.of(1.0, 3.0, 4.0),
        Arguments.of(20.0, 3.0, 23.0),
        Arguments.of(1.3, 3.4, 4.7),
        Arguments.of(0.4, 0.6, 1.0));
  }

}
