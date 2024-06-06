package edu.upvictoria;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MovieHTMLParser {

    public void parser () {
        try {
            Document doc = Jsoup.connect("https://www.imdb.com/title/tt0113101/?ref_=nv_sr_srsg_0_tt_3_nm_0_q_20%2520four%2520rooms").get();

            Element title = doc.select("h1[data-testid=hero__pageTitle] span.hero__primary-text[data-testid=hero__primary-text]").first();
            Element year = doc.select("ul.ipc-inline-list li.ipc-inline-list__item").first();
            Element rating = doc.select("div[data-testid=hero-rating-bar__aggregate-rating__score] span.sc-bde20123-1.cMEQkK").first();
            Set<String> stars = new HashSet<>();
            Set<String> directors = new HashSet<>();
            Set<String> writers = new HashSet<>();


            Elements directorElements1 = doc.select("li[data-testid=title-pc-principal-credit] a:matches((?i)Director[s]?) + div ul li a");
            Elements directorElements2 = doc.select("li[data-testid=title-pc-principal-credit] span:matches((?i)Director[s]?) + div ul li a");
            for (Element directorElement : directorElements1) {
                directors.add(directorElement.text());
            }
            for (Element directorElement : directorElements2) {
                directors.add(directorElement.text());
            }

            Elements writerElements1 = doc.select("li[data-testid=title-pc-principal-credit] a:matches((?i)Writer[s]?) + div ul li a");
            Elements writerElements2 = doc.select("li[data-testid=title-pc-principal-credit] span:matches((?i)Writer[s]?) + div ul li a");
            for (Element writerElement : writerElements1) {
                writers.add(writerElement.text());
            }
            for (Element writerElement : writerElements2) {
                writers.add(writerElement.text());
            }

            Elements starElements1 = doc.select("li[data-testid=title-pc-principal-credit] a:matches((?i)Star[s]?) + div ul li a");
            Elements starElements2 = doc.select("li[data-testid=title-pc-principal-credit] span:matches((?i)Star[s]?) + div ul li a");
            for (Element starElement : starElements1) {
                stars.add(starElement.text());
            }
            for (Element starElement : starElements2) {
                stars.add(starElement.text());
            }

            List<String> uniqueStars = new ArrayList<>(stars);
            List<String> uniqueDirectors = new ArrayList<>(directors);
            List<String> uniqueWriters = new ArrayList<>(writers);


            System.out.println("Title: " + title.text());
            System.out.println("Year: " + year.text());
            System.out.println("Rating: " + rating.text());
            System.out.println("Directors: " + uniqueDirectors);
            System.out.println("Writers: " + uniqueWriters);
            System.out.println("Stars: " + uniqueStars);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
