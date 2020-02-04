greet = function(userName="Anji"){
    console.log("Hello " + userName);
}

setTimeout(greet,2000);
setTimeout(()=>{greet("Suchi");},1000);
console.log("Program Terminated");