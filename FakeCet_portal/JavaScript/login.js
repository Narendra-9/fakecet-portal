document.querySelector(".login-container-form").addEventListener("submit",(e)=>{
    e.preventDefault();
    document.querySelector(".login-container").style.display="none";
    document.querySelector(".login-containerr").style.display="flex";

})

document.querySelector(".verifyotp").addEventListener("submit",(e)=>{
    e.preventDefault();
    window.location.href="./applycolleges.html"
})