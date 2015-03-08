/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.bluraymvc.dao;

import com.swcguild.bluraymvc.dto.Bluray;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface BlurayDao
  {
    public void addBluray(Bluray bluray);
    public void removeBluray(int counterId);
    public void updateBluray(Bluray bluray);
    public List<Bluray> getAllBlurays();
    public Bluray getBlurayById(int counterId);
    public List<Bluray> searchBlurays(Map<SearchTerm, String>criteria);
  }
