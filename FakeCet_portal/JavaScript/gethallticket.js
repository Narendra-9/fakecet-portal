function getRndInteger(min, max) {
    return Math.floor(Math.random() * (max - min + 1) ) + min;
  }
  document.querySelector(".formresult").addEventListener('submit',(e)=>{
    e.preventDefault();
    // document.querySelector(".overlay").style.display='block';
    // document.querySelector(".rank-card").style.display='block';
    // let rnumber=document.querySelector("#rnumber").value;
    // let dob=document.querySelector("#dob").value;
    let HallticketNumber=getRndInteger(10000000,99999999);
    // document.querySelector(".hno").innerHTML+=`<h5>HallticketNo : ${HallticketNumber}<h5>`;
    // document.querySelector(".center").innerHTML+=`<p style="font-size:15px; font-weight:500;">Centre : ION digital, Luthergiri, Rajamahendravaram, Andhra Pradesh 533105<p>`;
    let element=document.createElement("div");
    element.className="hall-ticket";
    element.innerHTML=`<h1>Hall Ticket for FAKECET-2024</h1>
        <div class="details">
            <p><strong>Hall Ticket Number:</strong> ${HallticketNumber}</p>
            <p><strong>Exam Name:</strong> FakeCET</p>
            <p><strong>Exam Centre:</strong> ION Digital Luthergiri,Rajeev Gandhi College,Rajahmundry</p>
            <p><strong>Date:</strong> October 20, 2024</p>
            <p><strong>Time:</strong> 9:00 AM - 12:00 PM</p>
        </div>
        <div class="instructions">
            <h2>Instructions:</h2>
            <ul>
                <li>Bring a valid ID proof along with this hall ticket.</li>
                <li>Reach the exam centre at least 30 minutes before the start time.</li>
                <li>No electronic devices are allowed in the examination hall.</li>
                <li>Follow the COVID-19 guidelines as per the government regulations.</li>
            </ul>
        </div>`;
    
    html2pdf().from(element).save();
    
  });

//   function downloadform(){
//     console.log("helo")
// let ticketno=document.querySelector("#ticketno").value;
// let dobno=document.querySelector("#dobno").value;
// let myno=document.querySelector("#myno").value;
// let element=document.createElement("div");
// element.innerHTML= '<h1>Hall ticket</h1>' +
// '<p>HallTicket NO: ' + ticketno+ '</p>' +
// '<p>DOB:: ' + dobno + '</p>'+`<p>Number`+myno +`<p>`;
// html2pdf().from(element).save();
// }

  // document.querySelector(".close-btn").addEventListener('click',()=>{
  //   document.querySelector(".overlay").style.display='none';
  //   document.querySelector(".rank-card").style.display='none';

  //   document.querySelector(".hno").innerHTML="";
  //   document.querySelector(".center").innerHTML="";

  // })