$(document).ready(function() {
    $('.delete-button').click(function() {
        let childNumber = $(this).attr('data-kid-number');
        console.log(childNumber);
        deleteInfo(childNumber);
    });

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
});
