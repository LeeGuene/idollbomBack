// 카테고리에 따른 소카 내용이 달라짐
const selectbox = document.querySelector('.category')
const dollbom = document.querySelector('.category-dollbom')
const sport = document.querySelector('.category-sport')
const study = document.querySelector('.category-study')
const entertainment = document.querySelector('.category-entertainment')
// 시간을 막기 위함
const date = document.querySelector('.date')
const time = document.querySelector('.time')
const today = new Date()
date.value = new Date().toISOString().substring(0,10)

selectbox.addEventListener('change', () => {
    const category = selectbox.options[selectbox.selectedIndex].value             

    if(category === '돌봄'){
       dollbom.style.display="flex";
       sport.style.display="none";
       study.style.display="none";
       entertainment.style.display="none";
    }

    else if(category === '교육'){
        dollbom.style.display="none";
        sport.style.display="none";
        study.style.display="flex";
        entertainment.style.display="none";
    }

    else if(category === '운동'){
        dollbom.style.display="none";
        sport.style.display="flex";
        study.style.display="none";
        entertainment.style.display="none";
    }

    else if(category === '예능'){
        dollbom.style.display="none";
        sport.style.display="none";
        study.style.display="none";
        entertainment.style.display="flex";
    }
});

// 전문가 추천해주는 div
const random_pro = document.querySelector('.random_pro')
const pro_search = document.querySelector('.pro-search')
const pro_reset = document.querySelector('.reset')
pro_search.addEventListener("click", ()=>{
    // 당일 날짜라면 막기
    random_pro.style.display="flex"

})

pro_reset.addEventListener("click", () =>{
    random_pro.style.display="none"
})

// 검색버튼을 눌렀을 때 비동기로 sql문 실행하기
// 현재 로그인된 아이디도 가져와야함
function autoSubmit(){
    // 어떠한 카테고리가 선택이 되었는지
    const category = selectbox.options[selectbox.selectedIndex].value
    // 어떠한 유형에 수업을 선택했는지 (총 4개 존재)
    let categoryData;
    // 날짜와 시간도 가져오도록함

    // 카테고리에 따른 데이터를 설정합니다.
    if (category === '돌봄') {
        categoryData = dollbom.options[dollbom.selectedIndex].value;
    } else if (category === '운동') {
        categoryData = sport.options[sport.selectedIndex].value;
    } else if (category === '교육') {
        categoryData = study.options[study.selectedIndex].value;
    } else if (category === '예능') {
        categoryData = entertainment.options[entertainment.selectedIndex].value;
    }

    $.ajax({
        method: 'get',
        url: '/submit',
        contentType: 'application/json',
        data: JSON.stringify({
            category: category,
            // providerId: loginId
            categoryData: categoryData,
            dateTime: dateTime,
            time: time
        }),
        // 전문가 추천 자리에 뿌려줄 append 해줘서 뿌려주면됨
        success: function (data){

        },
        error: function (data){
            alert('검색한 정보에 대한 수업이 없습니다.')
        }
    })

}