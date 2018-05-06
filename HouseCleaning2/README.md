# House cleaning 2

## The company structure

In this example, [Harry](src/main/java/dja/housecleaning/Harry.java) gets a [smart garage](src/main/java/dja/housecleaning/Garage.java). Not that he really needs one, but that's what everyone else seams to have. He can now say "SELECT cleaning tools/supplies FROM garage WHERE tools LIKE provided instructions" and the garage will give him the tools/supplies needed. 

Harry also hires [Ronald](src/main/java/dja/housecleaning/Ronald.java) to handle customers' requests. Ronald comes up with standard [order form](src/main/java/dja/housecleaning/OrderForm.java) which customers need to fill in. Ronald then passes the relevant information to Harry. 

## The PROs 

Now Harry and the garage can be isolated from the customers _(package private)_. Customers can only talk to Ronald and use the order form.

## The CONs

Since Harry, Ronald and the garage are all in the same [place(package)](src/main/java/dja/housecleaning/), now Ronald has full access to the garage. There is no way to physically limit Ronald's access to the garage. Therefore Ronald can now borrow the van and the tools _(without Harry's knowledge)_ and the company may stop functioning.

