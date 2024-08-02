document.addEventListener("DOMContentLoaded", function() {
    let check = document.querySelector(".check");
    let checkOut = document.querySelector('.registration_wrap a.check-out');
    
    // 아이찾기 자세히 보기 버튼
    if (check) {
        check.addEventListener("click", function () {
            alert("로그인을 하고 이용을 해주세요!!!");
            window.location.href = '/user/login';
        });
    }
    
    // 수업등록 자세히 보기 버튼
    if (checkOut) {
        checkOut.addEventListener("click", function () {
            alert("로그인을 하고 이용을 해주세요!!!");
            window.location.href = '/user/login';
        });
    }

});