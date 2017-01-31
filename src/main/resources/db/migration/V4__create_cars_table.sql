CREATE TABLE `cars` (
  `id`          INT NOT NULL AUTO_INCREMENT,
  `version`     INT NOT NULL DEFAULT 0,
  `model`       VARCHAR(45) NOT NULL,
  `make`        VARCHAR(45) NOT NULL,
  `year`        INT NOT NULL,
  `car_class`   ENUM('BASIC', 'LUX') NOT NULL,
  `driver_id`   INT NOT NULL,
  `created`     TIMESTAMP NOT NULL  DEFAULT NOW(),
  `modified`    TIMESTAMP NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`),
  CONSTRAINT `driver_id`
  FOREIGN KEY (`driver_id`)
  REFERENCES `drivers` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION);
