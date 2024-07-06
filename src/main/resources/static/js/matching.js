// 카테고리에 따른 소카 내용이 달라짐
const selectbox = document.querySelector('.category')
const data = document.querySelector('.category-data')
const date = document.querySelector('.date')
const time = document.querySelector('.time')
const today = new Date()
date.value = new Date().toISOString().substring(0,10)

selectbox.addEventListener('change', () => {
    const category = selectbox.options[selectbox.selectedIndex].value             

    if(category === '돌봄'){
        data.options[0] = new Option("등/하원")
        data.options[1] = new Option("실내놀이")
        data.options[2] = new Option("책읽기")
        data.options[3] = new Option("놀이터")
        data.options[4] = new Option("견학/체험")
    }

    else if(category === '교육'){
        data.options[0] = new Option("초등국어")
        data.options[1] = new Option("초등수학")
        data.options[2] = new Option("초등영어")
        data.options[3] = new Option("초등과학")
        data.options[4] = new Option("코딩")
    }

    else if(category === '운동'){
        data.options[0] = new Option("축구")
        data.options[1] = new Option("야구")
        data.options[2] = new Option("줄넘기")
        data.options[3] = new Option("자전거")
        data.options[4] = new Option("배드민턴")
    }

    else if(category === '예능'){
        data.options[0] = new Option("그리기")
        data.options[1] = new Option("리코더")
        data.options[2] = new Option("피아노")
        data.options[3] = new Option("바이올린")
        data.options[4] = new Option("방송댄스")
    }
});

// 전문가 추천해주는 div
const random_pro = document.querySelector('.random_pro')
const pro_search = document.querySelector('.pro-search')
pro_search.addEventListener("click", ()=>{
    // 당일 날짜라면 막기
    random_pro.style.display="flex"
})