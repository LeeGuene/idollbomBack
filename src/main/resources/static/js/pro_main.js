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

    // 메인 페이지 상단 배너 슬라이드 js
    // 이미지 슬라이드 관련 변수 및 이벤트
    const sliderBox = document.querySelector(".slider-box");
    console.log(sliderBox);
    const sliderItems = document.querySelectorAll(".slider-item");
    const btns = document.querySelectorAll(".slider-btn");
    console.log(btns);

    sliderBox.ontransitionend = ()=> {
        // 기준 위치인 transform(-100%) 에서 왼쪽 버튼은 0%로 이동, 오른쪽 버튼은 -200% 이동한다.
        if (sliderBox.style.transform === 'translateX(-200%)') {
            // 오른쪽을 클릭한 경우, 트랜지 션이 끝난 후 실행됨.
            let copy = sliderBox.children[0].cloneNode(true); // 첫째 이미지 복제
            sliderBox.children[0].remove(); // 첫째 이미지 삭제
            sliderBox.appendChild(copy); // 첫번째 이미지를 마지막 이미지로 추가

        } else {
            // 왼쪽을 클릭한 경우, 트랜지션이 끝난 후 실행됨.
            let copy = sliderBox.lastElementChild.cloneNode(true); // 이미지 복제
            sliderBox.lastElementChild.remove(); // 기존 이미지 삭제
            sliderBox.firstElementChild.before(copy); // 마지막 이미지를 가장 앞쪽에 배치
        }

        // 공통 코드 ( 반드시 if문 아래쪽에 입력해야 한다!! )
        sliderBox.style.transition = '0s'; // 트랜잭션 제거
        sliderBox.style.transform = 'translateX(-100%)'; // 원래 기준위치로 이동
    }

    // 이미지 슬라이드 관련됨.
    btns.forEach(btn=>{
        btn.addEventListener("click", ()=>{

            // 위에서 트랜지션 효과가 없어졌으므로 클릭할 때마다 다시 트랜지션을 추가해야 한다.
            if(btn.classList.contains("right")){
                sliderBox.style.transform = 'translateX(-200%)';
                sliderBox.style.transition = '1s';

            }

            if(btn.classList.contains("left")){
                sliderBox.style.transform = `translateX(0%)`;
                sliderBox.style.transition = '1s';

            }
        });
    });


});