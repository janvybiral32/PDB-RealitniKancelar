/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vutbr.fit.pdb.realitnikancelar;

import static cz.vutbr.fit.pdb.realitnikancelar.Data.mergeShapes;
import java.awt.Shape;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import java.lang.IllegalArgumentException;

/**
 *
 * @author Honza
 */
public class OwnerHistoryDialog extends javax.swing.JDialog {
    
    private ObjectInfo currentInfo;
    private static DefaultComboBoxModel ownersComboBoxModel = new DefaultComboBoxModel();
    private static DefaultComboBoxModel ownersHistoryListModel = new DefaultComboBoxModel();

    /**
     * Creates new form OwnerHistoryDialog
     */
    public OwnerHistoryDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        for (int i = 0; i < Data.pointsInfo.size(); i++)
        {
            if (Data.pointsInfo.get(i).selected)
            {
                currentInfo = Data.pointsInfo.get(i);
            }
        }
        
        for (int i = 0; i < Data.polylinesInfo.size(); i++)
        {
            if (Data.polylinesInfo.get(i).selected)
            {
                currentInfo = Data.polylinesInfo.get(i);
            }
        }
        
        for (int i = 0; i < Data.rectanglesInfo.size(); i++)
        {
            if (Data.rectanglesInfo.get(i).selected)
            {
                currentInfo = Data.rectanglesInfo.get(i);
            }
        }
        
        for (int i = 0; i < Data.ellipsesInfo.size(); i++)
        {
            if (Data.ellipsesInfo.get(i).selected)
            {
                currentInfo = Data.ellipsesInfo.get(i);
            }
        }
        
        for (int i = 0; i < Data.polygonsInfo.size(); i++)
        {
            if (Data.polygonsInfo.get(i).selected)
            {
                currentInfo = Data.polygonsInfo.get(i);
            }
        }
        
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
        upButton.setEnabled(false);
        downButton.setEnabled(false);
        
        objectNameLabel.setText(currentInfo.nazev);
        
        ownersComboBoxModel.removeAllElements();
        for (int i = 0; i < MainWindow.ownersListNames.size(); i++)
        {
            ownersComboBoxModel.addElement(MainWindow.ownersListNames.get(i));
        }
        ownersComboBoxModel.addElement("Bez majitele");
        ownerComboBox.setModel(ownersComboBoxModel);
        
        ownersHistoryListModel.removeAllElements();
        for (int i = 0; i < currentInfo.majitele.size(); i++)
        {
            if (currentInfo.majitele.get(i) == null)
            {
                ownersHistoryListModel.addElement("Bez majitele");
            }
            else
            {
                ownersHistoryListModel.addElement(currentInfo.majitele.get(i).jmeno);
            }
        }
        ownersHistoryList.setModel(ownersHistoryListModel);
        if (ownersHistoryListModel.getSize() != 0)
        {
            ownersHistoryList.setSelectedIndex(ownersHistoryListModel.getSize()-1);
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

        jButton1 = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        doField = new javax.swing.JTextField();
        odField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ownerComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        objectNameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ownersHistoryList = new javax.swing.JList<>();
        upButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Historie majitelů");

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Majitelem od:");

        jLabel2.setText("Majitelem do:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Historie majitelů");

        jLabel4.setText("Majitel:");

        jLabel5.setText("Název objektu:");

        objectNameLabel.setText("jLabel6");

        ownersHistoryList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " ", " ", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ownersHistoryList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ownersHistoryListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ownersHistoryList);

