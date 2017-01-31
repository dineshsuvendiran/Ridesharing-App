CREATE TABLE `drivers` (
  `id`         INT NOT NULL AUTO_INCREMENT,
  `version`    INT NOT NULL DEFAULT 0,
  `name`       VARCHAR(45) NOT NULL,
  `age`        INT NOT NULL,
  `gender`     ENUM('MALE','FEMALE') NOT NULL,
  `violations` INT NOT NULL DEFAULT 0,
  `banned`  BOOLEAN NOT NULL DEFAULT FALSE,
  `created`    TIMESTAMP NOT NULL  DEFAULT NOW(),
  `modified`   TIMESTAMP NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`));
