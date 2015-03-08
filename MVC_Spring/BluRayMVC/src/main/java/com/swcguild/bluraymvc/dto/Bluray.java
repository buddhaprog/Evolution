/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.bluraymvc.dto;

import java.util.Objects;

/**
 *
 * @author Helvinator
 */
public class Bluray {
    
private int counterId;
private String title;
private String releaseDate;
private String mpaaRating;
private String director;
private String studio;
private String userRating;
private String userNotes;


@Override
    public String toString() { //fix how this looks with some escape sequences
        return "Bluray{" + "counterId=" + counterId + 
                ", title=" + title + 
                ", releaseDate=" + releaseDate + 
                ", mpaaRating=" + mpaaRating + 
                ", director=" + director +
                ", studio=" + studio + 
                ", userRating=" + userRating + 
                ", userNotes=" + userNotes + '}';
    }
    
    public boolean titleMatch(String checkme) {
    	return this.title.equals(checkme);}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.counterId;
        hash = 79 * hash + Objects.hashCode(this.title);
        hash = 79 * hash + Objects.hashCode(this.releaseDate);
        hash = 79 * hash + Objects.hashCode(this.mpaaRating);
        hash = 79 * hash + Objects.hashCode(this.director);
        hash = 79 * hash + Objects.hashCode(this.studio);
        hash = 79 * hash + Objects.hashCode(this.userRating);
        hash = 79 * hash + Objects.hashCode(this.userNotes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bluray other = (Bluray) obj;
        if (this.counterId != other.counterId) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.mpaaRating, other.mpaaRating)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.userRating, other.userRating)) {
            return false;
        }
        if (!Objects.equals(this.userNotes, other.userNotes)) {
            return false;
        }
        return true;
    }


    public int getCounterId() {
        return counterId;
    }

    public void setCounterId(int counterId) {
        this.counterId = counterId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getUserNotes() {
        return userNotes;
    }

    public void setUserNotes(String userNotes) {
        this.userNotes = userNotes;
    }
    

}

    