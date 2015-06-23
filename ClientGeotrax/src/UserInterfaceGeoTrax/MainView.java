package UserInterfaceGeoTrax;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import GPSComGeoTrax.ConnectionPort;

public class MainView extends JFrame {
	
	private JPanel panelMain;
	private JPanel panelMiddle;
	private JPanel panelLeft;
	private JPanel panelRight;
	private JPanel panelRightRight;
	private JPanel panelRightLeft;
	private JPanel panelBottom;
	private JLabel labelSettings;
	private JLabel labelGPSDatas;
	private JLabel labelListsPorts;
	private JLabel labelBaudRate;
	private JLabel labelDataBits;
	private JLabel labelStopBits;
	private JLabel labelParity;
	private JLabel labelUTC;
	private JLabel labelStatus;
	private JLabel labelNbSV;
	private JLabel labelLatitude;
	private JLabel labelNI;
	private JLabel labelLongitude;
	private JLabel labelEI;
	private JLabel labelAltitude;
	private JLabel labelUTCEdit;
	private JLabel labelStatusEdit;
	private JLabel labelNbSVEdit;
	private JLabel labelLatitudeEdit;
	private JLabel labelNIEdit;
	private JLabel labelLongitudeEdit;
	private JLabel labelEIEdit;
	private JLabel labelAltitudeEdit;
	private Box boxVerticalPanelLeft;
	private Box boxVerticalPanelRightRight;
	private Box boxVerticalPanelRightLeft;
	private Font police;
	private Widgets widg;
	private ConnectionPort serialPort;
	
	public MainView(ConnectionPort port) {
		// TODO Auto-generated constructor stub
		
		//Définition de la fenêtre principale
	    this.setSize(700, 400);
	    this.setTitle("Analyseur de ports séries");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    
	    serialPort = port;
	    widg = new Widgets(this);
	    
	    panelMain = new JPanel();  
	    panelMiddle = new JPanel(); 
	    panelLeft = new JPanel(); 
	    panelRight = new JPanel(); 
	    panelRightRight = new JPanel(); 
	    panelRightLeft = new JPanel(); 
	    panelBottom = new JPanel(); 
	    
		labelSettings= new JLabel();  
		labelGPSDatas= new JLabel();  
		labelListsPorts= new JLabel();  
		labelBaudRate= new JLabel();  
		labelDataBits= new JLabel();  
		labelStopBits= new JLabel();  
		labelParity= new JLabel();  
		labelUTC= new JLabel();
		labelStatus= new JLabel();
		labelNbSV= new JLabel();
		labelLatitude= new JLabel();
		labelNI= new JLabel();
		labelLongitude= new JLabel();
		labelEI= new JLabel();
		labelAltitude= new JLabel();
		labelUTCEdit= new JLabel();
		labelStatusEdit= new JLabel();
		labelNbSVEdit= new JLabel();
		labelLatitudeEdit= new JLabel();
		labelNIEdit= new JLabel();
		labelLongitudeEdit= new JLabel();
		labelEIEdit= new JLabel();
		labelAltitudeEdit= new JLabel();
	    
	    police = new Font("Arial", Font.BOLD, 20);
	    
	}
	
	public void CreatePanelMain(){
		
		widg.CreateButtonConnection();
		widg.CreateButtonDisconnection();
		widg.CreateButtonRefresh();
		widg.CreateComboBoxComboBauds();
		widg.CreateListListBox();
		
		CreatePanelMiddle();
		CreatePanelLeft();
		CreatePanelRight();
		CreatePanelBottom();
		
		panelMain.add(panelLeft, BorderLayout.WEST);
		panelMain.add(panelMiddle, BorderLayout.CENTER);
		panelMain.add(panelRight, BorderLayout.EAST);
		panelMain.add(panelBottom);
		
		getContentPane().add( panelMain );
		
		panelRight.setBorder(BorderFactory.createLineBorder(Color.black));
		panelRightRight.setBorder(BorderFactory.createLineBorder(Color.black));
		//panelRightLeft.setBorder(BorderFactory.createLineBorder(Color.black));
		panelMiddle.setBorder(BorderFactory.createLineBorder(Color.black));
		panelLeft.setBorder(BorderFactory.createLineBorder(Color.black));
		//panelBottom.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.setContentPane(panelMain);
	    this.setVisible(true);
		
	}
	

