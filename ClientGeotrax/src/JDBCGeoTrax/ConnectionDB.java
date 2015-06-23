package JDBCGeoTrax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import javax.json.stream.JsonParserFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;



public class ConnectionDB {


		private String getRequest;
		private String postRequest;
		private URL oracle;
		private URLConnection fluxUrl;
		private BufferedReader in;
		private int idline;
     
        public ConnectionDB() {        
        		
        	idline=0;
        	getRequest = "";
        	postRequest = "";
        }
     
        public String getRequestHttp(String url) throws IOException{
        	
        	String inputLine;
        	
        	oracle = new URL(url);
        	fluxUrl = oracle.openConnection();
        	in = new BufferedReader(new InputStreamReader(fluxUrl.getInputStream()));
        	
        	while ((inputLine = in.readLine()) != null)
        		getRequest +=inputLine;
        	
        	System.out.print(getRequest);
        	
        	JsonParserFactory factory = Json.createParserFactory(null);
        	JsonParser parser = factory.createParser(new StringReader(getRequest));

        	while (parser.hasNext()) {
        	  Event event = parser.next();

        	  switch (event) {
        	    case KEY_NAME: {
        	      System.out.print(parser.getString() + "="); break;
        	    }
        	    case VALUE_STRING: {
        	      System.out.println(parser.getString()); break;
        	    }
        	  }
        	}
        	
        	in.close();
        	return getRequest;
        }
        
        public void sendPost(String url, String strUTC, String strStatus, String strNbVSs, String strLatitude, String strNI, String strLongitude, String strEI, String strAltitude) throws Exception {  
        	   
            HttpClient client = new DefaultHttpClient();  
            HttpPost post = new HttpPost(url);  
       
            // add header  
              
            post.setHeader("Content-Type", "application/json");  
            JSONObject obj = new JSONObject();   
            
            obj.put("id", Integer.toString(idline));   
            obj.put("box_id", "1");  
            obj.put("utc_time", strUTC);  
            obj.put("lat", strLatitude);  
            obj.put("northing_indicator", strNI);  
            obj.put("lon", strLongitude);  
            obj.put("easting_indicator", strEI);  
            obj.put("status", strStatus);  
            obj.put("sv_number", strNbVSs);  
            obj.put("hdop", "");  
            obj.put("alt", strAltitude);  
            obj.put("alt_unit", "m");  
            obj.put("geoid_separation", "");  
            obj.put("geoid_unit", "");  
            obj.put("age_of_dgps", "");  
            obj.put("dgps_ref_id", "");  
     
            StringEntity entity = new StringEntity(obj.toString());  
       
            post.setEntity(entity);  
       
            HttpResponse response = client.execute(post);  
            System.out.println("\nSending 'POST' request to URL : " + url);  
            System.out.println("Post parameters : " + post.getEntity());  
            System.out.println("Response Code : " +   
                                        response.getStatusLine().getStatusCode());  
       
            BufferedReader rd = new BufferedReader(  
                            new InputStreamReader(response.getEntity().getContent()));  
                      
            StringBuffer result = new StringBuffer();  
            String line = "";  
            while ((line = rd.readLine()) != null) {  
                result.append(line);  
            }  
       
            System.out.println(result.toString());  
       
        } 
        

		public String getGetRequest() {
			return getRequest;
		}
	
		public void setGetRequest(String getRequest) {
			this.getRequest = getRequest;
		}
	
		public String getPostRequest() {
			return postRequest;
		}
	
		public void setPostRequest(String postRequest) {
			this.postRequest = postRequest;
		}
    	public URL getOracle() {
    		return oracle;
    	}

    	public void setOracle(URL oracle) {
    		this.oracle = oracle;
    	}

    	public URLConnection getFluxUrl() {
    		return fluxUrl;
    	}

    	public void setFluxUrl(URLConnection fluxUrl) {
    		this.fluxUrl = fluxUrl;
    	}

    	public BufferedReader getIn() {
    		return in;
    	}

    	public void setIn(BufferedReader in) {
    		this.in = in;
    	}
}
