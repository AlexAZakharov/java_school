package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactsDate;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactsDataGenerators {

    @Parameter(names = "-c", description = "Group count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Date format")
    public String format;

    public static void main(String [] args) throws IOException {
        ContactsDataGenerators generator = new ContactsDataGenerators();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex){
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactsDate> contacts = generatorsContact(count);
        if (format.equals("csv")){
            saveAsCsv(contacts, new File(file));
        }else if (format.equals("xml")){
            saveAsXml(contacts, new File(file));
        }else {
            System.out.println("Unrecognized format" + format);
        }
    }

    private void saveAsXml(List<ContactsDate> contacts, File file) throws IOException {
        XStream xstream =new XStream();
        xstream.processAnnotations(ContactsDate.class);
        String xml = xstream.toXML(contacts);
        try (Writer writer = new FileWriter(file)){
            writer.write(xml);
        }
    }

    private void saveAsCsv(List<ContactsDate> contacts, File file) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            for (ContactsDate contact : contacts) {
                writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n"
                        , contact.getMiddlename()
                        , contact.getLastname()
                        , contact.getNickname()
                        , contact.getFirstname()
                        , contact.getCompany()
                        , contact.getAddress()
                        , contact.getHome()
                        , contact.getEmail()
                        , contact.getEmail2()
                        , contact.getEmail3()
                        , contact.getAddress2()
                        , contact.getHomePhon()
                        , contact.getMobilePhon()
                        , contact.getWorkPhon()
                ));
            }
        }
    }

    private  List<ContactsDate> generatorsContact(int count) {
        List<ContactsDate> contacts = new ArrayList<ContactsDate>();
        for (int i=0; i<count; i++){
            contacts.add(new ContactsDate()
                    .withMiddlename(String.format("A %s",i))
                    .withLastname(String.format("Ivan %s",i))
                    .withNickname(String.format("gaz %s",i))
                    .withFirstname(String.format("Bobrov %s",i))
                    .withCompany(String.format("Company %s",i))
                    .withAddress(String.format("Address %s",i))
                    .withHome(String.format("home %s",i))
                    .withEmail(String.format("Email(%s)",i))
                    .withEmail2(String.format("Email2(%s)",i))
                    .withEmail3(String.format("Email3(%s)",i))
                    .withAddress2(String.format("Address2(%s)",i))
                    .withHomePhon(String.format("777 %s",i))
                    .withMobilePhon(String.format("321 %s",i))
                    .withWorkPhon(String.format("123%s",i))
                    .withGroup("test1")
                    .withPhoto(new File("src/test/resources/i.jpg"))
            );
        }
        return contacts;
    }


}
