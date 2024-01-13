package mentor.entity;

import mentor.ContactService.IContactService;
import mentor.run.Main;

import java.util.List;
import java.util.Scanner;


public class Contact implements IContactService {
    private int id;
    private String name;
    private String phone;
    private String address;

    public Contact() {
    }

    public Contact(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception{
            if (name.length() > 20)
                throw new Exception("Tên tối đa 20 kí tự");
            this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws Exception{
        if (name.length() > 30)
            throw new Exception("Tên tối đa 20 kí tự");
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws Exception{
        if (name.length() > 100)
            throw new Exception("Tên tối đa 20 kí tự");
        this.address = address;
    }



    @Override
    public void input(List<Contact> list, Scanner sc) throws Exception {
        System.out.println("Nhập tên:");
        setName(sc.nextLine());
        boolean isExistPhone;
        do {
            System.out.println("Nhập số điện thoại:");
            String inputPhone = sc.nextLine();
            isExistPhone = !validPhone(inputPhone,list);
            if (!isExistPhone){
                setPhone(inputPhone);
            }
        } while (isExistPhone);

        /*String inputPhone = null;
        final String finalInputPhone = inputPhone;
        do {
            System.out.println("Nhập số điện thoại:");
            inputPhone = sc.nextLine();
        }while (validPhone(list,contact -> contact.getPhone().equals(finalInputPhone)));
        setPhone(finalInputPhone);*/

        System.out.println("Nhập địa chỉ: ");
        setAddress(sc.nextLine());
    }

    @Override
    public void display() {
        System.out.printf("ID: %5s | Tên: %-20s | Số điện thoại: %-30s | Địa chỉ : %-100s |\n",getId(),getName(),getPhone(),getAddress());
    }


    /**
     * validPhone: kiểm tra số điện thoại đã tồn tại hay chưa
     * @param
     * @param contacts
     * @return true: không trùng / false: có trùng
     */
    private boolean validPhone(String inputPhone, List<Contact> contacts/*,Predicate<Contact> predicate*/){
        for (Contact contact:contacts) {
            if (contact.getPhone().equals(inputPhone)){
                System.err.println("Số điện thoại đã tồn tại");
                return false;
            }
        }
        return true;
    }
}
