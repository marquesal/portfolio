CREATE TABLE cars (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
car_brand VARCHAR(40) NOT NULL,
car_model VARCHAR(40) NOT NULL,
horsepower INT NOT NULL,
car_engine VARCHAR(50) NOT NULL,
)
 
insert into cars (car_brand, car_model, horsepower, car_engine)
values
('Plymouth', 'GTX 440 Six Pack', 375, 'V8'),
('Ford', 'Mustang 428 Super Cobra Jet', 375, 'V8'),
('Plymouth', 'Superbird 426 Hemi', 	425, 'V6'),
('Dodge', 'Challenger R/T 426 Hemi', 450, 'V12')
