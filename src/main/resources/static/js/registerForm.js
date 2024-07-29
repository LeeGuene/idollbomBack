const dollbom = document.querySelector('.category-dollbom')
const sport = document.querySelector('.category-sport')
const study = document.querySelector('.category-study')
const entertainment = document.querySelector('.category-entertainment')

// 각 라디오 버튼의 값을 가져오는 js
document.querySelectorAll('input[name="classCategoryBig"]').forEach((elem) => {
  elem.addEventListener("change", function(event) {
    const selectedValue = event.target.value;
    console.log("선택된 카테고리:", selectedValue);
    // 여기서 원하는 작업을 수행
    if(selectedValue === '돌봄'){
      dollbom.style.display="flex";
      sport.style.display="none";
      study.style.display="none";
      entertainment.style.display="none";
    }

    else if(selectedValue === '교육'){
      dollbom.style.display="none";
      sport.style.display="none";
      study.style.display="flex";
      entertainment.style.display="none";
    }

    else if(selectedValue === '운동'){
      dollbom.style.display="none";
      sport.style.display="flex";
      study.style.display="none";
      entertainment.style.display="none";
    }

    else if(selectedValue === '예능'){
      dollbom.style.display="none";
      sport.style.display="none";
      study.style.display="none";
      entertainment.style.display="flex";
    }
  })
})

// 써머노트 부분
$(document).ready(function() {
  initializeSummernote();
});

function initializeSummernote() {
  $('#classContent').summernote({
    height: 300,
    tabsize: 2,
    placeholder: '내용을 입력하세요.',
    callbacks: {
      onImageUpload: function(files) {
        for (let i = 0; i < files.length; i++) {
          uploadImage(files[i], this);
        }
      }
    }
  });
}

function uploadImage(file) {
  let data = new FormData();
  data.append("file", file);
  $.ajax({
    url: '/upload/image',
    cache: false, // 캐시 데이터 사용하지 않음
    contentType: false, // 파일 업로드 시, 헤더가 파일로 자동으로 설정
    processData: false, // 문자열로 바뀌지 않게 설정
    enctype : 'multipart/form-data',
    data: data,
    method: "post",
    success: function(url) {
      console.log(url)
      insertImageToSummernote(url);
    },
    error: function(data) {
      console.error(data);
    }
  });
}

function insertImageToSummernote(url) {
  const img = document.createElement("img");
  img.src = url;
  img.style.width = '100%';
  $('#classContent').summernote('insertNode', img);
}

// 선택한 시간을 보여줌
function addToSelectedList() {
  var selectBox = document.getElementById("timeSelect");
  var selectedOption = selectBox.options[selectBox.selectedIndex];
  var selectedText = selectedOption.text;


  var selectedTimesSpan = document.getElementById("selectedTime");
  var currentTimes = selectedTimesSpan.textContent.trim();
  // "====시간 선택====" 옵션이 선택된 경우, 선택을 초기화
  if (selectedOption.value === "none") {
    alert('시간을 선택해주세요.')
    currentTimes = ""
    return;
  }

  if (currentTimes !== "") {
    currentTimes += ", ";
  }

  currentTimes += selectedText
  selectedTimesSpan.textContent = currentTimes;

  // 선택된 시간을 숨은 입력 필드에 추가하여 폼 데이터로 전송
  var hiddenInput = document.createElement("input");
  hiddenInput.type = "hidden";
  hiddenInput.name = "selectedTimes"; // 폼 데이터의 이름
  hiddenInput.value = selectedTimesSpan.textContent;

  // 폼에 숨은 입력 필드 추가
  document.getElementById("register-form").append(hiddenInput);
}

// 유효성 체크
function validateForm() {
  let isValid = true;
  let message = "";

  console.log('실행되니?')

  // 수업 제목
  const title = document.getElementById('title').value
  const classTitle = document.getElementById('classTitle')
  if (!title) {
    classTitle.style.display="block"
    isValid = false;
  }

  // 수업 소개
  const intro = document.getElementById('intro').value;
  const classIntro = document.getElementById('classIntro')
  if (!intro) {
    classIntro.style.display="block"
    isValid = false;
  }

  // // 날짜 선택
  // // 당일로 한다면, 등록하지 못하게 막기
  // const dateSelect = document.getElementById('dateSelect').value;
  // if (!dateSelect) {
  //   message += "날짜를 선택해 주세요.\n";
  //   isValid = false;
  // }
  //
  // // 시간 선택
  // const timeSelect = document.getElementById('timeSelect').value;
  // if (timeSelect === "none") {
  //   message += "시간을 선택해 주세요.\n";
  //   isValid = false;
  // }
  //
  // // 수업 사진
  // const upload = document.getElementById('upload').files.length;
  // if (upload === 0) {
  //   message += "수업 사진을 업로드해 주세요.\n";
  //   isValid = false;
  // }

  // 값이 true여야만 실행
  return isValid
}

// 날짜 관련 js
// 당일 날짜로만 등록 및 이전 날짜는 막기
document.addEventListener('DOMContentLoaded', function() {
  // 현재 날짜를 YYYY-MM-DD 형식으로 가져옵니다.
  const today = new Date()
  const year = today.getFullYear()
  const month = ('0' + (today.getMonth() + 1)).slice(-2) // 월을 두 자리로 포맷
  const day = ('0' + today.getDate()).slice(-2) // 일을 두 자리로 포맷
  const todayString = `${year}-${month}-${day}`

  // 날짜 선택 입력 필드 가져오기
  const dateInput = document.getElementById('dateSelect')

  // min 속성 및 기본값 설정
  dateInput.setAttribute('min', todayString)
  dateInput.value = todayString; // 기본값 설정
})