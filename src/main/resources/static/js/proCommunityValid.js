// 전문가 유효성 체크
const proTitle = document.getElementById('proPostTitle')
const proCommunityTitle = document.getElementById('communityTitle').parentNode

const proContent = document.getElementById('proPostContent')
const proCommunityContent = document.getElementById('communityContent').parentNode

function proCommunityForm(){
    let isValid = true

    if (proTitle.value === '') {
        proCommunityTitle.style.display="flex"
        isValid = false
    }

    if(proContent.value === ''){
        proCommunityContent.style.display="flex"
        isValid = false
    }

    return isValid
}

// 수업 제목이 채워졌다면
proTitle.addEventListener('input', function (){
    proCommunityTitle.style.display='none'
})

proContent.addEventListener('input', function (){
    proCommunityContent.style.display='none'
})