CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO flavour.dishes(id, name, price, type)
	   VALUES (uuid_generate_v4(),'Favas guisadas', 15.7, 'CARNE');

