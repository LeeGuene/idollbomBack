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

// 댓글 관련 ajax
// 날짜 포맷
function formatDate(dateString) {
    const now = new Date();
    const commentDate = new Date(dateString); // 문자열을 Date 객체로 변환

    const nowYear = now.getFullYear();
    const nowMonth = now.getMonth();
    const nowDate = now.getDate();

    const commentYear = commentDate.getFullYear();
    const commentMonth = commentDate.getMonth();
    const commentDateDate = commentDate.getDate();

    let displayText = "";

    // 년, 월, 일이 모두 같은 경우 "오늘"로 표시
    if (nowYear === commentYear && nowMonth === commentMonth && nowDate === commentDateDate) {
        displayText = "today";
    } else {
        // 그 외의 경우, 정해진 포맷으로 표시
        const yy = commentYear.toString().slice(-2); // 마지막 두 자리를 가지고 옴.
        const M = commentMonth + 1; // 월은 0부터 시작하므로 1을 더해줍니다.
        const d = commentDateDate;
        const HH = commentDate.getHours().toString().padStart(2, '0');
        const mm = commentDate.getMinutes().toString().padStart(2, '0'); // 두자리 수 일 때 앞에 0을 붙임.

        // 날짜 형식은 여기서 바꿔주기만 하면 끝!
        displayText = `${yy}년 ${M}월 ${d}일 ${HH}시 ${mm}분`;
    }
    return displayText;
}

// 현재 로그인된 PK를 가지고옴
// html에서 받아온 값이 string이어서 형변환을 해줘야함
const loginId = parseInt($('input[name="loginId"]').val())

// 페이지가 처음 로드될 때 댓글 목록 조회 함수가 실행되도록 한다.
$(document).ready(function (){
    let parentPostNumber = $('input[name="parentPostNumber"]').val()
    getComments(parentPostNumber)
    console.log(loginId)
    console.log(parentPostNumber)
})

// 댓글 목록 조회 함수
function getComments(parentPostNumber){
    $.ajax({
        method: 'get',
        url: '/comments/' + parentPostNumber,
        success: function(data){ // 200이 넘어온다면
            let commentListArea = $('.comment-list')

            // 댓글이 작성될 해당 섹션 비우기
            // 이 함수가 호출될 때마다 새롭게 select load하기 위해
            commentListArea.empty()

            // 댓글이 없다면 표시할 html
            if(data.length === 0){
                commentListArea.append(
                    `<div class="alert alert-info">
                        첫 번째 댓글을 남겨주세요!
                    </div>`
                )
            }

            // 댓글이 존재한다면 목록을 뿌려줄 반복문
            data.forEach(function (comment){
                let commentDate = formatDate(comment.parentCommentRegisterDate)
                let buttons = ''
                let editStr = ''
                console.log(typeof loginId)
                console.log(typeof comment.parentNumber)
                console.log(loginId === comment.parentNumber)

                // 작성일과 수정일을 비교해서 html에  (수정) 을 뿌려주기 위해서
                if(comment.parentCommentUpdateDate !== comment.parentCommentRegisterDate){
                    commentDate = formatDate(comment.parentCommentUpdateDate)
                    editStr = '(수정)'
                }

                // 현재 로그인된 계정과 댓글 작성자가 동일하다면 버튼 생성
                if(loginId === comment.parentNumber){
                    buttons = `
                        <!-- 수정, 삭제 버튼 -->
                         <div class="comment-actions">
                            <button onclick="updateComment(${comment.parentCommentNumber})">수정</button>
                            <button onclick="deleteComment(${comment.parentCommentNumber})">삭제</button>
                        </div>
                   `
                }

                // 종합적으로 뿌려주는 댓글 부분
                let commentElement = `
               <div class="comment-card" id="comment-${comment.parentCommentNumber}">
                    <div class="comment-body">
                        <div class="comment-title">${comment.parentNickName}</div>
                        <div class="comment-subtitle">${commentDate}${editStr}</div>
                        <p class="comment-text">${comment.parentCommentContent}</p>
                        <!-- 수정, 삭제 버튼 -->
                        ${buttons}
                    </div>
                </div>
               `
                // 해당 섹셔에 추가
                // 댓글에 개수만큼 차례대로 추가될 것!
                commentListArea.append(commentElement)
            })
        },
        error: function (data){
            console.log(data, "불러오기 실패")
        }
    })
}

