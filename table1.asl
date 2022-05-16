!get(order).
+!get(order):true 
	<- .send(manager, achieve, serve(table1,order)).
		
	
	 /*.wait(1000);
	   .send(manager, achieve, serve(table2,order));
	   .wait(1000);
	   .send(manager, achieve, serve(table3,order));
	   .wait(1000);
	   .send(manager, achieve, serve(table1,order));
	   .wait(1000);
	   .send(manager, achieve, serve(table4,order)).
	   
	  
	   //.wait(5000);
	   //.send(manager, achieve, serve(table1,order)).  */
