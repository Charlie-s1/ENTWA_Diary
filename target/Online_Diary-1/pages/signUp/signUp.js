window.addEventListener('load',function(){
    document.querySelector("#sendData").addEventListener('click', sendData);
});

function sendData(){
    const username = document.querySelector("#userName").value;
    const fname = document.querySelector("#fname").value;
    const lname = document.querySelector("#lname").value;
    const add = document.querySelector("#add").value;
    const phone = document.querySelector("#phone").value;
    const email = document.querySelector("#email").value;
    const pass  = document.querySelector("#pass").value;

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "/Online_Diary/signUp");
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    const data = `userName=${username}&pass=${pass}&fname=${fname}
    &lname=${lname}&add=${add}&phone=${phone}&email=${email}&pass=${pass}`;
    
    xhr.onload = function(){
        console.log('Signed in as: ' + xhr.responseText);
        sessionStorage.setItem('id',xhr.responseText);
        window.location.href = "../userHome.html";
    };
    xhr.send(data);
}