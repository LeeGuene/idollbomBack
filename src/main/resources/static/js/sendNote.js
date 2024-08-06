
console.log("실행!!");
// 쪽지 보내기 버튼 클릭 이벤트 발생 시, 전문가의 쪽지 목록에 추가가 되도록 한다.
document.addEventListener("DOMContentLoaded", function(){
    const form = document.querySelector('form');
    const sendBtn = document.querySelector('button.btn-open-modal');
    const modal = document.querySelector(".modal");
    console.log(modal);

    sendBtn.addEventListener("click", e=>{
        console.log("클릭 이벤트 실행!!");
        modal.style.display = 'flex';

        const parentNumber = document.querySelector('input[name="parentNumber"]').value;
        const proNumber = document.querySelector('input[name="proNumber"]').value;

        console.log(proNumber);
        console.log(parentNumber);

        // form.append(parentNumber);
        // form.append(proNumber);
        // document.body.append(form);
        // form.submit();
    })
});



