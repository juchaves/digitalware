
SELECT products.id, products.name,
(SELECT MAX(items.price) FROM opheliadb.items WHERE opheliadb.items.product_id= opheliadb.products.id )
AS price
 FROM opheliadb.products;

SELECT products.id, products.name
FROM opheliadb.products
WHERE (SELECT COUNT(1) FROM opheliadb.items WHERE opheliadb.items.product_id = opheliadb.products.id ) <=5;

SELECT customers.id, customers.name FROM opheliadb.customers;