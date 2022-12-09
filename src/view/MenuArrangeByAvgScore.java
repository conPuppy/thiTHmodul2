package view;

import manager.StudentManager;

import java.util.Scanner;

public class MenuArrangeByAvgScore {
    Scanner scanner = new Scanner(System.in);
    StudentManager studentManager = new StudentManager();
    public void showMenu() {
        int choice;
        while (true) {
            try {
                System.out.println("""
                        ---- Sắp xếp sinh viên theo điểm trung bình ----
                        1. Sắp xếp điểm trung bình tăng dần
                        2. Sắp xếp điểm trung bình giảm dần
                        3. Thoát
                        Chọn chức năng:\s""");
                choice = Integer.parseInt(scanner.nextLine());
                if(choice>0) {
                    switch (choice) {
                        case 1:
                            studentManager.arrangeAscengdingScore();
                            break;
                        case 2:
                            studentManager.arrangeDescendingScore();
                            break;
                        case 3:
                            return;
                    }
                }
            }catch (NumberFormatException e) {
                System.err.println("Phải nhập số!");
            }
        }
    }
}
