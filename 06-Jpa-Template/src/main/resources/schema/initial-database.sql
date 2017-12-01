CREATE TABLE `month_payment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增序列ID',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名称',
  `salary` decimal(18,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '支出工资',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `month_payment`(`id`, `name`, `salary`) VALUES (1, 'RandomName1512028732904', 12.34);
INSERT INTO `month_payment`(`id`, `name`, `salary`) VALUES (2, 'RandomName1512028735366', 12.34);
INSERT INTO `month_payment`(`id`, `name`, `salary`) VALUES (3, 'RandomName1512028738439', 12.34);