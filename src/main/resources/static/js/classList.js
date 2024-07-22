// 버튼 클릭 시 css 적용 바꾸기
// 부모요소에서 가져오는 class
// 페이지 로딩 후 실행될 함수
document.addEventListener("DOMContentLoaded", function() {
    // 각 링크 요소에 클릭 이벤트 리스너 추가
    document.getElementById("one").addEventListener("click", function() {
        // 다른 링크들의 폰트 색상 초기화
        resetFontColors();
        // 클릭된 링크의 폰트 색상 변경
        this.style.color = "#048D3B";
        // 추가적으로 필요한 동작을 여기에 작성할 수 있습니다.
    });

    document.getElementById("two").addEventListener("click", function() {
        resetFontColors();
        this.style.color = "#048D3B";
    });

    document.getElementById("three").addEventListener("click", function() {
        resetFontColors();
        this.style.color = "#048D3B";
    });

    document.getElementById("four").addEventListener("click", function() {
        resetFontColors();
        this.style.color = "#048D3B";
    });

    document.getElementById("five").addEventListener("click", function() {
        resetFontColors();
        this.style.color = "#048D3B";
    });

    // 폰트 색상을 초기화하는 함수
    function resetFontColors() {
        var links = document.querySelectorAll(".category a");
        links.forEach(function(link) {
            link.style.color = ""; // 기본 값으로 설정
        });
    }
    // 찜하기 버튼을 눌렀을 경우 색상이 바뀌면서, 수업 찜 목록 리스트에 추가되도록 실행

    // =============================== 이근 추가 부분 =============================== //

    // 수업 찜 추가버튼
    // const saveBtns = document.querySelectorAll('#save-btn');
    // let classNumber; // 수업 pk
    // let imageSrc;  // 찜 버튼 src속성
    // const category = document.querySelector('input[name="category"]').value;
    // saveBtns.forEach(saveBtn =>{
        // 리스트에 있는 찜 버튼들 중에 클릭 이벤트가 발생한 버튼만
        // saveBtn.addEventListener("click", event=>{

            // event.preventDefault();

            // 클릭된 버튼요소의 부모의 부모의 자식요소로 접근하여 수업 pk를 가져온다.
            // classNumber = event.currentTarget.parentElement.parentElement.children[0].value;
            // imageSrc = event.currentTarget.children[0].src;

            // 즐겨찾기 되지 않은 수업이라면
            // if(imageSrc.indexOf('pick_n') !== -1){
                // 색상이 채워진 이미지로 변경
                // saveBtn.children[0].src = '../images/class_list_pick_y.png';
                // const form = document.createElement('form');
                // document.body.appendChild(form);

                // $.ajax({
                //     method: 'post',
                //     url: '/ParentMyPageRest/insertSaveClass/' + classNumber,
                //     success: function(){
                //         window.location.href='/class/classcare';
                //     },
                //     error: function(data){
                //         console.log("에러 메세지 : " + data);
                //     }
                // });

            // }else{
                // 기존 이미지로 변경
                // saveBtn.children[0].src = '../images/class_list_pick_n.png';
            // }
        // });
    // })

    // =============================== 이근 추가 부분 =============================== //

});

// 페이지 로딩 완료 이후 실행
$(document).ready(function () {
    let saveBtns = document.querySelectorAll('#save-btn');
    let classNumber; // 수업 pk
    let imageSrc;  // 찜 버튼 src속성
    $(saveBtns).click(function(e){
        e.preventDefault();
        classNumber = $(this).parent().parent().children(0).val();
        imageSrc = $(this).children(1).attr('src');

        if(imageSrc.indexOf('pick_n') !== -1){

            $.ajax({
                method: 'post',
                url: '/ParentMyPageRest/insertSaveClass/' + classNumber,
                success: function(data){
                    console.log("수업 찜 목록 추가 성공시 : " + data);
                    // 색상이 채워진 이미지로 변경
                    imageSrc = '../images/class_list_pick_y.png';
                    $(this).children(1).attr('src', imageSrc);
                    // window.locatiosn.href='/class/classcare';
                },
                error: function(data){
                    console.log("에러 메세지 : " + data);
                }
            });

        }else{
            // 기존 이미지로 변경
            imageSrc = '../images/class_list_pick_n.png';
            $(this).children(1).attr('src', imageSrc);
        }
    });

});
// 검색하기를 눌렀을 때 일어나는 이벤트
function submitForm() {
    document.getElementById("searchForm").submit();
}




















