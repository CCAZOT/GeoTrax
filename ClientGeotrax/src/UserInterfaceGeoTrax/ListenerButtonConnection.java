package UserInterfaceGeoTrax;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerButtonConnection implements ActionListener {
	
	Widgets wid;
	
	public ListenerButtonConnection(Widgets mainWid) {
		super();
		// TODO Auto-generated constructor stub
		wid = mainWid;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		wid.ConnexionSerialPort();
		wid.getConnection().setEnabled(false);
		wid.getDisconnection().setEnabled(true);
	}

}
