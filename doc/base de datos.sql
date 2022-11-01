	
select uuid() as uid;

#comando de consultas countries 
select * from geografica.countries;
DELETE FROM geografica.countries WHERE name ='';
DELETE FROM geografica.cities WHERE countries = '';
DELETE FROM geografica.countries WHERE countries < 100;
	
SELECT * FROM geografica.countries WHERE population > 10;
SELECT * FROM geografica.countries WHERE population > 10 ORDER BY name;

SELECT * FROM geografica.cities WHERE population > 10;
SELECT * FROM geografica.cities WHERE population > 10 ORDER BY name;

INSERT INTO geografica.countries(id,name,population,countryCode) VALUES(?,?,?,?);


#comando de consultas cities
DELETE FROM geografica.cities WHERE name = '';


SELECT * FROM geografica.cities WHERE name = 'Colombia' ORDER BY population;
select * from geografica.cities;

INSERT INTO geografica.countries(id, name, population, countryCode) VALUES ('b4c627d9-54be-11ed-a184-089798c1c177', 'Mexico', 150.1, '+43');
INSERT INTO geografica.cities(id, name, countryID, population) VALUES ('e4aa04f6-3dd0-11ed-b878-0242ac120002', 'Cali', '6ec3e8ec-3dd0-11ed-b878-0242ac120004', 2.2);
INSERT INTO geografica.cities(id, name, countryID, population) VALUES ('cd43f3e0-54c1-11ed-a184-089798c1c177', 'Medellin', '6ec3e8ec-3dd0-11ed-b878-0242ac120002', 5.2);
INSERT INTO geografica.cities(id, name, countryID, population) VALUES ('d3c790fe-54c1-11ed-a184-089798c1c177', 'Bogota', '6ec3e8ec-3dd0-11ed-b878-0242ac120002', 6.2);
INSERT INTO geografica.cities(id, name, countryID, population) VALUES ('d9f943db-54c1-11ed-a184-089798c1c177', 'Barranquilla', '6ec3e8ec-3dd0-11ed-b878-0242ac120002', 4.2);
INSERT INTO geografica.cities(id, name, countryID, population) VALUES ('df6671c9-54c1-11ed-a184-089798c1c177', 'Manizales', '6ec3e8ec-3dd0-11ed-b878-0242ac120002', 8.2);

