/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientside;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


/**
 *
 * @author Varun Jasti
 */
public class Poker extends javax.swing.JPanel {
    
    private ArrayList<JLabel> labelList = new ArrayList<>();
    private ArrayList<JLabel> cardList = new ArrayList<>();

    /**
     * Creates new form Poker
     */
    public Poker() {
        initComponents();
//        ImageIcon img = new ImageIcon(new ImageIcon(ClientSide.class.getResource("Cards/back.png")).getImage().getScaledInstance(65, 100, java.awt.Image.SCALE_SMOOTH));
//        JLabel card11 = new JLabel(img);
//        card11.setSize(65,100);
//        card11.setLocation(650, 335);
//        add(card11);
        createLabels();
        createCards();
    }
    
    public void createLabels() {
        int width = 140;
        int height = 15;
        Font f = new java.awt.Font("Rockwell", 0, 14);
        JLabel p1Label = new JLabel();
        p1Label.setSize(width, height);
        p1Label.setLocation(650, 315);
        p1Label.setFont(f);
        p1Label.setHorizontalAlignment(SwingConstants.CENTER);
        add(p1Label);
        labelList.add(p1Label);
        JLabel p2Label = new JLabel();
        p2Label.setSize(width, height);
        p2Label.setLocation(650, 190);
        p2Label.setFont(f);
        p2Label.setHorizontalAlignment(SwingConstants.CENTER);
        add(p2Label);
        labelList.add(p2Label);
        JLabel p3Label = new JLabel();
        p3Label.setSize(width, height);
        p3Label.setLocation(650, 65);
        p3Label.setFont(f);
        p3Label.setHorizontalAlignment(SwingConstants.CENTER);
        add(p3Label);
        labelList.add(p3Label);
        JLabel p4Label = new JLabel();
        p4Label.setSize(width, height);
        p4Label.setLocation(480, 10);
        p4Label.setFont(f);
        p4Label.setHorizontalAlignment(SwingConstants.CENTER);
        add(p4Label);
        labelList.add(p4Label);
        JLabel p5Label = new JLabel();
        p5Label.setSize(width, height);
        p5Label.setLocation(330, 10);
        p5Label.setFont(f);
        p5Label.setHorizontalAlignment(SwingConstants.CENTER);
        add(p5Label);
        labelList.add(p5Label);
        JLabel p6Label = new JLabel();
        p6Label.setSize(width, height);
        p6Label.setLocation(180, 10);
        p6Label.setFont(f);
        p6Label.setHorizontalAlignment(SwingConstants.CENTER);
        add(p6Label);
        labelList.add(p6Label);
        JLabel p7Label = new JLabel();
        p7Label.setSize(width, height);
        p7Label.setLocation(10, 65);
        p7Label.setFont(f);
        p7Label.setHorizontalAlignment(SwingConstants.CENTER);
        add(p7Label);
        labelList.add(p7Label);
        JLabel p8Label = new JLabel();
        p8Label.setSize(width, height);
        p8Label.setLocation(10, 190);
        p8Label.setFont(f);
        p8Label.setHorizontalAlignment(SwingConstants.CENTER);
        add(p8Label);
        labelList.add(p8Label);
        JLabel p9Label = new JLabel();
        p9Label.setSize(width, height);
        p9Label.setLocation(10, 315);
        p9Label.setFont(f);
        p9Label.setHorizontalAlignment(SwingConstants.CENTER);
        add(p9Label);
        labelList.add(p9Label);
    }
    
    public void createCards() {
        int width = 65;
        int height = 100;
        for (JLabel label : labelList) {
            JLabel card1 = new JLabel();
            card1.setSize(width, height);
            card1.setLocation(label.getLocation().x, label.getLocation().y+20);
            add(card1);
            cardList.add(card1);
            JLabel card2 = new JLabel();
            card2.setSize(width, height);
            card2.setLocation(label.getLocation().x+75, label.getLocation().y+20);
            add(card2);
            cardList.add(card2);
        }
    }
    
    public void loadPlayers() {
        clearLabel();
        ImageIcon img = new ImageIcon(new ImageIcon(ClientSide.class.getResource("Cards/back.png")).getImage().getScaledInstance(65, 100, java.awt.Image.SCALE_SMOOTH));
        ClientSide.mainPlayerToEnd();
        for (int i = 0; i < ClientSide.getList().size()-1; i++) {
            labelList.get(i).setText(ClientSide.getList().get(i).getName());
            int j = i*2;
            cardList.get(j).setIcon(img);
            cardList.get(j+1).setIcon(img);
        }
    }
    
    private void clearLabel() {
        for (JLabel label : labelList) {
            label.setText("");
        }
        for (JLabel card : cardList) {
            card.setIcon(null);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
