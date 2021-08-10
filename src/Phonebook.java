import java.io.Serializable;
import java.time.LocalDate;

public class Phonebook implements Serializable {
   private String phoneNumber;
   private String groupPhoneBook;
   private String fullName;
   private String sex;
   private String address;
   private LocalDate bornDay;
   private String email;

    public Phonebook(String phoneNumber, String groupPhoneBook, String fullName, String sex, String address, LocalDate bornDay, String email) {
        this.phoneNumber = phoneNumber;
        this.groupPhoneBook = groupPhoneBook;
        this.fullName = fullName;
        this.sex = sex;
        this.address = address;
        this.bornDay = bornDay;
        this.email = email;
    }
    public Phonebook(){

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroupPhoneBook() {
        return groupPhoneBook;
    }

    public void setGroupPhoneBook(String groupPhoneBook) {
        this.groupPhoneBook = groupPhoneBook;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBornDay() {
        return bornDay;
    }

    public void setBornDay(LocalDate bornDay) {
        this.bornDay = bornDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Phonebook{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", groupPhoneBook='" + groupPhoneBook + '\'' +
                ", fullName='" + fullName + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", bornDay=" + bornDay +
                ", email='" + email + '\'' +
                '}';
    }
}
