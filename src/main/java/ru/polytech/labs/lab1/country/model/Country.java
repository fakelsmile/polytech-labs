package ru.polytech.labs.lab1.country.model;

public class Country {

    private String name;

    private double area;

    private Double population;

    private String capitalName;

    private Double capitalPopulation;

    /**
     * Конструктор класса Country с полной информацией о стране
     *
     * @param name              название страны
     * @param area              площадь страны
     * @param population        население страны
     * @param capitalName       название столицы
     * @param capitalPopulation население столицы
     */
    public Country(String name, double area, Double population, String capitalName, Double capitalPopulation) {
        setName(name);
        setArea(area);
        setPopulation(population);
        setCapitalName(capitalName);
        setCapitalPopulation(capitalPopulation);
    }

    /**
     * Конструктор класса Country без информации о столице
     *
     * @param name       название страны
     * @param area       площадь страны
     * @param population население страны
     */
    public Country(String name, double area, Double population) {
        this(name, area, population, null, null);
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public double getPopulation() {
        return population;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public Double getCapitalPopulation() {
        return capitalPopulation;
    }

    public void setArea(double area) {
        if (area <= 0) {
            throw new IllegalArgumentException("Площадь должна быть больше нуля!");
        }
        this.area = area;
    }

    public void setPopulation(Double population) {
        if (population <= 0) {
            throw new IllegalArgumentException("Население должно быть больше нуля!");
        }
        this.population = population;
    }

    public void setName(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException("Название не должно быть пустым!");
        }
        this.name = name;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public void setCapitalPopulation(Double capitalPopulation) {
        this.capitalPopulation = capitalPopulation;
    }

    /**
     * Метод очиститки информации о столице
     */
    public void clearCapital() {
        capitalName = null;
        capitalPopulation = null;
    }

    /**
     * Метод рассчета плотности населения страны
     *
     * @return плотность населения
     */
    public double getPopulationDensity() {
        return population / area;
    }

    /**
     * Метод формирования вывода информации о стране
     */
    public void print() {
        StringBuilder sb = new StringBuilder();

        sb.append("Страна: ").append(name).append("\n");
        sb.append("Площадь: ").append(String.format("%,.2f", area)).append(" квадратных километров\n");
        sb.append("Население: ")
                .append(population != null ? String.format("%,.0f", population) + " человек" : "Население неизвестно")
                .append("\n");

        if (capitalName != null) {
            sb.append("Столица: ").append(capitalName).append("\n");
            sb.append("Население столицы: ")
                    .append(capitalPopulation != null ? String.format("%,.0f", capitalPopulation)
                            + " человек" : "Население неизвестно")
                    .append("\n");
        }

        sb.append("Плотность населения: ")
                .append(String.format("%.2f", getPopulationDensity()))
                .append(" человек на квадратный километр\n");

        System.out.println(sb);
    }

    /**
     * Метод вывода информации из массива стран
     *
     * @param countries массив стран
     */
    public static void printAll(Country[] countries) {
        for (Country country : countries) {
            country.print();
        }
    }
}