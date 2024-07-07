const modal = document.querySelector('.modal');
const modal2 = document.querySelector('.modal2');
const btnOpenModal=document.querySelector('.btn-open-modal');
const btnCloseModal=document.querySelector('.close-btnen');
const btnCloseModal2=document.querySelector('.close-btnen2');
const btnOpenModalUpdate =document.querySelector('.btn-update-modal')


btnOpenModalUpdate.addEventListener("click", ()=>{
    modal2.style.display="flex";
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