create database userAuth;
use userAuth;
show tables;

select * from user_auth_entity;
INSERT INTO user_auth_entity (username, password, email, role) VALUES
('alice456', 'alicepassword123', 'alice@example.com', 'USER'),
('robert789', 'robertpassword123', 'robert@example.com', 'ADMIN'),
('sarah321', 'sarahpassword123', 'sarah@example.com', 'USER'),
('david654', 'davidpassword123', 'david@example.com', 'ADMIN');
