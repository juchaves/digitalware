-- consulta 1
SELECT products.id, products.name,
(SELECT MAX(items.price) FROM opheliadb.items WHERE opheliadb.items.product_id= opheliadb.products.id )
AS price
 FROM opheliadb.products;

-- consulta 2
SELECT products.id, products.name
FROM opheliadb.products
WHERE (SELECT COUNT(1) FROM opheliadb.items WHERE opheliadb.items.product_id = opheliadb.products.id ) <=5;

-- consulta 3
SELECT customers.id, customers.name FROM opheliadb.customers
WHERE TIMESTAMPDIFF(YEAR, customers.birthday_date , CURDATE()) > 35
AND EXISTS( SELECT 1 FROM opheliadb.sales WHERE sales.customer_id = customers.id AND
		sales.date BETWEEN '2000-02-01' AND '2000-05-25' );

-- consulta 4
SELECT products.id, products.name, COUNT(1), SUM(items.price)
FROM opheliadb.items
INNER JOIN opheliadb.products ON products.id = items.product_id
INNER JOIN opheliadb.sales ON sales.id = items.sale_id
WHERE sales.date BETWEEN '2020-01-01' AND '2021-01-01'
GROUP BY products.id;

--consulta 5
SELECT sales.id, sales.date, sales.full_value
FROM opheliadb.sales
WHERE sales.customer_id = (SELECT MAX(sales.customer_id) FROM opheliadb.sales
		WHERE sales.date=(SELECT MAX(sales.date) FROM opheliadb.sales) );
