package assignment13.main;

import java.util.ArrayList;
import java.io.*;
import javax.xml.stream.*;  // StAX API

/**
 *
 * @author Arun
 */
public class XMLTesterApp
{
    private static String productsFilename = "products.xml";

    public static void main(String[] args)
    {
        System.out.println("Products list:");
        ArrayList<Product> products = readProducts();
        printProducts(products);


        Product p1 = new Product("test", "XML Tester", 77.77);
        products.add(p1);
        writeProducts(products);
        System.out.println("XML Tester has been added to the XML document.\n");


        System.out.println("Products list:");
        products = readProducts();
        printProducts(products);


        products.remove(2);
        writeProducts(products);
        System.out.println("XML Tester has been deleted from the XML document.\n");


        System.out.println("Products list:");
        products = readProducts();
        printProducts(products);

    }

    private static ArrayList<Product> readProducts()
    {
        ArrayList<Product> products = new ArrayList<Product>();
        Product p = null;
        
        // add code that reads the XML document from the products.xml file
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try
        {
            FileReader fileReader = new FileReader(productsFilename);
            XMLStreamReader xmlReader = inputFactory.createXMLStreamReader(fileReader);
            
            while (xmlReader.hasNext())
            {
                int eventType = xmlReader.getEventType();
                switch (eventType)
                {
                    case XMLStreamConstants.START_ELEMENT:
                        String elementName = xmlReader.getLocalName();
                        if (elementName.equals("Product"))
                        {
                            p = new Product();
                            String code = xmlReader.getAttributeValue(0);
                            p.setCode(code);
                        }
                        if (elementName.equals("Description"))
                        {
                            String description = xmlReader.getElementText();
                            p.setDescription(description);
                        }
                        if (elementName.equals("Price"))
                        {
                            String strPrice = xmlReader.getElementText();
                            double price = Double.parseDouble(strPrice);
                            p.setPrice(price);
                        }
                        break;
                        
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = xmlReader.getLocalName();
                        if (elementName.equals("Product"))
                        {
                            products.add(p);
                        }
                        break;
                    default:
                        break;
                }
                xmlReader.next();
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(XMLStreamException e)
        {
            e.printStackTrace();  
        }
        return products;
    }

    private static void writeProducts(ArrayList<Product> products)
    {
        // add code that writes the XML document to the products.xml file
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        
        try
        {
            FileWriter fileWriter = new FileWriter(productsFilename);
            XMLStreamWriter xmlWriter = outputFactory.createXMLStreamWriter(fileWriter);
            
            xmlWriter.writeStartDocument("1.0");
            xmlWriter.writeStartElement("Products");
            for (Product p : products)
            {
                xmlWriter.writeStartElement("Product");
                xmlWriter.writeAttribute("Code", p.getCode());
                
                xmlWriter.writeStartElement("Description");
                xmlWriter.writeCharacters(p.getDescription());
                xmlWriter.writeEndElement();
                
                xmlWriter.writeStartElement("Price");
                double price = p.getPrice();
                xmlWriter.writeCharacters(Double.toString(price));
                xmlWriter.writeEndElement();
                
                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();
            xmlWriter.flush();
            xmlWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (XMLStreamException e)
        {
            e.printStackTrace();
        }
    }

    private static void printProducts(ArrayList<Product> products)
    {
        for (Product p : products)
        {
            printProduct(p);
        }
        System.out.println();
    }

    private static void printProduct(Product p)
    {
        String productString =
            StringUtils.padWithSpaces(p.getCode(), 8) +
            StringUtils.padWithSpaces(p.getDescription(), 44) +
            p.getFormattedPrice();

        System.out.println(productString);
    }
}
