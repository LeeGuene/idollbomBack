// 수업 제목
const title = document.getElementById('title')
// 해당 부모 노드로 찾아가는 parentNode
const classTitle = document.getElementById('classTitle').parentNode

// 수업 소개
const intro = document.getElementById('intro')
const classIntro = document.getElementById('classIntro').parentNode

// 날짜 선택
// 당일로 한다면, 등록하지 못하게 막기
const dateSelect = document.getElementById('dateSelect')
const classDate = document.getElementById('classDate').parentNode
// 현재 날짜를 가져옵니다.
const today = new Date()
// 날짜의 연도, 월, 일을 추출합니다.
const year = today.getFullYear()
const month = String(today.getMonth() + 1).padStart(2, '0') // 월은 0부터 시작하므로 +1
const day = String(today.getDate()).padStart(2, '0')
// 형식에 맞게 날짜를 포맷합니다.
const formattedDate = `${year}-${month}-${day}`

// 시간 선택
const timeSelect = document.getElementById('timeSelect')
const classDay = document.getElementById('classDay').parentNode

// 수업 사진
const upload = document.getElementById('upload')
const classImage = document.getElementById('classImage').parentNode

// 수업 내용
const content = document.getElementById('summerNote')
const classContent = document.getElementById('content').parentNode

// 결제 금액
const money = document.getElementById('payment-amount')
const classMoney = document.getElementById('classMoney').parentNode

// 유효성 체크
function validForm() {
    let isValid = true

    if (title.value === '') {
        classTitle.style.display="flex"
        isValid = false
    }

    if (intro.value === '') {
        classIntro.style.display="flex"
        isValid = false
    }

    if (dateSelect.value === formattedDate) {
        classDate.style.display="flex"
        isValid = false
    }

    if (timeSelect.value === "none") {
        classDay.style.display="flex"
        isValid = false
    }

    if (upload.files.length === 0) {
        classImage.style.display="flex"
        isValid = false
    }

    if(document.getElementsByClassName('note-editable')[0].textContent === ''){
        classContent.style.display='flex'
        isValid = false
    }
    else{
        classContent.style.display='none'
    }

    if(money.value === '') {
        classMoney.style.display = "flex"
        isValid = false
    }

    // 값이 true여야만 실행
    return isValid
}


// 수업 제목이 채워졌다면
title.addEventListener("change", function(e){
    classTitle.style.display = 'none'
})

// 수업 소개가 채워졌다면
intro.addEventListener("change", function(e){
    classIntro.style.display = 'none'
})

// 수업 날짜가 금일 날짜와 다르다면
dateSelect.addEventListener("change", function(e){
    classDate.style.display = 'none'
})

timeSelect.addEventListener("change", function(e){
    classDay.style.display = 'none'
})

upload.addEventListener("change", function(e){
    classImage.style.display = 'none'
})

money.addEventListener("change", function (){
    classMoney.style.display= 'none'
})