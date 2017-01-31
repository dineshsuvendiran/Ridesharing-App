CREATE TABLE `cities` (
  `id`              INT NOT NULL AUTO_INCREMENT,
  `version`         INT NOT NULL DEFAULT 0,
  `name`            VARCHAR(45) NOT NULL,
  `state`           VARCHAR(45) NOT NULL,
  `rateper_km_day`  DECIMAL(10,2) NOT NULL,
  `rateper_km_night`DECIMAL(10,2) NOT NULL,
  `created`         TIMESTAMP NOT NULL DEFAULT NOW(),
  `modified`        TIMESTAMP NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`));
