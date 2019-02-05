/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import entidades.contactoEmergencia;
import entidades.persona;
import java.awt.Color;
import java.util.StringTokenizer;

/**
 *
 * @author Vladimir
 */
public final class InformacionPersona extends javax.swing.JFrame {

    /**
     * Creates new form informacionPersona
     * @param person
     * @param contacto
     */
    public InformacionPersona(persona person, contactoEmergencia contacto) {
        initComponents();
        infoPersona(person, contacto);
    }

    public void infoPersona(persona person, contactoEmergencia contacto){
        
        //Informacion basica de la persona
        nombre.setText(person.getNombre());
        cedula.setText(String.valueOf(person.getCedula()));
        codVoluntario.setText(person.getCodigoVoluntario());
        genero.setText(person.getGenero());
        
        //Fecha de Nacimiento
        StringTokenizer tokensNacimiento = new StringTokenizer(person.getFechaNacimiento(), "-");
        String ano1 = tokensNacimiento.nextToken();
        String mes1 = tokensNacimiento.nextToken();
        String dia1 = tokensNacimiento.nextToken();
        nacimiento.setText(dia1+"/"+mes1+"/"+ano1);
        
        
        edad.setText(String.valueOf(person.getEdad()) + " años");
        oficio.setText(person.getOficio());
        if(person.getTelefono() != 0){ telefono.setText(String.valueOf(person.getTelefono()));} else{telefono.setText(" ");}
        if(person.getCelular() != 0){ celular.setText(String.valueOf(person.getCelular()));} else{celular.setText(" ");}
        correo.setText(person.getCorreo());
        
        StringTokenizer tokensIngreso = new StringTokenizer(person.getFechaIngreso(), "-");
        String ano2 = tokensIngreso.nextToken();
        String mes2 = tokensIngreso.nextToken();
        String dia2 = tokensIngreso.nextToken();
        ingreso.setText(dia2+"/"+mes2+"/"+ano2);
        
        
        if(person.getAnosCR() == 1){anosCR.setText(String.valueOf(person.getAnosCR()) + " año");} else{ anosCR.setText(String.valueOf(person.getAnosCR()) + " años"); }
        asociado.setText(person.getEsAsociado());
        cargo.setText(person.getCargo());
        comite.setText(person.getComite());
        grado.setText(person.getGrado());
        programa.setText(person.getPrograma());
        region.setText(person.getRegion());
        
        //Informacion de Idiomas
        String idioma = "";
        if(person.getIdioma().get(0)){
            idioma += "Español ";
        }
        if(person.getIdioma().get(1)){
            idioma += "Inglés ";
        }
        if(person.getIdioma().get(2)){
            idioma += "Portugués ";
        }
        if(person.getIdioma().get(3)){
            idioma += "Alemán ";
        }
        if(person.getIdioma().get(4)){
            idioma += "Francés ";
        }
        if(person.getIdioma().get(5)){
            idioma += "Mandarín ";
        }
        idio.setText(idioma);
        
        
        
        //Informacion sobre cursos
        jCheckBox7.setSelected(person.getCursos().get(0));
        jCheckBox6.setSelected(person.getCursos().get(1));
        jCheckBox5.setSelected(person.getCursos().get(2));
        jCheckBox11.setSelected(person.getCursos().get(3));
        jCheckBox10.setSelected(person.getCursos().get(4));
        jCheckBox9.setSelected(person.getCursos().get(5));
        jCheckBox14.setSelected(person.getCursos().get(6));
        jCheckBox13.setSelected(person.getCursos().get(7));
        jCheckBox12.setSelected(person.getCursos().get(8));
        jCheckBox17.setSelected(person.getCursos().get(9));
        jCheckBox16.setSelected(person.getCursos().get(10));
        jCheckBox15.setSelected(person.getCursos().get(11));
        jCheckBox20.setSelected(person.getCursos().get(12));
        jCheckBox19.setSelected(person.getCursos().get(13));
        jCheckBox18.setSelected(person.getCursos().get(14));
        jCheckBox23.setSelected(person.getCursos().get(15));
        jCheckBox22.setSelected(person.getCursos().get(16));
        jCheckBox21.setSelected(person.getCursos().get(17));
        jCheckBox26.setSelected(person.getCursos().get(18));
        jCheckBox25.setSelected(person.getCursos().get(19));
        jCheckBox24.setSelected(person.getCursos().get(20));
        
        jCheckBox7.setForeground(Color.black); 
        jCheckBox7.setEnabled(false);
        jCheckBox6.setForeground(Color.black); 
        jCheckBox6.setEnabled(false);
        jCheckBox5.setForeground(Color.black); 
        jCheckBox5.setEnabled(false);
        jCheckBox11.setForeground(Color.black); 
        jCheckBox11.setEnabled(false);
        jCheckBox10.setForeground(Color.black); 
        jCheckBox10.setEnabled(false);
        jCheckBox9.setForeground(Color.black); 
        jCheckBox9.setEnabled(false);
        jCheckBox14.setForeground(Color.black); 
        jCheckBox14.setEnabled(false);
        jCheckBox13.setForeground(Color.black); 
        jCheckBox13.setEnabled(false);
        jCheckBox12.setForeground(Color.black); 
        jCheckBox12.setEnabled(false);
        jCheckBox17.setForeground(Color.black); 
        jCheckBox17.setEnabled(false);
        jCheckBox16.setForeground(Color.black); 
        jCheckBox16.setEnabled(false);
        jCheckBox15.setForeground(Color.black); 
        jCheckBox15.setEnabled(false);
        jCheckBox20.setForeground(Color.black); 
        jCheckBox20.setEnabled(false);
        jCheckBox19.setForeground(Color.black); 
        jCheckBox19.setEnabled(false);
        jCheckBox18.setForeground(Color.black); 
        jCheckBox18.setEnabled(false);
        jCheckBox23.setForeground(Color.black); 
        jCheckBox23.setEnabled(false);
        jCheckBox22.setForeground(Color.black); 
        jCheckBox22.setEnabled(false);
        jCheckBox21.setForeground(Color.black); 
        jCheckBox21.setEnabled(false);
        jCheckBox26.setForeground(Color.black); 
        jCheckBox26.setEnabled(false);
        jCheckBox25.setForeground(Color.black); 
        jCheckBox25.setEnabled(false);
        jCheckBox24.setForeground(Color.black); 
        jCheckBox24.setEnabled(false);
        
        
        //Informacion de conctaco de la persona
        nombreCompleto.setText(contacto.getNombre());
        num.setText(String.valueOf(contacto.getNumero()));
        parentesco.setText(contacto.getParentesco());
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        celular = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        correo = new javax.swing.JLabel();
        asda = new javax.swing.JLabel();
        ww = new javax.swing.JLabel();
        asociado = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cargo = new javax.swing.JLabel();
        ingreso = new javax.swing.JLabel();
        region = new javax.swing.JLabel();
        adas = new javax.swing.JLabel();
        comite = new javax.swing.JLabel();
        anosCR = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        nacimiento = new javax.swing.JLabel();
        grado = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        edad = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        programa = new javax.swing.JLabel();
        oficio = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cedula = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        codVoluntario = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        genero = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        telefono = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        idio = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        jCheckBox20 = new javax.swing.JCheckBox();
        jCheckBox21 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox22 = new javax.swing.JCheckBox();
        jCheckBox23 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox24 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox25 = new javax.swing.JCheckBox();
        jCheckBox26 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        parentesco = new javax.swing.JLabel();
        nombreCompleto = new javax.swing.JLabel();
        num = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

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

        jTabbedPane1.setFocusable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        celular.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        celular.setText("-");

        jLabel21.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 51));
        jLabel21.setText("Correo:");

        correo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        correo.setText("-");

        asda.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        asda.setForeground(new java.awt.Color(255, 0, 51));
        asda.setText("Idioma(s):");

        ww.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        ww.setForeground(new java.awt.Color(255, 0, 51));
        ww.setText("Asociado Activo:");

        asociado.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        asociado.setText("-");

        jLabel27.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 0, 51));
        jLabel27.setText("Cargo:");

        cargo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cargo.setText("-");

        ingreso.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ingreso.setText("-");

        region.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        region.setText("-");

        adas.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        adas.setForeground(new java.awt.Color(255, 0, 51));
        adas.setText("Fecha de Ingreso: ");

        comite.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        comite.setText("-");

        anosCR.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        anosCR.setText("-");

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("Comité:");

        jLabel32.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 0, 51));
        jLabel32.setText("Años en Cruz Roja:");

        nacimiento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        nacimiento.setText("-");

        grado.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        grado.setText("-");

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("Fecha de Nacimiento: ");

        jLabel34.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 0, 51));
        jLabel34.setText("Grado académico:");

        edad.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        edad.setText("-");

        jLabel35.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 0, 51));
        jLabel35.setText("Programa:");

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 51));
        jLabel14.setText("Edad:");

        programa.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        programa.setText("-");

        oficio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        oficio.setText("-");

        jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 51));
        jLabel16.setText("Oficio:");

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 51));
        jLabel17.setText("Teléfono:");

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Cédula:");

        cedula.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cedula.setText("-");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Código de voluntario:");

        codVoluntario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        codVoluntario.setText("-");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Género:");

        genero.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        genero.setText("-");

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("Región:");

        telefono.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telefono.setText("-");

        jLabel19.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 51));
        jLabel19.setText("Celular:");

        idio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        idio.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(genero, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(12, 12, 12)
                        .addComponent(cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(region, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oficio, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(codVoluntario, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comite, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(79, 79, 79))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel21)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(ww)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(asociado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel19)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(celular, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel35)
                                    .addGap(12, 12, 12)
                                    .addComponent(programa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel32)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(anosCR, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(adas)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(121, 121, 121)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(asda)
                        .addGap(18, 18, 18)
                        .addComponent(idio, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(grado, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cedula)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(telefono)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(celular)
                    .addComponent(jLabel3)
                    .addComponent(codVoluntario))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(genero))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(correo)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(cargo))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34)
                        .addComponent(grado)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(programa)
                    .addComponent(jLabel7)
                    .addComponent(region))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(comite))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(adas)
                        .addComponent(ingreso)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(nacimiento))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32)
                        .addComponent(anosCR)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asda)
                    .addComponent(jLabel14)
                    .addComponent(edad)
                    .addComponent(idio))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(oficio))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ww)
                        .addComponent(asociado)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Información básica", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox15.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox15.setText("Asistente en Primeros Auxilios");
        jPanel2.add(jCheckBox15, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, -1, 30));

        jCheckBox16.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox16.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox16.setText("Básico en Primeros Auxilios");
        jPanel2.add(jCheckBox16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, 30));

        jCheckBox17.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox17.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox17.setText("Doctrina y Difusión");
        jPanel2.add(jCheckBox17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 30));

        jCheckBox18.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox18.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox18.setText("Primero Auxilios Psicológicos");
        jPanel2.add(jCheckBox18, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 290, -1, 30));

        jCheckBox19.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox19.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox19.setText("Técnico en Emergencias Médicas");
        jPanel2.add(jCheckBox19, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, -1, 30));

        jLabel22.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 51));
        jLabel22.setText("Cursos obtenidos");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

        jCheckBox20.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox20.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox20.setText("Asistente en Emergencias Médicas");
        jCheckBox20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox20ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, 30));

        jCheckBox21.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox21.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox21.setText("Formación de Instructores");
        jPanel2.add(jCheckBox21, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, -1, 30));

        jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox5.setText("Facilitadores en Brigadas Educativas");
        jPanel2.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, -1, 30));

        jCheckBox22.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox22.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox22.setText("Jóvenes Agentes de Cambio de comportamiento");
        jPanel2.add(jCheckBox22, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, -1, 30));

        jCheckBox23.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox23.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox23.setText("Retorno a la Alegría");
        jPanel2.add(jCheckBox23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, 30));

        jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox6.setText("Formación de Jefaturas Locales de Juventud");
        jPanel2.add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, 30));

        jCheckBox24.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox24.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox24.setText("Cortesía y Disciplina");
        jPanel2.add(jCheckBox24, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 390, -1, 30));

        jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox7.setText("Formación Básica en Juventud");
        jPanel2.add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 30));

        jCheckBox25.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox25.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox25.setText("Manejo de Suministros de Emergencias");
        jCheckBox25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox25ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox25, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, -1, 30));

        jCheckBox26.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox26.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox26.setText("Desarrollo de Habilidades de Liderazgo");
        jCheckBox26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox26ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, 30));

        jCheckBox9.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox9.setText("Dinamizadores Sociales");
        jPanel2.add(jCheckBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, -1, 30));

        jCheckBox10.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox10.setText("Facilitadores en Prevención en VIH-SIDA");
        jPanel2.add(jCheckBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, -1, 30));

        jCheckBox11.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox11.setText("Elaboración de Proyectos");
        jCheckBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox11ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 30));

        jCheckBox12.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox12.setText("Seguridad Vial");
        jPanel2.add(jCheckBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, -1, 30));

        jCheckBox13.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox13.setText("Habilidades para la vida");
        jPanel2.add(jCheckBox13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, 30));

        jCheckBox14.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckBox14.setText("Educación Ambiental");
        jPanel2.add(jCheckBox14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 30));

        jTabbedPane1.addTab("Capacitación", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 0, 51));
        jLabel25.setText("Parentesco:");

        jLabel26.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 0, 51));
        jLabel26.setText("Número de teléfono:");

        jLabel28.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 0, 51));
        jLabel28.setText("Nombre Completo:");

        jLabel24.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 0, 51));
        jLabel24.setText("Contacto en Caso de Emergencia");

        parentesco.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        parentesco.setText("-");

        nombreCompleto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        nombreCompleto.setText("-");

        num.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        num.setText("-");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(212, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(253, 253, 253))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(parentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jLabel24)))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addGap(66, 66, 66)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreCompleto)
                    .addComponent(jLabel28))
                .addGap(65, 65, 65)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(parentesco)
                    .addComponent(num)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25))
                .addGap(121, 121, 121))
        );

        jTabbedPane1.addTab("Contacto de emergencia", jPanel3);

        jPanel4.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 90, 1010, -1));

        nombre.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 40)); // NOI18N
        nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombre.setText("[nombre]");
        jPanel4.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 20, 1010, -1));

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

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1016, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Menu abrir = new Menu();
        abrir.setLocationRelativeTo(null);
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jCheckBox20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox20ActionPerformed

    private void jCheckBox26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox26ActionPerformed

    private void jCheckBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox11ActionPerformed

    private void jCheckBox25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox25ActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(persona person, contactoEmergencia contacto) {
                new InformacionPersona(person, contacto).setVisible(true);
            }

            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adas;
    private javax.swing.JLabel anosCR;
    private javax.swing.JLabel asda;
    private javax.swing.JLabel asociado;
    private javax.swing.JLabel cargo;
    private javax.swing.JLabel cedula;
    private javax.swing.JLabel celular;
    private javax.swing.JLabel codVoluntario;
    private javax.swing.JLabel comite;
    private javax.swing.JLabel correo;
    private javax.swing.JLabel edad;
    private javax.swing.JLabel genero;
    private javax.swing.JLabel grado;
    private javax.swing.JLabel idio;
    private javax.swing.JLabel ingreso;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JCheckBox jCheckBox25;
    private javax.swing.JCheckBox jCheckBox26;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel nacimiento;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel nombreCompleto;
    private javax.swing.JLabel num;
    private javax.swing.JLabel oficio;
    private javax.swing.JLabel parentesco;
    private javax.swing.JLabel programa;
    private javax.swing.JLabel region;
    private javax.swing.JLabel telefono;
    private javax.swing.JLabel ww;
    // End of variables declaration//GEN-END:variables
}
