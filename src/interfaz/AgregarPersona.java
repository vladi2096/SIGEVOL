/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import conexion.consultaBase;
import consultas.CargoConsulta;
import consultas.ComiteConsulta;
import consultas.ContactoEmergenciaConsulta;
import consultas.CursoConsulta;
import consultas.GradoAcademicoConsulta;
import consultas.IdiomaConsulta;
import consultas.PersonaConsulta;
import consultas.RegionConsulta;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import entidades.contactoEmergencia;
import entidades.persona;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vladimir
 */
public class AgregarPersona extends javax.swing.JFrame {

    /**
     * Creates new form agregarPersona
     */
    
    PersonaConsulta personaConsulta = new PersonaConsulta();
    ContactoEmergenciaConsulta contactoEmergenciaConsulta = new ContactoEmergenciaConsulta();
    IdiomaConsulta idiomaConsulta = new IdiomaConsulta();
    CursoConsulta cursoConsulta = new CursoConsulta();
    CargoConsulta cargoConsulta = new CargoConsulta();
    GradoAcademicoConsulta gradoAcademicoConsulta = new GradoAcademicoConsulta();
    RegionConsulta regionConsulta = new RegionConsulta();
    ComiteConsulta comiteConsulta = new ComiteConsulta();
    
    public AgregarPersona() 
    {
        initComponents();
        jPanel8.setVisible(false);
        jPanel6.setVisible(false);
        llenarCargo();
        llenarGradoAcademico();
        
        req1.setVisible(false);
        req2.setVisible(false);
        req4.setVisible(false);
        req5.setVisible(false);
        req6.setVisible(false);
        req7.setVisible(false);
        req8.setVisible(false);
        req10.setVisible(false);
        req11.setVisible(false);
        req12.setVisible(false);
        req3.setVisible(false);
        req13.setVisible(false);
        req9.setVisible(false);
    }
    
    public void llenarCargo()
    {
        ArrayList<String> lista;
        lista = cargoConsulta.obtenerCargo();
        for( String objeto : lista )
        {
            jComboBox2.addItem(objeto);
        }
    }
    
    public void llenarGradoAcademico()
    {
        ArrayList<String> lista;
        lista = gradoAcademicoConsulta.obtenerGradoAcademico();
        for( String objeto : lista )
        {
            jComboBox6.addItem(objeto);
        }
    }
    
    //Valida los datos general de la persona, nombre, cedula, codigo, etc.
    public boolean validarPrimerTab(){
        int count = 0;
        if(jTextField1.getText().equals("")){req1.setVisible(true); count++;} else{req1.setVisible(false);}
        if(jTextField3.getText().equals("")){req2.setVisible(true); count++;} else{req2.setVisible(false);}
        if(jTextField2.getText().equals("")){req4.setVisible(true); count++;} else{req4.setVisible(false);}
        if(jTextField5.getText().equals("")){req5.setVisible(true); count++;} else{req5.setVisible(false);}
        if(jTextField6.getText().equals("") || jTextField15.getText().equals("") || jTextField16.getText().equals("")){req6.setVisible(true); count++;} else{req6.setVisible(false);}
        if(jTextField18.getText().equals("") || jTextField17.getText().equals("") || jTextField19.getText().equals("")){req7.setVisible(true); count++;} else{req7.setVisible(false);}  
        return count == 0;
    }
    
    //Valida datos como la region, comite, grado academica, cargo, etc.
    public boolean validarSegundoTab(){
        int count = 0;
        if(jComboBox3.getSelectedItem().toString().equals(" ")){req8.setVisible(true); count++;} else{req8.setVisible(false);}
        if(jComboBox2.getSelectedItem().toString().equals("")){req10.setVisible(true); count++;} else{req10.setVisible(false);}
        if(jComboBox6.getSelectedItem().toString().equals("")){req11.setVisible(true); count++;} else{req11.setVisible(false);}
        if(jComboBox5.getSelectedItem().toString().equals("")){req12.setVisible(true); count++;} else{req12.setVisible(false);}
        return count == 0;
    }
    
