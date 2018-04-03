/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import domain.Vehicle;
import file.VehicleFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TokisakiKuro
 */
public class Interfaz extends javax.swing.JFrame {
    
    String [] titulos = {"Nombre","Año","Kilometraje","Americano","Serie"};
    DefaultTableModel dtm = new DefaultTableModel(null, titulos);
    
    boolean american=false;
    
    File file = new File("./vehicle.dat");
    VehicleFile vehicleFile = new VehicleFile(file);
    
    public void readAllVehicle() throws IOException{
        
        String datos[] = new String[5];
        ArrayList<Vehicle> myArrayList = vehicleFile.getVehicleList();
        
        for (int i = 0; i < myArrayList.size(); i++) {
            datos[0] = myArrayList.get(i).getName();
            datos[1] = Integer.toString(myArrayList.get(i).getYear());
            datos[2] = Float.toString(myArrayList.get(i).getMileage());
            datos[3] = Boolean.toString(myArrayList.get(i).isAmerican());
            datos[4] = Integer.toString(myArrayList.get(i).getSeries());
            dtm.addRow(datos);
        }
        jTable1.setModel(dtm);
        
    }
    
    public void limpiaTabla(){
        dtm.setRowCount(0);
    }
    
    private void yes(){
        CheckNo.setSelected(false);
        american=true;
}
    private void no(){
        CheckYes.setSelected(false);
        american=false;
    }
    
    private void ingresar() throws IOException{
        
        Vehicle v = new Vehicle(jTextFieldName.getText(), 
                Integer.parseInt(jTextFieldYear.getText()), 
                Float.parseFloat(jTextFieldMileage.getText()),
                american, Integer.parseInt(jTextFieldSeries.getText()));
        
        vehicleFile.addEndRecord(v);
       
        CheckYes.setSelected(false);
        CheckNo.setSelected(false);
        CheckNo.setEnabled(true);
        CheckYes.setEnabled(true);
        jTextFieldName.setText("");
        jTextFieldYear.setText("");
        jTextFieldMileage.setText("");
        jTextFieldSeries.setText("");
        american=false;
        limpiaTabla();
        readAllVehicle();
    }
    
    private void editar() throws IOException{
        
        vehicleFile.editVehicle(Integer.parseInt(TextSeriesE.getText()),
                                TextNameE.getText(),
                                Integer.parseInt(TextYearE.getText()),
                                Float.parseFloat(TextMileageE.getText()), 
                                american);
       
        jCheckYesE.setSelected(false);
        jCheckNoE.setSelected(false);
        jCheckYesE.setEnabled(true);
        jCheckNoE.setEnabled(true);
        TextNameE.setText("");
        TextYearE.setText("");
        TextMileageE.setText("");
        TextSeriesE.setText("");
        american=false;
        limpiaTabla();
        readAllVehicle();
    }
    
    private void borrar() throws IOException{
        boolean vehicleTemp = vehicleFile.deleteRecord(Integer.parseInt(TextSeriesE.getText()));
        jCheckYesE.setSelected(false);
        jCheckNoE.setSelected(false);
        jCheckYesE.setEnabled(true);
        jCheckNoE.setEnabled(true);
        TextNameE.setText("");
        TextYearE.setText("");
        TextMileageE.setText("");
        TextSeriesE.setText("");
        american=false;
        limpiaTabla();
        readAllVehicle();
    }
    
    private void yesEdit(){
        jCheckNoE.setSelected(false);
        american=true;
    }
    
    private void noEdit(){
        jCheckYesE.setSelected(false);
        american=false;
    }
    
    private void buscar() throws IOException{
        Vehicle v = vehicleFile.buscar(Integer.parseInt(TextSeriesE.getText()));
        TextNameE.setText(v.getName());
        TextYearE.setText(Integer.toString(v.getYear()));
        TextMileageE.setText(Float.toString(v.getMileage()));
        if (v.isAmerican()==true) {
            jCheckYesE.setSelected(true);
            american=true;
        }else{
            jCheckNoE.setSelected(true);
            american=false;
        }
        
    }
    
