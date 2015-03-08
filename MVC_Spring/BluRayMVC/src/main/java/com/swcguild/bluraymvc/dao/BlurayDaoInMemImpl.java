/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.bluraymvc.dao;

import com.swcguild.bluraymvc.dto.Bluray;

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
public class BlurayDaoInMemImpl implements BlurayDao
  {

    private Map<Integer, Bluray> blurayMap = new HashMap<>();
    private static int counter = 0;

    public static final String COUNTER_FILE = "counter.txt";
    // creating a file to read/write the library to
    public static final String BLURAYLIBRARY_FILE = "bluraylibrary.txt";
    //This is what we're going to use to seperate our items in the file
    public static final String DELIMITER = "::";

    @Override
    public void addBluray(Bluray bluray) {
        bluray.setCounterId(counter++);
        blurayMap.put(bluray.getCounterId(), bluray);

    }

    @Override
    public void removeBluray(int counterId) {
        blurayMap.remove(counterId);
    }

    @Override
    public void updateBluray(Bluray bluray) {
        blurayMap.put(bluray.getCounterId(), bluray);
    }

    @Override
    public List<Bluray> getAllBlurays() {
        Collection<Bluray> a = blurayMap.values();
        return new ArrayList(a);
    }

    @Override
    public Bluray getBlurayById(int counterId) {
        return blurayMap.get(counterId);
    }

    @Override
    public List<Bluray> searchBlurays(Map<SearchTerm, String> criteria) {
// Get all the search terms from the map
        //TITLE, RELEASE_DATE, MPAA_RATING,DIRECTOR,STUDIO,USER_RATING
        String titleCriteria = criteria.get(SearchTerm.TITLE);
        String releaseDateCriteria = criteria.get(SearchTerm.RELEASE_DATE);
        String mpaaRatingCriteria = criteria.get(SearchTerm.MPAA_RATING);
        String directorCriteria = criteria.get(SearchTerm.DIRECTOR);
        String studioCriteria = criteria.get(SearchTerm.STUDIO);
        String userRatingCriteria = criteria.get(SearchTerm.USER_RATING);

        // Declare all the predicate conditions
        Predicate<Bluray> titleMatches;
        Predicate<Bluray> releaseDateMatches;
        Predicate<Bluray> mpaaRatingMatches;
        Predicate<Bluray> directorMatches;
        Predicate<Bluray> studioMatches;
        Predicate<Bluray> userRatingMatches;
        // Placeholder predicate - always returns true.  Used for search terms
        // that are empty
        Predicate<Bluray> truePredicate = (a) -> {
            return true;
        };

        // Assign values to predicates.  If a given search term is empty, just
        // assign the default truePredicate, otherwise assign the predicate that
        // properly filters for the given term.
        titleMatches = (titleCriteria == null || titleCriteria.isEmpty())
                ? truePredicate
                : (a) -> a.getTitle().equals(titleCriteria);

        releaseDateMatches = (releaseDateCriteria == null || releaseDateCriteria.isEmpty())
                ? truePredicate
                : (a) -> a.getReleaseDate().equals(releaseDateCriteria);

        mpaaRatingMatches = (mpaaRatingCriteria == null || mpaaRatingCriteria.isEmpty())
                ? truePredicate
                : (a) -> a.getMpaaRating().equals(mpaaRatingCriteria);

        directorMatches = (directorCriteria == null || directorCriteria.isEmpty())
                ? truePredicate
                : (a) -> a.getDirector().equals(directorCriteria);

        studioMatches = (studioCriteria == null || studioCriteria.isEmpty())
                ? truePredicate
                : (a) -> a.getStudio().equals(studioCriteria);
        userRatingMatches = (userRatingCriteria == null || userRatingCriteria.isEmpty())
                ? truePredicate
                : (a) -> a.getUserRating().equals(userRatingCriteria);

        // Return the list of Contacts that match the given criteria.  To do this we
        // just AND all the predicates together in a filter operation.
        return blurayMap.values().stream()
                .filter(titleMatches
                        .and(releaseDateMatches)
                        .and(mpaaRatingMatches)
                        .and(directorMatches)
                        .and(studioMatches)
                        .and(userRatingMatches))
                .collect(Collectors.toList());
    }
  }
