package framework.urlConnector;

import java.net.HttpURLConnection;
import java.net.URL;
public class URLConnector  {
    public static boolean checkURLConnectivity(String url) {
        //To check the connectivity status of the URL
        try {
            URL webUrl = new URL(url);                                                  //Convert the string URL to URL object
            HttpURLConnection connection = (HttpURLConnection) webUrl.openConnection(); //Open the connection for the URL using HttpURLConnection typecasting
            connection.setRequestMethod("GET");                                         //Set the request method as GET
            connection.connect();                                                       //Connect to the URL
            int responseCode = connection.getResponseCode();                            //Get the response code
            return (responseCode==200);                                                 //Return true if the response code is 200

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}