package org.example;

public class WebPage {
    public static String getWebPage() {

        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Form Example</title>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Secuencia de Lucas</h1>\n" +
                "    <p>Número:</p>\n" +
                "    <input type=\"text\" id=\"numero\" name=\"name\" placeholder=\"Ingrese el número\"><br><br>\n" +
                "    <button type=\"submit\" onclick=\"loadSeq()\">Submit</button>\n" +
                "    <p id=\"resp\"></p>\n" +
                "<script>\n" +
                "    function loadSeq() {\n" +
                "        const valor = document.getElementById(\"numero\").value;\n" +
                "\n" +
                "        fetch(`http://localhost:4569/lucasseq/${valor}`, {\n" +
                "        method: 'GET'\n" +
                "        })\n" +
                "        .then(response => response.json())\n" +
                "        .then(data => {\n" +
                "            document.getElementById(\"resp\").textContent = `${data}`;\n" +
                "        })\n" +
                "    }\n" +
                "</script>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }
}
