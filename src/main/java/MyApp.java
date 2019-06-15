import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MyApp {

    public static void main(String[] args) {

        MyApp myApp = new MyApp();
        myApp.saveProduktInformation();
    }


    private static void saveProduktInformation() {
    // test
        try {
            Document doc = Jsoup.connect("https://prom.ua/p895411456-igrovoj-noutbu-omen.html")
                    .get();
            Elements newsHeadlines = doc.select("p895411456-igrovoj-noutbu-omen.html");
           // doc.select("div#
            for (Element headline : newsHeadlines) {
                System.out.println(headline.attr("title") + "  " + headline.absUrl("href"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
