package com.escom.practica2.vista;

import com.escom.practica2.helper.Helper;
import com.escom.practica2.modelo.Pregunta;
import com.escom.practica2.modelo.Respuesta;
import com.escom.practica2.servicios.PreguntaDaoCliente;
import com.escom.practica2.servicios.RespuestaDaoCliente;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.soap.SOAPBinding;
import javax.swing.JOptionPane;

public class ExamenFrame extends javax.swing.JInternalFrame {

    int posicion = 0;
    int idEx;
    List<Respuesta> lista;
    List<Pregunta> listaPreguntas;
    int tamLista;
    String respuestas[];

    public ExamenFrame(int idExamen) throws RemoteException, NotBoundException, MalformedURLException {

        initComponents();
        idEx = idExamen;
        Helper util = new Helper();
        Integer datos[] = new Integer[4];
        datos = util.llenarArreglo();
        int idPregunta = listarpreguntas(posicion, idExamen);
        respuestas = new String[tamLista];
        lista = new RespuestaDaoCliente().getAllRespuestas(idPregunta);
        opc1.setText(lista.get(datos[0]).getRespuesta());
        opc2.setText(lista.get(datos[1]).getRespuesta());
        opc3.setText(lista.get(datos[2]).getRespuesta());
        opc4.setText(lista.get(datos[3]).getRespuesta());
        jButton3.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        opc1 = new javax.swing.JRadioButton();
        opc2 = new javax.swing.JRadioButton();
        opc3 = new javax.swing.JRadioButton();
        opc4 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        preguntaLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();

        buttonGroup1.add(opc1);
        opc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opc1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(opc2);
        opc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opc2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(opc3);
        opc3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opc3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(opc4);
        opc4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opc4ActionPerformed(evt);
            }
        });

        jButton2.setText("Avanzar >>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Terminar Examen");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        preguntaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Pregunta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(preguntaLabel)
                            .addComponent(opc4)
                            .addComponent(opc2)
                            .addComponent(opc1)
                            .addComponent(opc3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)))
                .addContainerGap(387, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(idLabel)
                        .addGap(28, 28, 28)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(preguntaLabel)
                .addGap(18, 18, 18)
                .addComponent(opc1)
                .addGap(18, 18, 18)
                .addComponent(opc2)
                .addGap(18, 18, 18)
                .addComponent(opc3)
                .addGap(18, 18, 18)
                .addComponent(opc4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(idLabel))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opc1ActionPerformed
        respuestas[posicion] = opc1.getText();
    }//GEN-LAST:event_opc1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (posicion < tamLista) {

            jButton2.setEnabled(true);
            jButton3.setEnabled(false);

        }if(posicion == tamLista-2){
        jButton2.setEnabled(false);
            jButton3.setEnabled(true);
        
        }

        posicion++;
        Helper util = new Helper();
        Integer os[] = new Integer[4];
        os = util.llenarArreglo();
        int idPregunta = listarpreguntas(posicion, idEx);
        try {
            lista = new RespuestaDaoCliente().getAllRespuestas(idPregunta);
            buttonGroup1.clearSelection();
            opc1.setText(lista.get(os[3]).getRespuesta());
            opc2.setText(lista.get(os[2]).getRespuesta());
            opc3.setText(lista.get(os[1]).getRespuesta());
            opc4.setText(lista.get(os[0]).getRespuesta());
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void opc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opc2ActionPerformed
        respuestas[posicion] = opc2.getText();
    }//GEN-LAST:event_opc2ActionPerformed

    private void opc3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opc3ActionPerformed
        respuestas[posicion] = opc3.getText();
    }//GEN-LAST:event_opc3ActionPerformed

    private void opc4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opc4ActionPerformed
        respuestas[posicion] = opc4.getText();
    }//GEN-LAST:event_opc4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        evaluar();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JLabel idLabel;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton opc1;
    private javax.swing.JRadioButton opc2;
    private javax.swing.JRadioButton opc3;
    private javax.swing.JRadioButton opc4;
    private javax.swing.JLabel preguntaLabel;
    // End of variables declaration//GEN-END:variables

    public int listarpreguntas(int posicion, int idExamen) {

        PreguntaDaoCliente op = new PreguntaDaoCliente();

        try {
            listaPreguntas = op.getAllPreguntas(idExamen);
            if (listaPreguntas.isEmpty()) {

                JOptionPane.showMessageDialog(this, " No hay preguntas en este Examen. "
                        + "\n Consulte a su Maestro");

            } else {
                preguntaLabel.setText(listaPreguntas.get(posicion).getPregunta());
                tamLista = listaPreguntas.size();
                System.out.println(tamLista + "Tamaño"+posicion);

            }
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {

        }
        return listaPreguntas.get(posicion).getIdpregunta();
    }

    public void evaluar() {
        int correctas = 0;
        
        for (int i = 0; i < respuestas.length; i++) {

            if (respuestas[i] == null ? listaPreguntas.get(i).getRespuestaCorrecta() == null : respuestas[i].equals(listaPreguntas.get(i).getRespuestaCorrecta())) {
                correctas=correctas+1;
               
            }
        }
//        System.out.println(correctas);
//        System.out.println("tu promedio es: "+ correctas*10/respuestas.length);
        ResultadosFrame resultados  = new ResultadosFrame (listaPreguntas,respuestas,correctas*10/respuestas.length);
        MainFrame.desktop.add(resultados);
        resultados.setVisible(true);
        this.dispose();
    }

}
