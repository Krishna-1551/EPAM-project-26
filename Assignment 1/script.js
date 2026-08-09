// Getting the HTML elements
let coupons = [
    "DIWALI100",
    "FESTIVE200",
    "BANK300",
    "LUCKY500",
    "SUPER1000"
];
let isCustomerValid = false;

let registerButton = document.getElementById("registerBtn");

let registerSection = document.getElementById("registerSection");

// Hide the registration section when the page loads

registerSection.style.display = "none";

// Show the registration section when Register is clicked

registerButton.addEventListener("click", function () {

    registerSection.style.display = "block";

});
let customerInput = document.getElementById("customerId");

let validateButton = document.getElementById("validateBtn");

let message = document.getElementById("message");
let couponButton = document.getElementById("couponBtn");
validateButton.addEventListener("click", function () {

    let customerId = customerInput.value;

   if (
    customerId === "1001" ||
    customerId === "1002" ||
    customerId === "1003"
) {

    isCustomerValid = true;

    message.innerHTML = "✅ Customer Validated Successfully";

}
    else {

        message.innerHTML = "❌ Invalid Customer ID";

    }

});
couponButton.addEventListener("click", function () {

    if (isCustomerValid) {

        let randomIndex = Math.floor(Math.random() * coupons.length);

        let coupon = coupons[randomIndex];

        message.innerHTML = "🎉 Congratulations! Your Coupon is: " + coupon;

    }
    else {

        message.innerHTML = "❌ Please validate your Customer ID first.";

    }

});
