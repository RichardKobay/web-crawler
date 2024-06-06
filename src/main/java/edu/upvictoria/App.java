package edu.upvictoria;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.imdb.com/name/nm0213136/?ref_=tt_ov_dr").get();

            Element name = doc.select("h1[data-testid=hero__pageTitle] span.hero__primary-text[data-testid=hero__primary-text]").first();
            Element bornDate = Objects.requireNonNull(doc.select("div[data-testid=birth-and-death-birthdate]").first()).lastElementChild();
            Element desc = doc.select("div.ipc-html-content-inner-div").first();

            System.out.println(name.text());
            System.out.println(bornDate.text());
            System.out.println(desc.text());

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
