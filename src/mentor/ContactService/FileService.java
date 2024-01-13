package mentor.ContactService;

import java.io.IOException;
import java.util.List;

public  interface  FileService<C> {

    List<C> readContactsFromFile(String fileName) throws IOException;

    void writeContactsToFile(String fileName, List<C> list);
}
