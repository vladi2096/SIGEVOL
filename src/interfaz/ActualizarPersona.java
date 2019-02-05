/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import entidades.contactoEmergencia;
import entidades.persona;
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
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Vladimir
 */
public final class ActualizarPersona extends javax.swing.JFrame {

    consultaBase conexion = new consultaBase();
    PersonaConsulta personaConsulta = new PersonaConsulta();
    CargoConsulta cargoConsulta = new CargoConsulta();
    GradoAcademicoConsulta gradoAcademicoConsulta = new GradoAcademicoConsulta();
    RegionConsulta regionConsulta = new RegionConsulta();
    ComiteConsulta comiteConsulta = new ComiteConsulta();
    ContactoEmergenciaConsulta contactoEmergenciaConsulta = new ContactoEmergenciaConsulta();
    IdiomaConsulta idiomaConsulta = new IdiomaConsulta();
    CursoConsulta cursoConsulta =  new CursoConsulta();
    
    public ActualizarPersona() {
        initComponents();
        llenarCargo();
        llenarGradoAcademico();
        llenarRegion();
        jTabbedPane1.setVisible(false);
        actualizar.setVisible(false);
    }
    
    public void llenarCargo(){
        ArrayList<String> lista = cargoConsulta.obtenerCargo();
        for(int i=0; i < lista.size(); i++){
            cargo.addItem(lista.get(i));
        } 
    }
    
    public void llenarGradoAcademico(){
        ArrayList<String> lista = gradoAcademicoConsulta.obtenerGradoAcademico();
        for(int i=0; i < lista.size(); i++){
            grado.addItem(lista.get(i));
        }   
    }
    
    public void llenarRegion(){
        ArrayList<String> lista = regionConsulta.obtenerTodasRegion();
        for(int i=0; i < lista.size(); i++){
            region.addItem(lista.get(i));
        }
    }
    
