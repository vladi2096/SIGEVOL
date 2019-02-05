/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import entidades.traslado;
import java.awt.Color;
import java.util.StringTokenizer;
import javax.swing.UIManager;

/**
 *
 * @author Vladimir
 */
public class InfoPersonaTraslado extends javax.swing.JFrame {

    /**
     * Creates new form informacionPersona
     * @param person
     */
    public InfoPersonaTraslado(traslado person) {
        initComponents();
        infoPersona(person);
    }

    public void infoPersona(traslado person){
        
        //Informacion basica de la persona
        nombre.setText(person.getPersona().getNombre());
        cedula.setText(String.valueOf(person.getPersona().getCedula()));
        codVoluntario.setText(person.getPersona().getCodigoVoluntario());
        genero.setText(person.getPersona().getGenero());
        
        
        //Fecha de Nacimiento
        StringTokenizer tokensNacimiento = new StringTokenizer(person.getPersona().getFechaNacimiento(), "-");
        String ano1 = tokensNacimiento.nextToken();
        String mes1 = tokensNacimiento.nextToken();
        String dia1 = tokensNacimiento.nextToken();
        nacimiento.setText(dia1+"/"+mes1+"/"+ano1);
        
        //Fecha de Desafiliacion
        StringTokenizer tokensDesafiliacion = new StringTokenizer(person.getFecha(), "-");
        String ano3 = tokensDesafiliacion.nextToken();
        String mes3 = tokensDesafiliacion.nextToken();
        String dia3 = tokensDesafiliacion.nextToken();
        fechaTraslado.setText(dia3+"/"+mes3+"/"+ano3);
  
        edad.setText(String.valueOf(person.getPersona().getEdad()) + " años");
        if(person.getPersona().getTelefono() != 0){ telefono.setText(String.valueOf(person.getPersona().getTelefono()));} else{telefono.setText(" ");}
        if(person.getPersona().getCelular() != 0){ celular.setText(String.valueOf(person.getPersona().getCelular()));} else{celular.setText(" ");}
        correo.setText(person.getPersona().getCorreo());
        
        StringTokenizer tokensIngreso = new StringTokenizer(person.getPersona().getFechaIngreso(), "-");
        String ano2 = tokensIngreso.nextToken();
        String mes2 = tokensIngreso.nextToken();
        String dia2 = tokensIngreso.nextToken();
        ingreso.setText(dia2+"/"+mes2+"/"+ano2);
        
        comite.setText(person.getPersona().getComite());
        region.setText(person.getPersona().getRegion());
        
        motivo.setText(person.getMotivo());
        
        estructura.setText(person.getEstructura());
        comiteAct.setText(person.getComiteN());
        boleta.setText(String.valueOf(person.getNumBoleta()));
        regionAct.setText(person.getRegionN());
        
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        nombre = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        edad = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        celular = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        correo = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cedula = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        codVoluntario = new javax.swing.JLabel();
        ingreso = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        region = new javax.swing.JLabel();
        genero = new javax.swing.JLabel();
        adas = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comite = new javax.swing.JLabel();
        telefono = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nacimiento = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        fechaTraslado = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        motivo = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        regionAct = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comiteAct = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        estructura = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        boleta = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIPAJU");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButton4.setText("Menú principal");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 610, 199, 30));

        nombre.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 40)); // NOI18N
        nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombre.setText("[nombre]");
        jPanel4.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1010, -1));

        jPanel5.setBackground(new java.awt.Color(255, 0, 51));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/imagenes/principalCRJ.png"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(389, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(381, 381, 381))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4))
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 657, 1010, 70));

        edad.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        edad.setText("-");
        jPanel4.add(edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 51));
        jLabel14.setText("Edad:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        celular.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        celular.setText("-");
        jPanel4.add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, -1, -1));

        jLabel21.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 51));
        jLabel21.setText("Correo:");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, -1, -1));

        correo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        correo.setText("-");
        jPanel4.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, -1, -1));

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 51));
        jLabel17.setText("Teléfono:");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Cédula:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

        cedula.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cedula.setText("-");
        jPanel4.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Código de voluntario:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

        codVoluntario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        codVoluntario.setText("-");
        jPanel4.add(codVoluntario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, -1, -1));

        ingreso.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ingreso.setText("-");
        jPanel4.add(ingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 280, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Género:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        region.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        region.setText("-");
        jPanel4.add(region, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, -1, -1));

        genero.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        genero.setText("-");
        jPanel4.add(genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        adas.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        adas.setForeground(new java.awt.Color(255, 0, 51));
        adas.setText("Fecha de Ingreso: ");
        jPanel4.add(adas, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("Región Anterior:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, -1, -1));

        comite.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        comite.setText("-");
        jPanel4.add(comite, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, -1, -1));

        telefono.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telefono.setText("-");
        jPanel4.add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, -1, -1));

        jLabel19.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 51));
        jLabel19.setText("Celular:");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("Comité Anterior:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, -1, -1));

        nacimiento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        nacimiento.setText("-");
        jPanel4.add(nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("Fecha de Nacimiento: ");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, -1, -1));

        fechaTraslado.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        fechaTraslado.setText("-");
        jPanel4.add(fechaTraslado, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, -1, -1));

        jLabel18.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 51));
        jLabel18.setText("Fecha de traslado:");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, -1, -1));

        motivo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        motivo.setText("-");
        jPanel4.add(motivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 540, -1, -1));

        jLabel20.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 51));
        jLabel20.setText("Motivo:");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, -1, -1));

        regionAct.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        regionAct.setText("-");
        jPanel4.add(regionAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 380, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("Región Actual:");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 380, -1, -1));

        comiteAct.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        comiteAct.setText("-");
        jPanel4.add(comiteAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 430, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("Comité Actual:");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 430, -1, -1));

        estructura.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        estructura.setText("-");
        jPanel4.add(estructura, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 480, -1, -1));

        jLabel22.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 51));
        jLabel22.setText("Estructura Actual:");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, -1, -1));

        boleta.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        boleta.setText("-");
        jPanel4.add(boleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 330, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("Numero de boleta:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1016, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Menu abrir = new Menu();
        abrir.setLocationRelativeTo(null);
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(InfoPersonaTraslado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoPersonaTraslado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoPersonaTraslado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoPersonaTraslado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(traslado person) {
                new InfoPersonaTraslado(person).setVisible(true);
            }

            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adas;
    private javax.swing.JLabel boleta;
    private javax.swing.JLabel cedula;
    private javax.swing.JLabel celular;
    private javax.swing.JLabel codVoluntario;
    private javax.swing.JLabel comite;
    private javax.swing.JLabel comiteAct;
    private javax.swing.JLabel correo;
    private javax.swing.JLabel edad;
    private javax.swing.JLabel estructura;
    private javax.swing.JLabel fechaTraslado;
    private javax.swing.JLabel genero;
    private javax.swing.JLabel ingreso;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel motivo;
    private javax.swing.JLabel nacimiento;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel region;
    private javax.swing.JLabel regionAct;
    private javax.swing.JLabel telefono;
    // End of variables declaration//GEN-END:variables
}
