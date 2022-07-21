CREATE TABLE `customers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birthday_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `products` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `sales` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` datetime(6) DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `full_value` float DEFAULT NULL,
  `gross_value` float DEFAULT NULL,
  `tax` float DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd94vrikapjd2ews1k4lb71sfg` (`customer_id`),
  CONSTRAINT `FKd94vrikapjd2ews1k4lb71sfg` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `items` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `admission_date` datetime(6) DEFAULT NULL,
  `cost` float DEFAULT NULL,
  `item_code` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  `sale_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmtk37pxnx7d5ck7fkq2xcna4i` (`product_id`),
  KEY `FKop10re5q1ult59rlsx73rqn3a` (`sale_id`),
  CONSTRAINT `FKmtk37pxnx7d5ck7fkq2xcna4i` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  CONSTRAINT `FKop10re5q1ult59rlsx73rqn3a` FOREIGN KEY (`sale_id`) REFERENCES `sales` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
