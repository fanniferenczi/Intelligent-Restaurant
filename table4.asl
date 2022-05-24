!get(order).
+!get(order):true 
	<- .wait(7000);
		.send(manager, achieve, serve(table4,order));
		.wait(11000);
		!pay(table4).
		
+!pay(table4):true
	<-pay(table4).
