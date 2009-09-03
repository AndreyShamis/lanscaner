/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scaberlan;




import java.io.*;
import java.net.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import sun.net.www.http.HttpClient;



/**
 *
 * @author andy
 */
public class Manoa {


    private String SiteData = "";
    public void Manoa(){
        
    }


    public void Parse(){
        Pattern p = Pattern.compile("a*b");
        Matcher m = p.matcher("aaaaab");
        boolean b = m.matches();

    }

    public String DeleteHTML()throws UnsupportedEncodingException{
        String ReturnData = this.SiteData;
        ReturnData =  ReturnData.replaceAll("<script.*>.*</script>", "");
        ReturnData =  ReturnData.replaceAll("<style.*>.*</style>", "");
        ReturnData =  ReturnData.replaceAll("<br\\s*/+>", "");
       
        ReturnData =  ReturnData.replaceAll("&nbsp;", "");
//String s = ReturnData;
//byte[] b = s.getBytes("CP-1251");

////ReturnData = new String(b, "UTF-8");

        return ReturnData;
    }

    public void GetPage2(String URL_string){
        HttpClient client;
        client.


    }

    public void GetPage( String URL_string ){
        URL u;
        InputStream is = null;
        DataInputStream dis;
        String s;
        String output_data = "";
        try{
            u = new URL(URL_string);
            //Open an input stream from the url
            is = u.openStream();         // throws an IOException
            // Convert the InputStream to a buffered DataInputStream.      //
            // Buffering the stream makes the reading faster; the          //
            // readLine() method of the DataInputStream makes the reading  //
            // easier.                                                     //
            dis = new DataInputStream(new BufferedInputStream(is));
            // Now just read each record of the input stream, and print   //
            // it out.  Note that it's assumed that this problem is run   //
            // from a command-line, not from an application or applet.    //
            while ((s = dis.readLine()) != null) {
                output_data = output_data + s;
            }
            this.SetSiteData(output_data);
        }
        catch (MalformedURLException mue){
            System.out.println("Ouch - a MalformedURLException happened.");
            mue.printStackTrace();
            //System.exit(1);
        }
        catch (IOException ioe){
            System.out.println("Oops- an IOException happened.");
            ioe.printStackTrace();
            //System.exit(1);
        }
        finally{
            //  Close the InputStream  //
              //  try{
                    //is.close();
              //      System.out.println("Oops- an IOException happened.");
             //   }
             //   catch (IOException ioe){
                    // just going to ignore this one
             //   }
        }
        
    }

    public void SetSiteData(String NewValue){
        this.SiteData = NewValue;
    }
    public String GetSiteData(){
        return this.SiteData;
    }

}
