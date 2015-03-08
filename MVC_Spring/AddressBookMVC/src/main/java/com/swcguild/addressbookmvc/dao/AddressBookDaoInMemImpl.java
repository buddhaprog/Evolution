/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookmvc.dao;

import com.swcguild.addressbookmvc.dto.Address;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Helvinator
 */
public class AddressBookDaoInMemImpl implements AddressBookDao
  {

    private Map<Integer, Address> addressMap = new HashMap<>();
    private static int addressIdCounter = 0;

    @Override
    public void addAddress(Address address) {
        address.setAddressId(addressIdCounter++);
        addressMap.put(address.getAddressId(), address);
    }

    @Override
    public void removeAddress(int addressId) {
        addressMap.remove(addressId);
    }

    @Override
    public void updateAddress(Address address) {
        addressMap.put(address.getAddressId(), address);
    }

    @Override
    public List<Address> getAllAddresses() {
        Collection<Address> a = addressMap.values();
        return new ArrayList(a);
    }

    @Override
    public Address getAddressById(int addressId) {
        return addressMap.get(addressId);
    }

    @Override
    public List<Address> searchAddresses(Map<SearchTerm, String> criteria) {
        // Get all the search terms from the map
        String firstNameCriteria = criteria.get(SearchTerm.FIRST_NAME);
        String lastNameCriteria = criteria.get(SearchTerm.LAST_NAME);
        String streetAddressCriteria = criteria.get(SearchTerm.STREET_ADDRESS);
        String cityCriteria = criteria.get(SearchTerm.CITY);
        String stateCriteria = criteria.get(SearchTerm.STATE);
        String zipcodeCriteria = criteria.get(SearchTerm.ZIPCODE);

        // Declare all the predicate conditions
        Predicate<Address> firstNameMatches;
        Predicate<Address> lastNameMatches;
        Predicate<Address> streetAddressMatches;
        Predicate<Address> cityMatches;
        Predicate<Address> stateMatches;
        Predicate<Address> zipcodeMatches;
        // Placeholder predicate - always returns true.  Used for search terms
        // that are empty
        Predicate<Address> truePredicate = (a) -> {
            return true;
        };

        // Assign values to predicates.  If a given search term is empty, just
        // assign the default truePredicate, otherwise assign the predicate that
        // properly filters for the given term.
        firstNameMatches = (firstNameCriteria == null || firstNameCriteria.isEmpty())
                ? truePredicate
                : (a) -> a.getFirstName().equals(firstNameCriteria);

        lastNameMatches = (lastNameCriteria == null || lastNameCriteria.isEmpty())
                ? truePredicate
                : (a) -> a.getLastName().equals(lastNameCriteria);

        streetAddressMatches = (streetAddressCriteria == null || streetAddressCriteria.isEmpty())
                ? truePredicate
                : (a) -> a.getStreetAddress().equals(streetAddressCriteria);

        cityMatches = (cityCriteria == null || cityCriteria.isEmpty())
                ? truePredicate
                : (a) -> a.getCity().equals(cityCriteria);

        stateMatches = (stateCriteria == null || stateCriteria.isEmpty())
                ? truePredicate
                : (a) -> a.getState().equals(stateCriteria);
        zipcodeMatches = (zipcodeCriteria == null || zipcodeCriteria.isEmpty())
                ? truePredicate
                : (a) -> a.getZipcode().equals(zipcodeCriteria);

        // Return the list of Contacts that match the given criteria.  To do this we
        // just AND all the predicates together in a filter operation.
        return addressMap.values().stream()
                .filter(firstNameMatches
                        .and(lastNameMatches)
                        .and(streetAddressMatches)
                        .and(cityMatches)
                        .and(stateMatches)
                        .and(zipcodeMatches))
                .collect(Collectors.toList());
    }

  }
