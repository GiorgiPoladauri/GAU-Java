import java.util.*;

public class ProductManager {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(String name, double price) {
        products.add(new Product(name, price));
        System.out.println("✅ პროდუქტი დამატებულია: " + name);
    }

    public void removeProduct(String name) {
        boolean removed = products.removeIf(p -> p.getName().equalsIgnoreCase(name));
        if (removed) {
            System.out.println("🗑️ პროდუქტი წაშლილია: " + name);
        } else {
            System.out.println("❌ პროდუქტი ვერ მოიძებნა!");
        }
    }

    public void searchProduct(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                System.out.println("🔍 ნაპოვნია: " + p);
                return;
            }
        }
        System.out.println("❌ პროდუქტი ვერ მოიძებნა!");
    }

    public void printSortedByName() {
        ArrayList<Product> sorted = new ArrayList<>(products);
        Collections.sort(sorted);
        printList("სახელის მიხედვით", sorted);
    }

    public void printSortedByPrice() {
        ArrayList<Product> sorted = new ArrayList<>(products);
        sorted.sort(Comparator.comparingDouble(Product::getPrice));
        printList("ფასის მიხედვით", sorted);
    }

    private void printList(String title, List<Product> list) {
        System.out.println("\n📋 პროდუქტები (" + title + "):");
        for (Product p : list) {
            System.out.println("   • " + p);
        }
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== პროდუქტების მენიუ ===");
            System.out.println("1. დამატება");
            System.out.println("2. წაშლა (სახელით)");
            System.out.println("3. ძებნა (სახელით)");
            System.out.println("4. დაბეჭდვა სახელის მიხედვით");
            System.out.println("5. დაბეჭდვა ფასის მიხედვით");
            System.out.println("0. გამოსვლა");
            System.out.print("აირჩიეთ: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("პროდუქტის სახელი: ");
                    String name = scanner.nextLine();
                    System.out.print("ფასი: ");
                    double price = scanner.nextDouble();
                    addProduct(name, price);
                    break;
                case 2:
                    System.out.print("წასაშლელი პროდუქტის სახელი: ");
                    removeProduct(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("საძებნი პროდუქტის სახელი: ");
                    searchProduct(scanner.nextLine());
                    break;
                case 4:
                    printSortedByName();
                    break;
                case 5:
                    printSortedByPrice();
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
        new ProductManager().showMenu();
    }
}