!get(order).
+!get(order):true 
	<- .send(manager, achieve, serve(table2,order));
		.wait(5000);
	   .send(manager, achieve, serve(table2,order));
	   .wait(10000);
	   .send(manager, achieve, serve(table2,order)).
	  
	   //.wait(5000);
	   //.send(manager, achieve, serve(table1,order)). 
