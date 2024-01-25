-- Создание таблицы "Продукты"
CREATE TABLE Products (
    article INT(7) PRIMARY KEY,
    product_name VARCHAR(50) NOT NULL,
    color VARCHAR(20),
    price INT NOT NULL CHECK (price > 0),
    stock INT NOT NULL CHECK (stock >= 0)
);

-- Создание таблицы "Заказы"
CREATE TABLE Orders (
    order_id INT PRIMARY KEY,
    creation_date DATE,
    customer_name VARCHAR(100) NOT NULL,
    contact_phone VARCHAR(50),
    email_address VARCHAR(50),
    delivery_address VARCHAR(200) NOT NULL,
    order_status CHAR(1) CHECK (order_status IN ('P', 'S', 'C')),
    shipment_date DATE
);

-- Создание таблицы "Позиции заказа"
CREATE TABLE OrderPositions (
    order_id INT,
    article INT(7),
    price INT CHECK (price > 0),
    quantity INT CHECK (quantity > 0),
    PRIMARY KEY (order_id, article),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (article) REFERENCES Products(article)
);

-- Заполнение таблицы "Продукты"
INSERT INTO Products (article, product_name, color, price, stock) VALUES
(3251615, 'Стол кухонный', 'белый', 8000, 12),
(3251616, 'Стол кухонный', NULL, 8000, 15),
(3251617, 'Стул "гусарский"', 'орех', 4000, 0),
(3251619, 'Стул с высокой спинкой', 'белый', 3500, 37),
(3251620, 'Стул с высокой спинкой', 'коричневый', 3500, 52);

-- Заполнение таблицы "Заказы"
INSERT INTO Orders (order_id, creation_date, customer_name, contact_phone, email_address, delivery_address, order_status, shipment_date) VALUES
(1, '2020-11-20', 'Сергей Иванов', '(981)123-45-67', NULL, 'ул. Веденеева, 20-1-41', 'S', '2020-11-29'),
(2, '2020-11-22', 'Алексей Комаров', '(921)001-22-33', NULL, 'пр. Пархоменко 51-2-123', 'S', '2020-11-29'),
(3, '2020-11-28', 'Ирина Викторова', '(911)009-88-77', NULL, 'Тихорецкий пр. 21-21', 'P', NULL),
(4, '2020-12-03', 'Павел Николаев', NULL, 'pasha_nick@mail.ru', 'ул. Хлопина 3-88', 'P', NULL),
(5, '2020-12-03', 'Антонина Васильева', '(931)777-66-55', 'antvas66@gmail.com', 'пр. Науки, 11-3-9', 'P', NULL),
(6, '2020-12-10', 'Ирина Викторова', '(911)009-88-77', NULL, 'Тихорецкий пр. 21-21', 'P', NULL);

-- Заполнение таблицы "Позиции заказа"
INSERT INTO OrderPositions (order_id, article, price, quantity) VALUES
(1, 3251616, 7500, 1),
(2, 3251615, 7500, 1),
(3, 3251615, 8000, 1),
(3, 3251617, 4000, 4),
(4, 3251619, 3500, 2),
(5, 3251615, 8000, 1),
(5, 3251617, 4000, 4),
(6, 3251617, 4000, 2);

-- Список заказов, созданных в ноябре и декабре
SELECT * FROM Orders
WHERE MONTH(creation_date) IN (11, 12);

-- Список заказов, отгруженных в ноябре и декабре
SELECT * FROM Orders
WHERE order_status = 'S' AND MONTH(shipment_date) IN (11, 12);

-- Список клиентов с ФИО, телефоном и адресом электронной почты
SELECT customer_name, contact_phone, email_address FROM Orders;

-- Список позиций заказа с id=3
SELECT * FROM OrderPositions
WHERE order_id = 3;

-- Названия товаров в заказе с id=3
SELECT P.product_name
FROM OrderPositions OP
JOIN Products P ON OP.article = P.article
WHERE OP.order_id = 3;

-- Список отгруженных заказов и количество позиций в каждом
SELECT O.order_id, COUNT(OP.article) AS num_positions
FROM Orders O
JOIN OrderPositions OP ON O.order_id = OP.order_id
WHERE O.order_status = 'S'
GROUP BY O.order_id;

-- Список отгруженных заказов, количество позиций и общая стоимость заказа
SELECT O.order_id, COUNT(OP.article) AS num_positions, SUM(OP.price * OP.quantity) AS total_cost
FROM Orders O
JOIN OrderPositions OP ON O.order_id = OP.order_id
WHERE O.order_status = 'S'
GROUP BY O.order_id;

-- Запрос на фиксацию отгрузки заказа с id=5
UPDATE Orders
SET order_status = 'S', shipment_date = '2020-12-15'
WHERE order_id = 5;

-- Уменьшение остатка товара на складе
UPDATE Products
SET stock = stock - (SELECT quantity FROM OrderPositions WHERE order_id = 5 AND article = 3251615)
WHERE article = 3251615;