// $(document).ready(function() {
//     prevImage();
//     test();
//     document.querySelector("#searchAddress").addEventListener("click", execDaumPostcode);
// });

// 이미지를 미리 불러오는 js
function prevImage(input) {
    if (input.files && input.files[0]) {
        let reader = new FileReader();
        reader.onload = function (e) {
            document.getElementById('preview').src = e.target.result;

        };
        reader.readAsDataURL(input.files[0]);
    } else {
        document.getElementById('preview').src = "";

    }
}

//유효성검사
function test() {
    let p1 = document.getElementById('childName').value;
    let p2 = document.getElementById('childInstruct').value;
    let p3 = document.getElementById('presentNew').value;

    if (p3 != p2) {
        alert("비밀번호가 일치 하지 않습니다");
        return false;
    } else if (p1 == p3) {
        alert("현재 비밀번호와 같습니다");
        return false;
    } else {
        var newPassword = document.getElementById('hiddenPassword');
        newPassword.value = p2;
        console.log(p2);
        const btnSubmitModal=document.querySelector('.regist-btn');
        btnSubmitModal.addEventListener("click", ()=>{
            modal.style.display="none";
        });
        alert("성공적으로 수정되었습니다.");
    }
    document.getElementById('childName').value = '';
    document.getElementById('presentNew').value = '';
    document.getElementById('childInstruct').value = '';
}


function updateImg() {
    const fileInput = document.getElementById('input-file');
    const file = fileInput.files[0];

    if (!file) {
        alert("파일을 선택해주세요.");
        return;
    }

    const files = new FormData();
    files.append("file", file);

    $.ajax({
        url: '/ParentMyPageRest/updateImg',
        type: 'PUT',
        data: files,
        processData: false,
        contentType: false,
        success: function(response) {
            alert("파일이 성공적으로 업로드되었습니다.");
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.error(textStatus, errorThrown);
            alert("파일 업로드에 실패했습니다.");
        }
    });
}

