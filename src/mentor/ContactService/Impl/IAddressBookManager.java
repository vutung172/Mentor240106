package mentor.ContactService.Impl;

import java.util.List;

public interface IAddressBookManager<C> {
    void add(List<C> lists, C obj);
    void display(List<C> lists);
    void update(List<C> lists, C newObj);
    boolean delete(List<C> lists,int id);
    C findById(List<C> lists,int id);
}
