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

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?city_id=%s&page=%s&q=java";
    private static HashMap<String, String> cityCodes = new HashMap<>();

    {
        cityCodes.put("Москва", "678");
    }

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            int pageNumber = 1;
            while (true) {
                Document doc = getDocument(searchString, pageNumber);
                if (doc == null) {
                    break;
                }
                Elements vacancyElements = doc.getElementsByClass("job");
                if (vacancyElements.isEmpty()) {
                    break;
                }
                for (Element element : vacancyElements) {
                    Element titleElement = element.select("[class=title] a").first();
                    String title = titleElement.text();
                    String url = "https://moikrug.ru" + titleElement.attr("href");

                    Element addressElement = element.select("[class=location]").first();
                    String city = addressElement != null ? addressElement.text() : "";

                    Element companyElement = element.select("[class=company_name] a").first();
                    String companyName = companyElement.text();

                    Element salaryElement = element.select("[class=salary]").first();
                    String salary = salaryElement.text();

                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(companyName);
                    vacancy.setSalary(salary);
                    vacancy.setSiteName("https://moikrug.ru/");
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