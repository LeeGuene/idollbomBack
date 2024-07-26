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

// 비동기로 리스트와 검색 기능 구현
// const pageSize = 5
// let searchWord = null
// let searchType = null
//
// window.onload = function(){
//     searchType = $('select[name="searchType"]').val();
//     searchWord = $('input[name="searchWord"]').val();
//
//     // 첫 페이지 지정
//     getList(1);
// }
//
// function getList(page){
//     $.ajax({
//         method: 'get',
//         url: '/rest',
//         data: {
//             pageNo: page,
//             pageSize: pageSize,
//             searchType: searchType,
//             searchWord: searchWord
//         },
//         success: function (data){
//             // 리스트 뿌려주는 함수
//             renderBoard(data.content)
//             renderPagination(data)
//
//         },
//         error: function (data){
//             console.log('실패')
//         }
//     })
// }
//
// // 리스트 데이터를 받아서 렌더링 하는 함수
// // 전체 게시글을 보여주는 함수
// function renderBoard(communities){
//     const boardContainer = $('.table tbody')
//     boardContainer.empty()
//
//     communities.forEach(function (community){
//         let communityRow = `<tr>
//             <td><img src="/images/${community.parentProfileImageUrl}" alt="프로필"></td>
//             <td>${community.parentPostTitle}</td>
//             <td><a href="/parentcommunity/detail/${community.parentPostNumber}">자세히 보기</a></td>
//             <td>${community.parentNickname}</td></tr>
//             `
//
//         boardContainer.append(communityRow)
//     })
// }
//
// // 페이징 처리 영역
// // data- 는 속성이라고 생각 뒤에 있는 거는 데이터를 저장하기 위한 식별하기 위한 변수라고 생각
// function renderPagination(pagination) {
//     const paginationContainer = $('.pagination');
//     paginationContainer.empty();
//
//     // 이전 버튼
//     const prevDisabled = pagination.currentPage === 1 ? 'disabled' : '';
//     paginationContainer.append(`
//             <li class="page-item ${prevDisabled}">
//                 <a class="page-link" href="#" aria-label="Previous" data-page="${pagination.currentPage - 1}">
//                     <span aria-hidden="true">&laquo;</span>
//                 </a>
//             </li>
//         `);
//
//     for (let i = pagination.startPage; i <= pagination.endPage; i++) {
//         const activeClass = pagination.currentPage === i ? 'active' : '';
//         paginationContainer.append(`
//             <li class="page-item ${activeClass}">
//                 <a class="page-link" href="#" data-page="${i}">${i}</a>
//             </li>
//         `);
//     }
//
//     const nextDisabled = pagination.currentPage === pagination.totalPages ? 'disabled' : '';
//     paginationContainer.append(`
//             <li class="page-item ${nextDisabled}">
//                 <a class="page-link" href="#" aria-label="Next" data-page="${pagination.currentPage + 1}">
//                     <span aria-hidden="true">&raquo;</span>
//                 </a>
//             </li>
//         `);
//
//     // 페이지 클릭했을 때 실행할 함수.
//     $('.page-link').click(function(event) {
//         event.preventDefault();
//         const selectedPage = $(this).data('page');
//         getList(selectedPage);
//     });
// }
//
// // 검색 기능 함수
// function saveKeyword(){
//     searchType = $('select[name="searchType"]').val()
//     searchWord = $('input[name="searchWord"]').val()
//     getList(1)
// }
//
//
















