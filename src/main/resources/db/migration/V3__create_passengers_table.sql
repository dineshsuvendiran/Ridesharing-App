CREATE TABLE `passengers` (
  `id`              INT NOT NULL AUTO_INCREMENT,
  `version`         INT NOT NULL DEFAULT 0,
  `name`            VARCHAR(45) NOT NULL,
  `age`             INT NOT NULL,
  `gender`          ENUM('MALE', 'FEMALE') NOT NULL,
  `credit_balance`  INT NOT NULL DEFAULT 0,
  `created`         TIMESTAMP NOT NULL  DEFAULT NOW(),
  `modified`        TIMESTAMP NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`));
