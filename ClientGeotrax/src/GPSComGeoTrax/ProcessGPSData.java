package GPSComGeoTrax;

import java.io.IOException;

import javax.comm.SerialPortEvent;
import javax.comm.SerialPortEventListener;

public class ProcessGPSData implements SerialPortEventListener {
	
	private String vGTampon;
	private String[] datasGPS;
	private long vGTailleMaxTampon;
	private ConnectionPort port;
	
	private long startGPGGA;
	private long endGPGGA;
	private long startGPRMC;
	private long endGPRMC;
	
	private boolean valideGPGGA;
	private boolean valideGPRMC;

	public ProcessGPSData(ConnectionPort p1) {
		super();
		// TODO Auto-generated constructor stub
		vGTampon="";
		//vGTailleMaxTampon = 500;
		port=p1;
	}

	public void serialEvent(SerialPortEvent event) {
		long vLTestLongueur,vLOffsetDepart;
		String vLTampon;
		
		switch (event.getEventType()) {
			case SerialPortEvent.BI :
			case SerialPortEvent.OE :
			case SerialPortEvent.FE :
			case SerialPortEvent.PE :
			case SerialPortEvent.CD :
			case SerialPortEvent.CTS :
			case SerialPortEvent.DSR :
			case SerialPortEvent.RI :
			case SerialPortEvent.OUTPUT_BUFFER_EMPTY :
				break;
			case SerialPortEvent.DATA_AVAILABLE :
				try {
					vGTampon = (String) port.getRead().readLine();
					System.out.println(vGTampon);
					//vGTampon = vGTampon + vLTampon;
					//vLTestLongueur = vGTampon.length();
					/*if (vLTestLongueur>vGTailleMaxTampon)
					{
						vLOffsetDepart = (vLTestLongueur-vGTailleMaxTampon)+1;
						vGTampon=vGTampon.substring((int)vLOffsetDepart, (int)vLTestLongueur);
					}*/
					
					AnalyseTampon();
				} catch (IOException e) {
				}
				break;
		}
	}
	
	private void AnalyseTampon()
	{
		startGPGGA = vGTampon.indexOf("$GPGGA");
		//endGPGGA = -1;
		
		/*if(startGPGGA>=0){
			endGPGGA = vGTampon.indexOf("$",(int) startGPGGA+1);
			System.out.println(endGPGGA);
			}*/
		
		if(startGPGGA>=0){
			datasGPS = vGTampon.split(",");
			port.setStrUTC(datasGPS[1]);
			port.setStrLatitude(datasGPS[2]);
			port.setStrNI(datasGPS[3]);
			port.setStrLongitude(datasGPS[4]);
			port.setStrEI(datasGPS[5]);
			port.setStrStatus(datasGPS[6]);
			port.setStrNbVSs(datasGPS[7]);
			port.setStrAltitude(datasGPS[9]);
			
			port.checkData();
		}
	}
}
