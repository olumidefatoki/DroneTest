INSERT INTO drone(id, battery_capacity,model, serial_number, state, weight)
VALUES(1,100,'LIGHTWEIGHT','abc_001','IDLE',100);
INSERT INTO drone(id, battery_capacity,model, serial_number, state, weight)
VALUES(2,100,'LIGHTWEIGHT','abc_002','IDLE',100);
INSERT INTO drone(id, battery_capacity,model, serial_number, state, weight)
VALUES(3,100,'LIGHTWEIGHT','abc_003','IDLE',100);
INSERT INTO drone(id, battery_capacity,model, serial_number, state, weight)
VALUES(4,100,'MIDDLEWEIGHT','abd_001','IDLE',100);
INSERT INTO drone(id, battery_capacity,model, serial_number, state, weight)
VALUES(5,100,'MIDDLEWEIGHT','abd_002','IDLE',100);
INSERT INTO drone(id, battery_capacity,model, serial_number, state, weight)
VALUES(6,100,'MIDDLEWEIGHT','abd_003','IDLE',100);
INSERT INTO drone(id, battery_capacity,model, serial_number, state, weight)
VALUES(7,100,'CRUISERWEIGHT','abe_001','IDLE',100);
INSERT INTO drone(id, battery_capacity,model, serial_number, state, weight)
VALUES(8,100,'CRUISERWEIGHT','abe_002','IDLE',100);
INSERT INTO drone(id, battery_capacity,model, serial_number, state, weight)
VALUES(9,100,'HEAVYWEIGHT','abf_001','IDLE',100);
INSERT INTO drone(id, battery_capacity,model, serial_number, state, weight)
VALUES(10,100,'HEAVYWEIGHT','abf_002','IDLE',100);

INSERT INTO medication(id,drone_id,name, weight, code)
VALUES(1,1,'PARACETAMOL',2.50,'PARA_001');
INSERT INTO medication(id,drone_id,name, weight, code)
VALUES(2,1,'chloroquine',21.50,'CHL_002');
INSERT INTO medication(id,drone_id,name, weight, code)
VALUES(3,1,'Malarone',21.50,'MAL_002');
