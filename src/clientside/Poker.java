/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientside;

import java.awt.Font;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Varun Jasti
 */
public class Poker extends javax.swing.JPanel {
    
    private ArrayList<JLabel> labelList = new ArrayList<>();
    private ArrayList<JLabel> cardList = new ArrayList<>();
    private ArrayList<JLabel> communityList = new ArrayList<>();
    private JLabel myCard1;
    private JLabel myCard2;
    private Listen listen;
    private boolean bettable = false;
    private double callValue = 0;

    /**
     * Creates new form Poker
     */
    public Poker() {
        initComponents();
        myCard1 = new JLabel();
        myCard1.setSize(98, 150);
        myCard1.setLocation(297, 290);
        add(myCard1);
        myCard2 = new JLabel();
        myCard2.setSize(98, 150);
        myCard2.setLocation(405, 290);
        add(myCard2);
        createLabels();
        createCards();
    }
    
    public void startListening() {
        listen = new Listen();
        listen.start();
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
            card1.setLocation(label.getLocation().x, label.getLocation().y + 20);
            add(card1);
            cardList.add(card1);
            JLabel card2 = new JLabel();
            card2.setSize(width, height);
            card2.setLocation(label.getLocation().x + 75, label.getLocation().y + 20);
            add(card2);
            cardList.add(card2);
        }
        JLabel card1 = new JLabel();
        card1.setLocation(218, 130);
        communityList.add(card1);
        JLabel card2 = new JLabel();
        card2.setLocation(293, 130);
        communityList.add(card2);
        JLabel card3 = new JLabel();
        card3.setLocation(368, 130);
        communityList.add(card3);
        JLabel card4 = new JLabel();
        card4.setLocation(443, 130);
        communityList.add(card4);
        JLabel card5 = new JLabel();
        card5.setLocation(518, 130);
        communityList.add(card5);
        ImageIcon img = new ImageIcon(new ImageIcon(ClientSide.class.getResource("Cards/back.png")).getImage().getScaledInstance(65, 100, java.awt.Image.SCALE_SMOOTH));
        for (JLabel card : communityList) {
            card.setSize(width, height);
            card.setIcon(img);
            add(card);
        }
    }
    
    public void loadPlayers() {
        clearLabel();
        ImageIcon img = new ImageIcon(new ImageIcon(ClientSide.class.getResource("Cards/back.png")).getImage().getScaledInstance(65, 100, java.awt.Image.SCALE_SMOOTH));
        ClientSide.mainPlayerToEnd();
        for (int i = 0; i < ClientSide.getList().size() - 1; i++) {
            labelList.get(i).setText(ClientSide.getList().get(i).getName() + ": " + NumberFormat.getCurrencyInstance().format(ClientSide.getList().get(i).getBet()));
            int j = i * 2;
            cardList.get(j).setIcon(img);
            cardList.get(j + 1).setIcon(img);
        }
        money.setText(NumberFormat.getCurrencyInstance().format(ClientSide.getList().get(ClientSide.getList().size() - 1).getMoney()));
        bet.setText(NumberFormat.getCurrencyInstance().format(ClientSide.getList().get(ClientSide.getList().size() - 1).getBet()));
    }
    
    private void clearLabel() {
        for (JLabel label : labelList) {
            label.setText("");
        }
        for (JLabel card : cardList) {
            card.setIcon(null);
        }
    }
    
    public void loadBetAndMoney() {
        bet.setText(NumberFormat.getCurrencyInstance().format(ClientSide.getList().get(ClientSide.getList().size() - 1).getBet()));
        money.setText(NumberFormat.getCurrencyInstance().format(ClientSide.getList().get(ClientSide.getList().size() - 1).getMoney()));
    }
    
    public void setMyCards() {
        
    }
    
    class Listen extends Thread {
        
        private final AtomicBoolean running = new AtomicBoolean(false);
        
        public void stop1() {
            running.set(false);
        }
        
        @Override
        public void run() {
            running.set(true);
            try {
                while (running.get()) {
                    String input = ClientSide.getIn().readLine();
                    if (input.startsWith("hand")) {
                        String[] s = input.split("\\|");
                        myCard1.setIcon(new ImageIcon(new ImageIcon(ClientSide.class.getResource("Cards/" + s[1] + ".png")).getImage().getScaledInstance(98, 150, java.awt.Image.SCALE_SMOOTH)));
                        myCard2.setIcon(new ImageIcon(new ImageIcon(ClientSide.class.getResource("Cards/" + s[2] + ".png")).getImage().getScaledInstance(98, 150, java.awt.Image.SCALE_SMOOTH)));
                    } else if (input.startsWith("bet")) {
                        bettable = true;
                        betLabel.setText("<html><b>Bet</b></html>");
                        callValue = Double.parseDouble(input.split(",")[1]);
                        callButton.setText("Call: " + NumberFormat.getCurrencyInstance().format(callValue));
                    } else if (input.startsWith("userbet")) {
                        for (int i = 0; i < ClientSide.getList().size(); i++) {
                            if (ClientSide.getList().get(i).getName().equals(input.split(",")[1])) {
                                if (i != ClientSide.getList().size() - 1) {
                                    ClientSide.getList().get(i).setBet(Double.parseDouble(input.split(",")[2]));
                                    labelList.get(i).setText(ClientSide.getList().get(i).getName() + ": " + NumberFormat.getCurrencyInstance().format(ClientSide.getList().get(i).getBet()));
                                    break;
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
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

        money = new javax.swing.JLabel();
        moneyLabel = new javax.swing.JLabel();
        betLabel = new javax.swing.JLabel();
        bet = new javax.swing.JLabel();
        raiseButton = new javax.swing.JButton();
        lowerButton = new javax.swing.JButton();
        callButton = new javax.swing.JButton();
        foldButton = new javax.swing.JButton();
        betButton = new javax.swing.JButton();

        money.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        money.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        money.setText("jLabel1");

        moneyLabel.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        moneyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        moneyLabel.setText("Money");

        betLabel.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        betLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        betLabel.setText("Bet");

        bet.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        bet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bet.setText("jLabel1");

        raiseButton.setText("+0.10");
        raiseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raiseButtonActionPerformed(evt);
            }
        });

        lowerButton.setText("-0.10");
        lowerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lowerButtonActionPerformed(evt);
            }
        });

        callButton.setText("Call");
        callButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                callButtonActionPerformed(evt);
            }
        });

        foldButton.setText("Fold");
        foldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foldButtonActionPerformed(evt);
            }
        });

        betButton.setText("Bet");
        betButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(moneyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(betLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(money, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bet, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(513, 513, 513)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lowerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(raiseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(callButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(foldButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(betButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moneyLabel)
                    .addComponent(betLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(money)
                    .addComponent(bet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(raiseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lowerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(callButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(foldButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(betButton)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void raiseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raiseButtonActionPerformed
        if (bettable) {
            if (ClientSide.getList().get(ClientSide.getList().size() - 1).getMoney() >= 0.1) {
                ClientSide.getList().get(ClientSide.getList().size() - 1).setBet(ClientSide.getList().get(ClientSide.getList().size() - 1).getBet() + 0.1);
                ClientSide.getList().get(ClientSide.getList().size() - 1).setMoney(ClientSide.getList().get(ClientSide.getList().size() - 1).getMoney() - 0.1);
                loadBetAndMoney();
            }
        }
    }//GEN-LAST:event_raiseButtonActionPerformed

    private void lowerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lowerButtonActionPerformed
        if (bettable) {
            if (ClientSide.getList().get(ClientSide.getList().size() - 1).getBet() >= 0.1) {
                ClientSide.getList().get(ClientSide.getList().size() - 1).setBet(ClientSide.getList().get(ClientSide.getList().size() - 1).getBet() - 0.1);
                ClientSide.getList().get(ClientSide.getList().size() - 1).setMoney(ClientSide.getList().get(ClientSide.getList().size() - 1).getMoney() + 0.1);
                loadBetAndMoney();
            }
        }
    }//GEN-LAST:event_lowerButtonActionPerformed

    private void callButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_callButtonActionPerformed
        if (bettable) {
            if (ClientSide.getList().get(ClientSide.getList().size() - 1).getMoney() >= callValue - ClientSide.getList().get(ClientSide.getList().size() - 1).getBet()) {
                ClientSide.getList().get(ClientSide.getList().size() - 1).setMoney(ClientSide.getList().get(ClientSide.getList().size() - 1).getMoney() - (callValue - ClientSide.getList().get(ClientSide.getList().size() - 1).getBet()));
                ClientSide.getList().get(ClientSide.getList().size() - 1).setBet(callValue);
                loadBetAndMoney();
            }
        }
    }//GEN-LAST:event_callButtonActionPerformed

    private void foldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foldButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_foldButtonActionPerformed

    private void betButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betButtonActionPerformed
        if (bettable) {
            if (callValue > ClientSide.getList().get(ClientSide.getList().size() - 1).getBet()) {
                JOptionPane.showMessageDialog(ClientSide.getHome(), "Bet Too Low");
            } else {
                ClientSide.getOut().printf("bet,%.2f%n", ClientSide.getList().get(ClientSide.getList().size() - 1).getBet());
                betLabel.setText("Bet");
                bettable = false;
            }
        }
    }//GEN-LAST:event_betButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bet;
    private javax.swing.JButton betButton;
    private javax.swing.JLabel betLabel;
    private javax.swing.JButton callButton;
    private javax.swing.JButton foldButton;
    private javax.swing.JButton lowerButton;
    private javax.swing.JLabel money;
    private javax.swing.JLabel moneyLabel;
    private javax.swing.JButton raiseButton;
    // End of variables declaration//GEN-END:variables
}
