/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.practica2.vista;

import com.escom.practica2.modelo.Examen;
import com.escom.practica2.modelo.Materia;
import com.escom.practica2.servicios.ExamenDaoCliente;
import com.escom.practica2.servicios.MateriaDaoCliente;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DARTH VADER
 */
public class Materias extends javax.swing.JInternalFrame {

    DefaultComboBoxModel value;
    int idExamen;
    public Materias() {
        try {
            initComponents();
            cargarCombo();
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(Materias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboMaterias = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaExamenes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);

        comboMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMateriasActionPerformed(evt);
            }
        });

        tablaExamenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Examen", "Periodo", "Fecha"
            }
        ));
        tablaExamenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaExamenesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaExamenes);

        jScrollPane1.setViewportView(jScrollPane2);

        jButton1.setText("Comenzar Examen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Sección  de Exámenes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(comboMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(comboMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMateriasActionPerformed
        Materia materia  = (Materia)comboMaterias.getSelectedItem();
        listarArticulos(materia.getIdmateria());
        
    }//GEN-LAST:event_comboMateriasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ExamenFrame frameUno = new ExamenFrame();
        MainFrame.desktop.add(frameUno);
        frameUno.setIdExamen(idExamen);
        frameUno.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaExamenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaExamenesMouseClicked
        DefaultTableModel modelo = null;
        modelo = (DefaultTableModel) tablaExamenes.getModel();
       int fila = tablaExamenes.rowAtPoint(evt.getPoint());
       //int columna = tablaArticulos.columnAtPoint(evt.getPoint());
       //if ((fila > -1) && (columna > -1))
       // System.out.println(modelo.getValueAt(fila,columna));
        //System.out.println(modelo.getValueAt(fila, 0));
        idExamen= Integer.parseInt((String) modelo.getValueAt(fila,0)) ;
    }//GEN-LAST:event_tablaExamenesMouseClicked

    private void cargarCombo() throws RemoteException, NotBoundException, MalformedURLException {
       value =new DefaultComboBoxModel();
       comboMaterias.setModel(value);
        MateriaDaoCliente materias = new MateriaDaoCliente();
        List<Materia> lista;
        lista = materias.getAllMaterias();
        for (int i = 0; i < lista.size(); i++) {

            value.addElement(lista.get(i));

        }
        }
    
        private void listarArticulos(int idMateria) {
        try {
            ExamenDaoCliente help = new ExamenDaoCliente();
            List<Examen> lista;
            lista = help.getAllExamenes(idMateria);
            DefaultTableModel modelo = null;
            try {
                modelo = (DefaultTableModel) tablaExamenes.getModel();
                int a = modelo.getRowCount();
                for (int i = 0; i < a; i++) {
                    modelo.removeRow(0);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            
            String datos[] = new String[3];
            
            for (int i = 0; i < lista.size(); i++) {
                datos[0] = Integer.toString(lista.get(i).getIdexamen());
                datos[1] = lista.get(i).getPeriodo();
                datos[2] = lista.get(i).getFecha().toString();
                
                modelo.addRow(datos);
            }
            
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            System.out.println(ex.toString());
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboMaterias;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaExamenes;
    // End of variables declaration//GEN-END:variables
}
