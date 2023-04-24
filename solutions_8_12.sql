CREATE DATABASE IF NOT EXISTS mansFriends;

USE mansFriends;

-- 8. Создать таблицы с иерархией из диаграммы в БД
DROP TABLE IF EXISTS pets;
CREATE TABLE IF NOT EXISTS pets (
     id INT NOT NULL AUTO_INCREMENT,
     mansFriends VARCHAR(45),
     animal VARCHAR(45),
     PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS pack_animals;
CREATE TABLE IF NOT EXISTS pack_animals (
     id INT NOT NULL AUTO_INCREMENT,
     mansFriends VARCHAR(45),
     animal VARCHAR(45),
     PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS cats;
CREATE TABLE IF NOT EXISTS cats (
     id INT NOT NULL AUTO_INCREMENT,
     animal VARCHAR(45),
     `name` VARCHAR(45),
     command VARCHAR(45),
     birthday DATE,
     PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS dogs;
CREATE TABLE IF NOT EXISTS dogs (
     id INT NOT NULL AUTO_INCREMENT,
     animal VARCHAR(45),
     `name` VARCHAR(45),
     command VARCHAR(45),
     birthday DATE,
     PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS hamsters;
CREATE TABLE IF NOT EXISTS hamsters (
     id INT NOT NULL AUTO_INCREMENT,
     animal VARCHAR(45),
     `name` VARCHAR(45),
     command VARCHAR(45),
     birthday DATE,
     PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS horses;
CREATE TABLE IF NOT EXISTS horses (
     id INT NOT NULL AUTO_INCREMENT,
     animal VARCHAR(45),
     `name` VARCHAR(45),
     command VARCHAR(45),
     birthday DATE,
     PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS donkeys;
CREATE TABLE IF NOT EXISTS donkeys (
     id INT NOT NULL AUTO_INCREMENT,
     animal VARCHAR(45),
     `name` VARCHAR(45),
     command VARCHAR(45),
     birthday DATE,
     PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS camels;
CREATE TABLE IF NOT EXISTS camels (
     id INT NOT NULL AUTO_INCREMENT,
     animal VARCHAR(45),
     `name` VARCHAR(45),
     command VARCHAR(45),
     birthday DATE,
     PRIMARY KEY (ID)
);

-- 9. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения

INSERT INTO pets (mansfriends, animal)
VALUES
	('друзья человека', 'кошка'),
    ('друзья человека', 'собака'),
    ('друзья человека', 'хомяк');

INSERT INTO pack_animals (mansfriends, animal)
VALUES
	('друзья человека', 'лошадь'),
    ('друзья человека', 'верблюд'),
    ('друзья человека', 'осел');

INSERT INTO cats (animal, `name`, command, birthday)
VALUES
	('кошка', 'Васька', 'кушать', '2021.12.03'),
    ('кошка', 'Рыжий', 'гулять', '2020.04.12'),
    ('кошка', 'Том', 'играть', '2019.10.05');

INSERT INTO dogs (animal, `name`, command, birthday)
VALUES
	('собака', 'Блэк', 'место', '2016.03.01'),
    ('собака', 'Дружок', 'фас', '2018.11.30'),
    ('собака', 'Герта', 'лежать', '2017.09.23');
    
INSERT INTO hamsters (animal, `name`, command, birthday)
VALUES
	('хомяк', 'Вьюнок', 'не крутить колесо', '2023.11.29'),
    ('хомяк', 'Грызун', 'замереть', '2022.09.16'),
    ('хомяк', 'Проныра', 'крути колесо', '2021.07.19');
    
INSERT INTO horses (animal, `name`, command, birthday)
VALUES
	('лошадь', 'Вороной', 'алюр', '2011.05.04'),
    ('лошадь', 'Гордая', 'галоп', '2016.12.25'),
    ('лошадь', 'Звезда', 'рысь', '2021.01.01');

INSERT INTO donkeys (animal, `name`, command, birthday)
VALUES
	('осел', 'Трудяга', 'тише', '2020.02.18'),
    ('осел', 'Медленный', 'стой', '2018.04.27'),
    ('осел', 'Упертый', 'вперед', '2021.04.20');
    
INSERT INTO camels (animal, `name`, command, birthday)
VALUES
	('верблюд', 'Вороной', 'дай ногу', '2015.07.01'),
    ('верблюд', 'Горбатый', 'лежать', '2020.08.25'),
    ('верблюд', 'Упертый', 'поклон', '2021.06.17');    

-- 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. 
-- Объединить таблицы лошади, и ослы в одну таблицу.
DELETE FROM pack_animals
WHERE animal='верблюд';

SELECT *
FROM pack_animals;

DROP TABLE IF EXISTS odd_toed_animals;
CREATE TABLE odd_toed_animals
  AS (SELECT * FROM (SELECT animal, `name`, command, birthday FROM horses
       UNION ALL SELECT animal, `name`, command, birthday FROM donkeys) as animals);
       
SELECT * FROM odd_toed_animals;

DROP TABLE IF EXISTS home_animals;
CREATE TABLE home_animals
  AS (SELECT * FROM (SELECT animal, `name`, command, birthday FROM cats
       UNION ALL SELECT animal, `name`, command, birthday FROM dogs
       UNION ALL SELECT animal, `name`, command, birthday FROM hamsters) as animals);

-- 11. Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет и 
-- в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице
DROP TABLE IF EXISTS young_animals;
CREATE TABLE young_animals
  AS (SELECT * FROM (SELECT * FROM home_animals WHERE (FLOOR((DATEDIFF(CURRENT_DATE, birthday))/365)) BETWEEN 1 AND 2
      UNION ALL SELECT * FROM odd_toed_animals WHERE (FLOOR((DATEDIFF(CURRENT_DATE, birthday))/365)) BETWEEN 1 AND 2) AS young);
      
SELECT animal, `name`, command, birthday,
	   (FLOOR((DATEDIFF(CURRENT_DATE, birthday))/365)) AS yy,
       (FLOOR(((DATEDIFF(CURRENT_DATE, birthday)) - (FLOOR((DATEDIFF(CURRENT_DATE, birthday))/365))*365)/30)) AS mm 
       FROM young_animals;

-- 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.
SELECT * FROM (SELECT * FROM (SELECT * FROM pets UNION ALL SELECT * FROM pack_animals) AS `groups`) AS all_animals_groups
               INNER JOIN (SELECT * FROM (SELECT * FROM home_animals UNION ALL SELECT * FROM odd_toed_animals) AS animals) AS all_animals
               ON all_animals_groups.animal=all_animals.animal;
 





