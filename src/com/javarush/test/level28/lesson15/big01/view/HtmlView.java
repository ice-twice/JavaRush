package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HtmlView implements View {
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace(".", "/") + "/vacancies.html";
    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies) {
        String resultHtml = getUpdatedFileContent(vacancies);
        updateFile(resultHtml);
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        Document doc;
        try {
            doc = getDocument();
        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
        Element tempElement = doc.select("[class=vacancy template]").first();
        Element templateVacancy = tempElement.clone();
        templateVacancy.removeClass("template").removeAttr("style");
        doc.getElementsByAttributeValue("class", "vacancy").remove();

        for (Vacancy v : vacancies) {
            String title = v.getTitle();
            String url = v.getUrl();
            String city = v.getCity();
            String company = v.getCompanyName();
            String salary = v.getSalary();

            Element newVacancy = templateVacancy.clone();

            Element titleElem = newVacancy.select("[class=title]").select("a").first();
            titleElem.attr("href", url);
            titleElem.text(title);

            Element cityElem = newVacancy.select("[class=city]").first();
            cityElem.text(city);

            Element companyElem = newVacancy.select("[class=companyName]").first();
            companyElem.text(company);

            Element salaryElem = newVacancy.select("[class=salary]").first();
            salaryElem.text(salary);

            tempElement.before(newVacancy);
        }

        return doc.outerHtml();
    }

    private void updateFile(String s) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(filePath);
            printWriter.print(s);
        } catch (FileNotFoundException e) {
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
        // in this way does not pass test
        /*try (PrintWriter printWriter = new PrintWriter(filePath)) {
            printWriter.print(s);
        } catch (FileNotFoundException e) {
        }*/
    }

    protected Document getDocument() throws IOException {
        File file = new File(filePath);
        return Jsoup.parse(file, "UTF-8");
    }
}
