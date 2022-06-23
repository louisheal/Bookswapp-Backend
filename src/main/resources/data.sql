insert into Book (isbn, title, published) values ('978-1441529961', 'A Critique of Pure Physics:',
                                                  '2020-3-5');
insert into Book (isbn, title, published) values ('978-1292183398', 'Pure Mathematics', '2000-1-1');

insert into Users (username, passwdHash, name) values ('dev', 'dev', 'Dev Account');
insert into Users (username, passwdHash, name) values ('ef420_icl', '3451', 'Emil Filip');
insert into Users (username, passwdHash, name) values ('Anand5329', '0368', 'Anand Doshi');
insert into Users (username, passwdHash, name) values ('LJRex', '4796', 'Louis Heal');
insert into Users (username, passwdHash, name) values ('Anjey', '6699', 'Andrii Verveha');

insert into Ownership (owner_id, book_id, totalCopies, currentCopies)
values ((select id from Users where username='ef420_icl'),
    (select id from Book where isbn='978-1441529961'),
    1, 1);
insert into Ownership (owner_id, book_id, totalCopies, currentCopies)
values ((select id from Users where username='dev'),
    (select id from Book where isbn='978-1292183398'),
    1, 1);

insert into Ownership (owner_id, book_id, totalCopies, currentCopies)
values ((select id from Users where username='Anand5329'),
    (select id from Book where isbn='978-1441529961'),
    1, 1);

