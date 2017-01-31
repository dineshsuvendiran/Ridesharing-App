set FOREIGN_KEY_CHECKS = 0;
TRUNCATE  cities;
TRUNCATE  passengers;
TRUNCATE  drivers;
TRUNCATE  cars;
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