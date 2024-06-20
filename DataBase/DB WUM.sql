
CREATE TABLE `user` (
    `user_seq` INT AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL,
    `birth` DATE NOT NULL,
    `id` VARCHAR(20) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    `nickname` VARCHAR(20) NOT NULL,
    `tel` VARCHAR(30) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `role` VARCHAR(30) NOT NULL,
    `reg_date` DATE NOT NULL DEFAULT CURDATE(),
   
    PRIMARY KEY (`user_seq`)
);


CREATE TABLE `require` (
    `require_seq` INT AUTO_INCREMENT,
    `user_seq` INT NOT NULL,
    `title` VARCHAR(10) NOT NULL,
    `content` VARCHAR(500) NOT NULL,
    `post_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `require_like` INT NOT NULL DEFAULT 0,
    PRIMARY KEY (`require_seq`),
    FOREIGN KEY (`user_seq`) REFERENCES `user` (`user_seq`)
);

CREATE TABLE `score` (
    `score_seq` INT AUTO_INCREMENT,
    `user_seq` INT NOT NULL,
    `movie_seq` INT NOT NULL,
    `score` INT NOT NULL,
    `review_content` VARCHAR(300) NULL,
    `review_like` INT NOT NULL DEFAULT 0,
    `post_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`score_seq`),
    FOREIGN KEY (`user_seq`) REFERENCES `user` (`user_seq`),
    FOREIGN KEY (`movie_seq`) REFERENCES `movie` (`movie_seq`)
);

CREATE TABLE `wish` (
    `wish_seq` INT AUTO_INCREMENT,
    `user_seq` INT NOT NULL,
    `movie_seq` INT NOT NULL,
    PRIMARY KEY (`wish_seq`),
    FOREIGN KEY (`user_seq`) REFERENCES `user` (`user_seq`),
    FOREIGN KEY (`movie_seq`) REFERENCES `movie` (`movie_seq`)
);

