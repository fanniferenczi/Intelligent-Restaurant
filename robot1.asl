+!has(table1,order):true
	<-!at(robot1,manager);
	get(order);
	!at(robot1,table1);
	hand_in(order);
	!at(robot1,robot1).
	
+!has(table5,order):true
	<-!at(robot1,manager);
	get(order);
	!at(robot1,table5);
	hand_in(order);
	!at(robot1,robot1).
	
+!at(robot1,P):at(robot1,P)
	<- true.
	
+!at(robot1,P): not at(robot1,P)
	<- move_towards(P);
		!at(robot1,P).
