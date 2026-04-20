import java.util.*;

public class StudentManager {
    private ArrayList<String> students = new ArrayList<>();

    public void addStudent(String name) {
        students.add(name);
        System.out.println("✅ სტუდენტი დამატებულია: " + name);
    }

    public void removeStudent(String name) {
        if (students.remove(name)) {
            System.out.println("🗑️ სტუდენტი წაშლილია: " + name);
        } else {
            System.out.println("❌ სტუდენტი ვერ მოიძებნა!");
        }
    }

    public void searchStudent(String name) {
        if (students.contains(name)) {
            System.out.println("🔍 სტუდენტი ნაპოვნია: " + name);
        } else {
            System.out.println("❌ სტუდენტი ვერ მოიძებნა!");
        }
    }

    public void printSorted() {
        ArrayList<String> sorted = new ArrayList<>(students);
        Collections.sort(sorted);
        System.out.println("📋 სტუდენტების სია (ალფაბეტურად):");
        for (String s : sorted) {
            System.out.println("   - " + s);
        }
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== სტუდენტების მენიუ ===");
            System.out.println("1. დამატება");
            System.out.println("2. წაშლა");
            System.out.println("3. ძებნა");
            System.out.println("4. დაბეჭდვა (დალაგებული)");
            System.out.println("0. გამოსვლა");
            System.out.print("აირჩიეთ: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("სახელი: ");
                    addStudent(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("წასაშლელი სახელი: ");
                    removeStudent(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("საძებნი სახელი: ");
                    searchStudent(scanner.nextLine());
                    break;
                case 4:
                    printSorted();
                    break;
                case 0:
                    System.out.println("👋 პროგრამა დასრულდა!");
                    return;
                default:
                    System.out.println("არასწორი არჩევანი!");
            }
        }
    }

    public static void main(String[] args) {
        new StudentManager().showMenu();
    }
}