/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Akinwale
 * Created: May 16, 2022
 * Function: Database initializer
 */

INSERT INTO ServiceProvider(restaurantName,serviceCategory,email,phoneNumber,city)
VALUES ('Chicken Republic',0,'info@chicken_republic.com','08035674533',0);
INSERT INTO ServiceProvider(restaurantName,serviceCategory,email,phoneNumber,city)
VALUES ('Mr.Bigs',0,'info@Mr.Bigs.com','08025643333',0);
INSERT INTO ServiceProvider(restaurantName,serviceCategory,email,phoneNumber,city)
VALUES ('Ultima Restaurant',0,'info@ultimrest.com','08055688531',2);
INSERT INTO ServiceProvider(restaurantName,serviceCategory,email,phoneNumber,city)
VALUES ('Lagoon Restaurant',0,'info@lagoon.com','08077898909',1);
INSERT INTO ServiceProvider(restaurantName,serviceCategory,email,phoneNumber,city)
VALUES ('Cactus Restaurants',0,'info@turiah.com','08077885555',1);
INSERT INTO ServiceProvider(restaurantName,serviceCategory,email,phoneNumber,city)
VALUES ('Turiah Restaurants',0,'info@turiah.com','08077889031',2);

INSERT INTO MEAL(serviceName,picture,price,description,provider,preparationTime)
VALUES ('Pizza',FILE_READ('file.dat'),2000,'Pizza',0,30);