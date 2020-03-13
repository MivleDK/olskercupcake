-- MySQL test queryes for OlskerCupcakeDB

-- ----------------------------------
-- queryes for single tables 
-- ----------------------------------
SELECT * FROM users;
SELECT * FROM usersorders;
SELECT * FROM orders;
SELECT * FROM ordersorderline;
SELECT * FROM orderline;
SELECT * FROM products;

-- ----------------------------------
-- All topping products
-- ----------------------------------
SELECT * FROM products WHERE category = 'Topping';

-- ----------------------------------
-- All bottom products
-- ----------------------------------
SELECT * FROM products WHERE category = 'Bottom';

-- ------------------------------------------
-- Customer view in customer directory
-- ------------------------------------------
SELECT usersID,email,phone,kontobeloeb FROM users WHERE role = 'customer' ORDER BY usersID;

-- ----------------------------------
-- View basket from costumor
-- ----------------------------------
SELECT orderline.top,orderline.bund,orderline.antal,orderline.totalprice FROM orderline;
-- mangler en djævelsk masse joints

