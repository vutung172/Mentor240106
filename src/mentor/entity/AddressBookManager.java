package mentor.entity;

import mentor.ContactService.Impl.IAddressBookManager;

import java.util.List;

public class AddressBookManager implements IAddressBookManager<Contact> {
    @Override
    public void add(List<Contact> lists, Contact obj) {
        int max = lists.size();
        obj.setId(max+1);
        lists.add(obj);
    }

    @Override
    public void display(List<Contact> lists) {
        lists.stream().forEach(Contact::display);
    }

    @Override
    public void update(List<Contact> lists, Contact newObj) {
        lists.forEach(contact -> {
            if (contact.getId() == newObj.getId()){
                contact = newObj;
            }
        });
    }

    @Override
    public boolean delete(List<Contact> lists, int id) {
        Contact contact = findById(lists,id);
        if (contact != null) {
            lists.remove(contact);
            return true;
        }
        return false;
    }

    @Override
    public Contact findById(List<Contact> lists, int id) {
        for (Contact contact:lists) {
            if (contact.getId() == id){
                return contact;
            }
        }
       return null;
    }
}
