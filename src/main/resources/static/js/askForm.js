document.addEventListener("DOMContentLoaded", function(){
    const questionTitle = document.querySelector("#title-input");
    const titleErrMsg = document.querySelector('#title-err-msg');
    console.log(questionTitle);

    if(questionTitle.value === ''){
        titleErrMsg.style.display = 'block';
        titleErrMsg.style.textContent = '필수 입력 값입니다.';
    }else if(questionTitle.value.length > 30){
        titleErrMsg.style.display = 'block';
        titleErrMsg.style.textContent = '제목은 최대 30글자 이하입니다.';
    }

});


