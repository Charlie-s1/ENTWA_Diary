window.addEventListener('load',function(){
    document.querySelector("#menuIcon").addEventListener('click', showMenu);
});

function showMenu(){
    const menu = document.querySelector("#menu");
    menu.classList.toggle("showMenu");
    menu.classList.toggle("hideMenu");    
    
    
}
