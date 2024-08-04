// paymentcheck.html 로 넘어갈 때, 예약 날짜 pk 넘기기
window.onload = function(){
    const reservationArea = document.querySelector('#reservation-select');
    const paymentBtn = document.querySelector('.payment-btn');
    const proNumber = document.querySelector('input[name="proNumber"]');
    // 수업 날짜 리스트 (select 안에 option 채우기 전)
    let reservationList;
    let selectedReservation; // 선택된 예약정보 (select태그)
    const classNumber = document.querySelector('input[name="classNumber"]').value;
    let reservationDateNumber; // 예약 날짜 pk
    let reservationTimeNumber; // 예약 시간 pk

    // 수업 날짜 리스트 ( option 태그 채우기 )
    reservationList = document.querySelectorAll('.study-date-wrap option');
    // 모든 option을 select태그 하위 태그로 추가
    reservationList.forEach(reservation=>{
        reservationArea.appendChild(reservation);
    });

    // 선택한 예약정보에서 예약날짜 pk만 저장
    reservationArea.addEventListener("change", ()=>{
        selectedReservation = reservationArea.options[reservationArea.selectedIndex];
        reservationDateNumber = selectedReservation.querySelector('#reservationDateNumber');
        reservationTimeNumber = selectedReservation.querySelector('#reservationTimeNumber');
        console.log(reservationDateNumber);
    });

    selectedReservation = reservationArea.options[reservationArea.selectedIndex];
    reservationDateNumber = selectedReservation.querySelector('#reservationDateNumber');
    reservationTimeNumber = selectedReservation.querySelector('#reservationTimeNumber');
    // console.log(reservationDateNumber);
    const role = document.querySelector('input[name="role"]').value;
    console.log(role);

    // 결제하기 버튼 클릭시, 서버로 요청
    paymentBtn.addEventListener("click", (e)=>{
        e.preventDefault();

        if(role !== 'parent'){
            alert('로그인을 먼저 해 주세요.');
        }

        let form = document.createElement('form');
        form.append(reservationDateNumber);
        form.append(proNumber);
        form.append(reservationTimeNumber);

        document.body.append(form);

        form.method = 'get';
        form.action = '/paymentcheck/' + classNumber;
        form.submit();
    });

};

// 뒤로가기 버튼 이벤트
function goBack() {
    // js에서 제공해주는 이전 페이지로 가는 메소드
    // button은 꼭 type="button" 선언 필수!
    window.history.back();
}


















