DELETE FROM user_master;
INSERT INTO user_master(id,email,first_name,last_name,password,user_name) VALUES (1,'vkotecha91@gmail.com','Vishal','Kotecha','$2a$10$E.dwCiokjDjL1YMZ/gv4iOPAnKh9FW/DbHZdV9CKtyjE0cZcWXPVG','vishal');

INSERT IGNORE INTO role_master(id,name) VALUES (1,'user');
INSERT IGNORE INTO role_master(id,name) VALUES (2,'admin');

INSERT IGNORE INTO user_role(user_id,role_id) VALUES (1,1);

INSERT IGNORE INTO product (id, name) VALUES ('1', 'Shoes');
INSERT IGNORE INTO product (id, name) VALUES ('2', 'Clothes');
