package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            int pageNumber = 0;
            while (true) {
                Document doc = getDocument(searchString, pageNumber);
                Elements vacancysElements = doc.select("[data-qa=vacancy-serp__vacancy]");
                if (vacancysElements.isEmpty()) {
                    break;
                }
                for (Element element : vacancysElements) {
                    Element titleElement = element.select("[data-qa=vacancy-serp__vacancy-title]").first();
                    String title = titleElement.text();
                    String url = titleElement.attr("href");

                    Element addressElement = element.select("[data-qa=vacancy-serp__vacancy-address]").first();
                    String city = addressElement.text();

                    Element companyElement = element.select("[data-qa=vacancy-serp__vacancy-employer]").first();
                    String companyName = companyElement.text();

                    Element salaryElement = element.select("[data-qa=vacancy-serp__vacancy-compensation]").first();
                    String salary = salaryElement != null ? salaryElement.text() : "";

                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(companyName);
                    vacancy.setSalary(salary);
                    vacancy.setSiteName("http://hh.ua");
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
        if (page != 0) {
            return Jsoup.connect("http://javarush.ru/testdata/big28data" + page + ".html").get();
        }
        return Jsoup.connect("http://javarush.ru/testdata/big28data.html").get();
    }
}
