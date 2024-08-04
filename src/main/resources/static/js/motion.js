let answer; // 문의 답변내용을 담는 변수

$(document).ready(function(){
    const answerContents = document.querySelectorAll('.answer_content');
    // console.log(answerContents);

    answerContents.forEach(answerContent=>{
        if(answerContent.textContent != null){
            answer = answerContent.textContent;
        }
    })

});

$(function(){

    $(".gnb").on("mouseover",function(){
     $("#header").stop().animate({height: 270});
    });
    $("#header").on("mouseleave",function(){
     $("#header").stop().animate({height: 100});
    });

    let a="down";

    $(".question dl dt").on("click",function(){
        // 문의답변 내용이 없으면 슬라이드 적용하지 않음
        if (a==="down" && answer != null){
             $(this).next().stop().slideDown().css({display:"flex"});
             $($(this)).css({background: "url(../images/question2.png)no-repeat right 30px center rgba(224,224,224,0.3"})
             $($(this)).next().css({background: "rgba(224,224,224,0.3"})
             a="up";
       }else{
             $(this).next().stop().slideUp();
             $($(this)).css({background: "url(../images/question.png)no-repeat right 30px center"})
             $($(this)).next().css({background: "white"})
             a="down";
       }
    });

 });

// 헤더의 쪽지 모양 버튼 클릭하면
// 부모 마이페이지의 쪽지 목록 페이지로 이동
function goMynote(){
    window.location.href = '/ParentMyPage/myNote';
}