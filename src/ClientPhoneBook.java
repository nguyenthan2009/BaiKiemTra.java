import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ClientPhoneBook {
    public static void main(String[] args) {
        List<Phonebook> phonebookList = null;
        try{
            phonebookList = FilePhonebook.readFile();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        ManagerPhonebook managerPhonebook = new ManagerPhonebook(phonebookList);
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Ấn 1 để thêm 1 danh bạ");
            System.out.println("Ấn 2 để xóa 1 danh bạ");
            System.out.println("Ấn 3 để sửa 1 danh bạ");
            System.out.println("Ấn 4 để hiện thông tin tất cả danh bạ");
            System.out.println("Ấn 5 để tìm danh bạ theo số điện thoại");
            System.out.println("Ấn 0 để thoát chương trình");
            int number = sc.nextInt();
            switch (number){
                case 1:
                    try{
                    Pattern pattern = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
                    Pattern pattern1 = Pattern.compile("^[0-9]{10}$");
                    Phonebook phonebook = new Phonebook();
                    sc.nextLine();
                    while (true){
                        System.out.println("Mời bạn số điện thoại");
                        String phoneNumber = sc.nextLine();
                        if(pattern1.matcher(phoneNumber).matches()){
                            System.out.println("số điện thoại hợp lệ");
                            phonebook.setPhoneNumber(phoneNumber);
                            break;
                        }else{
                            System.out.println("Số điện thoại không hợp lệ, mời nhập lại");
                        }
                    }
                    while (true){
                        System.out.println("Mời bạn nhập gmail");
                        String gmail = sc.nextLine();
                        if(pattern.matcher(gmail).matches()){
                            System.out.println("Email hợp lệ");
                            phonebook.setEmail(gmail);
                            break;
                        }else{
                            System.out.println("Email không hợp lệ, mời nhập lại");
                        }
                    }
                    System.out.println("mời bạn nhập nhóm danh bạ");
                    String groupPhoneBook = sc.nextLine();
                    phonebook.setGroupPhoneBook(groupPhoneBook);
                    System.out.println("Nhập họ tên");
                    String fullName = sc.nextLine();
                    phonebook.setFullName(fullName);
                    System.out.println("Nhập giới tính");
                    String sex = sc.nextLine();
                    phonebook.setSex(sex);
                    System.out.println("Nhập địa chỉ");
                    String address = sc.nextLine();
                    phonebook.setAddress(address);
                    System.out.println("Nhập ngày sinh");
                    LocalDate localDate = LocalDate.of(sc.nextInt(),sc.nextInt(),sc.nextInt());
                    phonebook.setBornDay(localDate);
                    managerPhonebook.addPhoneBook(phonebook);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    sc.nextLine();
                    try {
                        System.out.println("Nhập số điện thoại của danh bạ cần xóa");
                        String phoneNumber = sc.nextLine();
                        managerPhonebook.deletePhoneBook(managerPhonebook.findPhonebookByphoneNumber(phoneNumber));
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        sc.nextLine();
                        System.out.println("Nhập số điện thoại của danh bạ bạn cần sửa");
                        String phoneNumber = sc.nextLine();
                        System.out.println("Nhập số điện thoại mới");
                        String newPhoneNumber = sc.nextLine();
                        System.out.println("Nhập nhóm danh bạ");
                        String gruopPhonebook = sc.nextLine();
                        System.out.println("Nhập họ tên");
                        String fullName = sc.nextLine();
                        System.out.println("Nhập giới tính");
                        String sex = sc.nextLine();
                        System.out.println("Nhập địa chỉ");
                        String address = sc.nextLine();
                        System.out.println("Nhập ngày sinh");
                        LocalDate localDate = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
                        System.out.println("Nhập gmail");
                        String gmail = sc.nextLine();
                        Phonebook phonebook = new Phonebook(newPhoneNumber, gruopPhonebook, fullName, sex, address, localDate, gmail);
                        managerPhonebook.editPhoneBook(managerPhonebook.getIndexbyPhoneNumber(phoneNumber), phonebook);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    managerPhonebook.showAll();
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("Nhập số điện thoại của danh bạ bạn muốn xem");
                    String PhoneNumber = sc.nextLine();
                    System.out.println(managerPhonebook.findPhonebookByphoneNumber(PhoneNumber));
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("No choice");
                    break;
            }
        }
    }
}
