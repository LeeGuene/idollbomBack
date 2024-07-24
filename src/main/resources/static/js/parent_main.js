// ====================== 강사님이 추가해주신 부분 ====================== //
document.addEventListener("DOMContentLoaded", function() {
    let check = document.querySelector(".check");

    if(check){
        check.addEventListener("click", function(){
            alert("로그인을 하고 이용을 해주세요!!!");
            window.location.href = '/user/login';
        })
    }
    
    // 추천 전문가 리스트 페이징 처리

    const pageSize = 3; // 한 페이지 내에 보여줄 추천 전문가 목록개수

    getList();

    function getList(page){
        $.ajax({
            method : 'get',
            url : '/rest/recommend',
            data : {
                page : page,            // 처음 페이지 로딩 시에는 defaultValue 값이 들어간다.
                pageSize : pageSize
            },
            success:function (data){
                // 리스트 뿌려주는 함수.
                // console.log(data);
                renderPro(data.content);
                renderPagination(data);
            },
            error:function (){
                console.error('실패')
            }
        })
    };

    function renderPro(pros){
        const proContainer = $('.pro_recommendation ul');
        proContainer.empty();

        pros.forEach(function(pro) {
            let boardRow =  `
            <li>
                <a href="#">
                    <div class="proImg-box">
                        <img src="/images/${pro.proProfileImageUrl}" />
                    </div>
                    <p>${pro.proName}</p>
                    <div>
                        <p>후기</p>

                        <!-- 별점 이미지 사진이 4.5rating밖에 없어서 일단 평균 별점 2점 초과하면 무조건 나오도록 설정함. -->
                        <img src="/images/${pro.averageRating > 2 ? 4.5 : 5}rating.png">
                            <p>(${pro.reviewCount})</p>
                    </div>
                </a>
            </li>`;

            proContainer.append(boardRow);
        });
    }

    function renderPagination(pagination) {
        const paginationContainer = $('.pro_control');
        paginationContainer.empty();

        // 이전 버튼
        const prevDisabled = pagination.currentPage === 1 ? 'style = "pointer-events : none"' : '';
        paginationContainer.append(`
            <button type="button" ${prevDisabled}>
                <a class="page-link" data-page="${pagination.currentPage - 1}">
                    <img src="/images/pro_button_pre.png" alt="이전 메뉴 보기">
                </a>
            </button>
        `);

        // 다음 버튼
        const nextDisabled = pagination.currentPage === pagination.totalPages ? 'style = "pointer-events : none"' : '';
        paginationContainer.append(`
            <button type="button" ${nextDisabled}>
                <a class="page-link" data-page="${pagination.currentPage + 1}">
                    <img src="/images/pro_button_next.png" alt="다음 메뉴 보기">
                </a>
            </button>
        `);

        // 페이지 클릭했을 때 실행할 함수.
        $('.page-link').click(function(event) {
            event.preventDefault();
            const selectedPage = $(this).data('page');
            getList(selectedPage);
        });
    }

});
// ====================== 강사님이 추가해주신 부분 ====================== //