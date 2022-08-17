package ru.netology.productmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;



public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();
    Product product1 = new Book(1,"Алиса в стране чудес",1200,"Льюис Кэрролл");
    Product product2 = new Book(2, "Приключения Тома Сойера",800, "Марк Твен");
    Product product3 = new Book(3, "Война и мир",1500, "Лев Толстой");
    Product product4 = new Smartphone(4, "Samsung", 30_000, "Samsŏng Gurup");
    Product product5 = new Smartphone(5, "Xiaomi", 20_000, "XIAOMI Russia");
    Product product6 = new Smartphone(6, "Huawei", 25_000, "Huawei Technologies Co. Ltd.");

    @Test
    public void shouldSaveProducts() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemovedById() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.removeById(3);

        Product[] expected = {product1, product2};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ShouldFindAll(){
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);


        Product[] expected = {product1, product2, product3, product4, product5, product6};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAlreadyExistsException() {

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(product3);
        });
    }
        @Test
        public void NotFoundException() {

            repo.save(product1);
            repo.save(product2);
            repo.save(product3);

            Assertions.assertThrows(NotFoundException.class, () -> {
                repo.removeById(4);
            });
        }

}
