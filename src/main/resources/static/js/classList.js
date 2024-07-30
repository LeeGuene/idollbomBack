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
    // 비동기 아님
    
    // 수업 찜 추가버튼
    // let saveBtns = document.querySelectorAll('.fail-btn');
    // let deleteBtns = document.querySelectorAll('.success-btn');
    // let classNumber;// 수업 pk
    // let imageSrc;  // 찜 버튼 src속성
    // let categoryBig;
    // let categorySmall = document.querySelector('input[name="category"]');
    // let pageNo;
    // let pageSize;

    // for(let index = 0; index < saveBtns.length; index++){
        // saveBtns[index].addEventListener("click", e=> {
        //     e.preventDefault();
        //     categoryBig = document.querySelector('input[name="categoryBig"]');
        //     classNumber = document.querySelector('input[name="classNumber"]').value;
            // 수업 찜 버튼을 클릭했을 때, 현재 선택된 pageNo, pageSize를 불러온다.
            // pageNo = document.querySelector('.pagination > .page-item.active > a').textContent;
            //
            // const pageLink = document.querySelector('.pagination > .page-item.active > a');
            // const pageHref = pageLink.getAttribute("href");
            // const params = new URLSearchParams(pageHref);
            // pageSize = params.get("pageSize");
            //
            // console.log(typeof pageNo);
            // console.log(typeof pageSize);

            // 클릭된 버튼요소의 부모의 부모의 자식요소로 접근하여 수업 pk를 가져온다.
            // imageSrc = e.currentTarget.children[0].src;


            // 즐겨찾기 되지 않은 수업이라면
    //         if (imageSrc.indexOf('pick_n') !== -1) {
    //
    //             const form = document.createElement('form');
    //             const indexInput = document.createElement('input');
    //             const pageNoInput = document.createElement('input');
    //             const pageSizeInput = document.createElement('input');
    //
    //             pageNoInput.name = 'pageNo';
    //             pageNoInput.type = 'hidden';
    //             pageNoInput.value = pageNo;
    //
    //             pageSizeInput.name = 'pageSize';
    //             pageSizeInput.type = 'hidden';
    //             pageSizeInput.value = pageSize;
    //
    //             indexInput.name = 'buttonIndex';
    //             indexInput.type = 'hidden';
    //             indexInput.value = index;
    //
    //             form.append(categoryBig);
    //             form.append(categorySmall);
    //             form.append(pageNoInput);
    //             form.append(pageSizeInput);
    //             form.append(indexInput);
    //
    //             // console.log(form);
    //             form.method = 'post';
    //             form.action = '/ParentMyPage/insertSaveClass/' + classNumber;
    //             document.body.appendChild(form);
    //             form.submit();
    //
    //         }
    //     });
    // }
    
    // 이미 추가된 찜 목록 버튼들 중 하나를 클릭하면
    // for(let index = 0; index < deleteBtns.length; index++){
    //     deleteBtns[index].addEventListener("click", e =>{
    //         e.preventDefault();
    //
    //         categoryBig = document.querySelector('input[name="categoryBig"]');
    //
    //         // 수업 찜 버튼을 클릭했을 때, 현재 선택된 pageNo, pageSize를 불러온다.
    //         pageNo = document.querySelector('.pagination > .page-item.active > a').textContent;
    //
    //         const pageLink = document.querySelector('.pagination > .page-item.active > a');
    //         const pageHref = pageLink.getAttribute("href");
    //         const params = new URLSearchParams(pageHref);
    //         pageSize = params.get("pageSize");
    //
    //         console.log(typeof pageNo);
    //         console.log(typeof pageSize);
    //
    //         // 클릭된 버튼요소의 부모의 부모의 자식요소로 접근하여 수업 pk를 가져온다.
    //         imageSrc = e.currentTarget.children[0].src;
    //
    //         if (imageSrc.indexOf('pick_y') !== -1) {
    //             const form = document.createElement('form');
    //             const indexInput = document.createElement('input');
    //             const pageNoInput = document.createElement('input');
    //             const pageSizeInput = document.createElement('input');
    //
    //             pageNoInput.name = 'pageNo';
    //             pageNoInput.type = 'hidden';
    //             pageNoInput.value = pageNo;
    //
    //             pageSizeInput.name = 'pageSize';
    //             pageSizeInput.type = 'hidden';
    //             pageSizeInput.value = pageSize;
    //
    //             indexInput.name = 'buttonIndex';
    //             indexInput.type = 'hidden';
    //             indexInput.value = index;
    //
    //             form.append(categoryBig);
    //             form.append(categorySmall);
    //             form.append(pageNoInput);
    //             form.append(pageSizeInput);
    //             form.append(indexInput);
    //
    //             // console.log(form);
    //             form.method = 'get';
    //             form.action = '/ParentMyPage/deleteSaveClass/' + classNumber;
    //             document.body.appendChild(form);
    //             form.submit();
    //
    //         }
    //
    //     });
    // }
    // =============================== 이근 추가 부분 =============================== //

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
    
    // 수업 찜 목록 추가, 삭제 버튼 비동기 구현
    // addClassSave();
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
            renderBoard(data.content)
            Pagination(data)
            console.log(data.totalElements);

            document.getElementById('totalCount').textContent = data.totalElements

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
                        <button type="submit" class="save-btn"><img th:src="@{/images/class_list_pick_n.png}"></button>
                        <!--자세기 보기를 누르면 수업 상세 페이지로 이동-->
                        <!-- 이근 수정 부분 -->
                        <p><a href="#">자세히 보기</a></p>
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

