package LaucherGeoTrax;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import UserInterfaceGeoTrax.MainView;
import GPSComGeoTrax.ConnectionPort;
import JDBCGeoTrax.ConnectionDB;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConnectionDB DB = new ConnectionDB();
		ConnectionPort port = new ConnectionPort(DB);
		MainView window = new MainView(port);
		port.setView(window);
		window.CreatePanelMain();
	}

}
