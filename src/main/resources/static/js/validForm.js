// 유효성 체크
function validForm() {
    let isValid = true;
    let message = "";

    console.log('실행되니?')

    // 수업 제목
    const title = document.getElementById('title').value
    console.log(title === '')
    // 해당 부모 노드로 찾아가는
    const classTitle = document.getElementById('classTitle').parentNode
    if (title === '') {
        console.log(title === '')
        classTitle.style.display="flex"
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
