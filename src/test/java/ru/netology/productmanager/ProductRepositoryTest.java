package ru.netology.productmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;


public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product product1 = new Book(1,"Алиса в стране чудес",1200,"Льюис Кэрролл");
    Product product2 = new Book(2, "Приключения Тома Сойера",800, "Марк Твен");
    Product product3 = new Book(3, "Война и мир",1500, "Лев Толстой");
    Product product4 = new Smartphone(4, "Samsung", 30_000, "Samsŏng Gurup");
    Product product5 = new Smartphone(5, "Xiaomi", 20_000, "XIAOMI Russia");
    Product product6 = new Smartphone(6, "Huawei", 25_000, "Huawei Technologies Co. Ltd.");
    Product product7 = new Book(7, "Приключения Тома Сойера",900, "Марк Твен");


    @BeforeEach
    public void shouldAddProduct() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
        manager.add(product7);
    }


    @Test
    public void shouldFindProductByName() {
        Product[] expected = {product1};
        Product[] actual = manager.searchBy("Алиса в стране чудес");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSomeProduct() {
        Product[] expected = {product2, product7};
        Product[] actual = manager.searchBy("Приключения Тома Сойера");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindOneProduct() {
        Product[] expected = {product5};
        Product[] actual = manager.searchBy("Xiaomi");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotFindProduct() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Лупа");

        Assertions.assertArrayEquals(expected, actual);
    }

}