// 이미지 슬라이드 관련 변수 및 이벤트
const sliderBox = document.querySelector(".slider-box");
const sliderItems = document.querySelectorAll(".slider-item");
const btns = document.querySelectorAll(".slider-btn");

// transition 동작이 끝나고 난 뒤, 실행되는 메서드
// 트랜지션 효과가 끝날때마다 실행되므로 두 번 실행됨. -> 트랜지션 효과 제거해서 1번만 실행하도록 한다.
sliderBox.ontransitionend = ()=>{
  
  // 기준 위치인 transform(-100%) 에서 왼쪽 버튼은 0%로 이동, 오른쪽 버튼은 -200% 이동한다.
  if(sliderBox.style.transform === 'translateX(-200%)'){
    // 오른쪽을 클릭한 경우, 트랜지션이 끝난 후 실행됨.
    let copy = sliderBox.children[0].cloneNode(true); // 첫째 이미지 복제
    sliderBox.children[0].remove(); // 첫째 이미지 삭제
    sliderBox.appendChild(copy); // 첫번째 이미지를 마지막 이미지로 추가
    
  }else{
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
})

// ===========================================================
// 더 보기 버튼 및 내용에 관련된 js.

const hiddenContent = document.querySelector(".hidden-content");
const moreBtn = document.querySelector(".study-more-btn");

moreBtn.addEventListener('click', ()=>{

  // open 클래스 여부에 따라 다른 화살표가 나타나도록 css 설정
  moreBtn.classList.toggle("open");
  // hidden 클래스 여부에 따라 height를 다르게 설정 
  hiddenContent.classList.toggle("hidden");

  // 버튼의 내용을 클릭할 때마다 변경
  if(moreBtn.children[0].textContent === '수업 더 보기'){
    moreBtn.children[0].textContent = "접기";
  }else{
    moreBtn.children[0].textContent = "수업 더 보기";
  }
});

// =========================================================

const loginId = $('input[name="loginId"]').val();

// 날짜 포맷
function formatDate(dateString) {
    const now = new Date();
    const reviewDate = new Date(dateString); // 문자열을 Date 객체로 변환

    const nowYear = now.getFullYear();
    const nowMonth = now.getMonth();
    const nowDate = now.getDate();

    const reviewYear = reviewDate.getFullYear();
    const reviewMonth = reviewDate.getMonth();
    const reviewDateDate = reviewDate.getDate();

    let displayText = "";

    // 년, 월, 일이 모두 같은 경우 "오늘"로 표시
    // if (nowYear === commentYear && nowMonth === commentMonth && nowDate === commentDateDate) {
    //     displayText = "오늘";
    // } else {
    // 그 외의 경우, 정해진 포맷으로 표시
    const yy = reviewYear.toString().slice(-2); // 마지막 두 자리를 가지고 옴.
    const M = reviewMonth + 1; // 월은 0부터 시작하므로 1을 더해줍니다.
    const d = reviewDateDate;
    const HH = reviewDate.getHours().toString().padStart(2, '0');
    const mm = reviewDate.getMinutes().toString().padStart(2, '0'); // 두자리 수 일 때 앞에 0을 붙임.

    displayText = `${yy}년 ${M}월 ${d}일 ${HH}시 ${mm}분`;
    // }
    return displayText;
}

// 페이지가 로드된 이후에 리뷰 목록 조회 함수가 실행되도록 한다.
$(document).ready(function () {
    let classNumber = $('input[name="classNumber"]').val();
    getReviews(classNumber);
})

// 댓글 목록 조회 함수
function getReviews(classNumber) {
    $.ajax({
        method : 'get',
        url : '/reviews/' + classNumber,
        success : function(reviews) {
            let reviewListArea = $('.review-list')

            // 댓글이 작성될 해당 섹션 비우기.
            reviewListArea.empty();

            // 댓글 없을 때 표시할 html
            if(reviews.length === 0){
                reviewListArea.append(
                    `<div>첫번째 댓글을 남겨주세요!</div>`
                );
            }

            // 리뷰 있을 때 목록을 뿌려줄 반복문.
            reviews.forEach(function(review) {
                let reviewDate = formatDate(review.reviewRegisterDate);
                let buttons = '';
                let editStr = '';

                // 작성일과 수정일을 비교해서 html 에 다른 모양으로 표시.
                if(review.reviewUpdateDate !== review.reviewRegisterDate){
                    reviewDate = formatDate(review.reviewUpdateDate);
                    editStr = ' (수정)';
                }

                // 종합적으로 뿌려줄 html
                let reviewElement = `
                        <li class="review-item" id="review-${review.reviewNumber}">
                          <input type="hidden" name="reviewNumber" value="${review.reviewNumber}" />
                          <textarea name="review-content" class="review-content" readonly>${review.reviewContent}</textarea>
                          <div>
                            <p>등록일 : <span>${reviewDate}${editStr}</span></p>
                            <p>수정일 : <span>${reviewDate}${editStr}</span></p>
                          </div>
                        </li>
                    `
                // 해당 섹션에 추가
                // 댓글의 갯 수 만큼 차례대로 추가될 것이다.
                reviewListArea.append(reviewElement);
            })
        },
        error : function(data) {
            console.error(data, "불러오기 실패");
        }
    })
}


// paymentcheck.html 로 넘어갈 때, 예약 날짜 pk 넘기기
window.onload = function(){
    const reservationArea = document.querySelector('#reservation-select');
    const reservationForm = document.querySelector('.detail-right-area > form:nth-child(1)');
    const paymentBtn = document.querySelector('.payment-btn');
    // 수업 날짜 리스트 (select 안에 option 채우기 전)
    let reservationList;

    let selectedReservation; // 선택된 예약정보 (select태그)
    const classNumber = document.querySelector('input[name="classNumber"]').value;
    let reservationDateNumber; // 예약 날짜 pk

  // 수업 날짜 리스트 ( option 태그 채우기 )
    reservationList = document.querySelectorAll('.study-date-wrap option');
    // 모든 option을 select태그 하위 태그로 추가
    reservationList.forEach(reservation=>{
      reservationArea.appendChild(reservation);
    });

    // 선택한 예약정보에서 예약날짜 pk만 저장
    reservationArea.addEventListener("change", ()=>{
      selectedReservation = reservationArea.options[reservationArea.selectedIndex];
      reservationDateNumber = selectedReservation.querySelector('#reservationDateNumber').value;
    });

    // 결제하기 버튼 클릭시, 서버로 요청
    paymentBtn.addEventListener("click", ()=>{
      reservationForm.method = 'get';
      reservationForm.action = '/paymentcheck/' + reservationDateNumber + '/' + classNumber;
      reservationForm.submit();
    });

};















