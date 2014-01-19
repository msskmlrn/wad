package wad.soahitcounter.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Service;

@Service
public class SimpleHitCounter implements HitCounter{

    @Override
    public int getAndIncrementCount() {
        String vastaus = getResponseBody("http://t-avihavai.users.cs.helsinki.fi/hitcounter/013752853");
        String uusi = vastaus.substring(0, 2);

        return Integer.parseInt(uusi);
  
    }
    
    private String getResponseBody(String url) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);
        try {
            HttpResponse response = httpclient.execute(httpget);
            return readInputStream(response.getEntity().getContent());
        } catch (IOException ex) {
            Logger.getLogger(SimpleHitCounter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    private String readInputStream(InputStream is) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(is);
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine()).append("\n");
        }

        return sb.toString();
    }
}