        upButton.setText("Nahoru");
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });

        downButton.setText("Dolů");
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });

        addButton.setText("Přidat");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setText("Změnit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Odebrat");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel3)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(objectNameLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ownerComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(odField)
                                    .addComponent(doField))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                                .addComponent(upButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(downButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(objectNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ownerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(odField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(upButton)
                        .addComponent(downButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editButton)
                        .addComponent(deleteButton)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(okButton)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        if (ownersHistoryListModel.getSize() != 0) {
            int index = ownerComboBox.getSelectedIndex();
            int index2 = ownersHistoryList.getSelectedIndex();
            if (index == ownersComboBoxModel.getSize() - 1) {
                if (currentInfo.majitele.get(index2) != null) {
                    currentInfo.majitele.set(index2, null);
                    currentInfo.modifiedInfo = true;
                }
            } else if (currentInfo.majitele.get(index2) != Data.owners.get(index)) {
                currentInfo.majitele.set(index2, Data.owners.get(index));
                currentInfo.modifiedInfo = true;
            }
            try {
                if (currentInfo.majitelOd.get(index2) != MainWindow.stringToDate(odField.getText())) {
                    currentInfo.majitelOd.set(index2, MainWindow.stringToDate(odField.getText()));
                    currentInfo.modifiedInfo = true;
                }
            } catch (IllegalArgumentException e) {
                odField.setText(MainWindow.dateToString(currentInfo.majitelOd.get(index2)));
            }
            try {
                if (currentInfo.majitelDo.get(index2) != MainWindow.stringToDate(doField.getText())) {
                    currentInfo.majitelDo.set(index2, MainWindow.stringToDate(doField.getText()));
                    currentInfo.modifiedInfo = true;
                }
            } catch (IllegalArgumentException e) {
                doField.setText(MainWindow.dateToString(currentInfo.majitelDo.get(index2)));
            }
        }
        
        setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    private void ownersHistoryListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ownersHistoryListValueChanged
        // TODO add your handling code here:
        
        if (ownersHistoryList.getSelectedIndex() == -1)
        {
            editButton.setEnabled(false);
            deleteButton.setEnabled(false);
            upButton.setEnabled(false);
            downButton.setEnabled(false);
        }
        else
        {
            addButton.setEnabled(true);
            editButton.setEnabled(true);
            deleteButton.setEnabled(true);
            upButton.setEnabled(true);
            downButton.setEnabled(true);
        }
        if (ownersHistoryListModel.getSize() == 0 || currentInfo.majitele.size() == 0 || ownersHistoryList.getSelectedIndex() == -1) return;
        int index = ownersHistoryList.getSelectedIndex();
        if (currentInfo.majitele.get(index) == null) {
            ownerComboBox.setSelectedItem("Bez majitele");
        }
        else {
            ownerComboBox.setSelectedItem(currentInfo.majitele.get(index).jmeno);
        }
        odField.setText(MainWindow.dateToString(currentInfo.majitelOd.get(index)));
        doField.setText(MainWindow.dateToString(currentInfo.majitelDo.get(index)));
    }//GEN-LAST:event_ownersHistoryListValueChanged

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        // TODO add your handling code here:
        int index = ownersHistoryList.getSelectedIndex();
        if (index > 0)
        {
            Owner owner = currentInfo.majitele.get(index);
            currentInfo.majitele.set(index, currentInfo.majitele.get(index-1));
            currentInfo.majitele.set(index-1, owner);
            currentInfo.modifiedInfo = true;
        }
        else
        {
            return;
        }
        
        ownersHistoryListModel.removeAllElements();
        for (int i = 0; i < currentInfo.majitele.size(); i++)
        {
            if (currentInfo.majitele.get(i) == null)
            {
                ownersHistoryListModel.addElement("Bez majitele");
            }
            else
            {
                ownersHistoryListModel.addElement(currentInfo.majitele.get(i).jmeno);
            }
        }
        
        ownersHistoryList.setSelectedIndex(index-1);
    }//GEN-LAST:event_upButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        int index = ownerComboBox.getSelectedIndex();
        
        try
        {
            currentInfo.majitelOd.add(MainWindow.stringToDate(odField.getText()));
        }
        catch (IllegalArgumentException e)
        {
            currentInfo.majitelOd.add(null);
        }
        try
        {
            currentInfo.majitelDo.add(MainWindow.stringToDate(doField.getText()));
        }
        catch (IllegalArgumentException e)
        {
            currentInfo.majitelDo.add(null);
        }
        
        if (index == ownersComboBoxModel.getSize()-1)
        {
            currentInfo.majitele.add(null);
            ownersHistoryListModel.addElement("Bez majitele");
        }
        else
        {
            currentInfo.majitele.add(Data.owners.get(index));
            ownersHistoryListModel.addElement(currentInfo.majitele.get(currentInfo.majitele.size()-1).jmeno);
        }
        
        ownersHistoryList.setSelectedIndex(currentInfo.majitele.size()-1);
        currentInfo.modifiedInfo = true;
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        int index = ownerComboBox.getSelectedIndex();
        int index2 = ownersHistoryList.getSelectedIndex();
        if (index == ownersComboBoxModel.getSize()-1)
        {
            if (currentInfo.majitele.get(index2) != null)
            {
                currentInfo.majitele.set(index2, null);
                currentInfo.modifiedInfo = true;
            }
        }
        else
        {
            if (currentInfo.majitele.get(index2) != Data.owners.get(index))
            {
                currentInfo.majitele.set(index2, Data.owners.get(index));
                currentInfo.modifiedInfo = true;
            }
        }
        try
        {
            if (currentInfo.majitelOd.get(index2) != MainWindow.stringToDate(odField.getText()))
            {
                currentInfo.majitelOd.set(index2, MainWindow.stringToDate(odField.getText()));
                currentInfo.modifiedInfo = true;
            }
        }
        catch (IllegalArgumentException e)
        {
            odField.setText(MainWindow.dateToString(currentInfo.majitelOd.get(index2)));
        }
        try
        {
            if (currentInfo.majitelDo.get(index2) != MainWindow.stringToDate(doField.getText()))
            {
                currentInfo.majitelDo.set(index2, MainWindow.stringToDate(doField.getText()));
                currentInfo.modifiedInfo = true;
            }
        }
        catch (IllegalArgumentException e)
        {
            doField.setText(MainWindow.dateToString(currentInfo.majitelDo.get(index2)));
        }
        
        ownersHistoryListModel.removeAllElements();
        for (int i = 0; i < currentInfo.majitele.size(); i++)
        {
            if (currentInfo.majitele.get(i) == null)
            {
                ownersHistoryListModel.addElement("Bez majitele");
            }
            else
            {
                ownersHistoryListModel.addElement(currentInfo.majitele.get(i).jmeno);
            }
        }
        
        ownersHistoryList.setSelectedIndex(index2);
    }//GEN-LAST:event_editButtonActionPerformed

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        // TODO add your handling code here:
        int index = ownersHistoryList.getSelectedIndex();
        if (index < ownersHistoryListModel.getSize()-1)
        {
            Owner owner = currentInfo.majitele.get(index);
            currentInfo.majitele.set(index, currentInfo.majitele.get(index+1));
            currentInfo.majitele.set(index+1, owner);
            currentInfo.modifiedInfo = true;
        }
        else
        {
            return;
        }
        
        ownersHistoryListModel.removeAllElements();
        for (int i = 0; i < currentInfo.majitele.size(); i++)
        {
            if (currentInfo.majitele.get(i) == null)
            {
                ownersHistoryListModel.addElement("Bez majitele");
            }
            else
            {
                ownersHistoryListModel.addElement(currentInfo.majitele.get(i).jmeno);
            }
        }
        
        ownersHistoryList.setSelectedIndex(index+1);
    }//GEN-LAST:event_downButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        int index = ownersHistoryList.getSelectedIndex();
        currentInfo.majitele.remove(index);
        
        currentInfo.majitelOd.remove(index);
        currentInfo.majitelDo.remove(index);
        
        currentInfo.modifiedInfo = true;
        
        ownersHistoryListModel.removeElementAt(index);
        
        ownersHistoryList.setSelectedIndex(ownersHistoryListModel.getSize()-1);
    }//GEN-LAST:event_deleteButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OwnerHistoryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OwnerHistoryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OwnerHistoryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OwnerHistoryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OwnerHistoryDialog dialog = new OwnerHistoryDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField doField;
    private javax.swing.JButton downButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel objectNameLabel;
    private javax.swing.JTextField odField;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox<String> ownerComboBox;
    private javax.swing.JList<String> ownersHistoryList;
    private javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables
}
