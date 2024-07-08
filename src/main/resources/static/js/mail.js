// 모달 열기 함수 정의
function openModal(element) {
    const noteNumber = element.getAttribute('th:value');
    const noteContent = element.getAttribute('data-content');

    // 모달 요소 가져오기
    const modal = document.querySelector('.modal');

    // 모달 열기
    modal.style.display = 'flex';

    // // 닫기 버튼 설정
    // const closeModalButton = modal.querySelector('.close');
    // closeModalButton.addEventListener('click', function() {
    //     modal.style.display = 'none';
    // });
    //
    // // 모달 외부 클릭 시 닫기
    // window.onclick = function(event) {
    //     if (event.target == modal) {
    //         modal.style.display = 'none';
    //     }
    // };none
}
