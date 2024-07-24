document.addEventListener("DOMContentLoaded", function() {
    let check = document.querySelector(".check");

    if(check){
        check.addEventListener("click", function(){
            alert("로그인을 하고 이용을 해주세요!!!");
            window.location.href = '/user/login';
        })
    }
});