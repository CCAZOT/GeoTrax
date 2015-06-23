package UserInterfaceGeoTrax;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ListenerButtonRefresh implements ActionListener {
	
	Widgets wid;
	
	public ListenerButtonRefresh(Widgets mainWid) {
		super();
		// TODO Auto-generated constructor stub
		wid = mainWid;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		wid.RefreshListListBox();
	}

}