// 댓글 추가
function addComment(){
    let parentPostNumber = $('input[name="parentPostNumber"]').val()
    let parentCommentContent = $('#commentContent').val()

    // textarea 비어있으면 경고
    if(!parentCommentContent){
        alert('내용을 입력하세오.')
        return
    }

    $.ajax({
        method: 'post',
        url: '/comments',
        // 데이터를 json 형태로 읽을게~
        contentType: 'application/json',
        data: JSON.stringify({
            parentPostNumber: parentPostNumber,
            parentCommentContent: parentCommentContent,
            parentNumber: loginId
        }),
        success: function (data){
            $('#commentContent').val('')
            getComments(parentPostNumber)
        },
        error: function (data){
            alert('왜 안되는거야?')
            console.log(data)
        }
    })
}

// 댓글 삭제
function deleteComment(parentCommentNumber){
    // 매개 변수로 pk 잘 넘어왔는지 확인.
    // alert(commentId)
     console.log(parentCommentNumber)

    if(!confirm('정말로 삭제하시겠습니까?')){
        return;
    }

    $.ajax({
        method : 'delete',
        url : '/comments/' + parentCommentNumber,
        success : function(data) {
            console.log(data, '삭제 성공')
            getComments($('input[name="parentPostNumber"]').val());
        },
        error : function(data) {
            console.error(data, '삭제 실패')
        }
    })
}

// 댓글 수정 폼 생성 함수
function createEditForm(parentCommentNumber, currentContent){
    return `
        <div class="mb-3">
            <textarea class="form-control comment-edit-content" style="resize: none" rows="3">${currentContent}</textarea>
        </div>
        <button class="update" onClick="editComment(${parentCommentNumber})">수정완료</button>
        <button class="delete" onClick="cancelEdit()">취소</button>
    `
}

// 수정 삭제 버튼 중 수정을 눌렀을 때
function updateComment(parentCommentNumber) {
    // 기존 댓글 내용을 가지고 와서, 수정 폼에 넣는다.
    let comment = $(`#comment-${parentCommentNumber}`);
    let content = comment.find('.comment-text').text()
    comment.find('.comment-body').html(createEditForm(parentCommentNumber, content))
}

// 수정 완료 버튼 눌렀을 때
function editComment(parentCommentNumber){
    let comment = $(`#comment-${parentCommentNumber}`);
    // textarea 는 속성이 두 개 존재
    // 데이터를 뿌려줄 때는 text, 입력한 데이터를 가져올 때는 value
    let updateContent = comment.find('.comment-edit-content').val()

    $.ajax({
        method : 'put',
        url : '/comments/' + parentCommentNumber,
        contentType: 'application/json',
        data: JSON.stringify({
            parentCommentContent : updateContent
        }),
        success : function(data) {
            console.log('수정 성공')
            getComments($('input[name="parentPostNumber"]').val());
        },
        error : function(data) {
            console.log('수정 삭제')
        }
    })
}

// 취소 버튼 눌렀을 때
function cancelEdit(){
    getComments($('input[name="parentPostNumber"]').val());
}

// 신고횟수에 따른 게시글 스타일 수정
// 게시글에 대한 횟수로 하자 > 컬럼 필요
// 부모는 나중에 강제탈퇴를 시키기 위함
document.addEventListener("DOMContentLoaded", function() {
    // 게시글 컨테이너를 선택
    let postContainer = document.getElementById("postContainer");

    // 게시글 횟수를 가져옴
    let reportCount = document.querySelector('#reportCount').val()

    // 신고 횟수 기준 설정
    let reportLimit = 1; // 예: 10회 이상 신고된 게시글 차단

    // 신고 횟수가 기준을 초과하면 게시글을 숨김
    if (reportCount >= reportLimit) {
        postContainer.innerHTML = "<p>이 게시글은 신고 횟수가 많아 더 이상 열람할 수 없습니다.</p>";
        postContainer.style.display = "none"; // 게시글 숨기기
        // 또는 다른 스타일을 적용할 수도 있습니다.
    }
});

