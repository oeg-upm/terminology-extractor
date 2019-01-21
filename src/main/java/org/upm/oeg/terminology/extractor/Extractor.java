/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upm.oeg.terminology.extractor;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.Proxy;
import java.net.InetSocketAddress;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
 
/**
 *
 * @author pcalleja
 */
public class Extractor {
    
    private static final String USER_AGENT = "Mozilla/5.0";

    public static void main (String [] args) throws Exception{
    
        
        
        if(args.length!=2){
            System.out.println("NO PARAMETERS INCLUDED");
            System.out.println(" [0]- Core [1]- Algorithm ");
            return;
        }
        
        
        String core= args[0];
        String Alg= args[1];
        
        System.out.println(core+" "+Alg);
        
        HttpURLConnection con =null;
        
        
        // String url = "http://localhost:8983/solr/Spanishcore/ttfidf";
      
        String url = "http://localhost:8983/solr/"+core+"/"+Alg;
      
        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		//String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		//wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		//System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());
            //System.out.println("en");
        } finally {
            
            con.disconnect();
        }
     }
     
    
}
