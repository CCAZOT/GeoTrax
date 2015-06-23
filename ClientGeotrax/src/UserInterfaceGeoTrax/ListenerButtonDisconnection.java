package UserInterfaceGeoTrax;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerButtonDisconnection implements ActionListener {

	Widgets wid;
	
	public ListenerButtonDisconnection(Widgets mainWid) {
		super();
		// TODO Auto-generated constructor stub
		wid = mainWid;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		wid.DisconnectionSerialPort();
		wid.getConnection().setEnabled(true);
		wid.getDisconnection().setEnabled(false);
	}
}
