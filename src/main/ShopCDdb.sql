DROP DATABASE IF EXISTS shopCD;
CREATE DATABASE shopCD;
USE shopCD;

CREATE TABLE stock(
cd_id int PRIMARY KEY auto_increment,
cd_name varchar(255),
cd_author varchar(255),
cd_country varchar(255),
price double
);

CREATE TABLE carrito(
car_id int PRIMARY KEY auto_increment,
car_numcd int,
car_price double
);

DESCRIBE stock;
DESCRIBE carrito;

INSERT INTO stock (cd_name,cd_author,cd_country,price) VALUES('Yuan','The Guo Brothers','China',4.95);
INSERT INTO stock (cd_name,cd_author,cd_country,price) VALUES('Drums of Passion','Babatunde Olatunji','Nigeria',6.95);
INSERT INTO stock (cd_name,cd_author,cd_country,price) VALUES('Kaira','Tounami Diabate','Mali', 6.95);
INSERT INTO stock (cd_name,cd_author,cd_country,price) VALUES('The Lion is Loose','Eliades Ochoa','Cuba',3.95);
INSERT INTO stock (cd_name,cd_author,cd_country,price) VALUES('Dance the Devil Away','Outback','Australia',4.95);
INSERT INTO stock (cd_name,cd_author,cd_country,price) VALUES('Record of Changes','Samulnori','Korea', 2.95);
INSERT INTO stock (cd_name,cd_author,cd_country,price) VALUES('Djelika','Tounami Diabate','Mali', 4.95);
INSERT INTO stock (cd_name,cd_author,cd_country,price) VALUES('Rapture','Nusrat Fateh Ali Khan','Pakistan', 2.95);
INSERT INTO stock (cd_name,cd_author,cd_country,price) VALUES('Cesaria Evora','Cesaria Evora','Cape Verde', 6.95);
INSERT INTO stock (cd_name,cd_author,cd_country,price) VALUES('Ibuki','Kodo','Japan', 3.95);
 
SELECT *FROM stock;