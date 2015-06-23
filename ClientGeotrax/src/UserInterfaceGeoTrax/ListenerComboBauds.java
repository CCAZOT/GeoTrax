package UserInterfaceGeoTrax;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class ListenerComboBauds implements ActionListener {
	
	Widgets wid;
	
	public ListenerComboBauds(Widgets mainWid) {
		super();
		// TODO Auto-generated constructor stub
		wid = mainWid;
	}
	
    public void actionPerformed(ActionEvent arg0){

    	JComboBox cb = (JComboBox)arg0.getSource();
        String baudSelect = (String)cb.getSelectedItem();
        System.out.println(baudSelect);
    }

}
