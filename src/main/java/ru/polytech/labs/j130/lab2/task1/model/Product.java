package ru.polytech.labs.j130.lab2.task1.model;

public class Product {

    private int article;

    private String productName;

    private String color;

    private int price;

    private int stock;

    public Product() {
    }

    /**
     * Конструктор для создания объекта Product
     *
     * @param article     артикул продукта
     * @param productName название продукта
     * @param color       цвет продукта
     * @param price       цена продукта
     * @param stock       количество продукта
     */
    public Product(int article, String productName, String color, int price, int stock) {
        this.article = article;
        this.productName = productName;
        this.color = color;
        this.price = price;
        this.stock = stock;
    }

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Переопределение метода toString для удобного вывода информации о продукте
     *
     * @return строковое представление продукта
     */
    @Override
    public String toString() {
        return article + ": " + productName
                + (color != null ? " (" + color + ")" : "")
                + "; price=" + price + "; stock=" + stock;
    }
}
