document.addEventListener('DOMContentLoaded', () => {
    const stars = document.querySelectorAll('.star');
    const ratingInput = document.getElementById('rating');

    stars.forEach((star, index) => {
        star.addEventListener('click', () => {
            updateStars(index + 1);
        });
    });

    function updateStars(rating) {
        stars.forEach((star, index) => {
            if (index < rating) {
                star.textContent = '★';
                star.classList.add('filled');
            } else {
                star.textContent = '☆';
                star.classList.remove('filled');
            }
            ratingInput.value = rating;
        });

        console.log(`Current rating is: ${rating}`);
    }
});


function openModal(element) {
    let className = element.getAttribute('data-class-name');
    let proName = element.getAttribute('data-pro-name');
    let classNumber = element.getAttribute('data-class-number');

    // 모달의 요소를 가져와서 값 설정
    document.getElementById('modalClassName').value = className;
    document.getElementById('proName').value = proName;
    document.getElementById('classNumber').value = classNumber;

    // 모달 요소 가져오기
    const modal = document.querySelector('.modal');

    // 모달 열기
    modal.style.display = 'flex';
}

function closeModal(element){
    const modal = document.querySelector('.modal');
    modal.style.display = 'none';
}

document.addEventListener('DOMContentLoaded', () => {
    const stars = document.querySelectorAll('.star');

    stars.forEach((star, index) => {
        star.addEventListener('click', () => {
            updateStars(index + 1);
        });
    });

    function updateStars(rating) {
        stars.forEach((star, index) => {
            if (index < rating) {
                star.textContent = '★';
                star.classList.add('filled');
            } else {
                star.textContent = '☆';
                star.classList.remove('filled');
            }
        });

        console.log(`Current rating is: ${rating}`);
    }
});
