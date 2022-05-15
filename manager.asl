


all_proposals_received(CNPId) :- 
  .count(introduction(participant,_),NP) & // number of participants
  .count(propose(CNPId,_), NO) &      // number of proposes received
  .count(refuse(CNPId), NR) &         // number of refusals received
  NP = NO + NR.

+!serve(table1,order): true
 	<-!startCNP(1,has(table1,order)). 
 
 +!serve(table2,order): true
 	<-!startCNP(2,has(table2,order)). 
 

 
+!startCNP(Id,Task) 
	<- .wait (2000);
	 +cnp_state(Id,propose); 
	 .findall(Name,introduction(participant,Name),LP);
	 .print("Sending CFP to ",LP);
     .send(LP,tell,cfp(Id,Task));
     .concat("+!contract(",Id,")",Event);
	 .at("now +4 seconds", Event).

// receive proposal 
@r1 +propose(CNPId,Offer)
   :  cnp_state(CNPId,propose) & all_proposals_received(CNPId)
   <- !contract(CNPId).
   
// receive refusals   
@r2 +refuse(CNPId) 
   :  cnp_state(CNPId,propose) & all_proposals_received(CNPId)
   <- !contract(CNPId).
  
   
 // this plan needs to be atomic so as not to accept
// proposals or refusals while contracting
@lc1[atomic]
+!contract(CNPId)
   :  cnp_state(CNPId,propose)
   <- -+cnp_state(CNPId,contract);
      .findall(offer(O,A),propose(CNPId,O)[source(A)],L);
      .print("Offers are ",L);
      L \== []; // constraint the plan execution to at least one offer
      .min(L,offer(WOf,WAg)); // sort offers, the first is the best
      .print("Winner is ",WAg," with ",WOf);
      !announce_result(CNPId,L,WAg);
	  .abolish(propose(CNPId,_));  //kéréshez tartozó ajánlatok törlése, így lehet többször is meghirdetni ezt a feladatot
      -+cnp_state(Id,finished).

// nothing todo, the current phase is not 'propose'
@lc2 +!contract(CNPId).

-!contract(CNPId)
   <- .print("CNP ",CNPId," has failed!").

+!announce_result(_,[],_).
// announce to the winner
+!announce_result(CNPId,[offer(O,WAg)|T],WAg) 
   <- .send(WAg,tell,accept_proposal(CNPId));
   	  .print("elküldve");
      !announce_result(CNPId,T,WAg).
// announce to others
+!announce_result(CNPId,[offer(O,LAg)|T],WAg) 
   <- .send(LAg,tell,reject_proposal(CNPId));
      !announce_result(CNPId,T,WAg).
	  
	  
	  
