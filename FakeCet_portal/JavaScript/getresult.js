function getRndInteger(min, max) {
    return Math.floor(Math.random() * (max - min + 1) ) + min;
  }
  document.querySelector(".formresult").addEventListener('submit',(e)=>{
    e.preventDefault();
    document.querySelector(".result-content").style.display='block';
    let rnumber=document.querySelector("#rnumber").value;
    let hnumber=document.querySelector("#hnumber").value;
    let marks=getRndInteger(0,160);

    document.querySelector("tbody").innerHTML=`<tr>
        <td>${rnumber}</td>
        <td>${hnumber}</td>
        <td>${marks}</td>
      </tr>`
  });