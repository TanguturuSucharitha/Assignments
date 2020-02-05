var tup = ["C++", 45, 3500];
console.log("Course Name : " + tup[0]);
console.log("Duration : " + tup[1]);
console.log("Fee : " + tup[2]);
console.log("--------------------------------------------------");
// Destructuring (un-packing)
var courseTitle = tup[0], duration = tup[1], fee = tup[2];
console.log("Course Name : " + courseTitle);
console.log("Duration : " + duration);
console.log("Fee : " + fee);
console.log("--------------------------------------------------");
// for of loop
for (var _i = 0, tup_1 = tup; _i < tup_1.length; _i++) {
    var v = tup_1[_i];
    console.log(v);
}
