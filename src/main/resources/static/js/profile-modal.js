// 프로필 이미지 변경 모달창
const profile_modal = document.querySelector('.modal-profile');
const profile_btnOpenModal=document.querySelector('.btn-profile-modal');
const profile_btnCloseModal=document.querySelector('.close-profile-btn');
const profile_btnCloseModal2=document.querySelector('#close-profile-btn');
const profile_btnCloseModal3=document.querySelector('.add-btn');

profile_btnCloseModal3.addEventListener("click", ()=>{
    profile_modal.style.display="none";
});

profile_btnOpenModal.addEventListener("click", ()=>{
    profile_modal.style.display="flex";
});

profile_btnCloseModal.addEventListener("click", ()=>{
    profile_modal.style.display="none";
});

profile_btnCloseModal2.addEventListener("click", ()=>{
    profile_modal.style.display="none";
});


function updateImg() {
    let img = document.querySelector(".input-file");

    let formData = new FormData();
    formData.append("file", img);

    $.ajax({
        url: '/ParentMyPageRest/updateKids/',
        type: 'PUT',
        contentType: 'application/json',
        data: formData,
        success: function (response) {
            console.log('업데이트 성공:', response);
        },
        error: function (error) {
            console.error('업데이트 실패:', error);
        }
    });
}
