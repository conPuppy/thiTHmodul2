package view;

import io.ReadWrite;
import manager.StudentManager;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    StudentManager studentManager = new StudentManager();
    MenuArrangeByAvgScore menuArrangeByAvgScore = new MenuArrangeByAvgScore();
    public void showMenu() {
        int choice;
        while (true) {
            try {
                System.out.println("""
                        ---- Chương trình quản lý sinh viên ----
                        1. Xem danh sách sinh viên
                        2. Thêm mới
                        3. Cập nhật
                        4. Xoá
                        5. Sắp xếp
                        6. Đọc từ file
                        7. Ghi từ file
                        8. Thoát
                        Chọn chức năng:\s""");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > 0) {
                    switch (choice) {
                        case 1:
                            studentManager.show();
                            break;
                        case 2:
                            studentManager.addNewStudent();
                            break;
                        case 3:
                            studentManager.updateStudentById();
                            break;
                        case 4:
                            studentManager.deleteStudentById();
                            break;
                        case 5:
                            menuArrangeByAvgScore.showMenu();
                            break;
                        case 6:
                            studentManager.readStudent();
                            break;
                        case 7:
                            studentManager.writeStudent();
                            break;
                        case 8:
                            break;

                    }
                } else System.out.println("Phải nhập từ 1 đến 8");
            } catch (Exception e) {
                System.err.println("Nhập số đi!");
            }
        }
    }
}
