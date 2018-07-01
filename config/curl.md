#### get All Restaurants
curl -s http://localhost:8080/voting/rest/admin/restaurant

#### get Restaurant By Name
curl -s http://localhost:8080/voting/rest/admin/restaurant/byName?name=Taco%20Bell

#### get Restaurant By Id
curl -s http://localhost:8080/voting/rest/admin/restaurant/100002

#### save Restaurant
curl -s -X POST -d '{"name":"TDGarden"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/voting/rest/admin/restaurant

//#### delete Restaurant
//curl -s -X DELETE http://localhost:8080/voting/rest/admin/restaurant/100002

#### get All Today Lunch
curl -s http://localhost:8080/voting/rest/admin/restaurant/menu

#### set Today Restaurant Lunch
curl -s -X POST -d '{"description":"stack,ketchup,vine","price":"20"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/voting/rest/admin/restaurant/100002/menu

#### get Today Menu
curl -s http://localhost:8080/voting/rest/user/menu

#### set user Vote
curl -s -X POST -d '{"description":"stack,ketchup,vine","price":"20","restaurant":{"id":100002,"name":"Taco Bell"}}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/voting/rest/user/100010

#### getAll users
curl -s http://localhost:8080/voting/rest/user

#### get user vote
curl -s http://localhost:8080/voting/rest/user/100010