simpleGreetProvider = function(){
    return "Hello ";
}

timelyGreetProvider = function(){
    greet="";

    hour = (new Date()).getHours();

    if (hour>=3 && hour<=11) greet="Good Morning ";
    else if(hour<=15) greet="Good Afternoon ";
    else greet="Good Evening ";

    return greet;
}

function greetUser(userName,greetProvider){
    return greetProvider() + " " + userName;
}
console.log(greetUser("SUCHI", simpleGreetProvider));

console.log(greetUser("SUCHI",timelyGreetProvider));

console.log(greetUser("SUCHI", function() { return "Sasriakal ";}));

console.log(greetUser("SUCHI",()=>"Namasthey "));

console.log(greetUser("SUCHI",()=>"Vanakkam "));
console.log(greetUser("SUCHI",()=>"Namaskar "));
(function(){
    console.log("has to execute her right away..!");    
})();
