package br.com.gfwesllei.calculator.controller;

import br.com.gfwesllei.calculator.response.ResultResponse;
import br.com.gfwesllei.calculator.service.OperationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/calculator")
@RequiredArgsConstructor
@Validated
public class CalculatorController {

  private final OperationService operationService;

  @GetMapping(value = "/sum/{numberOne}/{numberTwo}")
  public ResponseEntity<ResultResponse> sum(@PathVariable("numberOne") Double numberOne,
       @PathVariable("numberTwo") @NumberFormat(pattern = "[-+]?[0-9]*\\\\.?[0-9]+") Double numberTwo) {
    return ResponseEntity.ok(new ResultResponse(operationService.sumValues(numberOne, numberTwo)));
  }

}
