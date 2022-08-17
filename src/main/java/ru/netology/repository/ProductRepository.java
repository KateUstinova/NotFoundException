package ru.netology.repository;

import ru.netology.productmanager.Product;
import ru.netology.productmanager.NotFoundException;
import ru.netology.productmanager.AlreadyExistsException;
public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        int id = 0;
        if (findById(item.getId()) != null)
            throw new AlreadyExistsException(
                    "Product with ID " + id + " already exist"
            );
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public void removeById(int id) {
        Product product = findById(id);
        if (product == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }
    public Product findById(int id) {
        for (Product product : items) {
            if (product.getId() == id) {

                return product;
            }
        }
        return null;
    }

    public Product[] getItems() {
        return items;
    }
    public Product[] findAll() {
        return items;
    }
}