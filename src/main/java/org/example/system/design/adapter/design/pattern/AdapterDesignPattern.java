package org.example.system.design.adapter.design.pattern;

public class AdapterDesignPattern {
    public static void main(String[] args) {

        XmlDataProvider xmlDataProvider = new XmlDataProvider();

        XMLDataAdapter xmlDataAdapter = new XMLDataAdapter(xmlDataProvider);

        String data = "Asif:1";

        Client client = new Client(xmlDataAdapter);
        String report = client.getReport(data);

        System.out.println(report);

    }



}

interface IReports {
    String getJsonData(String data);
}

class XmlDataProvider {
    String getXMLData(String data) {
        String[] split = data.split(":");

        return "<name>" + split[0] +"</name>"+ "<id>" + split[1] + "</id>";
    }
}

class XMLDataAdapter implements IReports {

    XmlDataProvider xmlDataProvider;
    public XMLDataAdapter(XmlDataProvider xmlDataProvider) {
        this.xmlDataProvider = xmlDataProvider;
    }

    public

    @Override
     String getJsonData(String data) {

        String xmlData = xmlDataProvider.getXMLData(data);

        String nameStart = "<name>";
        String nameEnd = "</name>";

        String idStart = "<id>";
        String idEnd = "</id>";


        String name = xmlData.substring(xmlData.indexOf(nameStart) + nameStart.length(), xmlData.indexOf(nameEnd));
        String id = xmlData.substring(xmlData.indexOf(idStart) + idStart.length(), xmlData.indexOf(idEnd));



        String jsonDta;
        jsonDta = "{\"name\":%s,\"id\":%s}".formatted(name, id);


        return jsonDta;
    }
}

class Client {

    IReports reports;

    public Client(IReports reports) {
        this.reports = reports;
    }


    public String getReport (String data) {
        return reports.getJsonData(data);
    }


}