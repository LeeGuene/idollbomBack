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
        uploadImage(files[0])
        for (let i = 1; i < files.length; i++) {
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