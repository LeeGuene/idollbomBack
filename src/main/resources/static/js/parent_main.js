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
                console.log(data);
                renderPro(data.content);
                renderPagination(data);

                // 전문가 프로필 상세보기 페이지로 이동하는 메서드
                const proInfos = document.querySelectorAll('.pro_recommendation li > a');
                const proNumbers = document.querySelectorAll('.pro_recommendation li input');
                let proNumberInput;
                console.log(proNumbers);

                for(let index = 0; index < proInfos.length; index++){
                    proInfos[index].addEventListener("click", e=>{
                        // proNumber를 전달하면서 프로필 상세보기로 이동
                        proNumberInput = proNumbers[index];
                        const form = document.createElement('form');
                        form.append(proNumberInput);
                        document.body.append(form);

                        form.method = 'get';
                        form.action = '/pro/detail';
                        form.submit();
                    });
                }


            },
            error:function (){
                console.error('실패')
            }
        })
    };

    function renderPro(pros) {
        const proContainer = $('.pro_recommendation ul');
        proContainer.empty();

        // <img src="/images/${pro.averageRating > 2 ? 4.5 : 5}rating.png"/>

        pros.forEach(function (pro) {

            let fullCount = 5; // 만점 별점개수
            let repeatCount = Math.floor(pro.averageRating);
            let stars = '';

            for (let i = 0; i < repeatCount; i++) {
                stars += '★';
                fullCount--;
            }

            for(let i = 0; i < fullCount; i++){
                stars += '☆';
            }

            let boardRow = `
            <li>
                <a href="#">
                    <input type="hidden" name="proNumber" value="${pro.proNumber}" />
                    <div class="proImg-box">
                        <img src="/images/${pro.proProfileImageUrl}" />
                    </div>
                    <p>${pro.proName}</p>
                    <div>
                        <p>후기</p>
                        <!-- 별점 이미지 사진이 4.5rating밖에 없어서 일단 평균 별점 2점 초과하면 무조건 나오도록 설정함. -->
                        <span>${stars}</span>
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

// 전문가 대메뉴 클릭시 전문가 메인페이지로 이동 ( 새 창으로 띄우기 )
function goPromain(){
    console.log("메인 함수로 이동 실행!!");
    window.open("/promain", '_blank');
}