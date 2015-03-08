/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookmvc.dao;

import com.swcguild.addressbookmvc.dto.Address;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface AddressBookDao
  {

    public void addAddress(Address address);
    public void removeAddress(int addressId);
    public void updateAddress(Address address);
    public List<Address> getAllAddresses();
    public Address getAddressById(int addressId);
    public List<Address> searchAddresses(Map<SearchTerm, String>criteria);
    
  }
