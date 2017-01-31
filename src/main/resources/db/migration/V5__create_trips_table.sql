CREATE TABLE `trips` (
  `id`              INT NOT NULL AUTO_INCREMENT,
  `version`         INT NOT NULL DEFAULT 0,
  `start_time`      DATETIME NOT NULL,
  `end_time`        DATETIME NOT NULL,
  `total_minutes`   INT NOT NULL DEFAULT 0,
  `car_id`          INT NOT NULL,
  `passenger_id`    INT NOT NULL,
  `distance`        DECIMAL(10,2) NOT NULL DEFAULT 0,
  `cost`            DECIMAL(10,2) NOT NULL DEFAULT 0,
  `tip_percent`     DECIMAL(10,2) NOT NULL DEFAULT 0,
  `total_cost`      DECIMAL(10,2) NOT NULL DEFAULT 0,
  `created`         TIMESTAMP NOT NULL  DEFAULT NOW(),
  `modified`        TIMESTAMP NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`),
  CONSTRAINT `car_id`
  FOREIGN KEY (`car_id`)
  REFERENCES `cars` (`id`),

  CONSTRAINT `passenger_id`
  FOREIGN KEY (`passenger_id`)
  REFERENCES `passengers` (`id`));