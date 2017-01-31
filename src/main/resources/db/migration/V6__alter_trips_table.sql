ALTER TABLE trips ADD city_id INT NOT NULL;
ALTER TABLE trips ADD CONSTRAINT fk_city_id FOREIGN KEY (city_id) REFERENCES cities(id);