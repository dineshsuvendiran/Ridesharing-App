ALTER TABLE trips ADD driver_id INT NOT NULL;
ALTER TABLE trips ADD CONSTRAINT fk_driver_id FOREIGN KEY (driver_id) REFERENCES drivers(id);