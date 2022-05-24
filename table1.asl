!get(order).
+!get(order):true 
	<- .send(manager, achieve, serve(table1,order));
		.wait(10000);
		!pay(table1).
	
+!pay(table1):true
	<-pay(table1).
		
	
