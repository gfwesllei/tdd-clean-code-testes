package br.com.gfwesllei.calculator.response;

import lombok.Data;

@Data
public class ResultResponse {

  private double result;

  public
  ResultResponse(double result) {
    this.result = result;
  }
}
