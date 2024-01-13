package mentor.ContactService;

import mentor.entity.Contact;

import java.util.List;
import java.util.Scanner;

public interface IContactService {
    void input(List<Contact> list, Scanner sc) throws Exception;
    void display();
}
