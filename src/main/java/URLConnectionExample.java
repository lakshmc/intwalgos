import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URLConnectionExample {
    public static void main(String[] args){
        try {
            URL url = new URL("http://www.google.com");
            URLConnection conn = url.openConnection();

            InputStream is = conn.getInputStream();
            String str = new Scanner(is).useDelimiter("\\A").next();
            System.out.println(str);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
