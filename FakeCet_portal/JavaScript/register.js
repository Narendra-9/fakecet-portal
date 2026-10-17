document.querySelector(".appform").addEventListener('submit', (e) => {
    e.preventDefault();
    let valid = true; // Start with valid true
    let hallticketNumber = document.querySelector("#lhallticketnum").value;
    let hallticketNumber10 = document.querySelector("#hallticket10").value;
    let aadharNumber = document.querySelector("#aadhar").value;

    // Reset feedback messages
    document.querySelector(".hallticketfeedback").style.display = "none";
    document.querySelector(".hallticket10feedback").style.display = "none";
    document.querySelector(".aadharnumberfeedback").style.display = "none";

    // Validate 12th Hallticket Number
    if (hallticketNumber.length !== 11) {
        document.querySelector(".hallticketfeedback").style.display = "inline";
        valid = false; 
    }

    // Validate 10th Hallticket Number
    if (hallticketNumber10.length !== 11) {
        document.querySelector(".hallticket10feedback").style.display = "inline";
        valid = false;
    }

    // Validate Aadhar Number
    if (aadharNumber.length !== 12) {
        document.querySelector(".aadharnumberfeedback").style.display = "inline";
        valid = false;
    }

    if (valid) {
        // document.querySelector(".blur-effect").style.display = "block";
        // document.querySelector(".payment-hover").style.display = "flex";
        // document.querySelectorAll("input").forEach(i => i.disabled = true);
        // document.querySelectorAll("select").forEach(i => i.disabled = true);

        window.location.href="./payment.html"

        // document.querySelector(".appform").addEventListener("submit",(e)=>{
        //     e.preventDefault();
        //     window.location.href="./payment.html"
        // })
    }
});


document.querySelector("#lhallticketnum").addEventListener("input", () => {
    let hallticketNumber = document.querySelector("#lhallticketnum").value;
    document.querySelector(".hallticketfeedback").style.display = (hallticketNumber.length === 11) ? "none" : "inline";
});

document.querySelector("#aadhar").addEventListener("input", () => {
    let aadharNumber = document.querySelector("#aadhar").value;
    document.querySelector(".aadharnumberfeedback").style.display = (aadharNumber.length === 12) ? "none" : "inline";
});

document.querySelector("#hallticket10").addEventListener("input", () => {
    let hallticketNumber10 = document.querySelector("#hallticket10").value;
    document.querySelector(".hallticket10feedback").style.display = (hallticketNumber10.length === 11) ? "none" : "inline";
});


document.querySelectorAll("input").forEach(i => i.disabled = true);
document.querySelectorAll("select").forEach(i => i.disabled = true);
document.querySelector("#editoption").disabled=false;

document.querySelector("#editoption").addEventListener('change',()=>{
    if(document.querySelector("#editoption").value=="Yes"){
        document.querySelectorAll("input").forEach(i => i.disabled = false);
        document.querySelectorAll("select").forEach(i => i.disabled = false);
    }
})

// document.querySelector(".done").addEventListener("click", () => {
//     document.querySelector(".blur-effect").style.display = "none";
//     document.querySelector(".payment-hover").style.display = "none";
//     let ReferenceId = "HT" + document.querySelector("#lhallticketnum").value.slice(2);
//     let Regno = "FK" + document.querySelector("#lhallticketnum").value.slice(2);
//     alert("Applied successfully,\nYour Payment Reference Id: " + ReferenceId + "\nYour Registration No: " + Regno);
//     document.querySelector(".submit").classList.add("disabled");
//     const currentDate = new Date();
//     document.querySelector(".status").innerHTML += `<p style="font-weight: 500;">Application Form Submitted on ${currentDate}</p>`;
// });
