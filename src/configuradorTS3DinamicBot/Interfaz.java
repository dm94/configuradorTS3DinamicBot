package configuradorTS3DinamicBot;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.SystemColor;

/**
 * 
 * @author Dm94Dani
 * @version v1
 *
 */


public class Interfaz {

	private JFrame frmConfiguradorTsdinamicbot;
	private JTextField txtDireccion;
	private JTextField txtUsuario;
	private JTextField txtContra;
	private JTextField txtName;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JList listCanales;
	private JCheckBox checkLimite;
	private JSpinner spUsuarios;
	private JSpinner spId;
	private JSpinner spPuerto;
	private JSpinner spIdCanal;
	private DefaultListModel modelo;
	private ManejoDeArchivos mda=new ManejoDeArchivos();
	private ArrayList<String> canales=new ArrayList<String>();
	private ArrayList<String> especiales=new ArrayList<String>();
	private JTextField txtIdUnica;
	private JComboBox cbIdiomaBot;
	private JSpinner spIdCanalAtender;
	private JTextField txtBGNombreCanal;
	private JTextField txtPENombre;
	private JTextField txtRPFrase;
	private JTextField txtRPPalabra;
	private JTextField txtBGGComando;
	private JTextField txtBGGNombre;
	private JSpinner spBGIdCanal;
	private JSpinner spBGIdEspaciador;
	private JSpinner spPEIdEspaciador;
	private JList listArchivosEspeciales;
	private JSpinner spBGGNPersonas;
	private JSpinner spBGGIDEspaciador;
	private JList listBGGBusquedas;
	private JSpinner spBGGIdCanal;
	private JList listRPPalabras;
	private JSpinner spBGNPersonas;
	private JSpinner spPEIdServerGroup;
	private DefaultListModel modeloEspeciales;
	private DefaultListModel modeloPalabras;
	private DefaultListModel modeloBGG; 
	private ArrayList<String> palabras=new ArrayList<String>();
	private ArrayList<String> modelobgg=new ArrayList<String>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frmConfiguradorTsdinamicbot.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConfiguradorTsdinamicbot = new JFrame();
		frmConfiguradorTsdinamicbot.setTitle("Configurador | TS3DinamicBot");
		frmConfiguradorTsdinamicbot.setResizable(false);
		frmConfiguradorTsdinamicbot.setBounds(100, 100, 468, 321);
		frmConfiguradorTsdinamicbot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConfiguradorTsdinamicbot.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 462, 297);
		frmConfiguradorTsdinamicbot.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Principal", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 11, 77, 14);
		panel.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(96, 8, 122, 20);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblPuerto = new JLabel("Puerto:");
		lblPuerto.setBounds(228, 11, 69, 14);
		panel.add(lblPuerto);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 36, 77, 23);
		panel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setText("serveradmin");
		txtUsuario.setBounds(96, 39, 122, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContra = new JTextField();
		txtContra.setBounds(307, 37, 122, 22);
		panel.add(txtContra);
		txtContra.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(228, 40, 69, 19);
		panel.add(lblContrasea);
		
		JLabel lblNombreBot = new JLabel("Nombre Bot:");
		lblNombreBot.setBounds(10, 70, 77, 14);
		panel.add(lblNombreBot);
		
		txtName = new JTextField();
		txtName.setText("TS3DinamicBot");
		txtName.setBounds(96, 67, 122, 20);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblIdCanal = new JLabel("ID Canal:");
		lblIdCanal.setBounds(228, 70, 69, 17);
		panel.add(lblIdCanal);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarDatos();
			}
		});
		btnGuardar.setBounds(10, 210, 89, 23);
		panel.add(btnGuardar);
		
		spPuerto = new JSpinner();
		spPuerto.setModel(new SpinnerNumberModel(9987, 1, 65535, 1));
		spPuerto.setBounds(307, 8, 122, 20);
		panel.add(spPuerto);
		
		spIdCanal = new JSpinner();
		spIdCanal.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spIdCanal.setBounds(307, 70, 122, 20);
		panel.add(spIdCanal);
		
		JLabel lblCanalAtender = new JLabel("ID Canal a Atender:");
		lblCanalAtender.setBounds(10, 95, 201, 26);
		panel.add(lblCanalAtender);
		
		spIdCanalAtender = new JSpinner();
		spIdCanalAtender.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spIdCanalAtender.setBounds(228, 98, 201, 20);
		panel.add(spIdCanalAtender);
		
		JLabel lblIdUnicaAdmin = new JLabel("ID Unica Admin del Bot:");
		lblIdUnicaAdmin.setBounds(10, 132, 140, 14);
		panel.add(lblIdUnicaAdmin);
		
		txtIdUnica = new JTextField();
		txtIdUnica.setBounds(228, 129, 201, 20);
		panel.add(txtIdUnica);
		txtIdUnica.setColumns(10);
		
		JLabel lblIdiomaDelBot = new JLabel("Idioma del bot:");
		lblIdiomaDelBot.setBounds(10, 157, 187, 17);
		panel.add(lblIdiomaDelBot);
		
		cbIdiomaBot = new JComboBox();
		cbIdiomaBot.setBounds(228, 154, 201, 20);
		panel.add(cbIdiomaBot);
		
		cbIdiomaBot.addItem("English");
		cbIdiomaBot.addItem("Spanish");
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Canales", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnCargar_1 = new JButton("Cargar");
		btnCargar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarLista();
			}
		});
		btnCargar_1.setBounds(10, 235, 89, 23);
		panel_1.add(btnCargar_1);
		
		JButton btnGuardar_1 = new JButton("Guardar");
		btnGuardar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mda.guardarCanales(canales);
			}
		});
		btnGuardar_1.setBounds(109, 235, 89, 23);
		panel_1.add(btnGuardar_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 156, 437, 68);
		panel_1.add(scrollPane);
		
		listCanales = new JList();
		scrollPane.setViewportView(listCanales);
		
		JLabel lblIdEspaciador = new JLabel("ID Espaciador:");
		lblIdEspaciador.setBounds(10, 11, 89, 14);
		panel_1.add(lblIdEspaciador);
		
		JButton btnBorrarCanal = new JButton("Borrar Grupo");
		btnBorrarCanal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrarCanales();
			}
		});
		btnBorrarCanal.setBounds(139, 118, 110, 23);
		panel_1.add(btnBorrarCanal);
		
		JLabel lblNombre = new JLabel("Nombre Canales:");
		lblNombre.setBounds(173, 11, 131, 14);
		panel_1.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(274, 8, 173, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDescripcionnoPongas = new JLabel("Descripcion (No pongas el signo #, ni tildes): ");
		lblDescripcionnoPongas.setBounds(10, 36, 419, 14);
		panel_1.add(lblDescripcionnoPongas);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(10, 61, 437, 20);
		panel_1.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JButton btnAadirGrupo = new JButton("A\u00F1adir Grupo");
		btnAadirGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aniadirAlaLista();
			}
		});
		btnAadirGrupo.setBounds(10, 118, 119, 23);
		panel_1.add(btnAadirGrupo);
		
		checkLimite = new JCheckBox("Limitar Canales a");
		checkLimite.setBounds(10, 88, 171, 23);
		panel_1.add(checkLimite);
		
		JLabel lblUsuarios = new JLabel("usuarios.");
		lblUsuarios.setBounds(245, 93, 62, 14);
		panel_1.add(lblUsuarios);
		
		spUsuarios = new JSpinner();
		spUsuarios.setModel(new SpinnerNumberModel(5, 0, 255, 1));
		spUsuarios.setBounds(187, 89, 48, 20);
		panel_1.add(spUsuarios);
		
		spId = new JSpinner();
		spId.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		spId.setBounds(93, 8, 70, 20);
		panel_1.add(spId);
		
		modelo=new DefaultListModel();
		listCanales.setModel(modelo);
		
		JTabbedPane Especial = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Especiales", null, Especial, null);
		
		JPanel bg = new JPanel();
		Especial.addTab("Busqueda de Grupos", null, bg, null);
		bg.setLayout(null);
		
		JLabel lblIdCanal_1 = new JLabel("ID Canal:");
		lblIdCanal_1.setBounds(10, 9, 115, 24);
		bg.add(lblIdCanal_1);
		
		spBGIdCanal = new JSpinner();
		spBGIdCanal.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spBGIdCanal.setBounds(152, 11, 290, 20);
		bg.add(spBGIdCanal);
		
		JLabel lblNombreCanal = new JLabel("Nombre Canal:");
		lblNombreCanal.setBounds(10, 44, 115, 14);
		bg.add(lblNombreCanal);
		
		txtBGNombreCanal = new JTextField();
		txtBGNombreCanal.setBounds(152, 42, 290, 20);
		bg.add(txtBGNombreCanal);
		txtBGNombreCanal.setColumns(10);
		
		JLabel lblEspaciadorAMover = new JLabel("Espaciador a Mover");
		lblEspaciadorAMover.setToolTipText("Al llenarse la busqueda movera a la gente a los canales vacios de ese espaciador o canal padre");
		lblEspaciadorAMover.setBounds(10, 69, 115, 24);
		bg.add(lblEspaciadorAMover);
		
		spBGIdEspaciador = new JSpinner();
		spBGIdEspaciador.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spBGIdEspaciador.setBounds(152, 73, 290, 20);
		bg.add(spBGIdEspaciador);
		
		JLabel lblNPersonasNecesarias = new JLabel("N\u00BA Personas Necesarias");
		lblNPersonasNecesarias.setToolTipText("N\u00BA de personas necesarias para que la busqueda se complete");
		lblNPersonasNecesarias.setBounds(10, 104, 141, 20);
		bg.add(lblNPersonasNecesarias);
		
		spBGNPersonas = new JSpinner();
		spBGNPersonas.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spBGNPersonas.setBounds(152, 104, 290, 20);
		bg.add(spBGNPersonas);
		
		JButton btnBGAadirAConfig = new JButton("A\u00F1adir a Config");
		btnBGAadirAConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aniadirBusquedaGrupos();
			}
		});
		btnBGAadirAConfig.setBounds(10, 159, 432, 23);
		bg.add(btnBGAadirAConfig);
		
		JPanel pesp = new JPanel();
		Especial.addTab("Permisos Especiales", null, pesp, null);
		pesp.setLayout(null);
		
		JLabel lblIdEspaciador_1 = new JLabel("ID Espaciador");
		lblIdEspaciador_1.setToolTipText("Para definir que subcanales ser\u00E1n los elegidos para tener poderes especiales");
		lblIdEspaciador_1.setBounds(10, 11, 136, 20);
		pesp.add(lblIdEspaciador_1);
		
		spPEIdEspaciador = new JSpinner();
		spPEIdEspaciador.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spPEIdEspaciador.setBounds(176, 11, 266, 20);
		pesp.add(spPEIdEspaciador);
		
		JLabel lblNombreCanales = new JLabel("Nombre Canales");
		lblNombreCanales.setToolTipText("De todos los subcanales solo tendran permisos los que tengan un nombre parecido a este");
		lblNombreCanales.setBounds(10, 42, 136, 20);
		pesp.add(lblNombreCanales);
		
		txtPENombre = new JTextField();
		txtPENombre.setBounds(176, 42, 266, 20);
		pesp.add(txtPENombre);
		txtPENombre.setColumns(10);
		
		JLabel lblIdServerGroup = new JLabel("ID Server Group");
		lblIdServerGroup.setToolTipText("ID del grupo de servidor que va a tener los permisos especiales");
		lblIdServerGroup.setBounds(10, 73, 136, 20);
		pesp.add(lblIdServerGroup);
		
		spPEIdServerGroup = new JSpinner();
		spPEIdServerGroup.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spPEIdServerGroup.setBounds(176, 73, 266, 20);
		pesp.add(spPEIdServerGroup);
		
		JButton btnPEAadirAConfig = new JButton("A\u00F1adir a Config");
		btnPEAadirAConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aniadirPermisoEspecial();
			}
		});
		btnPEAadirAConfig.setBounds(10, 149, 432, 23);
		pesp.add(btnPEAadirAConfig);
		
		JPanel rp = new JPanel();
		Especial.addTab("Respuestas/Preguntas", null, rp, null);
		rp.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 92, 432, 86);
		rp.add(scrollPane_2);
		
		listRPPalabras = new JList();
		scrollPane_2.setViewportView(listRPPalabras);
		
		JLabel lblRespuestaDeLa = new JLabel("Respuesta de la frase:");
		lblRespuestaDeLa.setToolTipText("Respuesta que dira el bot al leer la frase con las palabras indicadas");
		lblRespuestaDeLa.setBounds(10, 11, 148, 14);
		rp.add(lblRespuestaDeLa);
		
		txtRPFrase = new JTextField();
		txtRPFrase.setToolTipText("Max 128 caracteres");
		txtRPFrase.setBounds(168, 8, 274, 20);
		rp.add(txtRPFrase);
		txtRPFrase.setColumns(10);
		
		JLabel lblPalabras = new JLabel("Palabras:");
		lblPalabras.setBounds(10, 67, 76, 14);
		rp.add(lblPalabras);
		
		JLabel lblPalabra = new JLabel("Palabra:");
		lblPalabra.setToolTipText("Si hay 2 palabras de estas en la pregunta el bot respondera con la frase");
		lblPalabra.setBounds(10, 36, 76, 20);
		rp.add(lblPalabra);
		
		txtRPPalabra = new JTextField();
		txtRPPalabra.setBounds(96, 36, 125, 20);
		rp.add(txtRPPalabra);
		txtRPPalabra.setColumns(10);
		
		JButton btnRPAniadirPalabra = new JButton("A\u00F1adir palabra a la lista");
		btnRPAniadirPalabra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aniadirPalabrasALista();
			}
		});
		btnRPAniadirPalabra.setBounds(251, 35, 191, 23);
		rp.add(btnRPAniadirPalabra);
		
		JButton btnRPAadirALa = new JButton("A\u00F1adir a Config");
		btnRPAadirALa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aniadirRPConfig();
			}
		});
		btnRPAadirALa.setBounds(10, 191, 432, 23);
		rp.add(btnRPAadirALa);
		
		JPanel bgg = new JPanel();
		Especial.addTab("Busqueda Global", null, bgg, null);
		bgg.setLayout(null);
		
		JLabel lblIdCanalCon = new JLabel("ID Canal con Busquedas:");
		lblIdCanalCon.setBounds(10, 11, 165, 17);
		bgg.add(lblIdCanalCon);
		
		spBGGIdCanal = new JSpinner();
		spBGGIdCanal.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spBGGIdCanal.setBounds(182, 8, 260, 20);
		bgg.add(spBGGIdCanal);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 135, 432, 46);
		bgg.add(scrollPane_3);
		
		listBGGBusquedas = new JList();
		scrollPane_3.setViewportView(listBGGBusquedas);
		
		JButton btnBGGAadirAConfig = new JButton("A\u00F1adir a Config");
		btnBGGAadirAConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aniadirListadoBusquedasAConfig();
			}
		});
		btnBGGAadirAConfig.setBounds(10, 192, 432, 23);
		bgg.add(btnBGGAadirAConfig);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.controlLtHighlight);
		panel_2.setBounds(10, 39, 432, 96);
		bgg.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblComando = new JLabel("Comando:");
		lblComando.setToolTipText("comando que tendran que poner para entrar a la busqueda");
		lblComando.setBounds(10, 11, 75, 14);
		panel_2.add(lblComando);
		
		txtBGGComando = new JTextField();
		txtBGGComando.setBounds(74, 8, 114, 20);
		panel_2.add(txtBGGComando);
		txtBGGComando.setColumns(10);
		
		JLabel lblIdEspaciador_2 = new JLabel("ID Espaciador:");
		lblIdEspaciador_2.setToolTipText("Sus subcanales ser\u00E1n a donde se muevan los usuarios cuando se llene la busqueda");
		lblIdEspaciador_2.setBounds(198, 11, 100, 14);
		panel_2.add(lblIdEspaciador_2);
		
		spBGGIDEspaciador = new JSpinner();
		spBGGIDEspaciador.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spBGGIDEspaciador.setBounds(308, 8, 114, 20);
		panel_2.add(spBGGIDEspaciador);
		
		JLabel lblNPersonas = new JLabel("N\u00BA Personas");
		lblNPersonas.setBounds(10, 36, 100, 14);
		panel_2.add(lblNPersonas);
		
		spBGGNPersonas = new JSpinner();
		spBGGNPersonas.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spBGGNPersonas.setToolTipText("N\u00BA Personas necesarias para llenar una busqueda de grupo");
		spBGGNPersonas.setBounds(120, 33, 68, 20);
		panel_2.add(spBGGNPersonas);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setToolTipText("Nombre de la busqueda de grupo");
		lblNombre_1.setBounds(198, 36, 68, 14);
		panel_2.add(lblNombre_1);
		
		txtBGGNombre = new JTextField();
		txtBGGNombre.setBounds(276, 33, 146, 20);
		panel_2.add(txtBGGNombre);
		txtBGGNombre.setColumns(10);
		
		JButton btnBGGAniadirALista = new JButton("A\u00F1adir Busqueda a la lista");
		btnBGGAniadirALista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aniadirAListaBusquedas();
			}
		});
		btnBGGAniadirALista.setBounds(10, 61, 412, 23);
		panel_2.add(btnBGGAniadirALista);
		
		JPanel Config = new JPanel();
		Especial.addTab("Config", null, Config, null);
		Config.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 432, 163);
		Config.add(scrollPane_1);
		
		listArchivosEspeciales = new JList();
		scrollPane_1.setViewportView(listArchivosEspeciales);
		
		JButton btnGuardarEspeciales = new JButton("Guardar Especiales");
		btnGuardarEspeciales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mda.guardarEspeciales(especiales);
			}
		});
		btnGuardarEspeciales.setBounds(20, 185, 166, 23);
		Config.add(btnGuardarEspeciales);
		
		
		modeloEspeciales=new DefaultListModel();
		listArchivosEspeciales.setModel(modeloEspeciales);
		
		modeloPalabras=new DefaultListModel();
		listRPPalabras.setModel(modeloPalabras);
		
		modeloBGG=new DefaultListModel();
		listBGGBusquedas.setModel(modeloBGG);
	}
	
	private void aniadirAlaLista() {
		String id="";
		String nombre="";
		String descripcion="";
		String limiteUsuarios="";
		
		
		if(spId.getValue().toString().length()>0 && txtNombre.getText().length()>0){
			id=spId.getValue().toString();
			nombre=txtNombre.getText().trim();
			descripcion=txtDescripcion.getText().trim();
			
			if(checkLimite.isSelected()){
				System.out.println(spUsuarios.getValue().toString());		
				limiteUsuarios=spUsuarios.getValue().toString();
				
				modelo.addElement(id+"#"+nombre+"#"+descripcion+"#"+"true#"+limiteUsuarios);
				canales.add(id+"#"+nombre+"#"+descripcion+"#"+"true#"+limiteUsuarios);
			}else{
				modelo.addElement(id+"#"+nombre+"#"+descripcion+"#"+"false");
				canales.add(id+"#"+nombre+"#"+descripcion+"#"+"false");
			}
			
		}
	}
	
	private void cargarLista(){
		canales=mda.cargarCanales();
		
		for(int i=0;i<canales.size();i++){
			modelo.addElement(canales.get(i));
		}
	}
	
	private void borrarCanales() {
		if(!listCanales.isSelectionEmpty()){
			modelo.removeElementAt(listCanales.getSelectedIndex());
			canales.remove(listCanales.getSelectedIndex());
		}
	}
	
	private void guardarDatos(){
		String direccion="";
		String puerto="";
		String usuario="";
		String contra="";
		String idCanal="";
		String nombreBot="";
		String idioma="";
		String idUnica="";
		String idCanalAtendido="";
		
		direccion=txtDireccion.getText();
		puerto=spPuerto.getValue().toString();
		usuario=txtUsuario.getText();
		contra=txtContra.getText();
		idCanal=spIdCanal.getValue().toString();
		nombreBot=txtName.getText();
		idioma=cbIdiomaBot.getSelectedItem().toString();
		idUnica=txtIdUnica.getText();
		idCanalAtendido=spIdCanalAtender.getValue().toString();
		
		if(direccion!=null && usuario!=null && contra!=null && nombreBot!=null){
			mda.guardarDatos(direccion,puerto,usuario,contra,idCanal,nombreBot,idioma,idUnica,idCanalAtendido);
		}
		
	}
	
	private void aniadirBusquedaGrupos() {
		String idCanal="";
		String nombreCanal="";
		String idEspaciador="";
		String nPersonas="";
		
		idCanal=spBGIdCanal.getValue().toString();
		nombreCanal=txtBGNombreCanal.getText();
		idEspaciador=spBGIdEspaciador.getValue().toString();
		nPersonas=spBGNPersonas.getValue().toString();
		
		if(idCanal!=null && nombreCanal!=null && idEspaciador!=null && nPersonas!=null){
			if(idCanal.length()>0 && nombreCanal.length()>0 && idEspaciador.length()>0 && nPersonas.length()>0){
				especiales.add("1#"+idCanal+"#"+nombreCanal+"#"+idEspaciador+"#"+nPersonas);
				modeloEspeciales.addElement("1#"+idCanal+"#"+nombreCanal+"#"+idEspaciador+"#"+nPersonas);
				
				spBGIdCanal.setValue(1);
				txtBGNombreCanal.setText("");
				spBGIdEspaciador.setValue(1);
				spBGNPersonas.setValue(1);
			}
		}
	}
	
	private void aniadirPermisoEspecial(){
		String idEspaciador="";
		String nombre="";
		String idServerGroup="";
		
		idEspaciador=spPEIdEspaciador.getValue().toString();
		nombre=txtPENombre.getText();
		idServerGroup=spPEIdEspaciador.getValue().toString();
		
		
		if(idEspaciador!=null && nombre!=null && idServerGroup!=null){
			if(idEspaciador.length()>0 && nombre.length()>0 && idServerGroup.length()>0){
				especiales.add("2#"+idEspaciador+"#"+nombre+"#"+idServerGroup);
				modeloEspeciales.addElement("2#"+idEspaciador+"#"+nombre+"#"+idServerGroup);
				
				spPEIdEspaciador.setValue(1);
				txtPENombre.setText("");
				spPEIdEspaciador.setValue(1);
				
			}
		}
	}
	
	private void aniadirPalabrasALista(){
		String palabra="";
		
		palabra=txtRPPalabra.getText();
		
		if(palabra!=null){
			if(palabra.length()>0){
				modeloPalabras.addElement(palabra);
				palabras.add(palabra);
				
				txtRPPalabra.setText("");
			}
		}
	}
	
	private void aniadirRPConfig(){
		if(palabras.size()>=2){
			String respuesta="";
			respuesta=txtRPFrase.getText();
			
			if(respuesta!=null){
				if(respuesta.length()>0){
					String listapalabras="";
					
					for(int i=0;i<palabras.size();i++){
						if(i==palabras.size()-1){
							listapalabras=listapalabras+palabras.get(i);
						}else{
							listapalabras=listapalabras+palabras.get(i)+",";
						}
					}
					
					especiales.add("3#"+listapalabras+"#"+respuesta);
					modeloEspeciales.addElement("3#"+listapalabras+"#"+respuesta);
					
					palabras.clear();
					modeloPalabras.clear();
					txtRPFrase.setText("");
				}
			}
		}
	}

	private void aniadirAListaBusquedas(){
		String comando="";
		String idEspaciador="";
		String numPersonas="";
		String nombreBusqueda="";
		
		comando=txtBGGComando.getText();
		idEspaciador=spBGGIDEspaciador.getValue().toString();
		numPersonas=spBGGNPersonas.getValue().toString();
		nombreBusqueda=txtBGGNombre.getText();
		
		if(comando!=null && idEspaciador!=null && numPersonas!=null && nombreBusqueda!=null){
			if(comando.length()>0 && idEspaciador.length()>0 && numPersonas.length()>0 && nombreBusqueda.length()>0){
				modeloBGG.addElement(comando+","+idEspaciador+","+numPersonas+","+nombreBusqueda);
				modelobgg.add(comando+","+idEspaciador+","+numPersonas+","+nombreBusqueda);
				
				txtBGGComando.setText("");
				spBGGIDEspaciador.setValue(1);
				spBGGNPersonas.setValue(1);
				txtBGGNombre.setText("");
			}
		}
		
	}

	private void aniadirListadoBusquedasAConfig(){
		if(modelobgg.size()>=1){
			String idCanal="";
			idCanal=spBGGIdCanal.getValue().toString();
			
			if(idCanal!=null){
				if(idCanal.length()>0){
					String listadoBusqueda="";
					
					for(int i=0;i<modelobgg.size();i++){
						if(i==modelobgg.size()-1){
							listadoBusqueda=listadoBusqueda+modelobgg.get(i);
						}else{
							listadoBusqueda=listadoBusqueda+modelobgg.get(i)+"#";
						}
					}
					
					especiales.add("4#"+idCanal+"#"+listadoBusqueda);
					modeloEspeciales.addElement("4#"+idCanal+"#"+listadoBusqueda);
					
					
					modelobgg.clear();
					modeloBGG.clear();
					spBGGIdCanal.setValue(1);
				}
			}
			
		}
	}
}
