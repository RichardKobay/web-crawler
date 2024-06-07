package edu.upvictoria;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Document doc = Jsoup.connect("https://www.imdb.com/title/tt1517268/?ref_=nv_sr_srsg_0_tt_4_nm_4_q_barbie").get();

            Elements links = doc.select("a");

            List<String> hrefs = new ArrayList<>();

            for (Element link : links) {
                String href = link.absUrl("href");
                if (!href.isEmpty())
                    hrefs.add(href);
            }

            for (String href : hrefs)
                System.out.println(href);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
