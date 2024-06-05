package edu.upvictoria;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {

            Document doc = Jsoup.connect("https://www.imdb.com/title/tt1392190/?ref_=hm_tpks_tt_i_1_pd_tp1_pbr_ic").get();
            // Gets the title
            System.out.println(doc.title());

            // Gets all the links
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                System.out.println(link.attr("abs:href"));
            }


            // Element tittle = doc.select("span.hero__primary-text[data-testid=hero__primary-text]").first();
            // Elements actorLinks = doc.select("a.ipc-metadata-list-item__list-content-item.ipc-metadata-list-item__list-content-item--link");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