    public void llenarComite(String region){
        comite.removeAllItems(); 
        ArrayList<String> lista;
        lista = comiteConsulta.obtenerComitesXRegion( regionConsulta.obtenerRegionId( region ) );
        for(int i=0; i < lista.size(); i++){
            comite.addItem(lista.get(i));
        }
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
    
     
    public void actualizarPersona(persona person, contactoEmergencia contacto, int cedula){
        cursoConsulta.borrarCursos(cedula);
        idiomaConsulta.actulizarPersona(person.getIdioma(), cedula);
        for(int i = 0; i < person.getCursos().size(); i++){
            if(person.getCursos().get(i)){
                cursoConsulta.agregarCursoPersona(cedula, i+1);
            }
        }
        personaConsulta.actulizarPersona(person, cedula);
        contactoEmergenciaConsulta.actulizarContactoEmergencia(contacto, cedula);
    }

    public void infoPersona(persona person, contactoEmergencia contacto){
        
        //Informacion basica de la persona
        nombre.setText(person.getNombre());
        codigo.setText(person.getCodigoVoluntario());
        
        genero.setSelectedItem(person.getGenero());
        
        //Fecha de Nacimiento
        StringTokenizer tokensNacimiento = new StringTokenizer(person.getFechaNacimiento(), "-");
        ano1.setText(tokensNacimiento.nextToken());
        mes1.setText(tokensNacimiento.nextToken());
        dia1.setText(tokensNacimiento.nextToken());
        
        
        oficio.setText(person.getOficio());
        
        if(person.getTelefono() != 0){ telefono.setText(String.valueOf(person.getTelefono()));} else{telefono.setText("");}
        if(person.getCelular() != 0){ celular.setText(String.valueOf(person.getCelular()));} else{celular.setText("");}
        correo.setText(person.getCorreo());
        
        //Fecha de Ingreso
        StringTokenizer tokensIngreso = new StringTokenizer(person.getFechaIngreso(), "-");
        ano2.setText(tokensIngreso.nextToken());
        mes2.setText(tokensIngreso.nextToken());
        dia2.setText(tokensIngreso.nextToken());
        
        
        asociado.setSelectedItem(person.getEsAsociado());
        
        
        cargo.setSelectedItem(person.getCargo());
        
        grado.setSelectedItem(person.getGrado());
        region.setSelectedItem(person.getRegion());
        llenarComite(region.getSelectedItem().toString());
        comite.setSelectedItem(person.getComite());
        
        
        espanol.setSelected(person.getIdioma().get(0));
        ingles.setSelected(person.getIdioma().get(1));
        portugues.setSelected(person.getIdioma().get(2));
        aleman.setSelected(person.getIdioma().get(3));
        frances.setSelected(person.getIdioma().get(4));
        mandarin.setSelected(person.getIdioma().get(5));

        //Informacion cursos
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
        
        //Informacion de conctaco de la persona
        nombreCompleto.setText(contacto.getNombre());
        nume.setText(String.valueOf(contacto.getNumero()));
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
        jLabel21 = new javax.swing.JLabel();
        ww = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        adas = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        codigo = new javax.swing.JTextField();
        mes1 = new javax.swing.JTextField();
        ano1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        dia1 = new javax.swing.JTextField();
        genero = new javax.swing.JComboBox<>();
        cargo = new javax.swing.JComboBox<>();
        region = new javax.swing.JComboBox<>();
        comite = new javax.swing.JComboBox<>();
        celular = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        mes2 = new javax.swing.JTextField();
        ano2 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        dia2 = new javax.swing.JTextField();
        grado = new javax.swing.JComboBox<>();
        asociado = new javax.swing.JComboBox<>();
        oficio = new javax.swing.JTextField();
        aleman = new javax.swing.JCheckBox();
        ingles = new javax.swing.JCheckBox();
        espanol = new javax.swing.JCheckBox();
        portugues = new javax.swing.JCheckBox();
        frances = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        mandarin = new javax.swing.JCheckBox();
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
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        nombreCompleto = new javax.swing.JTextField();
        nume = new javax.swing.JTextField();
        parentesco = new javax.swing.JTextField();
        actualizar = new javax.swing.JButton();
        botonBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIPAJU");
        setBackground(new java.awt.Color(255, 204, 102));
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(1047, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jButton4.setText("Menu Principal");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 670, 162, -1));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 51));
        jLabel21.setText("Correo:");

        ww.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        ww.setForeground(new java.awt.Color(255, 0, 51));
        ww.setText("Asociado Activo:");

        jLabel27.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 0, 51));
        jLabel27.setText("Cargo:");

        adas.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        adas.setForeground(new java.awt.Color(255, 0, 51));
        adas.setText("Fecha de Ingreso: ");

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("Comité:");

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("Fecha de Nacimiento: ");

        jLabel34.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 0, 51));
        jLabel34.setText("Grado académico:");

        jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 51));
        jLabel16.setText("Oficio:");

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 51));
        jLabel17.setText("Teléfono:");

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Código de voluntario:");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Género:");

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("Región:");

        jLabel19.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 51));
        jLabel19.setText("Celular:");

        nombre.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        codigo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        mes1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        mes1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mes1ActionPerformed(evt);
            }
        });

        ano1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        ano1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ano1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ano1ActionPerformed(evt);
            }
        });

        jLabel18.setText("DD");

        jLabel29.setText("MM");

        jLabel30.setText("AAAA");

        dia1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        dia1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dia1ActionPerformed(evt);
            }
        });

        genero.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Masculino", "Femenino" }));

        cargo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        region.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        region.setToolTipText("");
        region.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regionActionPerformed(evt);
            }
        });

        comite.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        comite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comiteActionPerformed(evt);
            }
        });

        celular.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        celular.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        celular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                celularActionPerformed(evt);
            }
        });
        celular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                celularKeyTyped(evt);
            }
        });

        telefono.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoActionPerformed(evt);
            }
        });
        telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoKeyTyped(evt);
            }
        });

        correo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoActionPerformed(evt);
            }
        });

        mes2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        mes2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mes2ActionPerformed(evt);
            }
        });

        ano2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        ano2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ano2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ano2ActionPerformed(evt);
            }
        });

        jLabel20.setText("DD");

        jLabel31.setText("MM");

        jLabel32.setText("AAAA");

        dia2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        dia2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dia2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dia2ActionPerformed(evt);
            }
        });

        grado.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        asociado.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        asociado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        oficio.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        oficio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oficioActionPerformed(evt);
            }
        });

        aleman.setBackground(new java.awt.Color(255, 255, 255));
        aleman.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        aleman.setForeground(new java.awt.Color(255, 0, 51));
        aleman.setText("Alemán");

        ingles.setBackground(new java.awt.Color(255, 255, 255));
        ingles.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        ingles.setForeground(new java.awt.Color(255, 0, 51));
        ingles.setText("Inglés");

        espanol.setBackground(new java.awt.Color(255, 255, 255));
        espanol.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        espanol.setForeground(new java.awt.Color(255, 0, 51));
        espanol.setText("Español");

        portugues.setBackground(new java.awt.Color(255, 255, 255));
        portugues.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        portugues.setForeground(new java.awt.Color(255, 0, 51));
        portugues.setText("Portugués");

        frances.setBackground(new java.awt.Color(255, 255, 255));
        frances.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        frances.setForeground(new java.awt.Color(255, 0, 51));
        frances.setText("Francés");
        frances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                francesActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 51));
        jLabel23.setText("Idioma(s):");

        mandarin.setBackground(new java.awt.Color(255, 255, 255));
        mandarin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        mandarin.setForeground(new java.awt.Color(255, 0, 51));
        mandarin.setText("Mandarín");
        mandarin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mandarinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel17)
                .addGap(12, 12, 12)
                .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jLabel19)
                .addGap(12, 12, 12)
                .addComponent(celular, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addComponent(genero, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180)
                .addComponent(jLabel21)
                .addGap(12, 12, 12)
                .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel27)
                .addGap(12, 12, 12)
                .addComponent(cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180)
                .addComponent(jLabel34)
                .addGap(12, 12, 12)
                .addComponent(grado, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel7)
                .addGap(12, 12, 12)
                .addComponent(region, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180)
                .addComponent(jLabel16)
                .addGap(12, 12, 12)
                .addComponent(oficio, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(comite, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180)
                .addComponent(ww)
                .addGap(12, 12, 12)
                .addComponent(asociado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(dia1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(mes1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(ano1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(adas)
                .addGap(5, 5, 5)
                .addComponent(dia2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(mes2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(ano2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(jLabel18)
                .addGap(33, 33, 33)
                .addComponent(jLabel29)
                .addGap(35, 35, 35)
                .addComponent(jLabel30)
                .addGap(278, 278, 278)
                .addComponent(jLabel20)
                .addGap(33, 33, 33)
                .addComponent(jLabel31)
                .addGap(35, 35, 35)
                .addComponent(jLabel32))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel23)
                .addGap(22, 22, 22)
                .addComponent(espanol)
                .addGap(17, 17, 17)
                .addComponent(ingles)
                .addGap(25, 25, 25)
                .addComponent(portugues)
                .addGap(19, 19, 19)
                .addComponent(aleman)
                .addGap(23, 23, 23)
                .addComponent(frances)
                .addGap(17, 17, 17)
                .addComponent(mandarin))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel17))))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(celular, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel19))))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genero, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel21))))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel34))))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel7))
                    .addComponent(region, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel16))
                    .addComponent(oficio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comite, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(asociado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(ww))))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dia1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mes1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ano1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dia2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mes2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ano2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(adas))))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel20)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(espanol)
                    .addComponent(ingles)
                    .addComponent(portugues)
                    .addComponent(aleman)
                    .addComponent(frances)
                    .addComponent(mandarin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Información básica", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jCheckBox15.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox15.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox15.setText("Asistente en Primeros Auxilios");

        jCheckBox16.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox16.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox16.setText("Básico en Primeros Auxilios");

        jCheckBox17.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox17.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox17.setText("Doctrina y Difusión");

        jCheckBox18.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox18.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox18.setText("Primero Auxilios Psicológicos");

        jCheckBox19.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox19.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox19.setText("Técnico en Emergencias Médicas");

        jLabel22.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 51));
        jLabel22.setText("Cursos obtenidos");

        jCheckBox20.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox20.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox20.setText("Asistente en Emergencias Médicas");
        jCheckBox20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox20ActionPerformed(evt);
            }
        });

        jCheckBox21.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox21.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox21.setText("Formación de Instructores");

        jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox5.setText("Facilitadores en Brigadas Educativas");

        jCheckBox22.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox22.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox22.setText("Jóvenes Agentes de Cambio de comportamiento");

        jCheckBox23.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox23.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox23.setText("Retorno a la Alegría");

        jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox6.setText("Formación de Jefaturas Locales de Juventud");

        jCheckBox24.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox24.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox24.setText("Cortesía y Disciplina");

        jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox7.setText("Formación Básica en Juventud");

        jCheckBox25.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox25.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox25.setText("Manejo de Suministros de Emergencias");

        jCheckBox26.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox26.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox26.setText("Desarrollo de Habilidades de Liderazgo");
        jCheckBox26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox26ActionPerformed(evt);
            }
        });

        jCheckBox9.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox9.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox9.setText("Dinamizadores Sociales");

        jCheckBox10.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox10.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox10.setText("Facilitadores en Prevención en VIH-SIDA");

        jCheckBox11.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox11.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox11.setText("Elaboración de Proyectos");
        jCheckBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox11ActionPerformed(evt);
            }
        });

        jCheckBox12.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox12.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox12.setText("Seguridad Vial");

        jCheckBox13.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox13.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox13.setText("Habilidades para la vida");

        jCheckBox14.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox14.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox14.setText("Educación Ambiental");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(jLabel22))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBox7)
                        .addGap(77, 77, 77)
                        .addComponent(jCheckBox6)
                        .addGap(41, 41, 41)
                        .addComponent(jCheckBox5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBox11)
                        .addGap(111, 111, 111)
                        .addComponent(jCheckBox10)
                        .addGap(65, 65, 65)
                        .addComponent(jCheckBox9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBox14)
                        .addGap(143, 143, 143)
                        .addComponent(jCheckBox13)
                        .addGap(183, 183, 183)
                        .addComponent(jCheckBox12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBox17)
                        .addGap(161, 161, 161)
                        .addComponent(jCheckBox16)
                        .addGap(155, 155, 155)
                        .addComponent(jCheckBox15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBox20)
                        .addGap(45, 45, 45)
                        .addComponent(jCheckBox19)
                        .addGap(115, 115, 115)
                        .addComponent(jCheckBox18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBox23)
                        .addGap(155, 155, 155)
                        .addComponent(jCheckBox22)
                        .addGap(11, 11, 11)
                        .addComponent(jCheckBox21))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBox26)
                        .addGap(13, 13, 13)
                        .addComponent(jCheckBox25)
                        .addGap(73, 73, 73)
                        .addComponent(jCheckBox24))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel22)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox5))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox11)
                    .addComponent(jCheckBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox9))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox14)
                    .addComponent(jCheckBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox12))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox17)
                    .addComponent(jCheckBox16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox15))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox20)
                    .addComponent(jCheckBox19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox18))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox23)
                    .addComponent(jCheckBox22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox21))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox26)
                    .addComponent(jCheckBox25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox24))
                .addContainerGap(77, Short.MAX_VALUE))
        );

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

        nombreCompleto.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        nombreCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreCompletoActionPerformed(evt);
            }
        });

        nume.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        nume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeActionPerformed(evt);
            }
        });

        parentesco.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        parentesco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parentescoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nume, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(parentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(155, 155, 155))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(193, 193, 193))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel24)
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nume, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(parentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Contacto de emergencia", jPanel3);

        jPanel4.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 160, 1010, -1));

        actualizar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        actualizar.setText("Actualizar");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        jPanel4.add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 130, 40));

        botonBuscar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 130, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Escriba la cédula a actualizar:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, 40));

        jPanel5.setBackground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 714, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 30, 714));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/imagenes/logo pequeno.png"))); // NOI18N
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 670, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel6.setText("Actualizar datos");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        cedula.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cedula.setToolTipText("");
        cedula.setBorder(null);
        cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaActionPerformed(evt);
            }
        });
        cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cedulaKeyTyped(evt);
            }
        });
        jPanel4.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 240, 40));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 240, 20));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1047, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mes1ActionPerformed

    private void ano1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ano1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ano1ActionPerformed

    private void dia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dia1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dia1ActionPerformed

    private void celularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_celularActionPerformed

    private void celularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_celularKeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
            (caracter > '9')) &&
        (caracter != '\b' /*corresponde a BACK_SPACE*/))
        {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_celularKeyTyped

    private void telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoActionPerformed

    private void telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
            (caracter > '9')) &&
        (caracter != '\b' /*corresponde a BACK_SPACE*/))
        {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_telefonoKeyTyped

    private void correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correoActionPerformed

    private void mes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mes2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mes2ActionPerformed

    private void ano2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ano2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ano2ActionPerformed

    private void dia2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dia2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dia2ActionPerformed

    private void oficioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oficioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oficioActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        persona person = personaConsulta.obtenerPersona("", Integer.parseInt(cedula.getText()), "Activo");
        if(person.getNombre() != null)
        {
            jTabbedPane1.setVisible(true);
            contactoEmergencia contacto = contactoEmergenciaConsulta.obtenerContactoEmergencia(Integer.parseInt(cedula.getText()));
            ArrayList<Boolean> idioma = idiomaConsulta.obtenerIdioma( person.getCedula() );
            ArrayList<Boolean> cursos = cursoConsulta.obtenerCurso( person.getCedula() );
            person.setIdioma(idioma);
            person.setCursos(cursos);
            infoPersona(person, contacto);
            actualizar.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No se encontro ningun resultado\n\n Ingrese otra cedula");
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void nombreCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreCompletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreCompletoActionPerformed

    private void numeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeActionPerformed

    private void parentescoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parentescoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_parentescoActionPerformed

    private void regionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regionActionPerformed
        String region_name = region.getSelectedItem().toString();
        comite.removeAllItems();
        ArrayList<String> lista;
        lista = comiteConsulta.obtenerComitesXRegion(regionConsulta.obtenerRegionId(region_name));
        for(int i=0; i < lista.size(); i++){
            comite.addItem(lista.get(i));
        }
    }//GEN-LAST:event_regionActionPerformed

    private void comiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comiteActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        int cedula1 = Integer.parseInt(cedula.getText());
        int num = JOptionPane.showConfirmDialog(null, "¿Actualizar con los nuevos datos?", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(num == 0){
            persona person = new persona();
            person.setNombre(nombre.getText());
            person.setCodigoVoluntario(codigo.getText());
            person.setGenero(genero.getSelectedItem().toString());
            
            person.setFechaNacimiento(ano1.getText()+"-"+mes1.getText()+"-"+dia1.getText());
            
            if(telefono.getText().equals("")){
                person.setTelefono(0);
            }
            else{
                person.setTelefono(Integer.parseInt(telefono.getText()));
            }
            if(celular.getText().equals("")){
                person.setCelular(0);
            }
            else{
                person.setCelular(Integer.parseInt(celular.getText()));
            }

            if(correo.getText().equals("")){
                person.setCorreo("false");
            }
            else{
                person.setCorreo(correo.getText());
            }

            if(oficio.getText().equals("")){
                person.setOficio("false");
            }
            else{
                person.setOficio(oficio.getText());
            }
            person.setFechaIngreso(ano2.getText()+"-"+mes2.getText()+"-"+dia2.getText()); 
            ArrayList<Boolean> idioma = new ArrayList<>();
            idioma.add(espanol.isSelected());
            idioma.add(ingles.isSelected());
            idioma.add(portugues.isSelected());
            idioma.add(aleman.isSelected());
            idioma.add(frances.isSelected());
            idioma.add(mandarin.isSelected());
            person.setIdioma(idioma);
            person.setIdComite(comiteConsulta.obtenerComiteId(comite.getSelectedItem().toString()));
            person.setIdCargo(cargoConsulta.obtenerCargoId(cargo.getSelectedItem().toString()));
            person.setIdGrado(gradoAcademicoConsulta.obtenerGradoAcademicoId(grado.getSelectedItem().toString()));
            person.setEsAsociado(asociado.getSelectedItem().toString());
            //Agregar los cursos
            ArrayList<Boolean> curso = obtenerCurso();
            person.setCursos(curso);
            //Agregar Contacto de Emergencia (objeto) 
            contactoEmergencia contacto = new contactoEmergencia();
            contacto.setNombre(nombreCompleto.getText());
            contacto.setNumero(Integer.parseInt(nume.getText()));
            contacto.setParentesco(parentesco.getText());
            try{
                this.actualizarPersona(person, contacto, cedula1);
                JOptionPane.showMessageDialog(null, "Datos actualizados correcatamente");
                Menu abrir = new Menu();
                abrir.setLocationRelativeTo(null);
                abrir.setVisible(true);
                this.setVisible(false);
            }
            catch( Exception e ){
                JOptionPane.showMessageDialog(null, "Algo ha ocurrido, inténtelo de nuevo");
            }
        }   
    }//GEN-LAST:event_actualizarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Menu abrir = new Menu();
        abrir.setLocationRelativeTo(null);
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaActionPerformed

    private void cedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedulaKeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
            (caracter > '9')) &&
        (caracter != '\b' /*corresponde a BACK_SPACE*/))
        {
            evt.consume();  // ignorar el evento de teclado
        }
        int largo = nombre.getText().length()+1;
        if(largo > 0){
            botonBuscar.setEnabled(true);
        }
    }//GEN-LAST:event_cedulaKeyTyped

    private void jCheckBox20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox20ActionPerformed

    private void jCheckBox26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox26ActionPerformed

    private void jCheckBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox11ActionPerformed

    private void francesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_francesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_francesActionPerformed

    private void mandarinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mandarinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mandarinActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(() -> {
            new ActualizarPersona().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JLabel adas;
    private javax.swing.JCheckBox aleman;
    private javax.swing.JTextField ano1;
    private javax.swing.JTextField ano2;
    private javax.swing.JComboBox<String> asociado;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JComboBox<String> cargo;
    private javax.swing.JTextField cedula;
    private javax.swing.JTextField celular;
    private javax.swing.JTextField codigo;
    private javax.swing.JComboBox<String> comite;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField dia1;
    private javax.swing.JTextField dia2;
    private javax.swing.JCheckBox espanol;
    private javax.swing.JCheckBox frances;
    private javax.swing.JComboBox<String> genero;
    private javax.swing.JComboBox<String> grado;
    private javax.swing.JCheckBox ingles;
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
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JCheckBox mandarin;
    private javax.swing.JTextField mes1;
    private javax.swing.JTextField mes2;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField nombreCompleto;
    private javax.swing.JTextField nume;
    private javax.swing.JTextField oficio;
    private javax.swing.JTextField parentesco;
    private javax.swing.JCheckBox portugues;
    private javax.swing.JComboBox<String> region;
    private javax.swing.JTextField telefono;
    private javax.swing.JLabel ww;
    // End of variables declaration//GEN-END:variables
}
