/*
 * Copyright (C) 2014 Eddie
 */
package edu.arhs.team1100.worldclass.forms;

import edu.arhs.team1100.worldclass.handlers.MatchHandler;
import edu.arhs.team1100.worldclass.handlers.TeamHandler;
import edu.arhs.team1100.worldclass.objects.Match;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Eddie
 */
public class RankingFrame extends JFrame {

    private Integer[][] rank;
    private UpdateThread updating;
    private Cursor invisibleCursor;
    private boolean invisMouse = false;
    private int fontSizeOffest = 2;

    /**
     * Creates new form RankingAndMatchesFrame
     */
    public RankingFrame() {

        //Creates a new Thread to update the scores
        updating = new UpdateThread(this);

        //setUndecorated(true);
        initComponents();
        setResizable(false);
        //setAlwaysOnTop(true);
        //setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(1080, 720);
        invisibleCursor = Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(1, 1, BufferedImage.TRANSLUCENT), new Point(0, 0), "InvisibleCursor");
        //setCursor(invisibleCursor);

        rankTable.setDefaultRenderer(String.class, new RowHighlightCellRenderer());

        rankTable.setBackground(Color.white);

        JTableHeader header = rankTable.getTableHeader();
        header.setSize(header.getWidth(), getHeight() / 24);
        header.setFont(new Font("Tahoma", 0, header.getHeight() - fontSizeOffest));

        rankTable.setRowHeight((getHeight() - header.getHeight()) / 24 - 1);
        rankTable.setFont(new Font("Tahoma", 0, (getHeight() - header.getHeight()) / 24 - fontSizeOffest));

        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        header.setDefaultRenderer(renderer);

        rankTable.setSelectionModel(new ListSelectionModel() {

            public boolean isSelectionEmpty() {
                return true;
            }

            public boolean isSelectedIndex(int index) {
                return false;
            }

            public int getMinSelectionIndex() {
                return -1;
            }

            public int getMaxSelectionIndex() {
                return -1;
            }

            public int getLeadSelectionIndex() {
                return -1;
            }

            public int getAnchorSelectionIndex() {
                return -1;
            }

            public void setSelectionInterval(int index0, int index1) {
            }

            public void setLeadSelectionIndex(int index) {
            }

            public void setAnchorSelectionIndex(int index) {
            }

            public void addSelectionInterval(int index0, int index1) {
            }

            public void insertIndexInterval(int index, int length, boolean before) {
            }

            public void clearSelection() {
            }

            public void removeSelectionInterval(int index0, int index1) {
            }

            public void removeIndexInterval(int index0, int index1) {
            }

            public void setSelectionMode(int selectionMode) {
            }

            public int getSelectionMode() {
                return SINGLE_SELECTION;
            }

            public void addListSelectionListener(ListSelectionListener lsl) {
            }

            public void removeListSelectionListener(ListSelectionListener lsl) {
            }

            public void setValueIsAdjusting(boolean valueIsAdjusting) {
            }

            public boolean getValueIsAdjusting() {
                return false;
            }
        }
        );

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                updating.shutdown();

            }
        });

        setVisible(true);
    }

    public void startUpdating() {
        if (!updating.isAlive()) {
            updating.start();
        }
    }

    public void updateRank() {
        rank = new Integer[24][6];
        for (int i = 0; i < 24; i++) {
            rank[i][0] = i + 1;
            List<Match> matches = MatchHandler.getSavedMatches(i + 1);
            if (matches.size() > 0) {
                Collections.sort(matches);
                rank[i][1] = matches.get(4).getScore();
                rank[i][2] = matches.get(3).getScore();
                rank[i][3] = matches.get(2).getScore();
                rank[i][4] = matches.get(1).getScore();
                rank[i][5] = matches.get(0).getScore();
            } else {
                rank[i][1] = 0;
                rank[i][2] = 0;
                rank[i][3] = 0;
                rank[i][4] = 0;
                rank[i][5] = 0;
            }
        }
        Arrays.sort(rank, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o2[1].compareTo(o1[1]) != 0) {
                    return o2[1].compareTo(o1[1]);
                } else if (o2[2].compareTo(o1[2]) != 0)
                    return o2[2].compareTo(o1[2]);
                else if (o2[3].compareTo(o1[3]) != 0)
                    return o2[3].compareTo(o1[3]);
                else if (o2[4].compareTo(o1[4]) != 0)
                    return o2[4].compareTo(o1[4]);
                else {
                    return o2[5].compareTo(o1[5]);
                }
                //return o2[1].compareTo(o1[1]);
            }

        });
        DefaultTableModel model = (DefaultTableModel) rankTable.getModel();
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (int i = 0; i < 24; i++) {
            int teamNumber = rank[i][0];
            String name = TeamHandler.getTeamByNumnber(teamNumber).getName();
            String highScore = "";
            List<Match> matches = MatchHandler.getSavedMatches(teamNumber);
            if (matches.size() > 0) {
                Match highScoreMatch = Collections.max(matches);
                highScore = highScoreMatch.getScore() + "";
            }
            String[] matchScore = {"", "", "", "", ""};
            for (int j = 0; j < matches.size(); j++) {
                matchScore[j] = matches.get(j).getScore() + "";
            }
            model.addRow(new Object[]{i + 1, name, highScore, matchScore[0], matchScore[1], matchScore[2], matchScore[3], matchScore[4]});

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        rankTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        rankTable.setBackground(java.awt.SystemColor.control);
        rankTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rank", "Team Name", "High Score", "Match 1", "Match 2", "Match 3", "Match 4", "Match 5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rankTable.getTableHeader().setReorderingAllowed(false);
        rankTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rankTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(rankTable);
        if (rankTable.getColumnModel().getColumnCount() > 0) {
            rankTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            rankTable.getColumnModel().getColumn(1).setPreferredWidth(400);
            rankTable.getColumnModel().getColumn(2).setPreferredWidth(125);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rankTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rankTableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_M && evt.isControlDown()) {
            if (invisMouse) {
                setCursor(Cursor.getDefaultCursor());
            } else {
                setCursor(invisibleCursor);
            }
            invisMouse = !invisMouse;
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            updating.shutdown();
            dispose();
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            changeFont(true);
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            changeFont(false);
        } else if (evt.getKeyCode() == KeyEvent.VK_U && evt.isControlDown()) {
            System.out.println("updaing");
            updateRank();
        }
    }//GEN-LAST:event_rankTableKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable rankTable;
    // End of variables declaration//GEN-END:variables
    private void changeFont(boolean increase) {
        int one = 1;
        if (increase) {
            one = -1;
        }

        JTableHeader header = rankTable.getTableHeader();
        int headerFont = header.getFont().getSize();
        int rowFont = rankTable.getFont().getSize();
        header.setFont(new Font("Tahoma", 0, headerFont - one));
        rankTable.setFont(new Font("Tahoma", 0, rowFont - one));
    }

}

class UpdateThread extends Thread {

    private boolean running = true;
    private RankingFrame frame;

    public UpdateThread(RankingFrame rf) {
        frame = rf;
    }

    public void shutdown() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            frame.updateRank();
            try {
                this.sleep(120000);
            } catch (InterruptedException ex) {
            }
        }
    }
}

class RowHighlightCellRenderer extends DefaultTableCellRenderer {

    public RowHighlightCellRenderer() {
        super();
        setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setBackground(row % 2 == 1 ? Color.lightGray : Color.WHITE);
        return c;
    }
}