    public Interfaz() throws IOException {
        initComponents();
        readAllVehicle();
        TextMileageE.setEditable(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabelName = new javax.swing.JLabel();
        jLabelYear = new javax.swing.JLabel();
        jLabelMileage = new javax.swing.JLabel();
        jLabelAmerican = new javax.swing.JLabel();
        jLabelSeries = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldYear = new javax.swing.JTextField();
        jTextFieldMileage = new javax.swing.JTextField();
        jTextFieldSeries = new javax.swing.JTextField();
        CheckYes = new javax.swing.JCheckBox();
        CheckNo = new javax.swing.JCheckBox();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        TextSeriesE = new javax.swing.JTextField();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TextNameE = new javax.swing.JTextField();
        TextYearE = new javax.swing.JTextField();
        TextMileageE = new javax.swing.JTextField();
        jCheckYesE = new javax.swing.JCheckBox();
        jCheckNoE = new javax.swing.JCheckBox();
        jToggleButtonEdit = new javax.swing.JToggleButton();
        jToggleButtonDelete = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tarea2RandomAccessFile");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabelName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelName.setText("Nombre");

        jLabelYear.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelYear.setText("Año");

        jLabelMileage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelMileage.setText("Kilometraje");

        jLabelAmerican.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelAmerican.setText("Americano");

        jLabelSeries.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelSeries.setText("Serie");

        jTextFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameActionPerformed(evt);
            }
        });

        jTextFieldYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldYearActionPerformed(evt);
            }
        });

        CheckYes.setText("Sí");
        CheckYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckYesActionPerformed(evt);
            }
        });

        CheckNo.setText("No");
        CheckNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckNoActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Ingresar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelName)
                            .addComponent(jLabelYear)
                            .addComponent(jLabelMileage)
                            .addComponent(jLabelSeries)
                            .addComponent(jLabelAmerican))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CheckYes)
                                .addGap(18, 18, 18)
                                .addComponent(CheckNo))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldMileage)
                                .addComponent(jTextFieldYear)
                                .addComponent(jTextFieldName)
                                .addComponent(jTextFieldSeries, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelYear)
                    .addComponent(jTextFieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMileage)
                    .addComponent(jTextFieldMileage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAmerican)
                    .addComponent(CheckYes)
                    .addComponent(CheckNo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSeries))
                .addGap(32, 32, 32)
                .addComponent(jToggleButton1)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Ingresar", jPanel1);

        jToggleButton2.setText("Buscar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingresar Serie");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Año");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Kilometraje");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Americano");

        TextMileageE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextMileageEActionPerformed(evt);
            }
        });

        jCheckYesE.setText("Si");
        jCheckYesE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckYesEActionPerformed(evt);
            }
        });

        jCheckNoE.setText("No");
        jCheckNoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckNoEActionPerformed(evt);
            }
        });

        jToggleButtonEdit.setText("Editar");
        jToggleButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonEditActionPerformed(evt);
            }
        });

        jToggleButtonDelete.setText("Borrar");
        jToggleButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(TextSeriesE, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton2))
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextNameE, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(TextYearE)
                            .addComponent(TextMileageE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckYesE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckNoE))))
                    .addComponent(jToggleButtonEdit)
                    .addComponent(jToggleButtonDelete))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextSeriesE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextNameE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TextYearE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TextMileageE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jCheckYesE)
                    .addComponent(jCheckNoE))
                .addGap(39, 39, 39)
                .addComponent(jToggleButtonEdit)
                .addGap(18, 18, 18)
                .addComponent(jToggleButtonDelete)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Editar/Borrar", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane5)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CheckYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckYesActionPerformed
        yes();
    }//GEN-LAST:event_CheckYesActionPerformed

    private void CheckNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckNoActionPerformed
        no();
    }//GEN-LAST:event_CheckNoActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        try {
            ingresar();
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonEditActionPerformed
        try {
            editar();
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jToggleButtonEditActionPerformed

    private void jToggleButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonDeleteActionPerformed
        try {
            borrar();
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jToggleButtonDeleteActionPerformed

    private void jCheckYesEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckYesEActionPerformed
        yesEdit();
    }//GEN-LAST:event_jCheckYesEActionPerformed

    private void jCheckNoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckNoEActionPerformed
        noEdit();
    }//GEN-LAST:event_jCheckNoEActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        try {
            buscar();
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jTextFieldYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldYearActionPerformed

    private void TextMileageEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextMileageEActionPerformed
        
    }//GEN-LAST:event_TextMileageEActionPerformed

    private void jTextFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Interfaz().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckNo;
    private javax.swing.JCheckBox CheckYes;
    private javax.swing.JTextField TextMileageE;
    private javax.swing.JTextField TextNameE;
    private javax.swing.JTextField TextSeriesE;
    private javax.swing.JTextField TextYearE;
    private javax.swing.JCheckBox jCheckNoE;
    private javax.swing.JCheckBox jCheckYesE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAmerican;
    private javax.swing.JLabel jLabelMileage;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelSeries;
    private javax.swing.JLabel jLabelYear;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldMileage;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldSeries;
    private javax.swing.JTextField jTextFieldYear;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButtonDelete;
    private javax.swing.JToggleButton jToggleButtonEdit;
    // End of variables declaration//GEN-END:variables
}
