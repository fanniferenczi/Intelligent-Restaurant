
plays(initiator,manager). 

// send a message to the initiator introducing myself as a participant
+plays(initiator,In):.my_name(Me)
   <- .send(In,tell,introduction(participant,Me)).

// answer to Call For Proposal   
@c1 +cfp(CNPId,Task)[source(A)]:plays(initiator,A) 
   <- 	if(at(robot1,home1)){
   			if(Task==has(table1,order)){
				.findall(price(D),distance(robot1,table1,D),L);
				L \== [];
				.min(L,price(Dist));
				Offer=Dist;
				+proposal(CNPId,Task,Offer); // remember my proposal
				.send(A,tell,propose(CNPId,Offer));
				.print("robot1 has sent the price");
			}
			if(Task==has(table2,order)){
				.findall(price(D),distance(robot1,table2,D),L);
				L \== [];
				.min(L,price(Dist));
				Offer=Dist;
				+proposal(CNPId,Task,Offer); // remember my proposal
				.send(A,tell,propose(CNPId,Offer));
				.print("robot1 has sent the price");
			}
			if(Task==has(table3,order)){
				.findall(price(D),distance(robot1,table3,D),L);
				L \== [];
				.min(L,price(Dist));
				Offer=Dist;
				+proposal(CNPId,Task,Offer); // remember my proposal
				.send(A,tell,propose(CNPId,Offer));
				.print("robot1 has sent the price");
			}
			if(Task==has(table4,order)){
				.findall(price(D),distance(robot1,table4,D),L);
				L \== [];
				.min(L,price(Dist));
				Offer=Dist;
				+proposal(CNPId,Task,Offer); // remember my proposal
				.send(A,tell,propose(CNPId,Offer));
				.print("robot1 has sent the price");
			}
			if(Task==has(table5,order)){
				L \== [];
				.min(L,price(Dist));
				Offer=Dist;
				+proposal(CNPId,Task,Offer); // remember my proposal
				.send(A,tell,propose(CNPId,Offer));
				.print("robot1 has sent the price");
			}
		}
		else{
			.send(A,tell,refuse(CNPId));
			.print("robot1 is busy");
			 -cfp(CNPId,Task)[source(A)];
	         -proposal(CNPId,_,_); // clear memory
		}.

@r1 +accept_proposal(CNPId): proposal(CNPId,Task,Offer) 
   <-  !Task;
	   -cfp(CNPId,Task)[source(A)];
	   -proposal(CNPId,_,_); // clear memory
	   .abolish(accept_proposal(_)).
	   
	  
@r2 +reject_proposal(CNPId)
   <- -cfp(CNPId,Task)[source(A)];
      -proposal(CNPId,_,_); // clear memory
	  .abolish(reject_proposal(_)).
	  
+!has(table1,order):true
	<-!at(robot1,manager);
	get(order);
	!at(robot1,table1);
	hand_in(table1);
	!at(robot1,home1).
	
+!has(table2,order):true
	<-!at(robot1,manager);
	get(order);
	!at(robot1,table2);
	hand_in(table2);
	!at(robot1,home1).
	
+!has(table3,order):true
	<-!at(robot1,manager);
	get(order);
	!at(robot1,table3);
	hand_in(table3);
	!at(robot1,home1).
	
+!has(table4,order):true
	<- !at(robot1,manager);
	get(order);
	!at(robot1,table4);
	hand_in(table4);
	!at(robot1,home1).
	

+!has(table5,order):true
	<-!at(robot1,manager);
	get(order);
	!at(robot1,table5);
	hand_in(table5);
	!at(robot1,home1).
	
	
+!at(robot1,P):at(robot1,P)
	<- true.
	
+!at(robot1,P): not at(robot1,P)
	<- move_towards(P,0);
		!at(robot1,P).
	
		
