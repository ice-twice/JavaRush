package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "shop")
@XmlRootElement
public class Shop {
    @XmlElementWrapper(name = "goods", nillable = true)
    public List<String> names = new ArrayList<>();
    public int count;
    public double profit;
    public List<String> secretData = new ArrayList<>();

    /*public static void main(String[] args) throws JAXBException {
        Shop shop = new Shop();
        shop.names.add("S1");
        shop.names.add("S2");
        shop.count = 12;
        shop.profit = 123.4;
        shop.secretData.add("String1");
        shop.secretData.add("String2");
        shop.secretData.add("String3");
        shop.secretData.add("String4");
        shop.secretData.add("String5");

        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Shop.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(shop, writer);
        System.out.println(writer);
    }*/
}