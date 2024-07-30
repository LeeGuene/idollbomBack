// 여기서 데이터 넘기기
function pointSave(pay) {
    $.ajax({
        url: "/pay/rest/chargingOk",
        type: "post",
        data: JSON.stringify(pay),
        contentType: "application/json; charset=utf-8",
        success: function(result) {
            // 결제 성공하면 마이페이지 결제 내역으로 이동
            window.location.href = '/ParentMyPage/myPayment'
        },

        error: function () {
            console.error("AJAX 호출 실패");
            alert('결제 처리 중 오류가 발생했습니다.')
        }
    });
}

// js 에서 비동기 처리를 더 쉽게 관리하기 위해서 사용한다.
async function kakaoPay() {
    // 결제 요청을 보내고 응답을 받을 때 까지 시간이 걸리기 때문에
    // 결제 완료가 될 때까지 기다려라 라는 의미!
    const response = await Bootpay.requestPayment({
        "application_id": "59a4d323396fa607cbe75de4", /*WEB Application ID*/
        "price": $("#money").val(), /*결제 요청할 금액*/
        "order_name": $("#classname").val(), /*결제할 상품명*/
        "order_id": 'order_id_' + new Date().getTime(), /*주문번호*/
        "pg": "카카오페이", /*결제 요청할 PG Symbol*/
        "method": "간편", /*결제 요청할 결제수단 symbol*/
        // "user": { /*구매자 정보*/
        //     "id": $("#user").val()
        // },
        "items": [
            {
                "id": 'id_' + new Date().getTime(), /*상품의 고유 ID*/
                "name": $("#classname").val(), /*상품명*/
                "qty": 1, /*상품 구매 개수*/
                "price": $("#money").val() /*상품 하나의 단가*/
            }
        ],
        "extra": {
            "open_type": "iframe", /*결제창 진행방식*/
            "seller_name": "관리자", /*판매자 이름*/
        }
    })
    switch (response.event) {
        case 'done':
            // 결제 완료 처리
            pointSave({
                parentNumber: $("#parentId").val(),
                reservationDateNumber: $("#classDate").val(),
                reservationTimeNumber: $("#classTime").val(),
                childNumber: $("#childLists").val()
            });
            break;
    }
}

// 결제하기 버튼을 누르면 함수 실행
$(".kakaoPay").on("click", function () {
    let selectBox = document.getElementById('childLists')

    // 만약 아이를 선택하지 않았다면
    if(selectBox.value === 'none'){
        alert('아이를 선택해주세요.')
    }
    else{
        kakaoPay();
    }
})

// 뒤로가기 버튼을 눌렀을 때
function goBack() {
    // js에서 제공해주는 이전 페이지로 가는 메소드
    // button은 꼭 type="button" 선언 필수!
    window.history.back();
}
