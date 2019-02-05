/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import conexion.consultaBase;
import consultas.EstadisticaConsulta;
import java.util.ArrayList;

/**
 *
 * @author Vladimir
 */
public class EstadisticaGeneral extends javax.swing.JFrame {

    /**
     * Creates new form estadistica
     */
    
    EstadisticaConsulta estadisticaConsulta = new EstadisticaConsulta();
    
    public EstadisticaGeneral() {
        initComponents();
        cantidadPersonal();
        personalRegion();
    }
    
    
    public void cantidadPersonal(){
        ArrayList<Integer> cantidad = estadisticaConsulta.obtenerEstadisticas();
        inscritas.setText(String.valueOf(cantidad.get(0) + cantidad.get(1)));
        masculino.setText(String.valueOf(cantidad.get(0)));
        femenino.setText(String.valueOf(cantidad.get(1)));
        edad.setText(String.valueOf(cantidad.get(2)));
        
    }
    
    
    public void personalRegion(){
        
        ArrayList<Integer> cantidad = estadisticaConsulta.obtenerPersonalRegion();
        sanjose.setText(cantidad.get(0).toString());
        alajuela.setText(cantidad.get(1).toString());
        cartago.setText(cantidad.get(2).toString());
        heredia.setText(cantidad.get(3).toString());
        guanacaste.setText(cantidad.get(4).toString());
        puntarenas.setText(cantidad.get(5).toString());
        limon.setText(cantidad.get(6).toString());
        sur.setText(cantidad.get(7).toString());
        norte.setText(cantidad.get(8).toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        inscritas = new javax.swing.JLabel();
        masculino = new javax.swing.JLabel();
        femenino = new javax.swing.JLabel();
        sanjose = new javax.swing.JLabel();
        alajuela = new javax.swing.JLabel();
        cartago = new javax.swing.JLabel();
        heredia = new javax.swing.JLabel();
        guanacaste = new javax.swing.JLabel();
        puntarenas = new javax.swing.JLabel();
        limon = new javax.swing.JLabel();
        sur = new javax.swing.JLabel();
        norte = new javax.swing.JLabel();
        edad = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        edad1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        jLabel19.setText("jLabel19");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIPAJU");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/imagenes/logo pequeno.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(690, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, 0))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 651, 884, -1));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 40)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Estadísticas Generales");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 15, 884, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Personal Inscrito");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 210, -1));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Personal Masculino");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 210, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Personal Femenino");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 210, -1));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("San José");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 135, -1));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Alajuela");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 135, -1));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 204));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Cartago");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, 135, -1));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Heredia");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, 135, -1));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Guanacaste");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 410, 135, -1));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 204));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Puntarenas");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, 135, -1));

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 204));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Limón");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 135, -1));

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 204));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Zona Sur");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 135, -1));

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 204));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Zona Norte");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 510, 135, -1));

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Promedio de edad");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 190, -1));

        inscritas.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        inscritas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inscritas.setText("-");
        inscritas.setToolTipText("");
        jPanel1.add(inscritas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 210, -1));

        masculino.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        masculino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        masculino.setText("-");
        masculino.setToolTipText("");
        jPanel1.add(masculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 210, -1));

        femenino.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        femenino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        femenino.setText("-");
        femenino.setToolTipText("");
        jPanel1.add(femenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 210, -1));

        sanjose.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        sanjose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sanjose.setText("-");
        jPanel1.add(sanjose, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 135, -1));

        alajuela.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        alajuela.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alajuela.setText("-");
        jPanel1.add(alajuela, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 135, -1));

        cartago.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        cartago.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cartago.setText("-");
        jPanel1.add(cartago, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, 135, -1));

        heredia.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        heredia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heredia.setText("-");
        jPanel1.add(heredia, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 135, -1));

        guanacaste.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        guanacaste.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guanacaste.setText("-");
        jPanel1.add(guanacaste, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 440, 135, -1));

        puntarenas.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        puntarenas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puntarenas.setText("-");
        jPanel1.add(puntarenas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, 135, -1));

        limon.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        limon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        limon.setText("-");
        jPanel1.add(limon, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, 135, -1));

        sur.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        sur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sur.setText("-");
        jPanel1.add(sur, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 540, 135, -1));

        norte.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        norte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        norte.setText("-");
        jPanel1.add(norte, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 540, 135, -1));

        edad.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        edad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        edad.setText("-");
        jPanel1.add(edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 190, -1));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/imagenes/003-chico.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 210, 64));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/imagenes/reloj-de-arena.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 270, 64));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/imagenes/002-chica.png"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 210, 64));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/imagenes/001-personas.png"))); // NOI18N
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 210, 64));

        jLabel21.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Promedio de permanencia");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 270, -1));

        edad1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        edad1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        edad1.setText("-");
        jPanel1.add(edad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 270, -1));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/imagenes/calendario.png"))); // NOI18N
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 190, 64));

        jButton4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButton4.setText("Menú principal");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 600, 199, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 700));

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
            java.util.logging.Logger.getLogger(EstadisticaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstadisticaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstadisticaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstadisticaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstadisticaGeneral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alajuela;
    private javax.swing.JLabel cartago;
    private javax.swing.JLabel edad;
    private javax.swing.JLabel edad1;
    private javax.swing.JLabel femenino;
    private javax.swing.JLabel guanacaste;
    private javax.swing.JLabel heredia;
    private javax.swing.JLabel inscritas;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel limon;
    private javax.swing.JLabel masculino;
    private javax.swing.JLabel norte;
    private javax.swing.JLabel puntarenas;
    private javax.swing.JLabel sanjose;
    private javax.swing.JLabel sur;
    // End of variables declaration//GEN-END:variables
}
