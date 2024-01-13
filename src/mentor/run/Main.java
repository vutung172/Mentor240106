package mentor.run;

import mentor.ContactService.FileService;
import mentor.ContactService.Impl.FileServiceImpl;
import mentor.entity.AddressBookManager;
import mentor.entity.Contact;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static FileService<Contact>  fileService = new FileServiceImpl();
    static  List<Contact> contacts;

    static {
        try {
            contacts = fileService.readContactsFromFile("Contacts.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        AddressBookManager addressBookManager = new AddressBookManager();



        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("++++++Quản lý danh bạ+++++");
            System.out.println("1.Thêm");
            System.out.println("2.Hiển thị");
            System.out.println("3.Sửa");
            System.out.println("4.Xóa");
            System.out.println("5.Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    Contact contact = new Contact();
                    contact.input(contacts,sc);
                    addressBookManager.add(contacts,contact);
                    fileService.writeContactsToFile("Contacts.txt",contacts);
                    break;
                case 2:
                    addressBookManager.display(contacts);
                    break;
                case 3:
                    System.out.println("Nhập vào ID muốn sửa:");
                    int idUpdate = Integer.parseInt(sc.nextLine());
                    Contact foundContact = addressBookManager.findById(contacts,idUpdate);
                    if (foundContact == null){
                        System.err.println("ID liên hệ muốn tìm không tồn tại");
                    } else {
                        foundContact.input(contacts,sc);
                        addressBookManager.update(contacts,foundContact);

                    }
                    fileService.writeContactsToFile("Contacts.txt",contacts);
                    break;
                case 4:
                    System.out.println("Nhập ID muốn xóa: ");
                    int idDelete = Integer.parseInt(sc.nextLine());
                    if (addressBookManager.delete(contacts,idDelete)) {
                        System.out.println("Xóa thành công");
                    }else
                    {System.err.println("Xóa thất bại");}
                    fileService.writeContactsToFile("Contacts.txt",contacts);
                    break;
                case 5:
                    fileService.writeContactsToFile("Contacts.txt",contacts);
                    System.exit(0);
                default:
                    System.err.println("Lựa chọn không phù hợp");
            }

        }while (true);
    }
}
