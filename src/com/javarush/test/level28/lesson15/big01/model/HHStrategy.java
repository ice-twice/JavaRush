package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "https://hh.ua/search/vacancy?text=java&area=%s&page=%s";
    private static HashMap<String, String> cityCodes = new HashMap<>();

    {
        cityCodes.put("Москва", "1");
    }

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            int pageNumber = 0;
            while (true) {
                Document doc = getDocument(searchString, pageNumber);
                if (doc == null) {
                    break;
                }
                Elements vacancysElements = doc.select("[data-qa=vacancy-serp__vacancy]");
                if (vacancysElements.isEmpty()) {
                    break;
                }
                for (Element element : vacancysElements) {
                    Element titleElement = element.select("[data-qa=vacancy-serp__vacancy-title]").first();
                    String title = titleElement.text();
                    String url = titleElement.attr("href");

                    Element addressElement = element.select("[data-qa=vacancy-serp__vacancy-address]").first();
                    String city = addressElement.ownText();

                    Element companyElement = element.select("[data-qa=vacancy-serp__vacancy-employer]").first();
                    String companyName = companyElement != null ? companyElement.text() : "";

                    Element salaryElement = element.select("[data-qa=vacancy-serp__vacancy-compensation]").first();
                    String salary = salaryElement != null ? salaryElement.text() : "";

                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(companyName);
                    vacancy.setSalary(salary);
                    vacancy.setSiteName("http://hh.ua/");
                    vacancy.setUrl(url);

                    vacancies.add(vacancy);
                }

                pageNumber++;
            }
        } catch (IOException e) {
        }

        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, cityCodes.get(searchString), page);
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36";
        String referrer = "http://google.com.ua/";
        return Jsoup.connect(url).userAgent(userAgent).referrer(referrer).get();
    }
}
