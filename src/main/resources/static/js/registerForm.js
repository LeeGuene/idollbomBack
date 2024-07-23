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
  const img = document.createElement('img');
  img.src = url;
  img.style.width = '100%';
  $('#classContent').summernote('insertNode', img);
}

// 선택한 시간을 보여줌
function addToSelectedList() {
  var selectBox = document.getElementById("timeSelect");
  var selectedOption = selectBox.options[selectBox.selectedIndex];

  // "====시간 선택====" 옵션이 선택된 경우, 선택을 초기화
  if (selectedOption.value === "none") {
    alert('시간을 선택해주세요.')
    return;
  }

  var selectedText = selectedOption.text;
  var selectedValue = selectedOption.value;

  var selectedTimesSpan = document.getElementById("selectedTime");
  var currentTimes = selectedTimesSpan.textContent.trim();
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