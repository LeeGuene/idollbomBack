// 첨부파일 관련 js
const fileBtn = document.querySelector(".attachment-wrap > #file");
const uploadName = document.querySelector(".attachment-wrap > .upload-name");

console.log(fileBtn);
console.log(uploadName);

fileBtn.addEventListener("change", ()=>{
  let fileName = fileBtn.value; // 선택된 첨부파일 경로
  uploadName.value = fileName; // 추가된 파일 경로 출력
  uploadName.style.border = '2px solid #00B455'; // 테투리 css
});

const titleInput = document.querySelector("#parentPostTitle");
const contentInput = document.querySelector("#parentPostContent");

// 게시글 제목, 내용 클릭 시 적용되는 css
titleInput.onclick = ()=>{
  titleInput.style.borderBottom = '2px solid #00B455';
}

contentInput.onclick = ()=>{
  contentInput.style.borderBottom = '2px solid #00B455';
  contentInput.style.borderTop = '2px solid #00B455';
}
