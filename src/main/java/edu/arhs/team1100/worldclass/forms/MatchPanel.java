package edu.arhs.team1100.worldclass.forms;

import edu.arhs.team1100.worldclass.handlers.MatchHandler;
import edu.arhs.team1100.worldclass.objects.Match;
import java.awt.event.ActionEvent;

/**
 *
 * @author Eddie
 */
public class MatchPanel extends javax.swing.JPanel {

    private Match match;
    private int score;
    private int previousLoops;

    /**
     * Creates new form MatchPanel
     *
     * @param match the match to be loaded into the panel
     */
    public MatchPanel(Match match) {
        initComponents();
        this.match = match;
        loadMatch();
        score = 0;
        previousLoops = 0;
        updateScores();
    }

    /**
     * Creates new form MatchPanel
     */
    public MatchPanel() {
        initComponents();
        match = new Match();
        score = 0;
        previousLoops = 0;
    }

    private void loadMatch() {
        teamNumber.setText(match.getTeamNumber() + "");
        matchNumber.setText(match.getMatchNumber() + "");
        basketInBaseCB.setSelected(match.isBasketInBase());
        identicalPlusInBaseCB.setSelected(match.isIdenticalPlusInBase());
        doorOpenCB.setSelected(match.isDoorOpen());
        loopsOnScaleTF.setText(match.getLoopsOnScale() + "");
        peopleAndModelCB.setSelected(match.isPeopleAndModel());
        modelInCircleCB.setSelected(match.isModelInCirlce());
        colorWheelSpunCB.setSelected(match.isColorWheelSpun());
        correctColorRemovedCB.setSelected(match.isColorWheelSpun());
        ballShotCB.setSelected(match.isBallShot());
        ballTouchingMatCB.setSelected(match.isBallTouchingMat());
        insertInstalledCB.setSelected(match.isInsertInstalled());
        robotNotTouchingModelCB.setSelected(match.isRobotNotTouchingModel());
        rightSensesNotTouchingModelCB.setSelected(match.isRightSensesNotTouchModel());
        sliderMovedCB.setSelected(match.isSliderMoved());
        ideaModelNotTouchingCB.setSelected(match.isIdeaModelNotTouching());
        bulbFacingUp.setSelected(match.isBulbFacingUp());
        communityNotTouchingModelCB.setSelected(match.isCommunityNotTouchingModel());
        SDCardUpCB.setSelected(match.isSDCardUp());
        rotatedNinetyDegreesCB.setSelected(match.isRotatedNinetyDegrees());
        numberOfPenaltiesTF.setText(match.getPenalties() + "");
        yHandleMovedCB.setSelected(match.isyHandleMoved());
        scaleReadingTF.setText(match.getScaleReading() + "");
        tableNumber.setText(match.getTable() + "");
    }

