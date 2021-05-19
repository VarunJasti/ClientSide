/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientside;

import javax.swing.JPanel;

/**
 *
 * @author Varun Jasti
 */
public class Menu extends javax.swing.JPanel {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        usernameField.setSelectionStart(0);
        usernameField.setSelectionEnd(usernameField.getText().length());
    }
    
    public void joinLobby() {
        if (ClientSide.getCon() && ClientSide.newUser(usernameField.getText())) {
            String rosterList = ClientSide.read();
            String[] roster = rosterList.split(",");
            JPanel panel = ClientSide.getHome().getList().get(1);
            if (roster != null && panel instanceof Lobby) {
                ((Lobby)panel).loadRoster(roster);
            }
            ClientSide.getHome().showPanel(1);
        } else {
            //Some sort of error message here
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

        joinLobbyButton = new javax.swing.JButton();
        usernameField = new javax.swing.JTextField();

        joinLobbyButton.setText("Join Lobby");
        joinLobbyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinLobbyButtonActionPerformed(evt);
            }
        });

        usernameField.setText("Username");
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(joinLobbyButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(joinLobbyButton)
                .addGap(83, 83, 83))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void joinLobbyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinLobbyButtonActionPerformed
        joinLobby();
    }//GEN-LAST:event_joinLobbyButtonActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        joinLobby();
    }//GEN-LAST:event_usernameFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton joinLobbyButton;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
