INSERT INTO User(id,name) VALUES (1,'nabil');
INSERT INTO Message(id, texte, creationDate, user_id) VALUES (1,'Welcome to your local application',NOW(),1);
UPDATE hibernate_sequence SET next_val= 2 WHERE next_val=1;