function getRndInteger(min, max) {
    return Math.floor(Math.random() * (max - min + 1) ) + min;
  }
  // document.querySelector(".formresult").addEventListener('submit',(e)=>{
  //   e.preventDefault();
  //   document.querySelector(".overlay").style.display='block';
  //   document.querySelector(".rank-card").style.display='block';
  //   let rnumber=document.querySelector("#rnumber").value;
  //   let hnumber=document.querySelector("#hnumber").value;
  //   let dob=document.querySelector("#dob").value;
  //   let rank=getRndInteger(1,1000000);

  //   document.querySelector(".rno").innerHTML+=`<h5>RollNo : ${rnumber}<h5>`;
  //   document.querySelector(".hno").innerHTML+=`<h5>HallticketNo : ${hnumber}<h5>`;
  //   document.querySelector(".dob").innerHTML+=`<h5>DOB : ${dob}<h5>`;
  //   document.querySelector(".rankfield").innerHTML+=`<h5>Rank : ${rank}<h5>`;


    
  // });

  // document.querySelector(".close-btn").addEventListener('click',()=>{
  //   document.querySelector(".overlay").style.display='none';
  //   document.querySelector(".rank-card").style.display='none';

  //   document.querySelector(".rno").innerHTML="";
  //   document.querySelector(".hno").innerHTML="";
  //   document.querySelector(".dob").innerHTML="";
  //   document.querySelector(".rankfield").innerHTML="";

  // })


  document.querySelector(".formresult").addEventListener('submit',(e)=>{
    e.preventDefault();
    let maths=getRndInteger(40,80);
    let physics=getRndInteger(20,40);
    let Chemistry=getRndInteger(20,40);
    let rnumber=document.querySelector("#rnumber").value;
    let HallticketNumber=document.querySelector("#hnumber").value;
    let element=document.createElement("div");
    element.className="student-info";
    element.innerHTML=`<h1>Rank Card</h1>
        <div class="student-info">
            <p><strong>Registrationnumber</strong>${rnumber}</p>
            <p><strong>HallticketNumber</strong>${HallticketNumber}</p>
        </div>
        <div class="marks">
            <table>
                <thead>
                    <tr>
                        <th>Subject</th>
                        <th>Marks</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Maths</td>
                        <td>${maths}</td>
                    </tr>
                    <tr>
                        <td>Physics</td>
                        <td>${physics}</td>
                    </tr>
                    <tr>
                        <td>Chemistry</td>
                        <td>${Chemistry}</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="total">
            <p><strong>Total Marks:</strong>${maths+physics+Chemistry}</p>
            <p><strong>Rank:</strong>${getRndInteger(2000,4000)}</p>
        </div>`;
    
    html2pdf().from(element).save();
    
  });