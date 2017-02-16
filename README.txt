Out of personal preference I have chosen to use maven to build the application (instead of gradle).

The app exposes several endpoints that allow to query: 
1) all addresses associated to a given postcode 
2) names of the streets at the given postcode
3) street addresses (house number + street name) at the given postcode 

The repository contains a POSTMan collection with a sample requests for each endpoint.

Please note that based on https://alpha.openaddressesuk.org/ the postcode BT486DQ is not recognized and therefore the endpoint call returns no data for it. 