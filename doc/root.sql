/*CREATE TABLE company(
	company_id int PRIMARY KEY,
	company_name varchar(20),
	company_address varchar(20),
	company_phone_number varchar(20),
	company_e_mail varchar(20)	
);*/

/*CREATE TABLE busseats(
	seat_id int PRIMARY KEY,
	avaliable_seat int,
	number_of_seats int
	
);*/

/*CREATE TABLE trainseats(
	seat_id int PRIMARY KEY,
	avaliable_seat int,
	number_of_seats int
	
);

CREATE TABLE planeseats(
	seat_id int PRIMARY KEY,
	avaliable_seat int,
	number_of_seats int
	
);*/

/*CREATE TABLE bustravelroute(
	travel_route_id int PRIMARY KEY,
	"to" varchar(20),
	"from" varchar(20)
);*/

/*CREATE TABLE planetravelroute(
	travel_route_id int PRIMARY KEY,
	"to" varchar(20),
	"from" varchar(20)
);

CREATE TABLE traintravelroute(
	travel_route_id int PRIMARY KEY,
	"to" varchar(20),
	"from" varchar(20)
);*/

/*CREATE TABLE plane(
	plane_id int PRIMARY KEY,
	company_id int REFERENCES company(company_id),
	seat_id int REFERENCES planeseats(seat_id),
	travel_route_id int REFERENCES planetravelroute(travel_route_id)
	
);*/

/*CREATE TABLE bus(
	bus_id int PRIMARY KEY,
	company_id int REFERENCES company(company_id),
	seat_id int REFERENCES trainseats(seat_id),
	travel_route_id int REFERENCES traintravelroute(travel_route_id),
	bus_plate_number varchar(20),
	seat_design varchar(20)
	
);*/

/*CREATE TABLE train(
	train_id int PRIMARY KEY,
	company_id int REFERENCES company(company_id),
	seat_id int REFERENCES trainseats(seat_id),
	travel_route_id int REFERENCES traintravelroute(travel_route_id)
	
);*/

/*CREATE TABLE users(
	user_tckn bigint PRIMARY KEY unique,
	user_name varchar(20),
	user_phone_number varchar(20),
	user_address varchar(50),
	user_email varchar(20),
	user_gender varchar(1),
	user_username varchar(20) unique,
	user_password varchar(20)
)*/
 create table admin(
	 
 )inherits(users);
 
 /*create table customer(
 	costomer_bought_tickets int,
 	)inherits(users);*/
	
	
/*CREATE TABLE bills(
	bills_id int PRIMARY KEY,
	bills_date varchar(20)
	
);*/

/*CREATE TABLE tickets(
	ticket_id int PRIMARY KEY,
	company_id int REFERENCES company(company_id),
	user_tckn bigint REFERENCES users(user_tckn),
	plane_id int REFERENCES plane(plane_id),
	bus_id int REFERENCES bus(bus_id),
	train_id int REFERENCES train(train_id),
	bills_id int REFERENCES	bills(bills_id),
	ticket_date varchar(20),
	ticket_price int,
	departure_date varchar(20),
	arrival_date varchar(20)

);*/