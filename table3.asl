!get(order).
+!get(order):true 
	<- .wait(700);
		.send(manager, achieve, serve(table3,order));
		.wait(10500);
		!pay(table3).
		
+!pay(table3):true
	<-pay(table3).
