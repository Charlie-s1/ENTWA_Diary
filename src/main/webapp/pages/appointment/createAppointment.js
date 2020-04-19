window.addEventListener('load',function(){
    document.querySelector("#sendData").addEventListener('click', sendData);
});

function sendData(){
    const startData = document.querySelector("#start").value;
    const endData = document.querySelector("#end").value;
    const title = document.querySelector("#title").value;
    const desc = document.querySelector("#desc").value;

    start = startData.replace("T", " ") + ":00";
    end = endData.replace("T", " ") + ":00";

    console.log(start,end)
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "/Online_Diary/createAppointment");
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    const data = `start=${start}&end=${end}&title=${title}&desc=${desc}
                                    &id=${sessionStorage.getItem("id")}`;

    xhr.send(data);
}