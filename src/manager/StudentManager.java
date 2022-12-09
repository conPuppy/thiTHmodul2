package manager;

import io.ReadWrite;
import model.Student;


import java.util.*;

public class StudentManager {
    Scanner scanner = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();
    ReadWrite readWrite = new ReadWrite();

    //    hàm thêm sinh viên:
    public void addNewStudent() {
        students.add(createStudent());
    }

    //  hàm tạo sinh viên:
    public Student createStudent() {
        String id ;
        String name;
        int age;
        String gender;
        String address;
        double avgScore;

        do{
            System.out.println("Nhập mã sinh viên: ");
            id = scanner.nextLine();
            if(checkId(id)) {
                System.out.println("Mã sinh viên đã tồn tại!");
            } else break;
        } while (checkId(id));
            System.out.println("Nhập họ tên sinh viên: ");
            name = scanner.nextLine();
            System.out.println("Nhập tuổi sinh viên: ");
            do {
                try {
                    age = Integer.parseInt(scanner.nextLine());
                    if (age > 0) {
                        break;
                    } else System.err.println("Tuổi không được âm!");
                } catch (NumberFormatException e) {
                    System.err.println("Phải nhập số!");
                }
            } while (true);
            System.out.println("Nhập giới tính sinh viên:");
            gender = scanner.nextLine();
            System.out.println("Nhập địa chỉ sinh viên:");
            address = scanner.nextLine();
            System.out.println("Nhập điểm trung bình sinh viên:");
            avgScore = Double.parseDouble(scanner.nextLine());
            if (avgScore > 0) {
                return new Student(id, name, age, gender, address, avgScore);
            } else {
                System.err.println("Điểm trung bình phải lớn hơn 0!");
                return null;
            }
    }


    //    hàm hiển thị danh sách nhân viên:
    public void show() {
        System.out.printf("%-15s%-30s%-10s%-20s%-30s%-10s", "ID", "Tên", "Tuổi", "Giới tính", "Địa chỉ", "Điểm trung bình");
        System.out.println();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    //    hàm sửa thông tin sinh viên:
    public void updateStudentById() {
        System.out.println("Nhập mã sinh viên muốn sửa thông tin: ");
        String id = scanner.nextLine();
        int index = findStudentById(id);
        if (index >= 0) {
            String newID;
            int newAge;
            double newAvgScore;
            System.out.println("Nhập mã sinh viên: ");
            newID = scanner.nextLine();
            students.get(index).setId(newID);
            System.out.println("Nhập họ tên sinh viên: ");
            String newName = scanner.nextLine();
            students.get(index).setName(newName);
            System.out.println("Nhập tuổi sinh viên: ");
            do {
                try {
                    newAge = Integer.parseInt(scanner.nextLine());
                    if (newAge > 0) {
                        students.get(index).setAge(newAge);
                        break;
                    } else System.err.println("Tuổi không được âm!");
                } catch (NumberFormatException e) {
                    System.err.println("Phải nhập số!");
                }
            } while (true);
            System.out.println("Nhập giới tính sinh viên:");
            String gender = scanner.nextLine();
            students.get(index).setGender(gender);
            System.out.println("Nhập địa chỉ sinh viên:");
            String address = scanner.nextLine();
            students.get(index).setAddress(address);
            System.out.println("Nhập điểm trung bình sinh viên:");
            do {
                try {
                    newAvgScore = Double.parseDouble(scanner.nextLine());
                    if (newAvgScore > 0) {
                        students.get(index).setAvgScore(newAvgScore);
                        break;
                    } else System.err.println("Điểm trung bình phải lớn hơn 0!");
                } catch (NumberFormatException e) {
                    System.err.println("Điểm trung bình phải nhập số thập phân!");
                }
            } while (true);
        } else System.out.println("Không tìm được sinh viên có mã sinh viên " + id);
    }
    //    hàm tìm sinh viên theo id:

    public int findStudentById(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (id.equals(students.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    //    hàm check mã sinh viên không trùng nhau:
    public boolean checkId(String id) {
        if(students.size()>0) {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getId().equals(id)) {
                    return true;
                }
            }
            return false;
        }else return false;
    }

    //    hàm xoá sinh viên theo mã sinh viên:
    public void deleteStudentById() {
        System.out.println("Nhập mã sinh viên muốn xoá: ");
        String id = scanner.nextLine();
        int index = findStudentById(id);
        if (index >= 0) {
            students.remove(index);
            System.out.println("Đã xoá thành công sinh viên có mã sinh viên " + id);
        } else System.out.println("Không tìm thấy sinh viên có mã sinh viên " + id);
    }

    //    hàm sắp xếp sinh viên theo điểm trung bình tăng dần:
    public void arrangeAscengdingScore() {
        Student temp;
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).getAvgScore() > students.get(j).getAvgScore()) {
                    temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }
        show();

    }

    //    hàm sắp xếp sinh viên theo điểm trung bình giảm dần:
    public void arrangeDescendingScore() {
        Student temp;
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).getAvgScore() < students.get(j).getAvgScore()) {
                    temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }
        show();
    }

    //    hàm ghi file:
    public void writeStudent() {
        readWrite.write((ArrayList<Student>) students);
    }

    public void readStudent() {
        readWrite.read();
    }
}
