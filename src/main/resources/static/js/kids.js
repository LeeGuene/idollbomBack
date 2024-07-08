$(document).ready(function() {

    $('.delete-button').click(function () {
        let childNumber = $(this).attr('data-kid-number');
        console.log(childNumber);
        deleteInfo(childNumber);
    });

    $('.updateBt').click(function () {
        let childNumber = $(this).attr('data-kid-number');
        console.log(childNumber);
        editInfo(childNumber);
    });

    $('#update-form').submit(function (event) {
        //페이지 새로고침 방지
        event.preventDefault();
        updateInfo();

    });
});

// 수정될 아이 받아오기
function editInfo(childNumber){
        $.ajax({
            method: 'get',
            url: '/ParentMyPageRest/kidById',
            contentType: 'application/json',
            data: { childNumber: childNumber },
            success: function(data) {
                console.log(data);
                console.log("데이터 가져오기 성공");
                console.log(data.childName)
                // 이름가져오기
                $('#Kidname').val(data.childName);
                // 성별 가져오기
                if (data.childGender === '남자') {
                    $('#male').prop('checked', true); // '남자' 라디오 버튼을 선택함
                } else if (data.childGender === '여자') {
                    $('#female').prop('checked', true); // '여자' 라디오 버튼을 선택함
                }
                // 세부정보 가져오기
                $('#Kidtextarea').val(data.childSpecialIssues);
                $('#childNumber').val(data.childNumber);
                $('#parentNumber').val(data.parentNumber);

            },
            error: function(data) {
                console.error("데이터 가져오기 실패", data);
            }
        });
    }

// 아이 삭제 요청
function deleteInfo(childNumber) {
    $.ajax({
        method: 'post',
        url: '/ParentMyPage/deleteKids',
        contentType: 'application/json',
        data: JSON.stringify(childNumber),
        success: function(data) {
            console.log("삭제 성공");
            // 페이지 새로고침
            window.location.reload();
        },
        error: function(data) {
            console.error("삭제 실패", data);
        }
    });
}

// 아이정보 업데이트
function updateInfo() {
    let formData = {
        childNumber: $('#childNumber').val(),
        parentNumber: $('#parentNumber').val(),
        childName: $('#Kidname').val(),
        childAge: $('#Kidbirthday').val(),
        childGender: $('input[name="childGender"]:checked').val(),
        childSpecialIssues: $('#Kidtextarea').val()
    };

    console.log(formData.childNumber);

    $.ajax({
        url: '/ParentMyPageRest/updateKids/' + formData.childNumber,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(formData),
        success: function (response) {
            console.log('업데이트 성공:', response);
            // 페이지 새로고침
            window.location.reload();
        },
        error: function (error) {
            console.error('업데이트 실패:', error);
        }
    });
}
