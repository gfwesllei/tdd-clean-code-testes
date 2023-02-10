package br.com.gfwesllei.calculator.controller;

import br.com.gfwesllei.calculator.response.ResultResponse;
import br.com.gfwesllei.calculator.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/calculator")
@RequiredArgsConstructor
public class CalculatorController {

  private final OperationService operationService;

  @GetMapping(value = "/sum/{numberOne}/{numberTwo}")
  public ResponseEntity<ResultResponse> sum(@PathVariable("numberOne") Double numberOne,
      @PathVariable("numberTwo") Double numberTwo) {
    return ResponseEntity.ok(new ResultResponse(operationService.sumValues(numberOne, numberTwo)));
  }

}
