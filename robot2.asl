+!has(table1,order):true
	<-/*!at(robot1,manager);*/
	get(order);
	!at(robot2,table1);
	hand_in(order);
	!at(robot2,robot2).
	
+!has(table5,order):true
	<-/*!at(robot1,manager);*/
	get(order);
	!at(robot2,table5);
	hand_in(order);
	!at(robot2,robot2).
	
+!at(robot2,P):at(robot2,P)
	<- true.
	
+!at(robot2,P): not at(robot2,P)
	<- move_towards(P,1);
		!at(robot2,P).
