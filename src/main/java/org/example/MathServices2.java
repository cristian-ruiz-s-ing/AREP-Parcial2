package org.example;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class MathServices2 {
    public static void main(String[] args) {
        port(getPort());
        get("/calcular/:valor", (req, res) -> {
            String num = req.params("valor");
            return seqLucas(num);
        });
    }

    private static String seqLucas(String num) {
        List out = new ArrayList<>();
        out.add("2");
        out.add("1");
        int numero = Integer.parseInt(num);
        while (numero > 1){
            int a = Integer.parseInt((String) out.get(out.size()-1));
            int b = Integer.parseInt((String) out.get(out.size()-2));
            String n = String.valueOf(a+b);
            out.add(n);
            numero -= 1;
        }

        return out.toString();
    }


    private static int getPort() {
        if (System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568;
    }
}