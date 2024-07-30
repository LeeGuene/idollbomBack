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

});

// 비동기로 리스트와 검색 기능 구현
const pageSize = 5
let searchWord = null
let searchType = null
let category = null

window.onload = function(){
    searchType = $('select[name="searchType"]').val()
    searchWord = $('input[name="searchWord"]').val()
    category = $('input[name="category"]').val()

    console.log(category)

    // 첫 페이지 지정
    getList(1);

}

function getList(page){
    $.ajax({
        method: 'get',
        url: '/restList',
        data: {
            pageNo: page,
            pageSize: pageSize,
            searchType: searchType,
            searchWord: searchWord,
            category : category
        },
        success: function (data){
            // 리스트 뿌려주는 함수
            console.log(data.content);
            renderBoard(data.content)
            Pagination(data)

            console.log(data.totalElements);

            document.getElementById('totalCount').textContent = data.totalElements

            // 수업 찜 목록 추가/삭제 비동기 구현 메서드
            addClassSave();

        },
        error: function (data){
            alert('불러오기 실패')
            console.log(category)
            console.log(data)
        }
    })
}

// 리스트 데이터를 받아서 렌더링 하는 함수
function renderBoard(classLists){
    const boardContainer = $('.table tbody')
    boardContainer.empty()

    classLists.forEach(function (classList){

        let classListRow = `  
                <tr class="class_item">
                    <input type="hidden" name="classNumber" value="${classList.classNumber}" />
                     <input type="hidden" name="proNumber" value="${classList.proNumber}" />
                    <td><img src="/images/${classList.proProfileImageUrl}"></td>
                    <td>
                        <div>
                            <p>${classList.proName}</p>
                            <!--리뷰 점수와 갯수만 보여주자-->
                            <p>(${classList.reviewCount})</p>
                        </div>
                        <p>${classList.className}</p>
                        <p>${classList.classIntro}</p>
                        <p>${classList.proAddress}</p>
                        <p>${classList.classRegisterDate}</p>
                    </td>
                    <td>
                        <!-- 찜하기 버튼 --> 
                        <!-- 수업 찜 추가하면 마이 페이지의 찜 목록으로 이동 -->
                        <button type="submit" class="save-btn"><img src="/images/class_list_pick_n.png"></button>
                        <!--자세기 보기를 누르면 수업 상세 페이지로 이동-->
                        <!-- 이근 수정 부분 -->
                        <p><button class="detail-btn" onclick="goClassDetail(event)">자세히 보기</button></p>
<!--                        <p><a href="@{/class/detail(classNumber=*{classNumber}, proNumber=*{proNumber})}">자세히 보기</a></p>-->
                    </td>
                </tr>
            `

        boardContainer.append(classListRow)
    })
}

// 페이징 처리 영역
// data- 는 속성이라고 생각 뒤에 있는 거는 데이터를 저장하기 위한 식별하기 위한 변수라고 생각
function Pagination(pagination) {
    const Container = $('.pagination');
    Container.empty();

    // 이전 버튼
    const prevDisabled = pagination.currentPage === 1 ? 'disabled' : '';
    Container.append(`
            <li class="page-item ${prevDisabled}">
                <a class="page-link" href="#" aria-label="Previous" data-page="${pagination.currentPage - 1}">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        `);

    for (let i = pagination.startPage; i <= pagination.endPage; i++) {
        const activeClass = pagination.currentPage === i ? 'active' : '';
        Container.append(`
            <li class="page-item ${activeClass}">
                <a class="page-link" href="#" data-page="${i}">${i}</a>
            </li>
        `);
    }

    const nextDisabled = pagination.currentPage === pagination.totalPages ? 'disabled' : '';
    Container.append(`
            <li class="page-item ${nextDisabled}">
                <a class="page-link" href="#" aria-label="Next" data-page="${pagination.currentPage + 1}">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        `);

    // 페이지 클릭했을 때 실행할 함수.
    $('.page-link').click(function(event) {
        event.preventDefault();
        const selectedPage = $(this).data('page');
        getList(selectedPage);
    });
}

// 검색 기능 함수
function saveKeyword(){
    searchType = $('select[name="searchType"]').val()
    searchWord = $('input[name="searchWord"]').val()
    category = $('input[name="category"]').val()

    getList(1)
}

function addClassSave(){
    let saveBtns = document.querySelectorAll('.save-btn');
    // console.log(saveBtns);
    let classNumber; // 수업 pk
    let classItem; // 수업 하나
    let image;  // 찜 버튼 src속성
    let parentNumber = document.querySelector('input[name="parentNumber"]').value;
    // console.log(parentNumber);
    const classList = document.querySelectorAll('tbody > .class_item');
    // console.log(classList);

    saveBtns.forEach(saveBtn =>{
        saveBtn.addEventListener("click", e=>{
            e.preventDefault();
            classItem = e.currentTarget.parentElement.parentElement;
            classNumber = classItem.querySelector('input[name="classNumber"]').value;
            // console.log(classNumber);
            image = e.currentTarget.children[0];
            console.log(image);

            if(image.src.indexOf('pick_n') !== -1){
                console.log("수업 찜 목록 추가 실행!!");

                $.ajax({
                    method: 'post',
                    url: '/restList',
                    data: {
                        classNumber : classNumber,
                        parentNumber : parentNumber
                    },
                    success: function(data){
                        console.log("수업 찜 목록 추가 성공시 : " + data);
                        if(data === 1){
                            // 색상이 채워진 이미지로 변경
                            image.src = '/images/class_list_pick_y.png';
                        }

                    },
                    error: function(data){
                        console.log("에러 메세지 : " + data);
                    }
                });

            }else{

                $.ajax({
                    method: 'delete',
                    url: '/restList',
                    data: {
                        classNumber : classNumber,
                        parentNumber : parentNumber
                    },
                    success: function(data){
                        console.log("수업 찜 목록 삭제 성공시 : " + data);
                        // 색상이 채워진 이미지로 변경
                        if(data === 1){
                            image.src = '/images/class_list_pick_n.png';
                        }

                    },
                    error: function(data){
                        console.log("에러 메세지 : " + data);
                    }
                });

            }

        })
    })
}

// 수업 상세보기 페이지로 이동하는 메서드
function goClassDetail(e){
    console.log("자세히 보기 버튼 클릭!!");
    console.log(e.currentTarget);

    const form = document.createElement('form');
    const classItem = e.currentTarget.parentElement.parentElement.parentElement;
    const classNumber = classItem.querySelector('input[name="classNumber"]');
    const proNumber = classItem.querySelector('input[name="proNumber"]');

    console.log(classNumber);
    console.log(proNumber);

    form.method = 'get';
    form.action = '/class/detail';
    form.append(classNumber);
    form.append(proNumber);

    document.body.append(form);

    form.submit();



}