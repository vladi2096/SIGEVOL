/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;


import consultas.ContactoEmergenciaConsulta;
import consultas.CursoConsulta;
import consultas.IdiomaConsulta;
import consultas.PersonaConsulta;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import entidades.contactoEmergencia;
import entidades.persona;

/**
 *
 * @author Vladimir
 */
public class BuscarPersona extends javax.swing.JFrame {

    /**
     * Creates new form buscarPersona
     */
    
    PersonaConsulta personaConsulta = new PersonaConsulta();
    ContactoEmergenciaConsulta contactoEmergenciaConsulta = new ContactoEmergenciaConsulta();
    IdiomaConsulta idiomaConsulta = new IdiomaConsulta();
    CursoConsulta cursoConsulta =  new CursoConsulta();
    
    public BuscarPersona() {
        initComponents();
        botonBuscar.setEnabled(false);
        nombreSele.setVisible(false);
        
        
        //this.setMinimumSize(new Dimension(904, 190)); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        nombreSele = new javax.swing.JList<>();
        jSeparator1 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIPAJU");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel2.setText("Buscar por nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Escriba el nombre a buscar:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 40));

        nombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombre.setToolTipText("");
        nombre.setBorder(null);
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 360, 40));

        botonBuscar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 110, 40));

        jScrollPane1.setBorder(null);
        jScrollPane1.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N

        nombreSele.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        nombreSele.setToolTipText("");
        nombreSele.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreSeleKeyPressed(evt);
            }
        });
        nombreSele.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                nombreSeleValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(nombreSele);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 360, 110));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 360, 30));

        jButton6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jButton6.setText("Menu Principal");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 162, -1));

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(792, 3, 30, 322));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/imagenes/logo pequeno.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 825, 328));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        persona person = personaConsulta.obtenerPersona( nombre.getText(), 0, "Activo" );
        contactoEmergencia contacto = contactoEmergenciaConsulta.obtenerContactoEmergencia( person.getCedula() );
        ArrayList<Boolean> idioma = idiomaConsulta.obtenerIdioma( person.getCedula() );
        ArrayList<Boolean> cursos = cursoConsulta.obtenerCurso( person.getCedula() );
        person.setIdioma(idioma);
        person.setCursos(cursos);
        InformacionPersona abrir = new InformacionPersona(person, contacto);
        abrir.setLocationRelativeTo(null);
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        // TODO add your handling code here:
        
        if(nombre.getText().isEmpty()){
            nombreSele.setVisible(false);
            jScrollPane1.setVisible(false);
            
        }
        else{
            nombreSele.setVisible(true);
            jScrollPane1.setVisible(true);
            String palabra = nombre.getText();
            ArrayList<String> lista = personaConsulta.obtenerNombreBuscar(palabra);

            nombreSele.removeAll();
            DefaultListModel modelo = new DefaultListModel();
            for(int i = 0; i < lista.size(); i++){
                    modelo.addElement(lista.get(i));
            }
            nombreSele.setModel(modelo);
        }
    }//GEN-LAST:event_nombreKeyTyped

    private void nombreSeleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreSeleKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_nombreSeleKeyPressed

    private void nombreSeleValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_nombreSeleValueChanged
        // TODO add your handling code here:
        nombre.setText(nombreSele.getSelectedValue());
        nombreSele.setVisible(false);
        jScrollPane1.setVisible(false);
        botonBuscar.setEnabled(true);
        
    }//GEN-LAST:event_nombreSeleValueChanged

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Menu abrir = new Menu();
        abrir.setLocationRelativeTo(null);
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BuscarPersona().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nombre;
    private javax.swing.JList<String> nombreSele;
    // End of variables declaration//GEN-END:variables
}