import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManagerPhonebook {
    List<Phonebook> phonebookList = new ArrayList<>();

    public ManagerPhonebook(List<Phonebook> phonebookList) {
        this.phonebookList = phonebookList;
    }
    public void addPhoneBook(Phonebook phonebook) throws IOException{
        phonebookList.add(phonebook);
        FilePhonebook.writefile(phonebookList);
    }
    public Phonebook findPhonebookByphoneNumber(String phoneNumber){
        Phonebook phonebook = null;
        for(int i =0;i<phonebookList.size();i++){
            if(phonebookList.get(i).getPhoneNumber().equals(phoneNumber)){
                phonebook = phonebookList.get(i);
            }
        }
        return  phonebook;
    }
    public int getIndexbyPhoneNumber(String phoneNumber){
        int index =-1;
        for(int i =0;i<phonebookList.size();i++){
            if(phonebookList.get(i).getPhoneNumber().equals(phoneNumber)){
                index = i;
            }
        }
        return index;
    }
    public void editPhoneBook(int index, Phonebook newPhoneBook) throws IOException{
        phonebookList.set(index,newPhoneBook);
        FilePhonebook.writefile(phonebookList);
    }
    public void deletePhoneBook(Phonebook phonebook) throws IOException  {
        phonebookList.remove(phonebook);
        FilePhonebook.writefile(phonebookList);
    }
    public void showAll(){
        for (Phonebook phonebook:
                phonebookList) {
            System.out.println(phonebook);
        }
    }
}
