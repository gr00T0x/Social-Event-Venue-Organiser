## Event Organiser

A small application I built in Java for a university assignment.

It is a console based application that has two main purposes:
* A HR restricted zone 
* A terminal for general employees

The HR zone is password protected. The password is hardcoded into the sourcecode (*sighs uncontrollably*). This was a requirement in the brief I was set. 
* The HR zone has more admin options:  
* Such as removing venues from the array list, adding new venues and seeing the votes for venues from employees.

The main options are for 'employees' to vote for their 'venue of the month' for their social event. They can:
* Vote for existing venues
* Suggest new venues
* Look at the current venues in the arraylist
* Find the closest venue to them using their Latitude and Longitude (Thanks to the Haversine formula)
