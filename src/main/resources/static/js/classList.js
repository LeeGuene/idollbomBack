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
    const saveBtns = document.querySelectorAll('#save-btn');
    let classNumber; // 수업 pk
    let imageSrc;  // 찜 버튼 src속성
    let bigCategory = document.querySelector('#classCategoryBig');
    let smallCategory = document.querySelector('input[name="category"]');
    console.log(bigCategory);

    saveBtns.forEach(saveBtn =>{
        // 리스트에 있는 찜 버튼들 중에 클릭 이벤트가 발생한 버튼만
        saveBtn.addEventListener("click", event=>{
            // 클릭된 버튼요소의 부모의 부모의 자식요소로 접근하여 수업 pk를 가져온다.
            classNumber = event.currentTarget.parentElement.parentElement.children[1].value;
            imageSrc = event.currentTarget.children[0].src;

            // 즐겨찾기 되지 않은 수업이라면
            if(imageSrc.indexOf('pick_n') !== -1){
                // 색상이 채워진 이미지로 변경
                saveBtn.children[0].src = '../images/class_list_pick_y.png';

                let form = document.createElement('form');
                form.method = 'post';
                form.action = '/ParentMyPage/insertSaveClass/' + classNumber;
                document.body.appendChild(form);

                // Create hidden input for category
                let bigCategoryInput = document.createElement('input');
                let smallCategoryInput = document.createElement('input');
                bigCategoryInput.type = 'hidden';
                smallCategoryInput.type = 'hidden';

                bigCategoryInput.name = 'bigCategory';
                smallCategoryInput.name = 'smallCategory';
                bigCategoryInput.value = bigCategory;
                smallCategoryInput.value = smallCategory;

                form.appendChild(bigCategoryInput);
                form.appendChild(smallCategoryInput);

                form.submit();

            }else{
                // 기존 이미지로 변경
                saveBtn.children[0].src = '../images/class_list_pick_n.png';
            }
        });
    })

    // =============================== 이근 추가 부분 =============================== //

});

// 검색하기를 눌렀을 때 일어나는 이벤트
function submitForm() {
    document.getElementById("searchForm").submit();
}




















