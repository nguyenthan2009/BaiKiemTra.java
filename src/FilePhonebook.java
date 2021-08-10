import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilePhonebook {
        public static void writefile(List<Phonebook> phonebookList) throws IOException {
            ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("PhoneBook.txt"));

            ois.writeObject(phonebookList);
            ois.close();
        }

        public static List<Phonebook> readFile() throws IOException, ClassNotFoundException {
            List<Phonebook> list = new ArrayList<>();
            File file = new File("PhoneBook.txt");
            if (file.length() > 0) {
                ObjectInputStream out = new ObjectInputStream(new FileInputStream(file));
                list = (List<Phonebook>) out.readObject();
                out.close();
            }
            return list;
        }
}
