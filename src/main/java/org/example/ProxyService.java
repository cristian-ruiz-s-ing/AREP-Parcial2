package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static spark.Spark.*;

public class ProxyService {
    public static void main(String[] args) {
        port(getPort());
        get("/home", (req, res) -> {
            return WebPage.getWebPage();
        });

        get("/lucasseq/:valor", (req, res) -> {
            String val = req.params("valor");
            String urlMathService = "http://localhost:4567/calcular/"+val;
            System.out.println(urlMathService);
            URL url = new URL(urlMathService);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        });
    }

    private static int getPort() {
        if(System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4569;
    }

}
