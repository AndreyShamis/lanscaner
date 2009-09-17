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
 
        


    }

    public void GetPage( String URL_string ){
        URL u;
        InputStream is = null;
        DataInputStream dis;
        String s;
        String output_data = "";
        try{
            u = new URL(URL_string);

            is = u.openStream();        
            
            dis = new DataInputStream(new BufferedInputStream(is));

            //while ((s = dis.readLine()) != null) {
            //    output_data = output_data + s;
            //}
            output_data =dis.readUTF();
    
            this.SetSiteData(output_data);
        }
        catch (MalformedURLException mue){
            System.out.println("Ouch - a MalformedURLException happened." + mue.toString());
            mue.printStackTrace();
            //System.exit(1);
        }
        catch (IOException ioe){
            System.out.println("Oops- an IOException happened." + ioe.toString());
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
