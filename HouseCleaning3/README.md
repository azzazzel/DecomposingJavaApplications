# House cleaning 3

## The company structure


In this example, [Harry](HouseCleaning3-company/src/main/java/dja/housecleaning/company/Harry.java) hires new assistant [Andrey](HouseCleaning3-company/src/main/java/dja/housecleaning/company/Andrey.java). He also splits the company assets into a [garage](HouseCleaning3-assets/src/main/java/dja/housecleaning/assets/Garage.java) for the van and [storage](HouseCleaning3-assets/src/main/java/dja/housecleaning/assets/Storage.java) for the tools and supplies. 

Unenforced agreement is that Andrey is in charge for the storage and Harry is using the garage. Then the company is divided into 3 departments _(modules)_, following industry's best practices. 

### [Front office](HouseCleaning3-front) 

This is where  customers are served. Thus this is where [Ronald](HouseCleaning3-front/src/main/java/dja/housecleaning/front/Ronald.java) and the standard [order form](HouseCleaning3-front/src/main/java/dja/housecleaning/front/OrderForm.java) are located.

### [Company](HouseCleaning3-company)
This is where the company actually operates from. Thus this is where Harry and Andrey are located.

### [Assets](HouseCleaning3-assets)

This is where all the company assets are kept.

## The PROs 

The company operation can now be divided between Harry and Andrey and all future assistants. Andrey and all future assistants are not available _(package private)_ for anyone else but Harry.

## The CONs

Since both the garage and storage are outside the company they need to be publicly available. Again, there is no way to physically limit Ronald's access to the garage nor storage. Moreover, Harry need to be publicly available for Ronald to contact him, thus he is no longer isolated from customers.