	public void CreatePanelMiddle(){
	    //Creation du Panel de droite
    
		panelMiddle.setPreferredSize(new Dimension(190, 310));
		panelMiddle.setLayout(new BorderLayout());
		
		labelListsPorts.setText("<html><center><u>Lists of Ports</u></center></html>");
		panelMiddle.add(labelListsPorts, BorderLayout.NORTH);
		labelListsPorts.setFont(police);
		
		panelMiddle.add(widg.getListbox(),BorderLayout.CENTER);
		panelMiddle.add(widg.getRefresh(),BorderLayout.SOUTH);
	}
	
	public void CreatePanelLeft(){
	    //Creation du Panel de gauche
		panelLeft.setPreferredSize(new Dimension(190, 310));
		
		labelSettings.setText("<html><center><u>Setting</u></center></html>");
		labelSettings.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		labelSettings.setFont(police);
		
		labelBaudRate.setText("<html><u>Baud rate</u></html>");
		labelBaudRate.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		
		labelDataBits.setText("<html>DATABITS : 8</html>");
		labelDataBits.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
		
		labelStopBits.setText("<html>STOPBITS : 1</html>");
		labelStopBits.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
		
		labelParity.setText("<html>PARITY : EVEN</html>");
		labelParity.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
		
		boxVerticalPanelLeft = Box.createVerticalBox();
		boxVerticalPanelLeft.add(labelSettings);
		boxVerticalPanelLeft.add(labelBaudRate);
		boxVerticalPanelLeft.add(widg.getComboBaud());
		boxVerticalPanelLeft.add(labelDataBits);
		boxVerticalPanelLeft.add(labelStopBits);
		boxVerticalPanelLeft.add(labelParity);
		
		panelLeft.add(boxVerticalPanelLeft);
	    
	}
	
	private void CreatePanelRight() {
		// TODO Auto-generated method stub
		panelRight.setPreferredSize(new Dimension(280, 310));
		panelRight.setLayout(new BorderLayout());
		
		CreatePanelRightRight();
		CreatePanelRightLeft();
		
		panelRight.add(panelRightRight, BorderLayout.EAST);
		panelRight.add(panelRightLeft, BorderLayout.WEST);
		
		labelGPSDatas.setText("<html><center><u>Global Positioning System Fix Data</u></center></html>");
		panelRight.add(labelGPSDatas, BorderLayout.NORTH);
		labelGPSDatas.setFont(police);
	}
	
	private void CreatePanelRightLeft() {
		// TODO Auto-generated method stub
		panelRightLeft.setPreferredSize(new Dimension(140, 200));
		//panelRightLeft.setLayout(new BorderLayout());
		
		labelUTC.setText("<html>UTC :</html>");
		labelUTC.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
		
		labelStatus.setText("<html>Status :</html>");
		labelStatus.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
		
		labelNbSV.setText("<html>Number of SVs used :</html>");
		labelNbSV.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
		
		labelLatitude.setText("<html>Latitude :</html>");
		labelLatitude.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
		
		labelNI.setText("<html>Northing Indicator :</html>");
		labelNI.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
		
		labelLongitude.setText("<html>Longitude :</html>");
		labelLongitude.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
		
		labelEI.setText("<html>Easting Indicator :</html>");
		labelEI.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
		
		labelAltitude.setText("<html>Altitude(meters) :</html>");
		labelAltitude.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
		
		boxVerticalPanelRightLeft = Box.createVerticalBox();
		boxVerticalPanelRightLeft.add(labelUTC);
		boxVerticalPanelRightLeft.add(labelStatus);
		boxVerticalPanelRightLeft.add(labelNbSV);
		boxVerticalPanelRightLeft.add(labelLatitude);
		boxVerticalPanelRightLeft.add(labelNI);
		boxVerticalPanelRightLeft.add(labelLongitude);
		boxVerticalPanelRightLeft.add(labelEI);
		boxVerticalPanelRightLeft.add(labelAltitude);
		
		panelRightLeft.add(boxVerticalPanelRightLeft);
	}

