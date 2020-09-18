CREATE TABLE `users` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `username` varchar(250) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`username`)
) 

CREATE TABLE `todolist` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ts` timestamp, 
  `description` varchar(255) DEFAULT NULL,
  `is_done` bit(1) NOT NULL,
  `target_date` datetime(6) DEFAULT NULL,
  `user_id` varchar(250) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 
