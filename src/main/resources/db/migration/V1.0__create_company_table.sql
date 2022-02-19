`use ticketOffice`;

CREATE TABLE `companies` (
    `id` INT auto_increment NOT NULL,
    `email` VARCHAR(128) NOT NULL,
    `password` VARCHAR(128) NOT NULL,
    `companyName` VARCHAR(128) NOT NULL DEFAULT ' ',
    `enabled` boolean NOT NULL DEFAULT TRUE,
    `role` VARCHAR(16) NOT NULL DEFAULT 'USER',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `email_unique` (`email` ASC)
);