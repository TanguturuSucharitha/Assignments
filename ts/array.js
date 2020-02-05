var marks;
marks = [60, 70, 66];
var subjects = ["Java", "TypeScript", "Angular", "Mongo DB", "Node JS", "Express JS", "React JS"];
for (var _i = 0, subjects_1 = subjects; _i < subjects_1.length; _i++) {
    var sub = subjects_1[_i];
    console.log(sub);
}
subjects.push("jQuery");
subjects.push("ES6");
console.log("-------------------------------");
for (var _a = 0, subjects_2 = subjects; _a < subjects_2.length; _a++) {
    var sub = subjects_2[_a];
    console.log(sub);
}
console.log("-------------------------------");
console.log("Top Element = " + subjects.pop());
console.log("-------------------------------");
console.log(subjects.slice(1, 5));
console.log("-------------------------------");
console.log(subjects.splice(2, 0, "Angular 8"));
for (var _b = 0, subjects_3 = subjects; _b < subjects_3.length; _b++) {
    var sub = subjects_3[_b];
    console.log(sub);
}
console.log("-------------------------------");
var str = subjects.join(" + ");
console.log(str);
