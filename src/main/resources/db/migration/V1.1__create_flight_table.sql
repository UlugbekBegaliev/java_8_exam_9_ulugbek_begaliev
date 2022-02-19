`use ticketOffice`;

CREATE TABLE `flights` (
    `id` INT auto_increment NOT NULL,
    `active` DOUBLE PRECISION NOT NULL,
    `cost` DOUBLE PRECISION NOT NULL,
    `places` INT NOT NULL,
    `destination` VARCHAR(128) NOT NULL DEFAULT,
    `beginning` VARCHAR(128) NOT NULL DEFAULT,
    `arrival` TIMESTAMP NOT NULL,
    `departure` TIMESTAMP NOT NULL,
    `transport` VARCHAR(128) NOT NULL DEFAULT ' ',
    `company_id` INT(11) NOT NULL,
     PRIMARY KEY (`id`),
     FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
);