    //Valida los datos del contacto de emergencia.
    public boolean validarTercerTab(){ 
        int count = 0;
        if(jTextField12.getText().equals("")){req3.setVisible(true); count++;} else{req3.setVisible(false);}
        if(jTextField14.getText().equals("")){req13.setVisible(true); count++;} else{req13.setVisible(false);}
        if(jTextField13.getText().equals("")){req9.setVisible(true); count++;} else{req9.setVisible(false);}
        return count == 0;
    }
    
    public void crearPersona() throws SQLException{
        if( validarTercerTab() ){
            ///Agregar persona (objeto)
            persona person = new persona();
            person.setEstado("Activo");
            person.setNombre(jTextField1.getText()+" "+jTextField3.getText()+" "+jTextField4.getText());
            person.setCodigoVoluntario(jTextField2.getText());
            person.setCedula(Integer.parseInt(jTextField5.getText()));
            person.setGenero(jComboBox1.getSelectedItem().toString());
            
            person.setFechaNacimiento(jTextField16.getText()+"-"+jTextField15.getText()+"-"+jTextField6.getText());
            
            if(jTextField7.getText().equals("")){
                person.setTelefono(0);
            }
            else{
                person.setTelefono(Integer.parseInt(jTextField7.getText()));
            }
            if(jTextField8.getText().equals("")){
                person.setCelular(0);
            }
            else{
                person.setCelular(Integer.parseInt(jTextField8.getText()));
            }

            if(jTextField9.getText().equals("")){
                person.setCorreo("false");
            }
            else{
                person.setCorreo(jTextField9.getText());
            }

            if(jTextField10.getText().equals("")){
                person.setOficio("false");
            }
            else{
                person.setOficio(jTextField10.getText());
            }
            person.setFechaIngreso(jTextField18.getText()+"-"+jTextField17.getText()+"-"+jTextField19.getText());
            person.setIdPrograma(obtenerPrograma());
            person.setIdComite(comiteConsulta.obtenerComiteId(jComboBox4.getSelectedItem().toString()));
            person.setIdCargo(cargoConsulta.obtenerCargoId(jComboBox2.getSelectedItem().toString()));
            person.setIdGrado(gradoAcademicoConsulta.obtenerGradoAcademicoId(jComboBox6.getSelectedItem().toString()));
            person.setEsAsociado(jComboBox5.getSelectedItem().toString());

            ///Agregar Idiomas (objeto lista)
            ArrayList<Boolean> idioma;
            idioma = obtenerIdioma();
            person.setIdioma(idioma);
            
            ///Agregar Cursos
            ArrayList<Boolean> curso;
            curso = obtenerCurso();
            person.setCursos(curso);
            
            ///Agregar Contacto de Emergencia (objeto)
            contactoEmergencia contacto = new contactoEmergencia();
            contacto.setNombre(jTextField12.getText());
            contacto.setNumero(Integer.parseInt(jTextField14.getText()));
            contacto.setParentesco(jTextField13.getText());
            
            this.agregarPersona(person, contacto);
            
            Menu abrir = new Menu();
            abrir.setLocationRelativeTo(null);
            abrir.setVisible(true);
            this.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "Aun falta datos por rellenar");
        }  
    }
    
    public void agregarPersona(persona person, contactoEmergencia contacto) throws SQLException{
        
        personaConsulta.agregarPersona(person);
        contactoEmergenciaConsulta.agregarContactoEmergencia(contacto, person.getCedula());
        idiomaConsulta.agregarIdiomaPersona(person.getCedula(), person.getIdioma());
        for(int i = 0; i < person.getCursos().size(); i++){
            if(person.getCursos().get(i)){
                cursoConsulta.agregarCursoPersona(person.getCedula(), i+1);
            }
        }
    }
    
    public int obtenerPrograma(){
        Calendar cal= Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int anoPersona = Integer.parseInt(jTextField16.getText());

        if(year-anoPersona < 13)
        {
            return 1;
        }
        else if(year-anoPersona > 12 && year-anoPersona < 18)
        {
            return 2;
        }
        else if(year-anoPersona > 17 && year-anoPersona < 22)
        {
            return 3;
        }
        else
        {
            return 4;
        }
    }
    
    public ArrayList<Boolean> obtenerIdioma(){
        ArrayList<Boolean> idioma = new ArrayList<>();
        idioma.add(espanol.isSelected());
        idioma.add(ingles.isSelected());
        idioma.add(portugues.isSelected());
        idioma.add(aleman.isSelected());
        idioma.add(frances.isSelected());
        idioma.add(mandarin.isSelected()); 
        return idioma;
    }
    
    public ArrayList<Boolean> obtenerCurso(){
        ArrayList<Boolean> curso = new ArrayList<>();
        curso.add(jCheckBox7.isSelected());
        curso.add(jCheckBox6.isSelected());
        curso.add(jCheckBox5.isSelected());
        curso.add(jCheckBox11.isSelected());
        curso.add(jCheckBox10.isSelected());
        curso.add(jCheckBox9.isSelected());
        curso.add(jCheckBox14.isSelected());
        curso.add(jCheckBox13.isSelected());
        curso.add(jCheckBox12.isSelected());
        curso.add(jCheckBox17.isSelected());
        curso.add(jCheckBox16.isSelected());
        curso.add(jCheckBox15.isSelected());
        curso.add(jCheckBox20.isSelected());
        curso.add(jCheckBox19.isSelected());
        curso.add(jCheckBox18.isSelected());
        curso.add(jCheckBox23.isSelected());
        curso.add(jCheckBox22.isSelected());
        curso.add(jCheckBox21.isSelected());
        curso.add(jCheckBox26.isSelected());
        curso.add(jCheckBox25.isSelected());
        curso.add(jCheckBox24.isSelected());
        return curso;
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
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jComboBox2 = new javax.swing.JComboBox<>();
        jCheckBox17 = new javax.swing.JCheckBox();
        jComboBox3 = new javax.swing.JComboBox<>();
        jCheckBox18 = new javax.swing.JCheckBox();
        jComboBox4 = new javax.swing.JComboBox<>();
        jCheckBox19 = new javax.swing.JCheckBox();
        jLabel21 = new javax.swing.JLabel();
        jCheckBox20 = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        jCheckBox21 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox22 = new javax.swing.JCheckBox();
        jComboBox6 = new javax.swing.JComboBox<>();
        jCheckBox23 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox24 = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox25 = new javax.swing.JCheckBox();
        jCheckBox26 = new javax.swing.JCheckBox();
        req8 = new javax.swing.JLabel();
        req10 = new javax.swing.JLabel();
        req11 = new javax.swing.JLabel();
        req12 = new javax.swing.JLabel();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jComboBox5 = new javax.swing.JComboBox<>();
        jCheckBox12 = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jCheckBox13 = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        jCheckBox14 = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        aleman = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        ingles = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        espanol = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        portugues = new javax.swing.JCheckBox();
        frances = new javax.swing.JCheckBox();
        req1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        req2 = new javax.swing.JLabel();
        mandarin = new javax.swing.JCheckBox();
        jTextField2 = new javax.swing.JTextField();
        req4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        req5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        req6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        req7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jTextField12 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        req3 = new javax.swing.JLabel();
        req9 = new javax.swing.JLabel();
        req13 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIPAJU");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setPreferredSize(new java.awt.Dimension(1940, 1111));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 0, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/imagenes/principalCRJ.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(394, 394, 394)
                .addComponent(jLabel1)
                .addContainerGap(400, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 699, 1034, 70));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel4.setText("Agregar nueva persona");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 430, -1));

        jButton7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jButton7.setText("X");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, 40, 30));

        jButton8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButton8.setText("-");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, 40, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 1034, 100));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox15.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox15.setText("Asistente en Primeros Auxilios");
        jPanel8.add(jCheckBox15, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 350, -1, 30));

        jCheckBox16.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox16.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox16.setText("Básico en Primeros Auxilios");
        jPanel8.add(jCheckBox16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, -1, 30));

        jComboBox2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jPanel8.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 221, 34));

        jCheckBox17.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox17.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox17.setText("Doctrina y Difusión");
        jPanel8.add(jCheckBox17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 30));

        jComboBox3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "San Jose", "Alajuela", "Cartago", "Heredia", "Guanacaste", "Puntarenas", "Limon", "Zona Sur", "Zona Norte" }));
        jComboBox3.setName("cmbRegion"); // NOI18N
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel8.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 221, 34));

        jCheckBox18.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox18.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox18.setText("Primero Auxilios Psicológicos");
        jPanel8.add(jCheckBox18, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 390, -1, 30));

        jComboBox4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jPanel8.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 221, 34));

        jCheckBox19.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox19.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox19.setText("Técnico en Emergencias Médicas");
        jPanel8.add(jCheckBox19, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, -1, 30));

        jLabel21.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel21.setText("Cursos obtenidos");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, -1));

        jCheckBox20.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox20.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox20.setText("Asistente en Emergencias Médicas");
        jCheckBox20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox20ActionPerformed(evt);
            }
        });
        jPanel8.add(jCheckBox20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, 30));

        jLabel22.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel22.setText("Grado académico:");
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 30));

        jCheckBox21.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox21.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox21.setText("Formación de Instructores");
        jCheckBox21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox21ActionPerformed(evt);
            }
        });
        jPanel8.add(jCheckBox21, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 430, -1, 30));

        jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox5.setText("Facilitadores en Brigadas Educativas");
        jPanel8.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 230, -1, 30));

        jCheckBox22.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox22.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox22.setText("Jóvenes Agentes de Cambio de comportamiento");
        jPanel8.add(jCheckBox22, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, -1, 30));

        jComboBox6.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jPanel8.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 221, 34));

        jCheckBox23.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox23.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox23.setText("Retorno a la Alegría");
        jPanel8.add(jCheckBox23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, 30));

        jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox6.setText("Formación de Jefaturas Locales de Juventud");
        jPanel8.add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, -1, 30));

        jCheckBox24.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox24.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox24.setText("Cortesía y Disciplina");
        jPanel8.add(jCheckBox24, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 470, -1, 30));

        jLabel23.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel23.setText("Asociado Activo:");
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, 30));

        jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox7.setText("Formación Básica en Juventud");
        jPanel8.add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 30));

        jCheckBox25.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox25.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox25.setText("Manejo de Suministros de Emergencias");
        jPanel8.add(jCheckBox25, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, -1, 30));

        jCheckBox26.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox26.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox26.setText("Desarrollo de Habilidades de Liderazgo");
        jCheckBox26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox26ActionPerformed(evt);
            }
        });
        jPanel8.add(jCheckBox26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, 30));

        req8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        req8.setText("*Dato requerido*");
        jPanel8.add(req8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        req10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        req10.setText("*Dato requerido*");
        jPanel8.add(req10, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, -1, -1));

        req11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        req11.setText("*Dato requerido*");
        jPanel8.add(req11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));

        req12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        req12.setText("*Dato requerido*");
        jPanel8.add(req12, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, -1, -1));

        jCheckBox9.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox9.setText("Dinamizadores Sociales");
        jPanel8.add(jCheckBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 270, -1, 30));

        jCheckBox10.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox10.setText("Facilitadores en Prevención en VIH-SIDA");
        jPanel8.add(jCheckBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, -1, 30));

        jCheckBox11.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox11.setText("Elaboración de Proyectos");
        jCheckBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox11ActionPerformed(evt);
            }
        });
        jPanel8.add(jCheckBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 30));

        jComboBox5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Si", "No" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        jPanel8.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 221, 34));

        jCheckBox12.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox12.setText("Seguridad Vial");
        jPanel8.add(jCheckBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 310, -1, 30));
        jPanel8.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 1015, 10));

        jCheckBox13.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox13.setText("Habilidades para la vida");
        jPanel8.add(jCheckBox13, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, -1, 30));

        jLabel19.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel19.setText("Región:");
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 30));

        jCheckBox14.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jCheckBox14.setText("Educación Ambiental");
        jPanel8.add(jCheckBox14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, 30));

        jLabel20.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel20.setText("Comité:");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, 30));

        jLabel24.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel24.setText("Cargo:");
        jPanel8.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, -1, 30));

        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jButton1.setText("Atrás");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 540, 110, 30));

        jButton2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jButton2.setText("Siguiente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 540, 110, 30));

        jButton14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jButton14.setText("Menú principal");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 140, 30));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 103, 1034, 596));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 178, 31));

        jLabel29.setText("AAAA");
        jPanel7.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));

        jTextField4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 60, 178, 31));

        jTextField17.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 360, 37, 31));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Código del voluntario: ");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 30));

        jTextField9.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 256, 31));

        jTextField18.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 360, 69, 31));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("Oficio:");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, -1, 30));

        jLabel30.setText("DD");
        jPanel7.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 340, -1, -1));

        jTextField10.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 178, 31));

        jLabel31.setText("MM");
        jPanel7.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 340, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setText("Fecha de ingreso:");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, -1, 30));

        jLabel32.setText("AAAA");
        jPanel7.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 340, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Nombre:");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 30));

        jTextField19.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 360, 37, 31));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel13.setText("Primer Apellido:");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, 30));

        aleman.setBackground(new java.awt.Color(255, 255, 255));
        aleman.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        aleman.setText("Alemán");
        jPanel7.add(aleman, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel14.setText("Segundo Apellido:");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, -1, 30));

        ingles.setBackground(new java.awt.Color(255, 255, 255));
        ingles.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ingles.setText("Inglés");
        jPanel7.add(ingles, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel15.setText("Género:");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, -1, 30));

        espanol.setBackground(new java.awt.Color(255, 255, 255));
        espanol.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        espanol.setText("Español");
        jPanel7.add(espanol, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, -1, -1));

        jTextField1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setToolTipText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 178, 31));

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        jPanel7.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 150, 158, 31));

        portugues.setBackground(new java.awt.Color(255, 255, 255));
        portugues.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        portugues.setText("Portugués");
        jPanel7.add(portugues, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, -1, -1));

        frances.setBackground(new java.awt.Color(255, 255, 255));
        frances.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        frances.setText("Francés");
        frances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                francesActionPerformed(evt);
            }
        });
        jPanel7.add(frances, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, -1, -1));

        req1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        req1.setText("*Dato requerido*");
        jPanel7.add(req1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel18.setText("Idioma(s):");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, 30));

        req2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        req2.setText("*Dato requerido*");
        jPanel7.add(req2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, -1, -1));

        mandarin.setBackground(new java.awt.Color(255, 255, 255));
        mandarin.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        mandarin.setText("Mandarín");
        mandarin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mandarinActionPerformed(evt);
            }
        });
        jPanel7.add(mandarin, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, -1, -1));

        jTextField2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 178, 31));

        req4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        req4.setText("*Dato requerido*");
        jPanel7.add(req4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Cédula:");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, -1, 30));

        req5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        req5.setText("*Dato requerido*");
        jPanel7.add(req5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, -1, -1));

        jTextField5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        jPanel7.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 178, 31));

        req6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        req6.setText("*Dato requerido*");
        jPanel7.add(req6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Fecha de Nacimiento:");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, 30));

        req7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        req7.setText("*Dato requerido*");
        jPanel7.add(req7, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, -1, -1));

        jTextField6.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 37, 31));

        jTextField15.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 37, 31));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("Teléfono:");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, -1, 30));

        jTextField16.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 69, 31));

        jTextField7.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });
        jPanel7.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 178, 31));

        jLabel16.setText("DD");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Celular:");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, -1, 30));

        jLabel28.setText("MM");
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        jTextField8.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });
        jPanel7.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 260, 187, 31));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel17.setText("Correo:");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, 30));

        jButton9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jButton9.setText("Menú principal");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 140, 30));

        jButton10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jButton10.setText("Siguiente");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 540, 110, 30));

        jButton3.setText("Autopopulate");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 520, 160, 30));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 103, 1034, 596));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(1034, 596));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField12.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 490, 31));

        jLabel25.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 30)); // NOI18N
        jLabel25.setText("Contacto en Caso de Emergencia");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, -1, -1));

        jTextField13.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, 178, 31));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel26.setText("Parentesco:");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, -1, 30));

        jTextField14.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });
        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField14KeyTyped(evt);
            }
        });
        jPanel6.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 178, 31));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel27.setText("Número de teléfono:");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, -1, 30));

        jLabel33.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel33.setText("Nombre Completo:");
        jPanel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, 30));

        req3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        req3.setText("*Dato requerido*");
        jPanel6.add(req3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));

        req9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        req9.setText("*Dato requerido*");
        jPanel6.add(req9, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 400, -1, -1));

        req13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        req13.setText("*Dato requerido*");
        jPanel6.add(req13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, -1, -1));

        jButton11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jButton11.setText("Atrás");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 540, 110, 30));

        jButton12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jButton12.setText("Finalizar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 540, 110, 30));

        jButton15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jButton15.setText("Menú principal");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 140, 30));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 103, 1034, 596));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 772));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void francesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_francesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_francesActionPerformed

    private void mandarinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mandarinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mandarinActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
            (caracter > '9')) &&
        (caracter != '\b' /*corresponde a BACK_SPACE*/))
        {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if( ( ( caracter < '0' ) || ( caracter > '9' ) ) && ( caracter != '\b' ) )
        {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if( ( ( caracter < '0' ) || ( caracter > '9' ) ) && ( caracter != '\b' ) )
        {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_jTextField8KeyTyped

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        String region = jComboBox3.getSelectedItem().toString();
        jComboBox4.removeAllItems();
        ArrayList<String> lista;
        lista = comiteConsulta.obtenerComitesXRegion(regionConsulta.obtenerRegionId(region));
        for( String objeto : lista )
        {
            jComboBox4.addItem(objeto);
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jCheckBox20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox20ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jCheckBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox11ActionPerformed

    private void jCheckBox26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox26ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if( validarPrimerTab() )
        {
            if(personaConsulta.verificarCedula(Integer.parseInt(jTextField5.getText())))
            {
                JOptionPane.showMessageDialog( null, "Número de cédula ya se encuentra registrada" );
            }   
            else
            {
                jPanel7.setVisible(false);
                jPanel8.setVisible(true);      
            }
        }
        else
        {
            JOptionPane.showMessageDialog( null, "Aun falta datos por rellenar" );
        } 
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jPanel8.setVisible(false);
        jPanel7.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try {
            this.crearPersona();
        } 
        catch (SQLException ex) {
            Logger.getLogger(AgregarPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        jPanel6.setVisible(false);
        jPanel8.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    if( validarSegundoTab() )
        {
            jPanel8.setVisible( false );
            jPanel6.setVisible( true );
        }
        else
        {
            JOptionPane.showMessageDialog( null, "Aun falta datos por rellenar" );
        }   
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if( ( ( caracter < '0' ) || ( caracter > '9' ) ) && ( caracter != '\b' ) )
        {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_jTextField14KeyTyped

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jButton9.setEnabled(false);
        Menu abrir = new Menu();
        abrir.setLocationRelativeTo(null);
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        jButton14.setEnabled(false);
        Menu abrir = new Menu();
        abrir.setLocationRelativeTo(null);
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        jButton15.setEnabled(false);
        Menu abrir = new Menu();
        abrir.setLocationRelativeTo(null);
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jCheckBox21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox21ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextField1.setText("Vladimir");
        jTextField3.setText("Rojas");
        jTextField4.setText("Quesada");
        jTextField2.setText("VOL004517");
        jTextField6.setText("20");
        jTextField15.setText("07");
        jTextField16.setText("1996");
        jTextField8.setText("60076184");
        jTextField9.setText("vladirojas96@hotmail.com");
        jTextField10.setText("Desarrollador");
        jTextField19.setText("11");
        jTextField17.setText("02");
        jTextField18.setText("2010");
        espanol.setSelected(true);
        ingles.setSelected(true);
        jTextField12.setText("Hilda Quesada Villalobos");
        jTextField14.setText("60744530");
        jTextField13.setText("Madre");
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarPersona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox aleman;
    private javax.swing.JCheckBox espanol;
    private javax.swing.JCheckBox frances;
    private javax.swing.JCheckBox ingles;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JCheckBox mandarin;
    private javax.swing.JCheckBox portugues;
    private javax.swing.JLabel req1;
    private javax.swing.JLabel req10;
    private javax.swing.JLabel req11;
    private javax.swing.JLabel req12;
    private javax.swing.JLabel req13;
    private javax.swing.JLabel req2;
    private javax.swing.JLabel req3;
    private javax.swing.JLabel req4;
    private javax.swing.JLabel req5;
    private javax.swing.JLabel req6;
    private javax.swing.JLabel req7;
    private javax.swing.JLabel req8;
    private javax.swing.JLabel req9;
    // End of variables declaration//GEN-END:variables
}
