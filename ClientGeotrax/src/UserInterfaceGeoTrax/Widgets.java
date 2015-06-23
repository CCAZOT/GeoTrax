package UserInterfaceGeoTrax;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionListener;

public class Widgets {

	private JButton connection;
	private JButton disconnection;
	private JButton refresh;
	private JList listbox;
	private JComboBox comboBaud;
	private MainView view;
	
	public Widgets(MainView mainView) {
		// TODO Auto-generated constructor stub
		
		view = mainView;
		
		connection = new JButton("Connection");
		disconnection = new JButton("Deconnection");
		refresh = new JButton("Refresh");

	}
	
	public void CreateButtonConnection()
	{
		connection.setPreferredSize(new Dimension(150, 40));
		connection.addActionListener(new ListenerButtonConnection(this));
	}
	
	public void CreateButtonDisconnection()
	{
		disconnection.setPreferredSize(new Dimension(150, 40));
		disconnection.addActionListener(new ListenerButtonDisconnection(this));
	}
	
	public void CreateButtonRefresh()
	{
		refresh.setPreferredSize(new Dimension(100, 40));
		refresh.addActionListener(new ListenerButtonRefresh(this));
	}
	
	public void CreateListListBox()
	{
		listbox = new JList(view.getListsPort().toArray());
		//listbox.setListData(view.getListsPort().toArray());
		listbox.addListSelectionListener(new ListenersWidgets(this));
		listbox.setPreferredSize(new Dimension(150, 200));
		listbox.setBorder(BorderFactory.createLineBorder(Color.black));
		listbox.setSelectedIndex(0);
	}
	
	public void RefreshListListBox()
	{		
		int nbComponent = listbox.getComponentCount();
		for(int i =0;i>= nbComponent;i++)
		{
			listbox.remove(i);	
		}
		
		listbox.setListData(view.getListsPort().toArray());
		listbox.setSelectedIndex(0);
	}
	
	public void CreateComboBoxComboBauds()
	{

		String[] listBauds = {"1'200", "2'400", "4'800", "9'600","19'200","38'400", "57'600", "115'200","230'400"};
		
		//Combobox 
		comboBaud = new JComboBox(listBauds);
		comboBaud.setSelectedIndex(3);
		comboBaud.addActionListener(new ListenerComboBauds(this));
		comboBaud.setPreferredSize(new Dimension(180, 20));
		comboBaud.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public JButton getConnection() {
		return connection;
	}

	public void setConnection(JButton connection) {
		this.connection = connection;
	}

	public JButton getDisconnection() {
		return disconnection;
	}

	public void setDisconnection(JButton disconnection) {
		this.disconnection = disconnection;
	}

	public JButton getRefresh() {
		return refresh;
	}

	public void setRefresh(JButton refresh) {
		this.refresh = refresh;
	}

	public JList getListbox() {
		return listbox;
	}

	public void setListbox(JList listbox) {
		this.listbox = listbox;
	}

	public JComboBox getComboBaud() {
		return comboBaud;
	}

	public void setComboBaud(JComboBox comboBaud) {
		this.comboBaud = comboBaud;
	}

	public void ConnexionSerialPort() {
		// TODO Auto-generated method stub
		view.ConnexionSerialPort(listbox);
		
	}

	public void DisconnectionSerialPort() {
		// TODO Auto-generated method stub
		view.DisconnectionSerialPort();
	}
}
