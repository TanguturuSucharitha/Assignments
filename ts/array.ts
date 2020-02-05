var marks : number[];
marks = [60,70,66];

var subjects : string[] = ["Java", "TypeScript","Angular","Mongo DB","Node JS","Express JS","React JS"];

for(var sub of subjects) {
    console.log(sub);
}

subjects.push("jQuery");
subjects.push("ES6");

console.log("-------------------------------");
for(var sub of subjects) {
    console.log(sub);
}

console.log("-------------------------------");
console.log("Top Element = " + subjects.pop());

console.log("-------------------------------");

console.log(subjects.slice(1,5));       
console.log("-------------------------------");
console.log(subjects.splice(2,0,"Angular 8"));
for(var sub of subjects) {
    console.log(sub);
}
console.log("-------------------------------");
var str = subjects.join(" + ");
console.log(str);





