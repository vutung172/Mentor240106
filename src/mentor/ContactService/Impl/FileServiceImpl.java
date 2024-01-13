package mentor.ContactService.Impl;

import mentor.ContactService.FileService;
import mentor.entity.Contact;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileServiceImpl implements FileService<Contact> {
    @Override
    public List<Contact> readContactsFromFile(String fileName){
        List<Contact> contacts = new ArrayList<>();
        try{
            Path path = Path.of(fileName);
            Stream<String> fileStream = Files.lines(path);
            fileStream.forEach(stream -> {
                String[] contactDetail =  stream.split(",");
                Contact contact = new Contact();
                try {
                    contact.setId(Integer.parseInt(contactDetail[0]));
                    contact.setName(contactDetail[1]);
                    contact.setPhone(contactDetail[2]);
                    contact.setAddress(contactDetail[3]);

                    contacts.add(contact);
                } catch (Exception e) {
                    e.getStackTrace();
                }
            });
        } catch (IOException ioe){
            ioe.getStackTrace();
        }
        return contacts;
    }

    @Override
    public void writeContactsToFile(String fileName, List<Contact> list) {
        List<String> lines = new ArrayList<>();
        list.forEach(contact -> lines.add(contact.getId()+","+contact.getName()+","+contact.getPhone()+","+contact.getAddress()));
        try{
            Path path = Path.of(fileName);
            Files.write(path,lines);
        } catch (IOException ioe){
            ioe.getStackTrace();
        }
    }
}
