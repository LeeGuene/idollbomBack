const modal = document.querySelector('.modal');
const modal2 = document.querySelector('.modal2');
const btnOpenModal=document.querySelector('.btn-open-modal');
const btnCloseModal=document.querySelector('.close-btnen');
const btnCloseModal2=document.querySelector('.close-btnen2');
const closeInsertModal= document.querySelector('.cancle')


closeInsertModal.addEventListener("click", ()=>{
    modal2.style.display="none";
});

// 모든 수정 버튼을 선택
const btnOpenModalUpdates = document.querySelectorAll('.btn-update-modal');
// 모달활성화
btnOpenModalUpdates.forEach(btn => {
    btn.addEventListener("click", () => {
        const childNumber = btn.getAttribute('data-kid-number');
        modal2.style.display = "flex";
    });
});

btnOpenModal.addEventListener("click", ()=>{
    modal.style.display="flex";
});

btnCloseModal.addEventListener("click", ()=>{
    modal.style.display="none";
});

btnCloseModal2.addEventListener("click", ()=>{
    modal2.style.display="none";
});