    private void updateScores() {
        int reScore, odScore, pblScore, aScore, seScore, sScore, roboScore, rsScore, rcScore, obScore, clScore, caScore, acScore, pScore, eScore, readingScore;
        if (basketInBaseCB.isSelected()) {
            reScore = 30;
            if (identicalPlusInBaseCB.isSelected()) {
                reScore = 45;
            }
        } else {
            reScore = 0;
        }
        reverseEngineeringScore.setText(reScore + "");

        if (doorOpenCB.isSelected()) {
            odScore = 15;
        } else {
            odScore = 0;
        }
        openingDoorsScore.setText(odScore + "");     

        try {
            if (Integer.parseInt(loopsOnScaleTF.getText()) > 0) {
                pblScore = (Integer.parseInt(loopsOnScaleTF.getText()) + 1) * 10;
            } else {
                pblScore = 0;
            }
            projectBaseLearningScore.setText(pblScore + "");
        } catch (NumberFormatException e) {
            pblScore = 0;
        }

        if (peopleAndModelCB.isSelected()) {
            aScore = 20;
            if (modelInCircleCB.isSelected()) {
                aScore = 35;
            }
        } else {
            aScore = 0;
        }
        apprenticeshipScore.setText(aScore + "");

        if (colorWheelSpunCB.isSelected()) {
            seScore = 15;
            if (correctColorRemovedCB.isSelected()) {
                seScore = 60;
            }
        } else {
            seScore = 0;
        }
        searchEngineScore.setText(seScore + "");

        if (ballShotCB.isSelected()) {
            sScore = 30;
            if (ballTouchingMatCB.isSelected()) {
                sScore = 60;
            }
        } else {
            sScore = 0;
        }
        sportsScore.setText(sScore + "");

        if (insertInstalledCB.isSelected()) {
            roboScore = 25;
            if (robotNotTouchingModelCB.isSelected()) {
                roboScore = 55;
            }
        } else {
            roboScore = 0;
        }
        roboticsCompetitionScore.setText(roboScore + "");

        if (rightSensesNotTouchingModelCB.isSelected()) {
            rsScore = 40;
        } else {
            rsScore = 0;
        }
        rightSensesScore.setText(rsScore + "");

        if (sliderMovedCB.isSelected()) {
            rcScore = 40;
        } else {
            rcScore = 0;
        }
        remoteCommunicationsScore.setText(rcScore + "");

        if (ideaModelNotTouchingCB.isSelected()) {
            obScore = 25;
            if (bulbFacingUp.isSelected()) {
                obScore = 40;
            }
        } else {
            obScore = 0;
        }
        outsideTheBoxScore.setText(obScore + "");

        if (communityNotTouchingModelCB.isSelected()) {
            clScore = 25;
        } else {
            clScore = 0;
        }
        communityLearningScore.setText(clScore + "");

        if (SDCardUpCB.isSelected()) {
            caScore = 30;
        } else {
            caScore = 0;
        }
        cloudAccessScore.setText(caScore + "");

        if (rotatedNinetyDegreesCB.isSelected()) {
            acScore = 15;
        } else {
            acScore = 0;
        }
        adaptingToChangeScore.setText(acScore + "");

        try {
            int penalties = Integer.parseInt(numberOfPenaltiesTF.getText());
            if (penalties > 0) {
                pScore = -10 * penalties;
            } else {
                pScore = 0;
            }
        } catch (NumberFormatException e) {
            pScore = 0;
        }
        
        penaltiesScore.setText(pScore + "");

        if (yHandleMovedCB.isSelected()) {
            eScore = 20;
            try {
                int entanglementReading = Integer.parseInt(scaleReadingTF.getText());
                if (entanglementReading > 0) {
                    eScore = (int) (Math.round(entanglementReading / 100.0 * (reScore + odScore + pblScore + aScore + seScore + sScore + roboScore + rsScore + rcScore + obScore + clScore + caScore + acScore + pScore))) + 20;
                }
            } catch (NumberFormatException e) {
            }
        } else {
            eScore = 0;
        }
        engangementScore.setText(eScore + "");

        score = reScore + odScore + pblScore + aScore + seScore + sScore + roboScore + rsScore + rcScore + obScore + clScore + caScore + acScore + pScore + eScore;
        if (score < 0) {
            score = 0;
        }

        finalScore.setText(score + "");
    }

