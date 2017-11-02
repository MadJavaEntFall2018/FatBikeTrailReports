INSERT INTO FBTRTest.user (email, firstName, lastName, password, userName) VALUES ('UserDaoTester@gmail.com0', 'Unit0', 'Test0', 'supersecret0', 'UnitTester0');
INSERT INTO FBTRTest.user (email, firstName, lastName, password, userName) VALUES ('UserDaoTester@gmail.com1', 'Unit1', 'Test1', 'supersecret1', 'UnitTester1');
INSERT INTO FBTRTest.user (email, firstName, lastName, password, userName) VALUES ('UserDaoTester@gmail.com2', 'Unit2', 'Test2', 'supersecret2', 'UnitTester2');
INSERT INTO FBTRTest.user (email, firstName, lastName, password, userName) VALUES ('UserDaoTester@gmail.com3', 'Unit3', 'Test3', 'supersecret3', 'UnitTester3');
INSERT INTO FBTRTest.user (email, firstName, lastName, password, userName) VALUES ('UserDaoTester@gmail.com4', 'Unit4', 'Test4', 'supersecret4','UnitTester4');
INSERT INTO FBTRTest.user (email, firstName, lastName, password, userName) VALUES ('UserDaoTesterA@gmail.com', 'Unit', 'Test', 'supersecret', 'UnitTesterA');
INSERT INTO FBTRTest.role (userName, name) VALUES ('UnitTester0', 'user');
INSERT INTO FBTRTest.role (userName, name) VALUES ('UnitTester1', 'user');
INSERT INTO FBTRTest.role (userName, name) VALUES ('UnitTester2', 'user');
INSERT INTO FBTRTest.role (userName, name) VALUES ('UnitTester3', 'user');
INSERT INTO FBTRTest.role (userName, name) VALUES ('UnitTester4', 'user');
INSERT INTO FBTRTest.role (userName, name) VALUES ('UnitTesterA', 'admin');
INSERT INTO FBTRTest.difficulty (name) VALUES ('Hard');
INSERT INTO FBTRTest.difficulty (name) VALUES ('Easy');
INSERT INTO FBTRTest.trail_type (name) VALUES ('SingleTrack');
INSERT INTO FBTRTest.grooming_type (name) VALUES ('Ridden In');
INSERT INTO FBTRTest.grooming_type (name) VALUES ('Snowmobile');
INSERT INTO FBTRTest.trail (description, length, lengthUnits, location, name, trailMap, website, difficulty, type, user) VALUES ('Big Fat Loop', null, null, null, 'BFL', null, null, (Select difficultyId from difficulty where name = 'Hard'), (Select trailTypeId from trail_type where name = 'SingleTrack'), (Select userId from user where userName = 'UnitTester0'));
