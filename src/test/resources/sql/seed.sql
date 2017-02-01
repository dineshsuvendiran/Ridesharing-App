set FOREIGN_KEY_CHECKS = 0;
TRUNCATE  cities;
TRUNCATE  passengers;
TRUNCATE  drivers;
TRUNCATE  cars;
TRUNCATE trips;
set FOREIGN_KEY_CHECKS = 1;

INSERT INTO `cities`
(
`name`,
`state`,
`rateper_km_day`,
`rateper_km_night`
)
VALUES
("Bengaluru","Karnataka",20,25),
("Chennai","Tamilnadu",18,24);


INSERT INTO `passengers`
(
 `name`,
 `age`,
 `gender`,
 `credit_balance`
 )
VALUES
  ('Dinesh',27,'MALE',10000),
  ('Nirmal',22,'MALE',10000);


INSERT INTO `drivers`
(
 `name`,
 `age`,
 `gender`,
 `violations`
 )
VALUES
("Nirmal",25,'MALE',0),
("Dinesh",25,'MALE',0);

INSERT INTO `cars`
(
 `model`,
 `make`,
 `year`,
 `car_class`,
 `driver_id`)
VALUES
('C5','Mrcedes',2014,'LUX',1),
('X5','BMW',2014,'LUX',2);



INSERT INTO `trips`
(
 `start_time`,
 `end_time`,
 `total_minutes`,
 `car_id`,
 `passenger_id`,
 `distance`,
 `cost`,
 `tip_percent`,
 `total_cost`,
 `city_id`,
  `driver_id`)
    VALUES
      ("2017-02-01 13:25:00","2017-02-01 14:25:00",120,1,1,25,250,10,275,1,1),
      ("2017-03-03 13:23:00","2017-03-04 12:25:00",120,2,1,25,300,10,330,1,2),
      ("2017-02-01 13:25:00","2017-02-01 14:25:00",120,1,1,25,250,10,275,2,1);
