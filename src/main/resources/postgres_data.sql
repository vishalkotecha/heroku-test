INSERT INTO user_master(id,email,first_name,last_name,password,user_name) VALUES (1,'vkotecha91@gmail.com','Vishal','Kotecha','$2a$10$E.dwCiokjDjL1YMZ/gv4iOPAnKh9FW/DbHZdV9CKtyjE0cZcWXPVG','vishal') ON CONFLICT DO NOTHING;

INSERT INTO role_master(id,name) VALUES (1,'user') ON CONFLICT DO NOTHING;;
INSERT INTO role_master(id,name) VALUES (2,'admin') ON CONFLICT DO NOTHING;;

INSERT INTO user_role(user_id,role_id) VALUES (1,1) ON CONFLICT DO NOTHING;;

INSERT INTO product (id, name) VALUES ('1', 'Shoes') ON CONFLICT DO NOTHING;;
INSERT INTO product (id, name) VALUES ('2', 'Clothes') ON CONFLICT DO NOTHING;
