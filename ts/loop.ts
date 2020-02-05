var nums : number[] = [11,22,33];
for(var i=0; i<nums.length; i++) {
    console.log(nums[i]);
}

for(var n of nums) {
    console.log(n);
}

for(let n in nums) {
    console.log(n);
}