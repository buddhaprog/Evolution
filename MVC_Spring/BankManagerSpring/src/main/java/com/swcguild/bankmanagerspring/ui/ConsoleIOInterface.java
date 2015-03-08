/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.bankmanagerspring.ui;

import java.time.LocalDate;

/**
 *
 * @author Helvinator
 */
public interface ConsoleIOInterface
  {

    double askForDouble(String prompt);

    double askForDoubleRange(String prompt, double min, double max);

    float askForFloat(String prompt);

    float askForFloatRange(String prompt, float min, float max);

    int askForInt(String prompt);

    int askForIntRange(String prompt, int min, int max);

    String askForString(String prompt);

    void print(String prompt);

    void println(String prompt);

    LocalDate readIsoDate(String prompt);
    
  }
