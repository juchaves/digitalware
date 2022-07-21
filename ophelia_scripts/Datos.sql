INSERT INTO `opheliadb`.`products`
(`category`,
`name`,
`supplier`)
VALUES
("HERRAMIENTA",
"TALADRO 1",
"DEWALT");
INSERT INTO `opheliadb`.`products`
(`category`,
`name`,
`supplier`)
VALUES
("HERRAMIENTA",
"MARTILLO 2",
"STANDLEY");
INSERT INTO `opheliadb`.`products`
(`category`,
`name`,
`supplier`)
VALUES
("COCINA",
"CUCHILLO 1",
"TRAMONTINA");
INSERT INTO `opheliadb`.`products`
(`category`,
`name`,
`supplier`)
VALUES
("COCINA",
"VAJILLA 2",
"CORONA");

INSERT INTO `opheliadb`.`customers`
(`address`,
`birthday_date`,
`name`,
`phone`)
VALUES
('CL 1 #2-3',
'1975-12-06',
'Pedro Perez',
'3157772233');
INSERT INTO `opheliadb`.`customers`
(`address`,
`birthday_date`,
`name`,
`phone`)
VALUES
('CL 1 #2-3',
'1995-12-06',
'Martin Martinez',
'3157772244');
INSERT INTO `opheliadb`.`customers`
(`address`,
`birthday_date`,
`name`,
`phone`)
VALUES
('CL 1 #2-3',
'1985-12-06',
'Rodrigo Rodriguez',
'3157772255');


INSERT INTO `opheliadb`.`sales`
(`discount`,
`date`,
`tax`,
`gross_value`,
`full_value`,
`customer_id`)
VALUES
(10,
'2000-02-01',
10,
100,
100,
1);





INSERT INTO `opheliadb`.`items`
(`item_code`,
`cost`,
`admission_date`,
`price`,
`product_id`,
`sale_id`)
VALUES
(1,
10,
'2000-01-01',
20,
1,
null);

INSERT INTO `opheliadb`.`items`
(`item_code`,
`cost`,
`admission_date`,
`price`,
`product_id`,
`sale_id`)
VALUES
(1,
10,
'2000-01-01',
20,
1,
null);

INSERT INTO `opheliadb`.`items`
(`item_code`,
`cost`,
`admission_date`,
`price`,
`product_id`,
`sale_id`)
VALUES
(1,
10,
'2000-01-01',
20,
1,
null);


INSERT INTO `opheliadb`.`items`
(`item_code`,
`cost`,
`admission_date`,
`price`,
`product_id`,
`sale_id`)
VALUES
(2321,
10,
'2000-01-01',
20,
2,
null);

INSERT INTO `opheliadb`.`items`
(`item_code`,
`cost`,
`admission_date`,
`price`,
`product_id`,
`sale_id`)
VALUES
(2321,
10,
'2000-01-01',
20,
2,
null);

INSERT INTO `opheliadb`.`items`
(`item_code`,
`cost`,
`admission_date`,
`price`,
`product_id`,
`sale_id`)
VALUES
(2321,
10,
'2000-01-01',
20,
2,
null);


INSERT INTO `opheliadb`.`items`
(`item_code`,
`cost`,
`admission_date`,
`price`,
`product_id`,
`sale_id`)
VALUES
(2321,
10,
'2000-02-01',
20,
2,
1);

INSERT INTO `opheliadb`.`items`
(`item_code`,
`cost`,
`admission_date`,
`price`,
`product_id`,
`sale_id`)
VALUES
(2321,
10,
'2000-02-01',
20,
2,
1);

INSERT INTO `opheliadb`.`items`
(`item_code`,
`cost`,
`admission_date`,
`price`,
`product_id`,
`sale_id`)
VALUES
(2321,
10,
'2000-02-01',
20,
2,
1);


