// 게시글 삭제
function goDelete() {
    if (confirm('게시글을 삭제하시겠습니까?')) {
        // 사용자가 '확인'을 선택했을 경우, 삭제 절차 진행
        var parentPostNumber = document.querySelector('input[name="parentPostNumber"]').value;
        var parentNumber = document.querySelector('input[name="parentNumber"]').value;
        // Form을 통해 POST 요청으로 서버에 삭제를 요청하도록 변경
        var form = document.createElement('form');
        form.method = 'post';
        form.action = '/parentcommunity/delete/' + parentPostNumber + '/' + parentNumber;
        document.body.appendChild(form);
        form.submit();
    }
    // 사용자가 '취소'를 선택한 경우, 함수를 종료하고 아무것도 하지 않습니다.
}

// 게시글 수정
function goUpdate() {
    if (!confirm('게시글을 수정하시겠습니까?')) {
        return; // 사용자가 취소를 선택한 경우 아무 것도 하지 않습니다.
    }

    var parentPostNumber = document.querySelector('input[name="parentPostNumber"]').value;
    var parentNumber = document.querySelector('input[name="parentNumber"]').value;
    window.location.href = '/parentcommunity/edit/' + parentPostNumber + '/' + parentNumber;
}