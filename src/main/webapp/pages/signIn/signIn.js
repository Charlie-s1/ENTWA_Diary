window.addEventListener('load',function(){
    document.querySelector("#sendData").addEventListener('click', sendData);
});

function sendData(){
    const username = document.querySelector("#userName").value;
    const password = document.querySelector("#password").value;

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "/Online_Diary/signIn");
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    const data = `userName=${username}&password=${password}`;
    xhr.onload = function(){
        console.log('Signed in as: ' + xhr.responseText);
        sessionStorage.setItem('id',xhr.responseText);
        window.location.href = "../userHome.html";
    }
    xhr.send(data);
}