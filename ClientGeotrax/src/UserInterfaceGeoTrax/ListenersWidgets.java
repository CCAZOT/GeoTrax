package UserInterfaceGeoTrax;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListenersWidgets implements ListSelectionListener {
	
	Widgets wid;
	
	public ListenersWidgets(Widgets mainWid) {
		super();
		// TODO Auto-generated constructor stub
		wid = mainWid;
	}
	
	
	  public void valueChanged(ListSelectionEvent evt) { 
		  //ecran.setText((String)listbox.getSelectedValue());
		 }

}
