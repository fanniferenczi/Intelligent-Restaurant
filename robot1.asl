/*
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
   <- +proposal(CNPId,Task,Offer); // remember my proposal
      .send(A,tell,propose(CNPId,Offer)).

@r1 +accept_proposal(CNPId)
   :  proposal(CNPId,Task,Offer)
   <- .print("My proposal '",Offer,"' won CNP ",CNPId,
             " for ",Task,"!").
      // do the task and report to initiator
	  !has(table1,order).
	  
@r2 +reject_proposal(CNPId)
   <- .print("I lost CNP ",CNPId, ".");
      -proposal(CNPId,_,_). // clear memory




*/

!has(table5,order).

+!has(table1,order):true
	<-//!at(robot1,manager);
	get(order);
	!at(robot1,table1);
	hand_in(order);
	!at(robot1,robot1).
	
+!has(table2,order):true
	<-//!at(robot1,manager);
	get(order);
	!at(robot1,table2);
	hand_in(order);
	!at(robot1,robot1).
	
	+!has(table3,order):true
	<-//!at(robot1,manager);
	get(order);
	!at(robot1,table3);
	hand_in(order);
	!at(robot1,robot1).
	
+!has(table4,order):true
	<- //!at(robot1,manager);
	get(order);
	!at(robot1,table4);
	hand_in(order);
	!at(robot1,robot1).
	
	
	+!has(table5,order):true
	<-//!at(robot1,manager);
	get(order);
	!at(robot1,table5);
	hand_in(order);
	!at(robot1,robot1).
	
	+!has(table6,order):true
	<-//!at(robot1,manager);
	get(order);
	!at(robot1,table6);
	hand_in(order);
	!at(robot1,robot1).
	
	
+!at(robot1,P):at(robot1,P)
	<- true.
	
+!at(robot1,P): not at(robot1,P)
	<- move_towards(P,0);
		!at(robot1,P).
		
		