	private void CreatePanelRightRight() {
		// TODO Auto-generated method stub
		panelRightRight.setPreferredSize(new Dimension(140, 310));
		//panelRightRight.setLayout(new BorderLayout());
		
		labelUTCEdit.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
		//labelUTCEdit.setBorder(BorderFactory.createLineBorder(Color.black));
		
		labelStatusEdit.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
		//labelStatusEdit.setBorder(BorderFactory.createLineBorder(Color.black));
		
		labelNbSVEdit.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
		//labelNbSVEdit.setBorder(BorderFactory.createLineBorder(Color.black));
		
		labelLatitudeEdit.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
		//labelLatitudeEdit.setBorder(BorderFactory.createLineBorder(Color.black));
		
		labelNIEdit.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
		//labelNIEdit.setBorder(BorderFactory.createLineBorder(Color.black));
		
		labelLongitudeEdit.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
		//labelLongitudeEdit.setBorder(BorderFactory.createLineBorder(Color.black));
		
		labelEIEdit.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
		//labelEIEdit.setBorder(BorderFactory.createLineBorder(Color.black));
		
		labelAltitudeEdit.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
		//labelAltitudeEdit.setBorder(BorderFactory.createLineBorder(Color.black));
		
		boxVerticalPanelRightRight = Box.createVerticalBox();
		boxVerticalPanelRightRight.add(labelUTCEdit);
		boxVerticalPanelRightRight.add(labelStatusEdit);
		boxVerticalPanelRightRight.add(labelNbSVEdit);
		boxVerticalPanelRightRight.add(labelLatitudeEdit);
		boxVerticalPanelRightRight.add(labelNIEdit);
		boxVerticalPanelRightRight.add(labelLongitudeEdit);
		boxVerticalPanelRightRight.add(labelEIEdit);
		boxVerticalPanelRightRight.add(labelAltitudeEdit);
		
		panelRightRight.add(boxVerticalPanelRightRight);
	}

	public void CreatePanelBottom(){
	    //Creation du Panel du bas
		panelBottom.setPreferredSize(new Dimension(670, 40));
		panelBottom.setLayout(new BorderLayout());
		
		panelBottom.add(widg.getConnection(), BorderLayout.EAST);
		panelBottom.add(widg.getDisconnection(), BorderLayout.WEST);

	}

	public ArrayList getListsPort() {
		// TODO Auto-generated method stub
		return serialPort.getListData();
	}

	public void ConnexionSerialPort(JList listbox) {
		// TODO Auto-generated method stub
		serialPort.SerialPortConnection((String)listbox.getSelectedValue());
	}

	public void DisconnectionSerialPort() {
		// TODO Auto-generated method stub
		serialPort.DisconnectionPort();
	}

	public void RefreshDataGPS() {
		// TODO Auto-generated method stub
		labelUTCEdit.setText(String.valueOf(serialPort.getStrUTC()));
		labelStatusEdit.setText(String.valueOf(serialPort.getStrStatus()));
		labelNbSVEdit.setText(String.valueOf(serialPort.getStrNbVSs()));
		labelLatitudeEdit.setText(String.valueOf(serialPort.getStrLatitude()));
		labelNIEdit.setText(String.valueOf(serialPort.getStrNI()));
		labelLongitudeEdit.setText(String.valueOf(serialPort.getStrLongitude()));
		labelEIEdit.setText(String.valueOf(serialPort.getStrEI()));
		labelAltitudeEdit.setText(String.valueOf(serialPort.getStrAltitude()));
	}

}
