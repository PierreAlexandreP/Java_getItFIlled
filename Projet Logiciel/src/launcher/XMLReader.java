
/**
 * 
 */
package launcher;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


public class XMLReader {
    static final String TYPE = "type";
    static final String ITEM = "item";
    static final String X = "x";
    static final String Y = "y";
    static final String TWINX = "twinx";
    static final String TWINY = "twiny";
    static int i =0;

    @SuppressWarnings({ "unchecked", "null" })
    public List<Item> readConfig(String configFile) {
        List<Item> items = new ArrayList<Item>();
        try {
            // First, create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            String pathToFile = "Level30.xml";
            File file = new File(pathToFile);
            InputStream in = new FileInputStream(file);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            // read the XML document
            Item item = null;

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                
               	i=i+1;
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    // If we have an item element, we create a new item
                    if (startElement.getName().getLocalPart().equals(ITEM)) {
                        item = new Item();
                        // We read the attributes from this tag and add the date
                        // attribute to our object
                        Iterator<Attribute> attributes = startElement
                                .getAttributes();
                        while (attributes.hasNext()) {
                            Attribute attribute = attributes.next();
                            if(attribute.getName().toString().equals(X)) {
                            	item.setX(attribute.getValue());
                            }
                            if(attribute.getName().toString().equals(Y)) {
                            	item.setY(attribute.getValue());
                            }
                            if (attribute.getName().toString().equals(TYPE)) {
                                item.setType(attribute.getValue());
                            }
                            if (attribute.getName().toString().equals(TWINX)) {
                                item.setTwinx(attribute.getValue());
                            }
                            if (attribute.getName().toString().equals(TWINY)) {
                                item.setTwiny(attribute.getValue());
                            }
                        }
                    }

                    if (event.isStartElement()) {
 
                        if (event.asStartElement().getName().getLocalPart()
                                .equals(X)) {
                            event = eventReader.nextEvent();
                            item.setX(event.asCharacters().getData());

                            continue;
                        }
                    }
                }
                // If we reach the end of an item element, we add it to the list
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals(ITEM)) {
                        items.add(item);
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return items;
        
    }

}