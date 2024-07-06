$(function(){


    $(".gnb").on("mouseover",function(){
     $("#header").stop().animate({height: 270});
    });
    $("#header").on("mouseleave",function(){
     $("#header").stop().animate({height: 100});
    });


    let a="down";

    $(".question dl dt").on("click",function(){
       if (a==="down"){
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