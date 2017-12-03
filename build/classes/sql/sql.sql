DROP TABLE BOOKINGTABLE;
DROP TABLE BOOKING;
DROP TABLE TICKET;
DROP TABLE SCREENING;
DROP TABLE FILM;



DROP sequence seat_seq;
DROP sequence scring_seq;
drop sequence film_seq;
drop sequence book_seq;
drop sequence ticket_seq;

create sequence seat_seq increment by 1 start with 1;
create sequence scring_seq increment by 1 start with 1;
create sequence film_seq increment by 1 start with 1;
create sequence book_seq increment by 1 start with 1;
create sequence ticket_seq increment by 1 start with 1;

CREATE TABLE FILM(
    filmID number,
    TITLE varchar2(255),
    DIRECTOR varchar2(255),
    DESCRIPTION varchar2(255),
    PRIMARY KEY (filmID)
);

CREATE TABLE SCREENING(
    screeningID number,
    filmID number,
    sTime varchar2(255),
    sDate date,
    seatCount number,
    PRIMARY KEY(screeningID),
    FOREIGN KEY(filmID) REFERENCES film(filmID)
);

CREATE TABLE BOOKING(
    bookingID number,
    PRIMARY KEY(bookingID)
);

CREATE TABLE TICKET(
    ticketID number,
    screeningID number,
   
    seatNo number,
    rowNo number,
    PRIMARY KEY (ticketID),
    FOREIGN KEY (screeningID) REFERENCES screening(screeningID)
);

CREATE TABLE BOOKINGTABLE(
bookingID number,
ticketID number,
PRIMARY KEY (bookingID, ticketID),
FOREIGN KEY (bookingID) REFERENCES Booking(bookingID),
FOREIGN KEY (ticketID) REFERENCES Ticket(ticketID)
);


INSERT INTO FILM VALUES(film_seq.nextVal, 'Inception', 'Christopher Nolan', 'A thief, who steals corporate secrets through use of dream-sharing technology, is given the inverse task of planting an idea into the mind of a CEO.');
INSERT INTO FILM VALUES(film_seq.nextVal, 'V for Vendetta', 'James McTeigue', 'In a future British tyranny, a shadowy freedom fighter, V, plots to overthrow it with the help of a young woman.');
INSERT INTO FILM VALUES(film_seq.nextVal, 'Pulp Fiction', 'Quentin Tarantino', 'The lives of two mob hit men, a boxer, a gangsters wife, and a pair of diner bandits intertwine in four tales of violence and redemption.');
INSERT INTO FILM VALUES(film_seq.nextVal, 'The adventures of Kilian McCool', 'Quentin Tarantino', 'Kilian McCool saves the world again because hes awesome.');


INSERT INTO SCREENING VALUES(scring_seq.nextVal, 1,'6:00','10-JAN-2018', 1);
INSERT INTO SCREENING VALUES(scring_seq.nextVal, 1,'8:00', '10-JAN-2018', 1);
INSERT INTO SCREENING VALUES(scring_seq.nextVal, 1,'6:00', '11-JAN-2018', 1);
INSERT INTO SCREENING VALUES(scring_seq.nextVal, 2,'7:00', '10-JAN-2018', 1);
INSERT INTO SCREENING VALUES(scring_seq.nextVal, 2,'10:00', '11-JAN-2018', 1);
INSERT INTO SCREENING VALUES(scring_seq.nextVal, 3,'5:00', '10-JAN-2018', 1);
INSERT INTO SCREENING VALUES(scring_seq.nextVal, 3,'7:00', '10-JAN-2018', 1);
INSERT INTO SCREENING VALUES(scring_seq.nextVal, 3,'7:00', '11-JAN-2018', 1);
INSERT INTO SCREENING VALUES(scring_seq.nextVal, 4,'6:00', '10-JAN-2018', 1);