    public void saveMatch() {
        match.setBasketInBase(basketInBaseCB.isSelected());
        match.setIdenticalPlusInBase(identicalPlusInBaseCB.isSelected());
        match.setDoorOpen(doorOpenCB.isSelected());
        match.setLoopsOnScale(Integer.parseInt(loopsOnScaleTF.getText()));
        match.setPeopleAndModel(peopleAndModelCB.isSelected());
        match.setModelInCirlce(modelInCircleCB.isSelected());
        match.setColorWheelSpun(colorWheelSpunCB.isSelected());
        match.setCorrectColorRemoved(correctColorRemovedCB.isSelected());
        match.setBallShot(ballShotCB.isSelected());
        match.setBallTouchingMat(ballTouchingMatCB.isSelected());
        match.setInsertInstalled(insertInstalledCB.isSelected());
        match.setRobotNotTouchingModel(robotNotTouchingModelCB.isSelected());
        match.setRightSensesNotTouchModel(rightSensesNotTouchingModelCB.isSelected());
        match.setSliderMoved(sliderMovedCB.isSelected());
        match.setIdeaModelNotTouching(ideaModelNotTouchingCB.isSelected());
        match.setBulbFacingUp(bulbFacingUp.isSelected());
        match.setCommunityNotTouchingModel(communityNotTouchingModelCB.isSelected());
        match.setSDCardUp(SDCardUpCB.isSelected());
        match.setRotatedNinetyDegrees(rotatedNinetyDegreesCB.isSelected());
        match.setPenalties(Integer.parseInt(numberOfPenaltiesTF.getText()));
        match.setyHandleMoved(yHandleMovedCB.isSelected());
        match.setScaleReading(Integer.parseInt(scaleReadingTF.getText()));
        match.setScore(Integer.parseInt(finalScore.getText()));
        match.setSaved(true);
        
        MatchHandler.updateMatch(match);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        reverseEngineeringScore = new javax.swing.JLabel();
        basketInBaseCB = new javax.swing.JCheckBox();
        identicalPlusInBaseCB = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        openingDoorsScore = new javax.swing.JLabel();
        doorOpenCB = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        projectBaseLearningScore = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        peopleAndModelCB = new javax.swing.JCheckBox();
        modelInCircleCB = new javax.swing.JCheckBox();
        apprenticeshipScore = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        searchEngineScore = new javax.swing.JLabel();
        colorWheelSpunCB = new javax.swing.JCheckBox();
        correctColorRemovedCB = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        sportsScore = new javax.swing.JLabel();
        ballShotCB = new javax.swing.JCheckBox();
        ballTouchingMatCB = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        roboticsCompetitionScore = new javax.swing.JLabel();
        insertInstalledCB = new javax.swing.JCheckBox();
        robotNotTouchingModelCB = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        rightSensesScore = new javax.swing.JLabel();
        rightSensesNotTouchingModelCB = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        remoteCommunicationsScore = new javax.swing.JLabel();
        sliderMovedCB = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        outsideTheBoxScore = new javax.swing.JLabel();
        ideaModelNotTouchingCB = new javax.swing.JCheckBox();
        bulbFacingUp = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        communityLearningScore = new javax.swing.JLabel();
        communityNotTouchingModelCB = new javax.swing.JCheckBox();
        jLabel27 = new javax.swing.JLabel();
        cloudAccessScore = new javax.swing.JLabel();
        SDCardUpCB = new javax.swing.JCheckBox();
        jLabel29 = new javax.swing.JLabel();
        adaptingToChangeScore = new javax.swing.JLabel();
        rotatedNinetyDegreesCB = new javax.swing.JCheckBox();
        jLabel31 = new javax.swing.JLabel();
        penaltiesScore = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        numberOfPenaltiesTF = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        engangementScore = new javax.swing.JLabel();
        yHandleMovedCB = new javax.swing.JCheckBox();
        jLabel36 = new javax.swing.JLabel();
        scaleReadingTF = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        teamNumber = new javax.swing.JLabel();
        matchNumber = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        finalScore = new javax.swing.JLabel();
        loopsOnScaleTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tableNumber = new javax.swing.JLabel();

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel21.setText("0");

        jLabel1.setText("Team Number:");

        jLabel2.setText("Match:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Opening Doors");

        reverseEngineeringScore.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        reverseEngineeringScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        reverseEngineeringScore.setText("0");

        basketInBaseCB.setText("Basket in Base");
        basketInBaseCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basketInBaseCBActionPerformed(evt);
            }
        });

        identicalPlusInBaseCB.setText("Model in Base and Identical");
        identicalPlusInBaseCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identicalPlusInBaseCBActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("Reverse Engineering:");

        openingDoorsScore.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        openingDoorsScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        openingDoorsScore.setText("0");

        doorOpenCB.setText("Door Open");
        doorOpenCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doorOpenCBActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setText("Project Based Learning:");

        projectBaseLearningScore.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        projectBaseLearningScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        projectBaseLearningScore.setText("0");

        jLabel3.setText("Number of Loops on Scale:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setText("Apprenticeship:");

        peopleAndModelCB.setText("People Bound to Model");
        peopleAndModelCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peopleAndModelCBActionPerformed(evt);
            }
        });

        modelInCircleCB.setText("Model in White Circle");
        modelInCircleCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelInCircleCBActionPerformed(evt);
            }
        });

        apprenticeshipScore.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        apprenticeshipScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        apprenticeshipScore.setText("0");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel12.setText("Search Engine:");

        searchEngineScore.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        searchEngineScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        searchEngineScore.setText("0");

        colorWheelSpunCB.setText("Color Wheel Spun");
        colorWheelSpunCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorWheelSpunCBActionPerformed(evt);
            }
        });

        correctColorRemovedCB.setText("Correct Loop Removed");
        correctColorRemovedCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correctColorRemovedCBActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel14.setText("Sports:");

        sportsScore.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        sportsScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        sportsScore.setText("0");

        ballShotCB.setText("Ball Shot Towards Net");
        ballShotCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ballShotCBActionPerformed(evt);
            }
        });

        ballTouchingMatCB.setText("Ball Touches Net");
        ballTouchingMatCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ballTouchingMatCBActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel16.setText("Robotics Competition:");

        roboticsCompetitionScore.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        roboticsCompetitionScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        roboticsCompetitionScore.setText("0");

        insertInstalledCB.setText("Robotic Insert Installed");
        insertInstalledCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertInstalledCBActionPerformed(evt);
            }
        });

        robotNotTouchingModelCB.setText("Loop Not Touching Model");
        robotNotTouchingModelCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robotNotTouchingModelCBActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel18.setText("Using the Right Senses:");

        rightSensesScore.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        rightSensesScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        rightSensesScore.setText("0");

        rightSensesNotTouchingModelCB.setText("Loop Not Touching Model");
        rightSensesNotTouchingModelCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightSensesNotTouchingModelCBActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel20.setText("Remote Communications:");

        remoteCommunicationsScore.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        remoteCommunicationsScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        remoteCommunicationsScore.setText("0");

        sliderMovedCB.setText("Slider Pulled");
        sliderMovedCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sliderMovedCBActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel23.setText("Thinking Outside the Box:");

        outsideTheBoxScore.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        outsideTheBoxScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        outsideTheBoxScore.setText("0");

        ideaModelNotTouchingCB.setText("Idea Model Not Touching Box");
        ideaModelNotTouchingCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ideaModelNotTouchingCBActionPerformed(evt);
            }
        });

        bulbFacingUp.setText("Bulb Facing Up");
        bulbFacingUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bulbFacingUpActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel25.setText("Community Learning:");

        communityLearningScore.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        communityLearningScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        communityLearningScore.setText("0");

        communityNotTouchingModelCB.setText("Loop Not Touching Model");
        communityNotTouchingModelCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                communityNotTouchingModelCBActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel27.setText("Cloud Access:");

        cloudAccessScore.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        cloudAccessScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        cloudAccessScore.setText("0");

        SDCardUpCB.setText("SD is Up");
        SDCardUpCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SDCardUpCBActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel29.setText("Adapting To Change:");

        adaptingToChangeScore.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        adaptingToChangeScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        adaptingToChangeScore.setText("0");

        rotatedNinetyDegreesCB.setText("Model Rotated 90 Degrees");
        rotatedNinetyDegreesCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotatedNinetyDegreesCBActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel31.setText("Penalties:");

        penaltiesScore.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        penaltiesScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        penaltiesScore.setText("0");

        jLabel33.setText("Number of Penalties");

        numberOfPenaltiesTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfPenaltiesTFActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel34.setText("Engangement:");

        engangementScore.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        engangementScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        engangementScore.setText("0");

        yHandleMovedCB.setText("Yellow Handle Moved");
        yHandleMovedCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yHandleMovedCBActionPerformed(evt);
            }
        });

        jLabel36.setText("Scale Reading");

        scaleReadingTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scaleReadingTFActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel33)))
                            .addComponent(jLabel20)
                            .addComponent(jLabel18)
                            .addComponent(jLabel23)
                            .addComponent(jLabel25)
                            .addComponent(jLabel27)
                            .addComponent(jLabel29)
                            .addComponent(jLabel34)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel36)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(numberOfPenaltiesTF, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(engangementScore, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scaleReadingTF, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(penaltiesScore, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adaptingToChangeScore, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cloudAccessScore, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(communityLearningScore, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outsideTheBoxScore, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remoteCommunicationsScore, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightSensesScore, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yHandleMovedCB)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rightSensesNotTouchingModelCB)
                    .addComponent(sliderMovedCB)
                    .addComponent(ideaModelNotTouchingCB)
                    .addComponent(bulbFacingUp)
                    .addComponent(communityNotTouchingModelCB)
                    .addComponent(SDCardUpCB)
                    .addComponent(rotatedNinetyDegreesCB))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(rightSensesScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rightSensesNotTouchingModelCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(remoteCommunicationsScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderMovedCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(outsideTheBoxScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ideaModelNotTouchingCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bulbFacingUp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(communityLearningScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(communityNotTouchingModelCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(cloudAccessScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SDCardUpCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(adaptingToChangeScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rotatedNinetyDegreesCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(penaltiesScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(numberOfPenaltiesTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(engangementScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yHandleMovedCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(scaleReadingTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        teamNumber.setText("teamNumber");

        matchNumber.setText("matchNumber");

        jLabel5.setText("Final Score:");

        finalScore.setText("0");

        jLabel7.setText("Table:");

        tableNumber.setText("table");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(reverseEngineeringScore, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openingDoorsScore, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectBaseLearningScore, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loopsOnScaleTF, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apprenticeshipScore, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchEngineScore, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sportsScore, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roboticsCompetitionScore, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(insertInstalledCB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(robotNotTouchingModelCB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(ballShotCB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(ballTouchingMatCB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(correctColorRemovedCB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(colorWheelSpunCB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(peopleAndModelCB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(modelInCircleCB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(doorOpenCB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(basketInBaseCB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(identicalPlusInBaseCB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(teamNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(matchNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tableNumber)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finalScore)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(teamNumber)
                    .addComponent(matchNumber)
                    .addComponent(jLabel5)
                    .addComponent(finalScore)
                    .addComponent(jLabel7)
                    .addComponent(tableNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(reverseEngineeringScore))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(basketInBaseCB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(identicalPlusInBaseCB)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(openingDoorsScore))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doorOpenCB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(projectBaseLearningScore))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(loopsOnScaleTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(apprenticeshipScore))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(peopleAndModelCB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modelInCircleCB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(searchEngineScore))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colorWheelSpunCB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(correctColorRemovedCB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(sportsScore))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ballShotCB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ballTouchingMatCB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(roboticsCompetitionScore))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insertInstalledCB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(robotNotTouchingModelCB)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void basketInBaseCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basketInBaseCBActionPerformed
        updateScores();
    }//GEN-LAST:event_basketInBaseCBActionPerformed

    private void identicalPlusInBaseCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identicalPlusInBaseCBActionPerformed
        updateScores();
    }//GEN-LAST:event_identicalPlusInBaseCBActionPerformed

    private void doorOpenCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doorOpenCBActionPerformed
        updateScores();
    }//GEN-LAST:event_doorOpenCBActionPerformed

    private void peopleAndModelCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peopleAndModelCBActionPerformed
        updateScores();
    }//GEN-LAST:event_peopleAndModelCBActionPerformed

    private void modelInCircleCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelInCircleCBActionPerformed
        updateScores();
    }//GEN-LAST:event_modelInCircleCBActionPerformed

    private void colorWheelSpunCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorWheelSpunCBActionPerformed
        updateScores();
    }//GEN-LAST:event_colorWheelSpunCBActionPerformed

    private void correctColorRemovedCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correctColorRemovedCBActionPerformed
        updateScores();
    }//GEN-LAST:event_correctColorRemovedCBActionPerformed

    private void ballShotCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ballShotCBActionPerformed
        updateScores();
    }//GEN-LAST:event_ballShotCBActionPerformed

    private void ballTouchingMatCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ballTouchingMatCBActionPerformed
        updateScores();
    }//GEN-LAST:event_ballTouchingMatCBActionPerformed

    private void insertInstalledCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertInstalledCBActionPerformed
        updateScores();
    }//GEN-LAST:event_insertInstalledCBActionPerformed

    private void robotNotTouchingModelCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_robotNotTouchingModelCBActionPerformed
        updateScores();
    }//GEN-LAST:event_robotNotTouchingModelCBActionPerformed

    private void rightSensesNotTouchingModelCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightSensesNotTouchingModelCBActionPerformed
        updateScores();
    }//GEN-LAST:event_rightSensesNotTouchingModelCBActionPerformed

    private void sliderMovedCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sliderMovedCBActionPerformed
        updateScores();
    }//GEN-LAST:event_sliderMovedCBActionPerformed

    private void ideaModelNotTouchingCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ideaModelNotTouchingCBActionPerformed
        updateScores();
    }//GEN-LAST:event_ideaModelNotTouchingCBActionPerformed

    private void bulbFacingUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bulbFacingUpActionPerformed
        updateScores();
    }//GEN-LAST:event_bulbFacingUpActionPerformed

    private void communityNotTouchingModelCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_communityNotTouchingModelCBActionPerformed
        updateScores();
    }//GEN-LAST:event_communityNotTouchingModelCBActionPerformed

    private void SDCardUpCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SDCardUpCBActionPerformed
        updateScores();
    }//GEN-LAST:event_SDCardUpCBActionPerformed

    private void rotatedNinetyDegreesCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotatedNinetyDegreesCBActionPerformed
        updateScores();
    }//GEN-LAST:event_rotatedNinetyDegreesCBActionPerformed

    private void numberOfPenaltiesTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfPenaltiesTFActionPerformed
        updateScores();
    }//GEN-LAST:event_numberOfPenaltiesTFActionPerformed

    private void yHandleMovedCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yHandleMovedCBActionPerformed
        updateScores();
    }//GEN-LAST:event_yHandleMovedCBActionPerformed

    private void scaleReadingTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scaleReadingTFActionPerformed
        updateScores();
    }//GEN-LAST:event_scaleReadingTFActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        saveMatch();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void updateScoresOnEvent(ActionEvent evt){
        updateScores();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox SDCardUpCB;
    private javax.swing.JLabel adaptingToChangeScore;
    private javax.swing.JLabel apprenticeshipScore;
    private javax.swing.JCheckBox ballShotCB;
    private javax.swing.JCheckBox ballTouchingMatCB;
    private javax.swing.JCheckBox basketInBaseCB;
    private javax.swing.JCheckBox bulbFacingUp;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel cloudAccessScore;
    private javax.swing.JCheckBox colorWheelSpunCB;
    private javax.swing.JLabel communityLearningScore;
    private javax.swing.JCheckBox communityNotTouchingModelCB;
    private javax.swing.JCheckBox correctColorRemovedCB;
    private javax.swing.JCheckBox doorOpenCB;
    private javax.swing.JLabel engangementScore;
    private javax.swing.JLabel finalScore;
    private javax.swing.JCheckBox ideaModelNotTouchingCB;
    private javax.swing.JCheckBox identicalPlusInBaseCB;
    private javax.swing.JCheckBox insertInstalledCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField loopsOnScaleTF;
    private javax.swing.JLabel matchNumber;
    private javax.swing.JCheckBox modelInCircleCB;
    private javax.swing.JTextField numberOfPenaltiesTF;
    private javax.swing.JLabel openingDoorsScore;
    private javax.swing.JLabel outsideTheBoxScore;
    private javax.swing.JLabel penaltiesScore;
    private javax.swing.JCheckBox peopleAndModelCB;
    private javax.swing.JLabel projectBaseLearningScore;
    private javax.swing.JLabel remoteCommunicationsScore;
    private javax.swing.JLabel reverseEngineeringScore;
    private javax.swing.JCheckBox rightSensesNotTouchingModelCB;
    private javax.swing.JLabel rightSensesScore;
    private javax.swing.JCheckBox robotNotTouchingModelCB;
    private javax.swing.JLabel roboticsCompetitionScore;
    private javax.swing.JCheckBox rotatedNinetyDegreesCB;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField scaleReadingTF;
    private javax.swing.JLabel searchEngineScore;
    private javax.swing.JCheckBox sliderMovedCB;
    private javax.swing.JLabel sportsScore;
    private javax.swing.JLabel tableNumber;
    private javax.swing.JLabel teamNumber;
    private javax.swing.JCheckBox yHandleMovedCB;
    // End of variables declaration//GEN-END:variables

    public Match getMatch() {
        return match;
    }
}
