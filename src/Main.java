import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название изделия: ");
        String productName = scanner.nextLine();

        System.out.print("Введите количество сторон для кромления: ");
        int numberOfSides = scanner.nextInt();

        if (numberOfSides <= 0) {
            System.out.println("Количество сторон должно быть больше нуля.");
            return;
        }

        // Создаем экземпляр продукта
        Product product = new Product(productName, numberOfSides);

        // Ввод размеров
        product.inputSideLengths();

        // Отображаем информацию
        product.displayInfo();

        // Добавляем колличество изделий и общий метраж
        product.totalEdgeLength();
    }

}