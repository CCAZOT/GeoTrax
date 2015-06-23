package GPSComGeoTrax;

import javax.comm.*;
import java.io.*;
import java.util.*;

import JDBCGeoTrax.ConnectionDB;
import UserInterfaceGeoTrax.MainView;

import com.sun.comm.Win32Driver;

public class ConnectionPort  {

	private CommPortIdentifier portId;
	private Enumeration portList;
	private BufferedReader read;
	private SerialPort serialPort;
	private ArrayList listData;
	
	private String strUTC;
	private String strStatus;
	private String strNbVSs;
	private String strLatitude;
	private String strNI;
	private String strLongitude;
	private String strEI;
	private String strAltitude;	
	
	private Win32Driver w32Driver;
	private MainView view;
	private ConnectionDB dataBase;

	public ConnectionPort(ConnectionDB DB) {
		// TODO Auto-generated constructor stub
		
		dataBase = DB; 
		w32Driver= new Win32Driver();
		listData = new ArrayList();
		
	}
	
	public void listePortsDispo()
	{
		System.out.println("recherche...");

		w32Driver.initialize();	
		listData.clear();
		portList=null;
		portId=null;
		
		portList=CommPortIdentifier.getPortIdentifiers();

		int nbr=0;
		while (portList.hasMoreElements()){
			portId=(CommPortIdentifier)portList.nextElement();
			listData.add(portId.getName());
			System.out.println(listData.get(nbr));
			nbr++;
		}
	}
	
	public void SerialPortConnection (String com)
	{

		try
		{

			portId=CommPortIdentifier.getPortIdentifier(com);
			serialPort=(SerialPort)portId.open("Mon_Appli",2000);
			
			//récupération du flux
			CreateReadinFlow();
			
			listenerSerialPort();
			
			//paramétrage du port
			PortSettings();
			
			System.out.println("Ouverture du port "+com);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public void CreateReadinFlow()
	{
		try {
		read=new BufferedReader(
		new InputStreamReader(serialPort.getInputStream()));
		} catch (IOException e) {
		}
	}
	
	public void PortSettings()
	{
		//paramétrage du port
		serialPort.notifyOnDataAvailable(true);
		try {
		serialPort.setSerialPortParams(9600,
				SerialPort.DATABITS_8,
				SerialPort.STOPBITS_1,
				SerialPort.PARITY_EVEN);
		} catch (UnsupportedCommOperationException e) {
		}
	}
	
	public void listenerSerialPort()
	{
		try {
			serialPort.addEventListener(new ProcessGPSData(this));
		} catch (TooManyListenersException e) {
		}
	}
	
	public void DisconnectionPort()
	{
		try {
			read.close();
		} catch (IOException e) {
		}
		serialPort.close();
	}
	
	public BufferedReader getRead() {
		return read;
	}

	public void setRead(BufferedReader read) {
		this.read = read;
	}
	
	public ArrayList getListData() {
		System.out.println("listage des ports série disponibles:");
		listePortsDispo();
		return listData;
	}

	public void setListData(ArrayList listData) {
		this.listData = listData;
	}
	
	public String getStrUTC() {
		return strUTC;
	}

	public void setStrUTC(String strUTC) {
		this.strUTC = strUTC;
	}

	public String getStrStatus() {
		return strStatus;
	}

	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	public String getStrNbVSs() {
		return strNbVSs;
	}

	public void setStrNbVSs(String strNbVSs) {
		this.strNbVSs = strNbVSs;
	}

	public String getStrLatitude() {
		return strLatitude;
	}

	public void setStrLatitude(String strLatitude) {
		this.strLatitude = strLatitude;
	}

	public String getStrNI() {
		return strNI;
	}

	public void setStrNI(String strNI) {
		this.strNI = strNI;
	}

	public String getStrLongitude() {
		return strLongitude;
	}

	public void setStrLongitude(String strLogitude) {
		this.strLongitude = strLogitude;
	}

	public String getStrEI() {
		return strEI;
	}

	public void setStrEI(String strEI) {
		this.strEI = strEI;
	}

	public String getStrAltitude() {
		return strAltitude;
	}

	public void setStrAltitude(String strAltitude) {
		this.strAltitude = strAltitude;
	}

	public MainView getView() {
		return view;
	}

	public void setView(MainView view) {
		this.view = view;
	}

	public void checkData() {
		// TODO Auto-generated method stub
		view.RefreshDataGPS();
		
		if(!(strLatitude.isEmpty()) || !(strLongitude.isEmpty()))
		{
			try {
				dataBase.sendPost("http://176.31.127.200/geogeo/api/v1/lines",strUTC,strStatus,strNbVSs,strLatitude,strNI,strLongitude,strEI,strAltitude);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}
}
