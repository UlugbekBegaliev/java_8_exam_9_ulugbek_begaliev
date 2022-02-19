`use ticketOffice`;

CREATE TABLE `tickets` (
    `id` INT auto_increment NOT NULL,
    `buy` DOUBLE PRECISION NOT NULL,
    `cost` DOUBLE PRECISION NOT NULL,
    `places` INT NOT NULL,
    `destination` VARCHAR(128) NOT NULL DEFAULT,
    `reserved` VARCHAR(128) NOT NULL DEFAULT,
    `beginning` TIMESTAMP NOT NULL,
    `arrival` TIMESTAMP NOT NULL,
    `departure` VARCHAR(128) NOT NULL DEFAULT ' ',
    `client_id` INT(11) NOT NULL,
    `flight_id` INT(11) NOT NULL,
    `company_id` INT(11) NOT NULL,
    FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
    FOREIGN KEY (`flight_id`) REFERENCES `flight` (`id`)
    FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
    PRIMARY KEY (`id`),
);