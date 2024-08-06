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
                        <img src="${pro.proProfileImageUrl}" />
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

    // ====================== 강사님이 추가해주신 부분 ====================== //

    // 메인 페이지 상단 배너 슬라이드 js
    // 이미지 슬라이드 관련 변수 및 이벤트
    const sliderBox = document.querySelector(".slider-box");
    console.log(sliderBox);
    const sliderItems = document.querySelectorAll(".slider-item");
    const btns = document.querySelectorAll(".slider-btn");
    console.log(btns);

    // 자동 슬라이드를 위한 시간 설정 ( 단위 : 밀리초(ms) )
    const intervalTime = 3000;

    // 자동 이미지 슬라이드 함수
    function autoSlide() {
        sliderBox.style.transform = 'translateX(-200%)';
        sliderBox.style.transition = '1s';
    }

    sliderBox.ontransitionend = ()=> {
        // 기준 위치인 transform(-100%) 에서 왼쪽 버튼은 0%로 이동, 오른쪽 버튼은 -200% 이동한다.
        if (sliderBox.style.transform === 'translateX(-200%)') {
            // 오른쪽을 클릭한 경우, 트랜지 션이 끝난 후 실행됨.
            let copy = sliderBox.children[0].cloneNode(true); // 첫째 이미지 복제
            sliderBox.children[0].remove(); // 첫째 이미지 삭제
            sliderBox.appendChild(copy); // 첫번째 이미지를 마지막 이미지로 추가

        } else {
            // 왼쪽을 클릭한 경우, 트랜지션이 끝난 후 실행됨.
            let copy = sliderBox.lastElementChild.cloneNode(true); // 이미지 복제
            sliderBox.lastElementChild.remove(); // 기존 이미지 삭제
            sliderBox.firstElementChild.before(copy); // 마지막 이미지를 가장 앞쪽에 배치
        }

        // 공통 코드 ( 반드시 if문 아래쪽에 입력해야 한다!! )
        sliderBox.style.transition = '0s'; // 트랜잭션 제거
        sliderBox.style.transform = 'translateX(-100%)'; // 원래 기준위치로 이동
    }

    // 수동 이미지 슬라이드 (버튼 클릭시 이동)
    btns.forEach(btn=>{
        btn.addEventListener("click", ()=>{

            // 위에서 트랜지션 효과가 없어졌으므로 클릭할 때마다 다시 트랜지션을 추가해야 한다.
            if(btn.classList.contains("right")){
                sliderBox.style.transform = 'translateX(-200%)';
                sliderBox.style.transition = '1s';

                autoSlide();
            }

            if(btn.classList.contains("left")){
                sliderBox.style.transform = `translateX(0%)`;
                sliderBox.style.transition = '1s';

            }

            // 클릭 시, 자동 슬라이드 기능을 유지하기 위해 현재 인터벌을 clear 하고 재설정
            clearInterval(autoSlideInterval);
            autoSlideInterval = setInterval(autoSlide, intervalTime);
        });
    });

    // 자동 슬라이드를 설정
    let autoSlideInterval = setInterval(autoSlide, intervalTime);
});




