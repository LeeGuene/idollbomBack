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

            const detailBtns = document.querySelectorAll('.table tbody > tr a');
            const userRole = document.querySelector('input[name="userRole"]').value;
            console.log(detailBtns);
            console.log(userRole);

            detailBtns.forEach(detailBtn=>{
                detailBtn.addEventListener("click", e=>{
                    if(userRole !== 'parent'){
                        alert("로그인을 해 주세요!!");
                    }
                })
            })

        },
        error: function (data){
            console.log('실패')
        }
    })
}
// 현재 누가 로그인했는지
const userRole = $('input[name="userRole"]').val()

// 리스트 데이터를 받아서 렌더링 하는 함수
// 전체 게시글을 보여주는 함수
function renderBoard(communities){
    const boardContainer = $('.table tbody')
    boardContainer.empty()
    let linkHtml;

    communities.forEach(function (community){
        // 현재 로그인한 사람이 누구인지
        linkHtml = `<a href="/parentcommunity/detail/${community.parentPostNumber}">자세히보기</a>`

        // 해당 게시글 신고횟수가 1회 이상이면 게시글 막기
        if(community.parentPostReportCount >= 1){
            linkHtml = `<a style="cursor: not-allowed"<span class="disabled-link" data-message="해당 게시글은 볼 수 없습니다.">자세히 보기</span></a>`
        }

        let communityRow = `
        <tr>
            <td><img src="${community.parentProfileImageUrl}" alt="프로필"></td>
            <td>${community.parentPostTitle}</td>
            <td>${linkHtml}</td>
            <td>${community.parentNickname}</td>
            <td><input type="hidden" value="${community.parentPostReportCount}"></td>
        </tr>
        `

        boardContainer.append(communityRow)
    })

    // 클릭 이벤트 핸들러 추가
    $('.disabled-link').click(function(event) {
        const message = $(this).data('message');
        alert(message); // 메시지를 띄우는 코드
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

// 엔터로 검색할 함수
document.getElementById('searchEnter').addEventListener('keydown', async function(event){
    if(event.key === 'Enter'){
        event.preventDefault()
        searchType = $('select[name="searchType"]').val()
        searchWord = $('input[name="searchWord"]').val()
        getList(1)
    }
})