package edu.arhs.team1100.worldclass.objects;

import java.io.Serializable;

/**
 *
 * @author Eddie
 */
public class Team implements Serializable {

    private int teamNumber;
    private String location;
    private String name;
    private int fllNumber;

    public int getFllNumber() {
        return fllNumber;
    }

    public void setFllNumber(int fllNumber) {
        this.fllNumber = fllNumber;
    }

    public Team() {

    }

    public Team(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public Team(int teamNumber, String name) {
        this.teamNumber = teamNumber;
        this.name = name;
    }

    public Team(int teamNumber, String name, String location) {
        this.teamNumber = teamNumber;
        this.name = name;
        this.location = location;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    @Override
    public String toString() {
        return "" + teamNumber;
    }

}
