const pageSize = 5
let searchWord = null
let searchType = null

window.onload = function(){
    searchType = $('select[name="searchType"]').val();
    searchWord = $('input[name="searchWord"]').val();

    // 첫 페이지 지정
    getList(1);
}

function getList(page){
    $.ajax({
        method: 'get',
        url: '/rest',
        data: {
            pageNo: page,
            pageSize: pageSize,
            searchType: searchType,
            searchWord: searchWord
        },
        success: function (data){
            // 리스트 뿌려주는 함수
            renderBoard(data.content)
            renderPagination(data)

        },
        error: function (data){
            console.log('실패')
        }
    })
}

// 리스트 데이터를 받아서 렌더링 하는 함수
// 전체 게시글을 보여주는 함수
function renderBoard(communities){
    const boardContainer = $('.table tbody')
    boardContainer.empty()

    communities.forEach(function (community){
        let communityRow = `<tr>
            <td><img src="/images/${community.parentProfileImageUrl}" alt="프로필"></td>
            <td>${community.parentPostTitle}</td>
            <td><a href="/parentcommunity/detail/${community.parentPostNumber}">자세히 보기</a></td>
            <td>${community.parentNickname}</td></tr>
            `

        boardContainer.append(communityRow)
    })
}

// 페이징 처리 영역
// data- 는 속성이라고 생각 뒤에 있는 거는 데이터를 저장하기 위한 식별하기 위한 변수라고 생각
function renderPagination(pagination) {
    const paginationContainer = $('.pagination');
    paginationContainer.empty();

    // 이전 버튼
    const prevDisabled = pagination.currentPage === 1 ? 'disabled' : '';
    paginationContainer.append(`
            <li class="page-item ${prevDisabled}">
                <a class="page-link" href="#" aria-label="Previous" data-page="${pagination.currentPage - 1}">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        `);

    for (let i = pagination.startPage; i <= pagination.endPage; i++) {
        const activeClass = pagination.currentPage === i ? 'active' : '';
        paginationContainer.append(`
            <li class="page-item ${activeClass}">
                <a class="page-link" href="#" data-page="${i}">${i}</a>
            </li>
        `);
    }

    const nextDisabled = pagination.currentPage === pagination.totalPages ? 'disabled' : '';
    paginationContainer.append(`
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
    getList(1)
}