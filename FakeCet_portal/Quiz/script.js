let question=document.querySelector("#Question")
let options=document.querySelectorAll(".opt") 
let crt=document.querySelector(".crt-ans")
let addqbtn=document.querySelector(".addq")
let questions={}


addqbtn.addEventListener('click',addquestion)

if(!localStorage.getItem('qcnt')){
    localStorage.setItem('qcnt',1);
}




function addquestion(){
    let q=[]
    q.push(question.value)
    for(opt of options){
        q.push(opt.value)
    }
    q.push(crt.value)
    localStorage.setItem(localStorage.getItem('qcnt'),q)
    localStorage.setItem('qcnt',parseInt(localStorage.getItem('qcnt'))+1);
    question.value=''
    for(opt of options){
        opt.value=''
    }
    crt.value='';
}