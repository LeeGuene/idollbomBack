document.addEventListener("DOMContentLoaded", function(){
    const questionTitle = document.querySelector("#title-input");
    const questionContent = document.querySelector("#content-input");
    const titleErrMsg = document.querySelector('#title-err-msg');
    const contentErrMsg = document.querySelector('#content-err-msg');
    // console.log(questionTitle);
    // console.log(titleErrMsg);

    // 문의하기 제목 유효성 검사
    questionTitle.addEventListener("input", e=>{
        console.log(e.target.value);
        if(e.target.value === ""){
            titleErrMsg.style.display = 'block';
            titleErrMsg.textContent = "필수 입력 값입니다.";
        }else if(e.target.value.length > 30){
            titleErrMsg.style.display = 'block';
            titleErrMsg.textContent = '제목은 최대 30글자 이하입니다.';
        }else{
            titleErrMsg.style.display = 'none';
            titleErrMsg.textContent = '';
        }
    });

    // 문의하기 내용 유효성 검사
    questionContent.addEventListener("input", e =>{
        console.log(e.target.value);
        if(e.target.value === ""){
            contentErrMsg.style.display = 'block';
            contentErrMsg.textContent = "필수 입력 값입니다.";
        }else{
            contentErrMsg.display = 'none';
            contentErrMsg.textContent = '';
        }
    })

});


