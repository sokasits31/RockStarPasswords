DELETE FROM support_teams;
INSERT INTO support_teams VALUES  (1,'Team 1'),  (2,'Team 2'),  (3,'Team 3'), (4,'Team 4');
DELETE FROM users;
INSERT INTO users (email_address, user_role, first_name, last_name, primary_support, secondary_support, password, supportTeam_id) VALUES ('steve.sokasits@gmail.com', 'resource', 'Steve', 'Sokasits', 1, 1, 'college1', 1);
INSERT INTO users (email_address, user_role, first_name, last_name, primary_support, secondary_support, password, supportTeam_id) VALUES ('heather.sokasits@gmail.com', 'resource', 'Heather', 'Sokasits', 0, 1, 'college1', 2);
INSERT INTO users (email_address, user_role, first_name, last_name, primary_support, secondary_support, password, supportTeam_id) VALUES ('Lea.sokasits@gmail.com', 'resource', 'Lea', 'Sokasits', 0, 1, 'college1', 2);
INSERT INTO users (email_address, user_role, first_name, last_name, primary_support, secondary_support, password, supportTeam_id) VALUES ('Bradley.sokasits@gmail.com', 'resource', 'Bradley', 'Sokasits', 1, 0, 'college1', 1);
INSERT INTO users (email_address, user_role, first_name, last_name, primary_support, secondary_support, password, supportTeam_id) VALUES ('joe.blow@gmail.com', 'admin', 'Joe', 'Blow', 0, 0, 'college1', 1);
