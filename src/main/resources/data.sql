insert into Book (isbn, title, published) values ('978-1529034523', 'The Hitchhiker''s Guide to ' ||
                                                  'the Galaxy', cast('2020-3-5' as DATE));
insert into Book (isbn, title, published) values ('1', 'Book1', cast('2000-1-1' as DATE));
insert into Book (isbn, title, published) values ('2', 'Book2', cast('2000-1-2' as DATE));
insert into Book (isbn, title, published) values ('3', 'Book3', cast('2000-1-3' as DATE));

insert into Users (username, passwdHash, name) values ('emilfilip02', 'abx083247u', 'Emil Filip');
insert into Users (username, passwdHash, name) values ('Anand5329', '1245328967', 'Anand Doshi');
insert into Users (username, passwdHash, name) values ('LJRex', 'hashashash', 'Louis Heal');
insert into Users (username, passwdHash, name) values ('Anjey', '6699', 'Andrii Verveha');