// function addClassSave(){
//     let saveBtns = document.querySelectorAll('.save-btn');
//     console.log(saveBtns);
//     let classNumber; // 수업 pk
//     let imageSrc;  // 찜 버튼 src속성
//     let parentNumber = document.querySelector('input[name="parentNumber"]').value;
//     const classList = document.querySelectorAll('tbody > .class_item');
//     console.log(classList);

    // saveBtns.forEach(saveBtn =>{
    //     saveBtn.addEventListener("click", e=>{
    //         e.preventDefault();
    //         classNumber = e.currentTarget.parentElement.parentElement.children[0].value;
    //         console.log(classNumber);
    //         imageSrc = e.currentTarget.children[0].src;
    //         console.log(imageSrc);
    //
    //         if(imageSrc.indexOf('pick_n') !== -1){
    //             console.log("수업 찜 목록 추가 실행!!");
    //
    //             $.ajax({
    //                 method: 'post',
    //                 url: '/restList',
    //                 data: {
    //                     classNumber : classNumber,
    //                     parentNumber : parentNumber
    //                 },
    //                 success: function(data){
    //                     console.log("수업 찜 목록 추가 성공시 : " + data);
    //                     if(data === 1){
    //                         // 색상이 채워진 이미지로 변경
    //                         imageSrc = '/images/class_list_pick_y.png';
    //                         console.log(imageSrc);
    //                     }
    //
    //                 },
    //                 error: function(data){
    //                     console.log("에러 메세지 : " + data);
    //                 }
    //             });
    //
    //         }else{
    //
    //             $.ajax({
    //                 method: 'delete',
    //                 url: '/restList',
    //                 data: {
    //                     classNumber : classNumber,
    //                     parentNumber : parentNumber
    //                 },
    //                 success: function(data){
    //                     console.log("수업 찜 목록 삭제 성공시 : " + data);
    //                     // 색상이 채워진 이미지로 변경
    //                     if(data === 1){
    //                         imageSrc = '/images/class_list_pick_n.png';
    //                         console.log(imageSrc);
    //                     }
    //
    //                 },
    //                 error: function(data){
    //                     console.log("에러 메세지 : " + data);
    //                 }
    //             });
    //
    //         }
    //
    //     })
    // })

//}















