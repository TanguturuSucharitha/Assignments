greet = function(userName="Sravani"){
    console.log("Hello " + userName);
}

setInterval(() => {greet("Suchi");},2000);

console.log("Program Terminated");