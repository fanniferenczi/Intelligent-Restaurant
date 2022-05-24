!get(order).
+!get(order):true 
	<- .wait(3000);
		.send(manager, achieve, serve(table5,order));
		.wait(11500);
		!pay(table5).
		
+!pay(table5):true
	<-pay(table5).
