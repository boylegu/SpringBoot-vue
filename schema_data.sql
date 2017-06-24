CREATE TABLE persons (id  integer, create_datetime datetime, email varchar(255), phone varchar(255), sex varchar(255), username varchar(255), zone blob, primary key (id));

INSERT INTO persons (create_datetime, email, phone, sex, username, zone) VALUES (datetime('now'), 'gubaoer@hotmail.com', 08613000001111, 'male', 'gubaoer', 'HongKou District');

INSERT INTO persons (create_datetime, email, phone, sex, username, zone) VALUES (datetime('now'), 'boyle.gu@hotmail.com', 08613000001112, 'male', 'baoer.gu', 'JingAn District');

INSERT INTO persons (create_datetime, email, phone, sex, username, zone) VALUES (datetime('now'), 'yoyo.wu@gmail.com', 08613000001113, 'fmale', 'yoyo.wu', 'JingAn District');