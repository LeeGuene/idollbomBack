document.addEventListener("DOMContentLoaded", function(){
    const form = document.querySelector("form");
    const questionTitle = document.querySelector("#title-input");
    const questionContent = document.querySelector("#content-input");
    const titleErrMsg = document.querySelector('#title-err-msg');
    const contentErrMsg = document.querySelector('#content-err-msg');
    const viewCheckBoxs = document.querySelectorAll('input[type="radio"]');
    const submitBtn = document.querySelector(".post-submitBtn-wrap > button");
    // console.log(viewCheckBoxs);
    // console.log(questionTitle);
    // console.log(titleErrMsg);

    function validateForm(){
        let check = true;

        // 문의하기 제목 유효성 검사
        if(questionTitle.value === ""){
            titleErrMsg.style.display = 'block';
            titleErrMsg.textContent = "필수 입력 값입니다.";
            check = false;
        }else if(questionTitle.length > 30){
            titleErrMsg.style.display = 'block';
            titleErrMsg.textContent = '제목은 최대 30글자 이하입니다.';
            check = false;
        }else{
            titleErrMsg.style.display = 'none';
            titleErrMsg.textContent = '';
        }

        // 문의하기 내용 유효성
        if(questionContent.value === ""){
            contentErrMsg.style.display = 'block';
            contentErrMsg.textContent = "필수 입력 값입니다.";
            check = false;
        }else{
            contentErrMsg.display = 'none';
            contentErrMsg.textContent = '';
        }

        // 열람가능 여부 체크박스 유효성 검사
        // for(let i = 0; i < viewCheckBoxs.length; i++){
        //     if(!viewCheckBoxs[i].checked){
        //         check = false;
        //         break;
        //     }
        // }
        return check;
    }

    // 폼 입력값 변화에 따라 버튼 활성화/비활성화
    form.addEventListener("input", function(){
        if (validateForm()) {
            submitBtn.classList.remove('disabled');
        } else {
            submitBtn.classList.add('disabled');
        }
    });

    form.addEventListener("submit", e=> {
        e.preventDefault();
        if (validateForm()) {
            form.submit();
        } else {
            alert("유효하지 않은 값이 있습니다.");
        }
    });

});


