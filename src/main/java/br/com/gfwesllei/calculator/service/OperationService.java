package br.com.gfwesllei.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class OperationService {

  public double sumValues(double numberOne, double numberTwo) {
    return numberOne + numberTwo;
  }
}