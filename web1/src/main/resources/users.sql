CREATE TABLE `users` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `email` varchar(45) NOT NULL,
                         `username` varchar(45) NOT NULL,
                         `password` varchar(64) NOT NULL,
                         `roles` varchar(64) NOT NULL,
                         `enabled` tinyint(4) DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `email_UNIQUE` (`email`)
);

INSERT INTO `users` (`username`, `email`, `password`, `roles`, `enabled`) VALUES ('son', 'son@gmail.com','123', 'CUSTOMER', '1');