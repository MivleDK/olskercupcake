-- MySQL test queryes for OlskerCupcakeDB

-- ----------------------------------
-- queryes for single tables 
-- ----------------------------------
SELECT * FROM users;
SELECT * FROM orders;
SELECT * FROM orderline;
SELECT * FROM topping;
SELECT * FROM bottom;

-- ----------------------------------
-- All topping (dropdown)
-- ----------------------------------
SELECT * FROM topping ORDER BY topping_id;

-- ----------------------------------
-- All bottom (dropdown)
-- ----------------------------------
SELECT * FROM bottom ORDER BY bottom_id;

-- ------------------------------------------
-- Customer view in customer directory
-- ------------------------------------------
SELECT users_id,email,phone,credit FROM users WHERE role = 'customer' ORDER BY users_id;

-- -----------------------------------------
-- All orders
-- -----------------------------------------
SELECT * FROM users u
INNER JOIN orders o on u.users_id = o.users_id
INNER JOIN orderline ol on o.orders_id = ol.orders_id
INNER JOIN topping t on ol.topping_id = t.topping_id
INNER JOIN bottom b on ol.bottom_id = b.bottom_id;

-- -----------------------------------------
-- View basket
-- -----------------------------------------
SELECT b.name as bottom, t.name as topping, ol.quantity, ol.sum FROM users u
INNER JOIN orders o on u.users_id = o.users_id
INNER JOIN orderline ol on o.orders_id = ol.orders_id
INNER JOIN topping t on ol.topping_id = t.topping_id
INNER JOIN bottom b on ol.bottom_id = b.bottom_id
WHERE o.orders_id = '2';

-- -----------------------------------------
-- All Previous orders
-- -----------------------------------------
SELECT o.orders_id,o.order_date,b.name as bottom, t.name as topping, ol.quantity, ol.sum  FROM users u
INNER JOIN orders o on u.users_id = o.users_id
INNER JOIN orderline ol on o.orders_id = ol.orders_id
INNER JOIN topping t on ol.topping_id = t.topping_id
INNER JOIN bottom b on ol.bottom_id = b.bottom_id
WHERE o.status = 'Afsluttet';

-- -----------------------------------------
-- All Previous orders from customer
-- -----------------------------------------
SELECT o.orders_id, o.order_date, b.name as bottom, t.name as topping, ol.quantity, ol.sum  
FROM users u
INNER JOIN orders o on u.users_id = o.users_id
INNER JOIN orderline ol on o.orders_id = ol.orders_id
INNER JOIN topping t on ol.topping_id = t.topping_id
INNER JOIN bottom b on ol.bottom_id = b.bottom_id
WHERE o.status = 'Afsluttet' AND u.users_id = '4';

-- -----------------------------------------
-- order summary
-- -----------------------------------------
SELECT o.orders_id, o.order_date, o.status, u.email, sum(ol.quantity) as quantity, sum(ol.sum) as total  FROM users u
INNER JOIN orders o on u.users_id = o.users_id
INNER JOIN orderline ol on o.orders_id = ol.orders_id
GROUP BY o.orders_id
ORDER BY o.orders_id;

-- -----------------------------------------
-- Create order and insert into basket
-- -----------------------------------------
INSERT INTO orders (users_id) VALUES ('2');
-- Use 'PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );'
-- This return the latest id (look at createUser)
-- CHECK orders_id before test!!! and put the last id in orders_id values
INSERT INTO orderline (orders_id,quantity,sum,topping_id,bottom_id) VALUES ('4','2','20','2','3');

-- ------------------------------------------
-- Update user credit
-- ------------------------------------------
-- set user credit
UPDATE users SET credit = '300' WHERE email = 'robin@somewhere.com';
-- or add to current value
UPDATE users SET credit = credit + '400' WHERE email = 'robin@somewhere.com';

-- ------------------------------------------
-- Reset password
-- ------------------------------------------
UPDATE users SET password = '4321' WHERE users_id = '3';

-- ------------------------------------------
-- delete order
-- ------------------------------------------
-- Delete order and all orderlines connected using DELETE ON CASCADE  
DELETE FROM orders WHERE orders_id = '4';

-- ------------------------------------------
-- delete user
-- ------------------------------------------
-- Delete user and all orders, ordelines using DELETE ON CASCADE
DELETE FROM users WHERE users_id = '4';

-- ------------------------------------------
-- delete from basket
-- ------------------------------------------
DELETE FROM orderline WHERE orderline_id = '';
