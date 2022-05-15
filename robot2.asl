
price(Service,X) :- .random(R) & X = (10*R)+100.

plays(initiator,manager). 

// Plans 

// send a message to the initiator introducing myself
// as a participant
+plays(initiator,In)
   :  .my_name(Me)
   <- .send(In,tell,introduction(participant,Me)).

// answer to Call For Proposal   
@c1 +cfp(CNPId,Task)[source(A)]
   :  plays(initiator,A) & price(Task,Offer)
   <- /*if(at(robot2,home2)){
			.print("robot2 is at home");
			Offer=200;
		}
		else{
			.print("robot2 is not at home");
			Offer=200;
		}*/
		.print("robot2 kitalálta, most küldi");
   		+proposal(CNPId,Task,Offer); // remember my proposal
      .send(A,tell,propose(CNPId,Offer)).

@r1 +accept_proposal(CNPId)
   :  proposal(CNPId,Task,Offer)
   <- .print("My proposal '",Offer,"' won CNP ",CNPId,
             " for ",Task,"!");
      // do the task and report to initiator
	  	!Task;
		 -cfp(CNPId,Task)[source(A)];
	    -proposal(CNPId,_,_); // clear memory
		.abolish(accept_proposal(_)).
		
		 
	  
@r2 +reject_proposal(CNPId)
   <- .print("I lost CNP ",CNPId, ".");
   -cfp(CNPId,Task)[source(A)];
     -proposal(CNPId,_,_); // clear memory
	 .abolish(reject_proposal(_)).
	  
      



//!has(table2,order).

+!has(table1,order):true
	<-!at(robot2,manager);
	get(order);
	!at(robot2,table1);
	hand_in(order);
	!at(robot2,home2).

+!has(table2,order):true
	<-!at(robot2,manager);
	get(order);
	!at(robot2,table2);
	hand_in(order);
	!at(robot2,home2).
	
+!has(table3,order):true
	<-!at(robot2,manager);
	get(order);
	!at(robot2,table3);
	hand_in(order);
	!at(robot2,home2).
	
+!has(table4,order):true
	<-!at(robot2,manager);
	get(order);
	!at(robot2,table4);
	hand_in(order);
	!at(robot2,home2).
	
+!has(table5,order):true
	<-!at(robot2,manager);
	get(order);
	!at(robot2,table5);
	hand_in(order);
	!at(robot2,home2).
	
	  
	
+!at(robot2,P):at(robot2,P)
	<- true.
	
+!at(robot2,P): not at(robot2,P)
	<- move_towards(P,1);
		!at(robot2,P).
		
		
		
