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
    let saveBtns = document.querySelectorAll('.fail-btn');
    let deleteBtns = document.querySelectorAll('.success-btn');
    const classNumber =  $('input[name="classNumber"]').val(); // 수업 pk
    let imageSrc;  // 찜 버튼 src속성
    let categoryBig;
    let categorySmall = document.querySelector('input[name="category"]');
    let pageNo;
    let pageSize;

    for(let index = 0; index < saveBtns.length; index++){
        saveBtns[index].addEventListener("click", e=> {
            e.preventDefault();
            categoryBig = document.querySelector('input[name="categoryBig"]');

            // 수업 찜 버튼을 클릭했을 때, 현재 선택된 pageNo, pageSize를 불러온다.
            pageNo = document.querySelector('.pagination > .page-item.active > a').textContent;

            const pageLink = document.querySelector('.pagination > .page-item.active > a');
            const pageHref = pageLink.getAttribute("href");
            const params = new URLSearchParams(pageHref);
            pageSize = params.get("pageSize");

            console.log(typeof pageNo);
            console.log(typeof pageSize);

            // 클릭된 버튼요소의 부모의 부모의 자식요소로 접근하여 수업 pk를 가져온다.
            imageSrc = e.currentTarget.children[0].src;


            // 즐겨찾기 되지 않은 수업이라면
            if (imageSrc.indexOf('pick_n') !== -1) {

                const form = document.createElement('form');
                const indexInput = document.createElement('input');
                const pageNoInput = document.createElement('input');
                const pageSizeInput = document.createElement('input');

                pageNoInput.name = 'pageNo';
                pageNoInput.type = 'hidden';
                pageNoInput.value = pageNo;

                pageSizeInput.name = 'pageSize';
                pageSizeInput.type = 'hidden';
                pageSizeInput.value = pageSize;

                indexInput.name = 'buttonIndex';
                indexInput.type = 'hidden';
                indexInput.value = index;

                form.append(categoryBig);
                form.append(categorySmall);
                form.append(pageNoInput);
                form.append(pageSizeInput);
                form.append(indexInput);

                // console.log(form);
                form.method = 'post';
                form.action = '/ParentMyPage/insertSaveClass/' + classNumber;
                document.body.appendChild(form);
                form.submit();

            }
        });
    }
    
    // 이미 추가된 찜 목록 버튼들 중 하나를 클릭하면
    for(let index = 0; index < deleteBtns.length; index++){
        deleteBtns[index].addEventListener("click", e =>{
            e.preventDefault();

            categoryBig = document.querySelector('input[name="categoryBig"]');

            // 수업 찜 버튼을 클릭했을 때, 현재 선택된 pageNo, pageSize를 불러온다.
            pageNo = document.querySelector('.pagination > .page-item.active > a').textContent;

            const pageLink = document.querySelector('.pagination > .page-item.active > a');
            const pageHref = pageLink.getAttribute("href");
            const params = new URLSearchParams(pageHref);
            pageSize = params.get("pageSize");

            console.log(typeof pageNo);
            console.log(typeof pageSize);

            // 클릭된 버튼요소의 부모의 부모의 자식요소로 접근하여 수업 pk를 가져온다.
            imageSrc = e.currentTarget.children[0].src;

            if (imageSrc.indexOf('pick_y') !== -1) {
                const form = document.createElement('form');
                const indexInput = document.createElement('input');
                const pageNoInput = document.createElement('input');
                const pageSizeInput = document.createElement('input');

                pageNoInput.name = 'pageNo';
                pageNoInput.type = 'hidden';
                pageNoInput.value = pageNo;

                pageSizeInput.name = 'pageSize';
                pageSizeInput.type = 'hidden';
                pageSizeInput.value = pageSize;

                indexInput.name = 'buttonIndex';
                indexInput.type = 'hidden';
                indexInput.value = index;

                form.append(categoryBig);
                form.append(categorySmall);
                form.append(pageNoInput);
                form.append(pageSizeInput);
                form.append(indexInput);

                // console.log(form);
                form.method = 'get';
                form.action = '/ParentMyPage/deleteSaveClass/' + classNumber;
                document.body.appendChild(form);
                form.submit();

            }

        });
    }
    // =============================== 이근 추가 부분 =============================== //

});

// 검색하기를 눌렀을 때 일어나는 이벤트
function submitForm() {
    document.getElementById("searchForm").submit();
}




















