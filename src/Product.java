import java.text.DecimalFormat;
import java.util.Scanner;

class Product {
    private String name;
    private double[] sideLengths;
    private final double waste; // отходы в мм

    // Конструктор
    public Product(String name, int numberOfSides) {
        this.name = name;
        this.sideLengths = new double[numberOfSides];
        this.waste = 40; // фиксированные отходы
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getSideLengths() {
        return sideLengths;
    }

    public void setSideLengths(double[] sideLengths) {
        this.sideLengths = sideLengths;
    }

    public double getWaste() {
        return waste;
    }

    // Метод для ввода длин сторон
    public void inputSideLengths() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < getSideLengths().length; i++) {
            System.out.print("Введите длину стороны " + (i + 1) + " (в мм): ");
            getSideLengths()[i] = scanner.nextDouble();
        }
    }

    // Метод для расчета общей длины с переводом в метры
    public double calculateTotalLength() {
        double total = 0;
        double[] lengths = getSideLengths();
        for (int i = 0, lengthsLength = lengths.length; i < lengthsLength; i++) {
            double length = lengths[i];
            total += length + getWaste(); // добавляем длину стороны и отходы
        }
        return total / 1000;
    }

    // Метод для отображения информации о продукте
    public void displayInfo() {

        System.out.println("Длины сторон:");
        double[] lengths = getSideLengths();
        for (int i = 0; i < lengths.length; i++) {
            double length = lengths[i];
            System.out.println(length + " мм");
        }
        System.out.println("Общая длина (с учетом отходов): " + calculateTotalLength() + " м.");
    }

    // Метод расчёта общего расхода на все изделия
    public void totalEdgeLength() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Количество изделий: ");
        int numberProducts = scanner.nextInt();
        double totalEdge = numberProducts * calculateTotalLength();

        // Форматирование числа до 2 знаков после запятой
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Общий метраж: " + df.format(totalEdge) + " п.м.");
    }
}
