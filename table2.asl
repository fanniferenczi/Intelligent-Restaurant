!get(order).
+!get(order):true 
	<- .wait(500);
		.send(manager, achieve, serve(table2,order));
		.wait(10000);
		.send(manager, achieve, serve(table2,order));
		.wait(11000);
		!pay(table2).
		
+!pay(table2):true
	<-pay(table2).
		
