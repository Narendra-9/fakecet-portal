
document.querySelector(".register").addEventListener("click",()=>{
    document.querySelector(".register-container").style.display="flex";
    document.querySelector(".login-container").style.display="none";
})

document.querySelector(".loginnavigate").addEventListener("click",()=>{
    document.querySelector(".register-container").style.display="none";
    document.querySelector(".login-container").style.display="flex";
})
document.querySelector(".login-container-form").addEventListener("submit",(e)=>{
    e.preventDefault();
    window.location.href="./collegeportal.html";

})
document.querySelector(".register-container-form").addEventListener("submit",(e)=>{
    e.preventDefault();
    window.location.href="./collegeportal.html";

})