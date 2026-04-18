USE WishDB;

insert into wishlists (userID, name) VALUES
    ('1','lottes fødselsdag'),
    ('1','bents fødseldag');

INSERT INTO users (firstName, lastName, email, tlfNumber, gender, birthDate, password)
VALUES  ('Nicklas', 'Køppen', 'nicklasReal@email.dk', '12345667', 'mand', 08-02-2001, 'sikkerKode1'),
        ('Dummy', 'Haha', 'Fakemail@no.dk', '2020202', 'mand', 01-02-2001, 'fakePassword');