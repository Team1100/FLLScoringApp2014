package edu.arhs.team1100.worldclass.objects;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author Eddie
 */
public class Match implements Serializable, Comparable {

    private int teamNumber;
    private int matchNumber;

    public Match() {

    }

    public Match(int tn, int mn, String type, int t) {
        teamNumber = tn;
        matchNumber = mn;
        matchType = type.toUpperCase();
        table = t;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    private boolean basketInBase;
    private boolean identicalPlusInBase;
    private boolean doorOpen;
    private int loopsOnScale;
    private boolean peopleAndModel;
    private boolean modelInCirlce;
    private boolean colorWheelSpun;
    private boolean correctColorRemoved;
    private boolean ballShot;
    private boolean ballTouchingMat;
    private boolean insertInstalled;
    private boolean robotNotTouchingModel;
    private boolean rightSensesNotTouchModel;
    private boolean sliderMoved;
    private boolean ideaModelNotTouching;
    private boolean bulbFacingUp;
    private boolean communityNotTouchingModel;
    private boolean SDCardUp;
    private boolean rotatedNinetyDegrees;
    private int penalties;
    private boolean yHandleMoved;
    private int scaleReading;
    private int table;
    private String matchType;
    private int score;
    private boolean saved;

    public boolean getSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public boolean isBasketInBase() {
        return basketInBase;
    }

    public void setBasketInBase(boolean basketInBase) {
        this.basketInBase = basketInBase;
    }

    public boolean isIdenticalPlusInBase() {
        return identicalPlusInBase;
    }

    public void setIdenticalPlusInBase(boolean identicalPlusInBase) {
        this.identicalPlusInBase = identicalPlusInBase;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    public void setDoorOpen(boolean doorOpen) {
        this.doorOpen = doorOpen;
    }

    public int getLoopsOnScale() {
        return loopsOnScale;
    }

    public void setLoopsOnScale(int loopsOnScale) {
        this.loopsOnScale = loopsOnScale;
    }

    public boolean isPeopleAndModel() {
        return peopleAndModel;
    }

    public void setPeopleAndModel(boolean peopleAndModel) {
        this.peopleAndModel = peopleAndModel;
    }

    public boolean isModelInCirlce() {
        return modelInCirlce;
    }

    public void setModelInCirlce(boolean modelInCirlce) {
        this.modelInCirlce = modelInCirlce;
    }

    public boolean isColorWheelSpun() {
        return colorWheelSpun;
    }

    public void setColorWheelSpun(boolean colorWheelSpun) {
        this.colorWheelSpun = colorWheelSpun;
    }

    public boolean isCorrectColorRemoved() {
        return correctColorRemoved;
    }

    public void setCorrectColorRemoved(boolean correctColorRemoved) {
        this.correctColorRemoved = correctColorRemoved;
    }

    public boolean isBallShot() {
        return ballShot;
    }

    public void setBallShot(boolean ballShot) {
        this.ballShot = ballShot;
    }

    public boolean isBallTouchingMat() {
        return ballTouchingMat;
    }

    public void setBallTouchingMat(boolean ballTouchingMat) {
        this.ballTouchingMat = ballTouchingMat;
    }

    public boolean isInsertInstalled() {
        return insertInstalled;
    }

    public void setInsertInstalled(boolean insertInstalled) {
        this.insertInstalled = insertInstalled;
    }

    public boolean isRobotNotTouchingModel() {
        return robotNotTouchingModel;
    }

    public void setRobotNotTouchingModel(boolean robotNotTouchingModel) {
        this.robotNotTouchingModel = robotNotTouchingModel;
    }

    public boolean isRightSensesNotTouchModel() {
        return rightSensesNotTouchModel;
    }

    public void setRightSensesNotTouchModel(boolean rightSensesNotTouchModel) {
        this.rightSensesNotTouchModel = rightSensesNotTouchModel;
    }

    public boolean isSliderMoved() {
        return sliderMoved;
    }

    public void setSliderMoved(boolean sliderMoved) {
        this.sliderMoved = sliderMoved;
    }

    public boolean isIdeaModelNotTouching() {
        return ideaModelNotTouching;
    }

    public void setIdeaModelNotTouching(boolean ideaModelNotTouching) {
        this.ideaModelNotTouching = ideaModelNotTouching;
    }

    public boolean isBulbFacingUp() {
        return bulbFacingUp;
    }

    public void setBulbFacingUp(boolean bulbFacingUp) {
        this.bulbFacingUp = bulbFacingUp;
    }

    public boolean isCommunityNotTouchingModel() {
        return communityNotTouchingModel;
    }

    public void setCommunityNotTouchingModel(boolean communityNotTouchingModel) {
        this.communityNotTouchingModel = communityNotTouchingModel;
    }

    public boolean isSDCardUp() {
        return SDCardUp;
    }

    public void setSDCardUp(boolean SDCardUp) {
        this.SDCardUp = SDCardUp;
    }

    public boolean isRotatedNinetyDegrees() {
        return rotatedNinetyDegrees;
    }

    public void setRotatedNinetyDegrees(boolean rotatedNinetyDegrees) {
        this.rotatedNinetyDegrees = rotatedNinetyDegrees;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public boolean isyHandleMoved() {
        return yHandleMoved;
    }

    public void setyHandleMoved(boolean yHandleMoved) {
        this.yHandleMoved = yHandleMoved;
    }

    public int getScaleReading() {
        return scaleReading;
    }

    public void setScaleReading(int scaleReading) {
        this.scaleReading = scaleReading;
    }

    @Override
    public int compareTo(Object o) {
        return score - ((Match)o).score;
    }
}
